package com.baretto.mcq.datamodel;

/**
 * Represent the constraint on the answer of a MCQ question:
 * -ONE_RESPONSE: only one good response,
 * -ALL_THAT_APPLY: one or more good response,
 * -N_RESPONSES: N good responses.
 * Created by mehdi on 05/01/17.
 */
public enum AnswerConstraint {
    ONE_RESPONSE,
    ALL_THAT_APPLY,
    N_RESPONSES
}
