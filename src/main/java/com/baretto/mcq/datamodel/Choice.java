package com.baretto.mcq.datamodel;

/**
 * Represent one choice for a unique MCQ question.
 *
 * Created by mehdi on 05/01/17.
 */
public interface Choice {

    /**
     * Get the choice's label which be visible for a user.
     *
     * @return the label
     */
    String getLabel();

    /**
     * Check if the choice is selected for the MCQ question.
     *
     * @return true if the choice is selected ,
     *          false in other case.
     */
    boolean isSelected();

    /**
     * Define if the choice is selected or not for the MCQ question.
     * @param isSelected True if the choice is selected.
     */
    void setSelected(boolean isSelected);
}
