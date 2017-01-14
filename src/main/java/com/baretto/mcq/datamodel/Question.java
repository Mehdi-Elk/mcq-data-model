package com.baretto.mcq.datamodel;

import java.util.List;
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

    /**
     * replace the user choices for the question
     * @param selectedChoices
     */
    void setSelectedChoices(List<Choice> selectedChoices);

    /**
     * True if the question is answer Correctly.
     * @return
     */
    boolean answerIsCorrect();
}
