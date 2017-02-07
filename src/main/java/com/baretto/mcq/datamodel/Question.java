package com.baretto.mcq.datamodel;

import java.io.Serializable;
import java.util.*;

/**
 * Simple implementation of question for MCQ.
 * <p>
 * Created by mehdi on 07/01/17.
 */
public final class Question implements  Serializable {

    private  String label;
    private final List<Choice> choices = new ArrayList();
    private final Set<Choice> selectedChoices = new HashSet();
    private AnswerConstraint answerConstraint;
    private final List<Choice> correctChoises = new ArrayList();


    Question(){

    }
    /**
     * Instanciate a MCQ Question.
     *  @param aLabel
     * @param theChoices
     * @param theCorrectChoices
     * @param anAnswerConstraint
     */
    public Question(String aLabel, List<Choice> theChoices, List<Choice> theCorrectChoices, AnswerConstraint anAnswerConstraint) {
        label = aLabel;
        choices.addAll(theChoices);
        correctChoises.addAll(theCorrectChoices);
        answerConstraint = anAnswerConstraint;
    }



    public String getLabel() {
        return label;
    }

    public List<Choice> getChoices() {
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

        Question question = (Question) o;

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

    public Set<Choice> getSelectedChoices() {
        return selectedChoices;
    }


    public void setSelectedChoices(List<Choice> theSelectedChoices) {
        this.selectedChoices.clear();
        this.selectedChoices.addAll(theSelectedChoices);
    }


    public boolean answerIsCorrect() {
return this.selectedChoices.containsAll(this.correctChoises);
    }


}
