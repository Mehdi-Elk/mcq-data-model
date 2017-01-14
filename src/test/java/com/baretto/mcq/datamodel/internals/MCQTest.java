package com.baretto.mcq.datamodel.internals;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by WORK on 14/01/2017.
 */
public class MCQTest {

    @Test
    public void generateOneMCQWithTwoQuestionTest() {

        MCQ aMCQ = new MCQ(2);

        Assert.assertEquals(1, aMCQ.getQuestions().size());

    }
}
