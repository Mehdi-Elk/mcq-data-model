package com.baretto.mcq.datamodel;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

/**
 * A MCQ (multiple choice QuestionImpls) contain all the QuestionImpl for a test.
 * <p>
 * Created by WORK on 14/01/2017.
 */
public class MCQ implements Serializable {


    private Set<QuestionImpl> QuestionImpls;

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

    private Set<QuestionImpl> generateQuestionImplsFromJson(String json) throws IOException {
        Set<QuestionImpl> QuestionImpls = new HashSet();
        List<QuestionImpl> extract = new ObjectMapper().readValue(json, new TypeReference<List<QuestionImpl>>() {});
        QuestionImpls.addAll(extract);
        return QuestionImpls;
    }

    /**
     * Temporary method for generate QuestionImpl.
     *
     * @param i
     * @return
     */
    private Set<QuestionImpl> generateQuestionImpl(int i) {
        Set<QuestionImpl> theQuestionImpls = new LinkedHashSet<QuestionImpl>();
        for (int j = 0; j < i; j++) {
            ChoiceImpl firstChoice = new ChoiceImpl(j + ".1 : " + "The Product Owner cannot accurately report progress to the stakeholders");
            ChoiceImpl secondChoice = new ChoiceImpl(j + ".2 : " + "Impediments are raised and resolved more slowly");
            ChoiceImpl thirdChoice = new ChoiceImpl(j + ".3 : " + "The Scrum Master loses the ability to update the Gantt chart properly");
            ChoiceImpl fourthChoice = new ChoiceImpl(j + ".4 : " + "Oppprtunities to inspect and adapt the Sprint Backlog are lost");
            ChoiceImpl fithChoice = new ChoiceImpl(j + ".5 : " + "The Sprint plan becomes inaccurate ");
            ChoiceImpl sixthChoice = new ChoiceImpl(j + ".6 : " + "Too much work is spent updating the Scrum board before the meeting ");


            List<ChoiceImpl> choices = new ArrayList<ChoiceImpl>();
            choices.add(firstChoice);
            choices.add(secondChoice);
            choices.add(thirdChoice);
            choices.add(fourthChoice);
            choices.add(fithChoice);
            choices.add(sixthChoice);

            List<ChoiceImpl> correctChoices = new ArrayList<ChoiceImpl>();
            correctChoices.add(secondChoice);
            correctChoices.add(fourthChoice);
            correctChoices.add(fithChoice);


            final String QuestionImplLabel = "The Daily Scrum is an event that happens every day. What would be three key concerns if the frequency were to be lowered to every two or three days?";
            QuestionImpl QuestionImpl = new QuestionImpl(j + " : " + QuestionImplLabel, choices, correctChoices, AnswerConstraint.ALL_THAT_APPLY);
            theQuestionImpls.add(QuestionImpl);
        }
        return theQuestionImpls;

    }

    /**
     * get all the QuestionImpls of the MCQ
     *
     * @return
     */
    public Set<QuestionImpl> getQuestions() {
        return QuestionImpls;
    }
}
