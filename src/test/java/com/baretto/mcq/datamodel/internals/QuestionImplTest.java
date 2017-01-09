package com.baretto.mcq.datamodel.internals;

import com.baretto.mcq.datamodel.AnswerConstraint;
import com.baretto.mcq.datamodel.Choice;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mehdi on 09/01/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class QuestionImplTest {

    @Mock
    private Choice firstChoice;
    @Mock
    private Choice secondChoice;


    @Test
    public void testShouldBeEquals(){
        Set<Choice> choices =  new HashSet();
        choices.add(firstChoice);
        choices.add(secondChoice);

        QuestionImpl firstQuestion = new QuestionImpl("alabel", choices, AnswerConstraint.ONE_RESPONSE);
        QuestionImpl secondQuestion = new QuestionImpl("alabel", choices, AnswerConstraint.ONE_RESPONSE);

        Assert.assertEquals(firstQuestion, secondQuestion);
        Assert.assertEquals(secondQuestion, firstQuestion);
        Assert.assertEquals(firstQuestion, firstQuestion);

    }

    @Test
    public void testShouldBeNotEquals(){
        Set<Choice> choices =  new HashSet();
        choices.add(firstChoice);
        choices.add(secondChoice);
        QuestionImpl firstQuestion = new QuestionImpl("alabel", choices, AnswerConstraint.ONE_RESPONSE);


        QuestionImpl secondQuestion = new QuestionImpl("otherlabel", choices, AnswerConstraint.ONE_RESPONSE);
        Assert.assertNotEquals(firstQuestion, secondQuestion);


        secondQuestion = new QuestionImpl("alabel", choices, AnswerConstraint.ALL_THAT_APPLY);
        Assert.assertNotEquals(firstQuestion, secondQuestion);

        Set<Choice> otherChoices = new HashSet();
        otherChoices.add(firstChoice);
        secondQuestion = new QuestionImpl("alabel", otherChoices, AnswerConstraint.ALL_THAT_APPLY);
        Assert.assertNotEquals(firstQuestion, secondQuestion);
    }
}
