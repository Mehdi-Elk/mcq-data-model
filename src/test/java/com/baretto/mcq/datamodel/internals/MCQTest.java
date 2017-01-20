package com.baretto.mcq.datamodel.internals;

import com.baretto.mcq.datamodel.Choice;
import com.baretto.mcq.datamodel.Question;
import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

/**
 * Created by WORK on 14/01/2017.
 */
public class MCQTest {

    @Test
    public void generateOneMCQWithTwoQuestionTest() {

        MCQ aMCQ = new MCQ(2);

        Assert.assertEquals(2, aMCQ.getQuestions().size());

    }

}
