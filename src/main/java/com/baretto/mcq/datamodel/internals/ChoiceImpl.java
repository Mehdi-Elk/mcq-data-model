package com.baretto.mcq.datamodel.internals;

import com.baretto.mcq.datamodel.Choice;

import java.io.Serializable;

/**
 * Simple implementation of Choice for MCQ.
 * Created by mehdi on 07/01/17.
 */
public final class ChoiceImpl implements Choice, Serializable {

    private final String label;
    private final boolean isValid;

    /**
     * Instanciate a choice with the given label and specify if it's a valid choice for the MCQ question.
     * @param aLabel label of the choice.
     * @param isValid Indicate if the choice is valid for a question.
     */
    public ChoiceImpl(String aLabel, boolean isValid) {
        this.label = aLabel;
        this.isValid = isValid;
    }

    public String getLabel() {
        return label;
    }

    public boolean isValid() {
        return isValid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ChoiceImpl choice = (ChoiceImpl) o;

        if (isValid != choice.isValid) {
            return false;
        }
        return label.equals(choice.label);
    }

    @Override
    public int hashCode() {
        int result = label.hashCode();
        result = 31 * result + (isValid ? 1 : 0);
        return result;
    }
}
