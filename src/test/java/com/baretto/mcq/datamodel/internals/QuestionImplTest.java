package com.baretto.mcq.datamodel.internals;

import com.baretto.mcq.datamodel.AnswerConstraint;
import com.baretto.mcq.datamodel.Choice;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    public void testShouldBeEquals() {
        Set<Choice> choices = new HashSet();
        choices.add(firstChoice);
        choices.add(secondChoice);

        QuestionImpl firstQuestion = new QuestionImpl("alabel", choices,choices , AnswerConstraint.ONE_RESPONSE);
        QuestionImpl secondQuestion = new QuestionImpl("alabel", choices,choices , AnswerConstraint.ONE_RESPONSE);

        Assert.assertEquals(firstQuestion, secondQuestion);
        Assert.assertEquals(secondQuestion, firstQuestion);
        Assert.assertEquals(firstQuestion, firstQuestion);

    }

    @Test
    public void testShouldBeNotEquals() {
        Set<Choice> choices = new HashSet();
        choices.add(firstChoice);
        choices.add(secondChoice);
        QuestionImpl firstQuestion = new QuestionImpl("alabel", choices,choices , AnswerConstraint.ONE_RESPONSE);


        QuestionImpl secondQuestion = new QuestionImpl("otherlabel", choices,choices , AnswerConstraint.ONE_RESPONSE);
        Assert.assertNotEquals(firstQuestion, secondQuestion);


        secondQuestion = new QuestionImpl("alabel", choices, choices, AnswerConstraint.ALL_THAT_APPLY);
        Assert.assertNotEquals(firstQuestion, secondQuestion);

        Set<Choice> otherChoices = new HashSet();
        otherChoices.add(firstChoice);
        secondQuestion = new QuestionImpl("alabel", otherChoices, otherChoices, AnswerConstraint.ALL_THAT_APPLY);
        Assert.assertNotEquals(firstQuestion, secondQuestion);
    }

    @Test
    public void testGoodChoiceIsSelectedByUser() {
        Set<Choice> choices = new HashSet();
        choices.add(firstChoice);
        choices.add(secondChoice);
        Mockito.when(firstChoice.isValid()).thenReturn(true);
        Set<Choice> theCorrectchoices = new HashSet();
        theCorrectchoices.add(firstChoice);
        QuestionImpl question = new QuestionImpl("QuestionLabel", choices, theCorrectchoices, AnswerConstraint.ONE_RESPONSE);
        List<Choice> selectedChoices = new ArrayList();
        selectedChoices.add(firstChoice);

        question.setSelectedChoices(selectedChoices);

        Assert.assertTrue(question.answerIsCorrect());


    }


}
