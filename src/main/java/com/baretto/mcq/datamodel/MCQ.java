package com.baretto.mcq.datamodel;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

/**
 * A MCQ (multiple choice QuestionImpls) contain all the Question for a test.
 * <p>
 * Created by WORK on 14/01/2017.
 */
public class MCQ implements Serializable {


    private Set<Question> QuestionImpls;

    /**
     * generate a MCQ with "i" QuestionImpls
     *
     * @param i
     */
    public MCQ(int i) {

        QuestionImpls = generateQuestionImpl(i);

    }

    public MCQ(String json) {
        try {
            QuestionImpls = generateQuestionImplsFromJson(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Set<Question> generateQuestionImplsFromJson(String json) throws IOException {
        Set<Question> QuestionImpls = new HashSet();
        List<Question> extract = new ObjectMapper().readValue(json, new TypeReference<List<Question>>() {});
        QuestionImpls.addAll(extract);
        return QuestionImpls;
    }

    /**
     * Temporary method for generate Question.
     *
     * @param i
     * @return
     */
    private Set<Question> generateQuestionImpl(int i) {
        Set<Question> theQuestionImpls = new LinkedHashSet<Question>();
        for (int j = 0; j < i; j++) {
            Choice firstChoice = new Choice(j + ".1 : " + "The Product Owner cannot accurately report progress to the stakeholders");
            Choice secondChoice = new Choice(j + ".2 : " + "Impediments are raised and resolved more slowly");
            Choice thirdChoice = new Choice(j + ".3 : " + "The Scrum Master loses the ability to update the Gantt chart properly");
            Choice fourthChoice = new Choice(j + ".4 : " + "Oppprtunities to inspect and adapt the Sprint Backlog are lost");
            Choice fithChoice = new Choice(j + ".5 : " + "The Sprint plan becomes inaccurate ");
            Choice sixthChoice = new Choice(j + ".6 : " + "Too much work is spent updating the Scrum board before the meeting ");


            List<Choice> choices = new ArrayList<Choice>();
            choices.add(firstChoice);
            choices.add(secondChoice);
            choices.add(thirdChoice);
            choices.add(fourthChoice);
            choices.add(fithChoice);
            choices.add(sixthChoice);

            List<Choice> correctChoices = new ArrayList<Choice>();
            correctChoices.add(secondChoice);
            correctChoices.add(fourthChoice);
            correctChoices.add(fithChoice);


            final String QuestionImplLabel = "The Daily Scrum is an event that happens every day. What would be three key concerns if the frequency were to be lowered to every two or three days?";
            Question QuestionImpl = new Question(j + " : " + QuestionImplLabel, choices, correctChoices, AnswerConstraint.ALL_THAT_APPLY);
            theQuestionImpls.add(QuestionImpl);
        }
        return theQuestionImpls;

    }

    /**
     * get all the QuestionImpls of the MCQ
     *
     * @return
     */
    public Set<Question> getQuestions() {
        return QuestionImpls;
    }
}
