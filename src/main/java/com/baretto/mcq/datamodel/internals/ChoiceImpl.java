package com.baretto.mcq.datamodel.internals;

import com.baretto.mcq.datamodel.Choice;

import java.io.Serializable;

/**
 * Simple implementation of Choice for MCQ.
 * Created by mehdi on 07/01/17.
 */
public final class ChoiceImpl implements Choice, Serializable {

    private final String label;

    private final boolean isSelected = false;

    /**
     * Instanciate a choice for a MCQ Question with the provided label.
     * @param aLabel
     */
    public ChoiceImpl(String aLabel) {
        this.label = aLabel;;
    }

    public String getLabel() {
        return label;
    }

    /**
     * Check if the choice is selected for the MCQ question.
     *
     * @return true if the choice is selected ,
     *          false in other case.
     */
    public boolean isSelected() {
        return isSelected;
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

        if (isSelected != choice.isSelected) {
            return false;
        }
        return label.equals(choice.label);
    }

    @Override
    public int hashCode() {
        int result = label.hashCode();
        result = 31 * result + (isSelected ? 1 : 0);
        return result;
    }
}
