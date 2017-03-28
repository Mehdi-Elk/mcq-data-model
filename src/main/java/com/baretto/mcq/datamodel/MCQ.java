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

    private List<Question> questions = new ArrayList();

    private static final Logger LOGGER = LoggerFactory.getLogger(MCQ.class);

    public MCQ(String json, int numberOfQuestions) throws IOException {

            List<Question> allQuestions = extractQuestionsFromJson(json);
            Collections.shuffle(allQuestions);
            questions.addAll(allQuestions.subList(0, numberOfQuestions));
            shuffleChoices();

    }

    /**
     * Shuffle all choices. If "All of the above" is a choice, it's always the last.
     */
    private void shuffleChoices() {
        for (Question question : questions) {
            question.shuffleChoices();
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
