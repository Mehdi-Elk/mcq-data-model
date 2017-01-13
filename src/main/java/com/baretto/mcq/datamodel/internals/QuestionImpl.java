package com.baretto.mcq.datamodel.internals;

import com.baretto.mcq.datamodel.AnswerConstraint;
import com.baretto.mcq.datamodel.Choice;
import com.baretto.mcq.datamodel.Question;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Simple implementation of question for MCQ.
 *
 * Created by mehdi on 07/01/17.
 */
public final class QuestionImpl implements Question, Serializable {

    private final String label;
    private final Set<Choice> choices = new HashSet();
    private AnswerConstraint answerConstraint;

     public QuestionImpl(String aLabel, Set<Choice> theChoices, AnswerConstraint anAnswerConstraint){
        label = aLabel;
        choices.addAll(theChoices);
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
        if (!choices.equals(question.choices)){
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
}
