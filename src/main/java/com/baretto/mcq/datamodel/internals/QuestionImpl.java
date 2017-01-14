package com.baretto.mcq.datamodel.internals;

import com.baretto.mcq.datamodel.AnswerConstraint;
import com.baretto.mcq.datamodel.Choice;
import com.baretto.mcq.datamodel.Question;

import java.io.Serializable;
import java.util.*;

/**
 * Simple implementation of question for MCQ.
 * <p>
 * Created by mehdi on 07/01/17.
 */
public final class QuestionImpl implements Question, Serializable {

    private final String label;
    private final Set<Choice> choices = new HashSet();
    private List<Choice> selectedChoices = new ArrayList();
    private AnswerConstraint answerConstraint;
    private final Set<Choice> correctChoises = new HashSet();

    /**
     * Instanciate a MCQ Question.
     *  @param aLabel
     * @param theChoices
     * @param TheCorrectChoices
     * @param anAnswerConstraint
     */
    public QuestionImpl(String aLabel, Set<Choice> theChoices, Set<Choice> TheCorrectChoices, AnswerConstraint anAnswerConstraint) {
        label = aLabel;
        choices.addAll(theChoices);
        correctChoises.addAll(TheCorrectChoices);
        answerConstraint = anAnswerConstraint;
    }

    public String getLabel() {
        return label;
    }

    public Set<Choice> getChoices() {
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

    public List<Choice> getSelectedChoices() {
        return selectedChoices;
    }


    public void setSelectedChoices(List<Choice> theSelectedChoices) {
        this.selectedChoices = theSelectedChoices;
    }


    public boolean answerIsCorrect() {
return this.selectedChoices.containsAll(this.correctChoises);
    }


}
