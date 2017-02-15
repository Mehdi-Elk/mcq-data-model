package com.baretto.mcq.datamodel;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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


    private List<Question> questions = new ArrayList();

    private static final Logger LOGGER = LoggerFactory.getLogger(MCQ.class);

    public MCQ(String json) {
        try {
            questions.addAll(extractQuestionsFromJson(json));
        } catch (IOException e) {
            LOGGER.error("Error during question extraction from json",e);
        }
    }

    public MCQ(String json, int numberOfQuestions){
        try {
            List<Question> allQuestions = extractQuestionsFromJson(json);
            Collections.shuffle(allQuestions);
            questions.addAll(allQuestions.subList(0, numberOfQuestions));
        } catch (IOException e) {
            LOGGER.error("Error during question extraction from json",e);
        }
    }


    private List<Question> extractQuestionsFromJson(String json) throws IOException {
      return new ObjectMapper().readValue(json, new TypeReference<List<Question>>() {});
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
