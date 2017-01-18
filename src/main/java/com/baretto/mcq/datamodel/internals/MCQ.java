package com.baretto.mcq.datamodel.internals;

import com.baretto.mcq.datamodel.AnswerConstraint;
import com.baretto.mcq.datamodel.Choice;
import com.baretto.mcq.datamodel.Question;

import java.util.HashSet;
import java.util.Set;

/**
 * A MCQ (multiple choice questions) contain all the question for a test.
 *
 * Created by WORK on 14/01/2017.
 */
public class MCQ {


    private Set<Question> questions;

    /**
     * generate a MCQ with "i" questions
     * @param i
     */
    public MCQ(int i) {

        questions =  generateQuestion(i);
        
    }

    /**
     * Temporary method for generate question.
     * @param i
     * @return
     */
    private Set<Question> generateQuestion(int i) {
        Set<Question> theQuestions = new HashSet<Question>();
        for (int j = 0; j <= i; j++) {
            Choice firstChoice = new ChoiceImpl("firstLabel"+i);
            Choice secondChoice = new ChoiceImpl("SecondLabel"+i);

            Set <Choice> choices = new HashSet<Choice>();
            choices.add(firstChoice);
            choices.add(secondChoice);

            Set <Choice> correctChoices = new HashSet<Choice>();
            correctChoices.add(firstChoice);

           Question question = new QuestionImpl("label"+i,choices,correctChoices, AnswerConstraint.ONE_RESPONSE);
            theQuestions.add(question);
        }
        return theQuestions;

    }

    /**
     * get all the questions of the MCQ
     * @return
     */
    public Set<Question> getQuestions() {
        return questions;
    }
}
