package com.baretto.mcq.datamodel;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by WORK on 14/01/2017.
 */
public class MCQTest {


    public static final String QUESTION_1="{\"label\":\"Which of the fo||owing are ro|es on a Scrum Team?\",\"choices\":[{\"label\":\"Product Owner\"},{\"label\":\"Scrum Master\"},{\"label\":\"Users\"},{\"label\":\"Customers\"},{\"label\":\"Development Team\"}],\"selectedChoices\":[],\"answerConstraint\":\"ALL_THAT_APPLY\"}";
    public static final String QUESTION_2="{\"label\":\"Haw much work must a Development Team do to a Product Backlog item it selects for a Sprint?\",\"choices\":[{\"label\":\"As much as it has to|d the Product Owner wi|| be done for every Product Back|og item it se|ects in conformance with the\\ndeﬁnition of \\\"Done\\\".\"},{\"label\":\"A proportiona| amount of time on ana|ysis, design, programming, testing, and documentation.\"},{\"label\":\"A|| deve|opment work and at |east some testing.\"},{\"label\":\"As much as it can ﬁt into the Sprint. Any remaining work wi|| be transferred to a subsequent Sprint.\"}],\"selectedChoices\":[],\"answerConstraint\":\"ONE_RESPONSE\"}";
    public static final String JSON = "["+ QUESTION_1 +","+QUESTION_2+"]";
    @Test
    public void testGenerateMCQFromJson() {
        MCQ mcq = new MCQ(JSON, 2);
        Assert.assertEquals(2, mcq.getQuestions().size());
    }


    @Test
    public void testGenerateMCQFromJsonWithNumberOgQuestions() {
        MCQ mcq = new MCQ(JSON, 1);
        Assert.assertEquals(1, mcq.getQuestions().size());
    }

    @Test
    public void testShuffleChoiceDuringMCQGeneration() {
        MCQ mcq = new MCQ("["+QUESTION_1+"]", 1);

        List<Choice> choices = mcq.getQuestions().get(0).getChoices();
        String expectedChoices = "Product OwnerScrum MasterUsersCustomersDevelopment Team";

        StringBuilder result = new StringBuilder();
        for (Choice choice : choices) {
            result.append(choice.getLabel());
        }

        Assert.assertNotEquals(expectedChoices, result);
    }

    @Test
    public void testShuffleChoicesWithAllOfTheAbove() {
        String json = "[{\n  \"label\": \"Which Scrum Value is affected by a lack of trust in the Scrum Team?\",\n   \"choices\": [\n     {\n        \"label\": \"Commitment\"\n     },\n    {\n  \"label\": \"Courage\"\n     },\n  {\n  \"label\": \"Openness\"\n   },\n   {\n     \"label\": \"Focus\"\n   },\n    {\n \"label\": \"Respect\"\n},\n {\n\"label\": \"All of the above\"\n}\n ],\n  \"correctChoises\": [\n {\n   \"label\": \"All of the above\"\n     }\n    ],\n    \"selectedChoices\": [],\n    \"answerConstraint\": \"ONE_RESPONSE\"\n }]";

        MCQ mcq = new MCQ(json, 1);

        final Question question = mcq.getQuestions().get(0);
        Choice lastChoice = question.getChoices().get(5);
        Assert.assertEquals("All of the above", lastChoice.getLabel());

    }

}
