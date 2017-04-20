package com.baretto.mcq.datamodel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * The factory is used in order to generate MCQ from file.
 * <p>
 * Created by mehdi on 13/04/17.
 */
public class MCQFactory {

    /**
     * Link the choice index with a character.
     */
    private static final Map<Character, Integer> INDEX_CONVERTER = new HashMap<Character, Integer>();
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(MCQFactory.class);

    static {
        INDEX_CONVERTER.put('A', 0);
        INDEX_CONVERTER.put('B', 1);
        INDEX_CONVERTER.put('C', 2);
        INDEX_CONVERTER.put('D', 3);
        INDEX_CONVERTER.put('E', 4);
        INDEX_CONVERTER.put('F', 5);
        INDEX_CONVERTER.put('G', 6);
        INDEX_CONVERTER.put('H', 7);
    }


    /**
     * Generate an MCQ from the first sheet of the xlsx.
     * The format should be:
     * ID,QUESTION,CHOICE A,..,CHOICE F, RESPONSES.
     *
     * @param file
     * @return an MCQ
     */
    public static MCQ generateFromXlsx(File file) {
        List<Question> questions = new ArrayList<Question>();

        try {
            FileInputStream inputStream = new FileInputStream(file);
            Workbook workbook = getRelevantWorkbook(inputStream, file.getPath());

            Iterator<Row> iterator = retrieveRowIterator(workbook);

            while (iterator.hasNext()) addNewQuestion(questions, iterator);

            workbook.close();
            inputStream.close();

        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return new MCQ(questions);
    }

    private static Iterator<Row> retrieveRowIterator(Workbook workbook) {
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();
        iterator.next();
        return iterator;
    }

    private static Workbook getRelevantWorkbook(FileInputStream inputStream, String excelFilePath) throws IOException {
        Workbook workbook = null;

        if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("Incorrect file format");
        }
        return workbook;
    }

    private static void addNewQuestion(List<Question> questions, Iterator<Row> iterator) {
        Row nextRow = iterator.next();
        Iterator<Cell> cellIterator = nextRow.cellIterator();

        int column = 0;
        String questionLabel = "";
        List<Choice> theChoices = new ArrayList<Choice>();
        List<Choice> theCorrectChoices = new ArrayList<Choice>();
        AnswerConstraint anAnswerConstraint = AnswerConstraint.N_RESPONSES;


        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();

            if (column == 1) {
                questionLabel = cell.getStringCellValue();
            } else if (column <= 7 && column > 1) {
                addNewChoice(theChoices, cell);
            } else if (column == 8) {
                if (theChoices.size() > 1) {
                    String cellValue = cell.getStringCellValue();
                    cellValue = cellValue.replace(",", "");
                    if (cellValue.length() > 1) {
                        anAnswerConstraint = AnswerConstraint.N_RESPONSES;
                    }else if(cellValue.length() == 1){
                        anAnswerConstraint = AnswerConstraint.ONE_RESPONSE;
                    }
                    for (Character character : cellValue.toCharArray()) {
                        final Integer index = INDEX_CONVERTER.get(character);
                        final Choice choice = theChoices.get(index);
                        theCorrectChoices.add(choice);
                    }
                }

            }
            column = column + 1;
        }
        if (questionLabel.length() > 1) {
            questions.add(new Question(questionLabel, theChoices, theCorrectChoices, anAnswerConstraint));
        }
    }

    private static void addNewChoice(List<Choice> theChoices, Cell cell) {
        final String stringCellValue = cell.getStringCellValue();
        if (!stringCellValue.isEmpty()) {
            theChoices.add(new Choice(stringCellValue));
        }
    }
}
