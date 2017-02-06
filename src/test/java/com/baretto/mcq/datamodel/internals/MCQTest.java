package com.baretto.mcq.datamodel.internals;

import com.baretto.mcq.datamodel.MCQ;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by WORK on 14/01/2017.
 */
public class MCQTest {

    @Test
    public void generateOneMCQWithTwoQuestionTest() {

        MCQ aMCQ = new MCQ(2);

        Assert.assertEquals(2, aMCQ.getQuestions().size());

    }

    @Test
    public void testGenerateMCQFromJson(){
        String json = "[{\"label\":\"Which of the fo||owing are ro|es on a Scrum Team?\",\"choices\":[{\"label\":\"Product Owner\"},{\"label\":\"Scrum Master\"},{\"label\":\"Users\"},{\"label\":\"Customers\"},{\"label\":\"DeveIopment Team\"}],\"selectedChoices\":[],\"answerConstraint\":\"ALL_THAT_APPLY\"},{\"label\":\"Haw much work must a Development Team do to a Product Backlog item it selects for a Sprint?\",\"choices\":[{\"label\":\"As much as it has to|d the Product Owner wi|| be done for every Product Back|og item it se|ects in conformance with the\\ndeﬁnition of \\\"Done\\\".\"},{\"label\":\"A proportiona| amount of time on ana|ysis, design, programming, testing, and documentation.\"},{\"label\":\"A|| deve|opment work and at |east some testing.\"},{\"label\":\"As much as it can ﬁt into the Sprint. Any remaining work wi|| be transferred to a subsequent Sprint.\"}],\"selectedChoices\":[],\"answerConstraint\":\"ONE_RESPONSE\"}]" ;
        MCQ mcq = new MCQ(json);

        Assert.assertEquals(2, mcq.getQuestions().size());
    }

}
