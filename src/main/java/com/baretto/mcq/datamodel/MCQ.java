package com.baretto.mcq.datamodel;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xpath.internal.operations.Equals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

/**
 * A MCQ (multiple choice QuestionImpls) contain all the QuestionImpl for a test.
 * <p>
 * Created by WORK on 14/01/2017.
 */
public class MCQ implements Serializable {

    private static String ALL_OF_THE_ABOVE = "All of the above";

    private List<Question> questions = new ArrayList();

    private static final Logger LOGGER = LoggerFactory.getLogger(MCQ.class);

    public MCQ(String json, int numberOfQuestions) {
        try {
            List<Question> allQuestions = extractQuestionsFromJson(json);
            Collections.shuffle(allQuestions);
            questions.addAll(allQuestions.subList(0, numberOfQuestions));
            shuffleChoices();
        } catch (IOException e) {
            LOGGER.error("Error during question extraction from json", e);
        }
    }

    /**
     * Shuffle all choices. If "All of the above" is a choice, it's always the last.
     */
    private void shuffleChoices() {
        for (Question question : questions) {
            List<Choice> choicesToShuffle = question.getChoices();
            if(choicesToShuffle.size()>2){
                int lastIndex = choicesToShuffle.size() - 1;
                if (ALL_OF_THE_ABOVE.equals(choicesToShuffle.get(lastIndex).getLabel())) {
                    choicesToShuffle = choicesToShuffle.subList(0, lastIndex);
                }
                Collections.shuffle(choicesToShuffle);
            }
        }
    }


    private List<Question> extractQuestionsFromJson(String json) throws IOException {
        return new ObjectMapper().readValue(json, new TypeReference<List<Question>>() {
        });
    }


    /**
     * get all the QuestionImpls of the MCQ
     *
     * @return
     */
    public List<Question> getQuestions() {
        return questions;
    }
}
