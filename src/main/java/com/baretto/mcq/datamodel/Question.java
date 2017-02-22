package com.baretto.mcq.datamodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.*;
import java.util.List;

/**
 * Simple implementation of question for MCQ.
 * <p>
 * Created by mehdi on 07/01/17.
 */
public final class Question implements  Serializable {
    @JsonProperty
    private final List<Choice> choices = new ArrayList();
    @JsonProperty
    private final Set<Choice> selectedChoices = new HashSet();
    @JsonProperty
    private final List<Choice> correctChoises = new ArrayList();
    @JsonProperty
    private  String label;
    @JsonProperty
    private AnswerConstraint answerConstraint;




    private  String correction = "ceci est un test de correction";


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
return(( this.selectedChoices.containsAll(this.correctChoises))&&(this.correctChoises.containsAll(selectedChoices)));
    }

    public boolean choiceIsCorrect(Choice choice){
        return this.correctChoises.contains(choice);
    }

    public int retrieveNumberOfCorrectChoices(){
        return this.correctChoises.size();
    }

    public String getCorrection() {
        return correction;
    }

    public void setCorrection(String correction) {
        this.correction = correction;
    }
}


