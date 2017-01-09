package com.baretto.mcq.datamodel;

import java.util.Set;

/**
 * Represent a question for MCQ.
 * Created by mehdi on 05/01/17.
 */
public interface Question {
    /**
     * The label of the question which be visible for a user.
     * @return the label
     */
    String getLabel();

    /**
     * Get the possible set of {@link Choice} for the MCQ question.
     * @return set of choices.
     */
    Set<Choice> getChoices();

    /**
     * Get the constraint of the question, for more information read {@link AnswerConstraint}.
     * @return {@link AnswerConstraint}
     */
    AnswerConstraint getAnswerConstraint();
}
