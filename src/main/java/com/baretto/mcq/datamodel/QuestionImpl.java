package com.baretto.mcq.datamodel;

import java.io.Serializable;
import java.util.*;

/**
 * Simple implementation of question for MCQ.
 * <p>
 * Created by mehdi on 07/01/17.
 */
public final class QuestionImpl implements  Serializable {

    private  String label;
    private final List<ChoiceImpl> choices = new ArrayList();
    private final Set<ChoiceImpl> selectedChoices = new HashSet();
    private AnswerConstraint answerConstraint;
    private final List<ChoiceImpl> correctChoises = new ArrayList();


    QuestionImpl(){

    }
    /**
     * Instanciate a MCQ Question.
     *  @param aLabel
     * @param theChoices
     * @param theCorrectChoices
     * @param anAnswerConstraint
     */
    public QuestionImpl(String aLabel, List<ChoiceImpl> theChoices, List<ChoiceImpl> theCorrectChoices, AnswerConstraint anAnswerConstraint) {
        label = aLabel;
        choices.addAll(theChoices);
        correctChoises.addAll(theCorrectChoices);
        answerConstraint = anAnswerConstraint;
    }



    public String getLabel() {
        return label;
    }

    public List<ChoiceImpl> getChoices() {
        return choices;
    }

    public AnswerConstraint getAnswerConstraint() {
        return answerConstraint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        QuestionImpl question = (QuestionImpl) o;

        if (!label.equals(question.label)) {
            return false;
        }
        if (!choices.equals(question.choices)) {
            return false;
        }
        return answerConstraint == question.answerConstraint;
    }

    @Override
    public int hashCode() {
        int result = label.hashCode();
        result = 31 * result + choices.hashCode();
        result = 31 * result + answerConstraint.hashCode();
        return result;
    }

    public Set<ChoiceImpl> getSelectedChoices() {
        return selectedChoices;
    }


    public void setSelectedChoices(List<ChoiceImpl> theSelectedChoices) {
        this.selectedChoices.clear();
        this.selectedChoices.addAll(theSelectedChoices);
    }


    public boolean answerIsCorrect() {
return this.selectedChoices.containsAll(this.correctChoises);
    }


}
