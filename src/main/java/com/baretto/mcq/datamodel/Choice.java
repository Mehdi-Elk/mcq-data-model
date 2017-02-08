package com.baretto.mcq.datamodel;

import java.io.Serializable;

/**
 * Simple implementation of Choice for MCQ.
 * Created by mehdi on 07/01/17.
 */
public class Choice implements  Serializable {

    private String label;

    /** Indicate if the current {@link Choice} is selected. */
    private boolean isSelected = false;

    private Choice(){

    }
    /**
     * Instanciate a choice for a MCQ Question with the provided label.
     * @param aLabel
     */
    public Choice(String aLabel) {
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

    /**
     * Define if the choice is selected or not for the MCQ question.
     * @param isSelected True if the choice is selected.
     */
    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Choice choice = (Choice) o;

        return label != null ? label.equals(choice.label) : choice.label == null;
    }

    @Override
    public int hashCode() {
        return label != null ? label.hashCode() : 0;
    }
}
