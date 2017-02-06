package com.baretto.mcq.datamodel.internals;

import com.baretto.mcq.datamodel.AnswerConstraint;
import com.baretto.mcq.datamodel.ChoiceImpl;
import com.baretto.mcq.datamodel.QuestionImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.*;

/**
 * Created by mehdi on 09/01/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class QuestionImplTest {

    @Mock
    private ChoiceImpl firstChoice;
    @Mock
    private ChoiceImpl secondChoice;


    @Test
    public void testShouldBeEquals() {
        List<ChoiceImpl> choices = new ArrayList<ChoiceImpl>();
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
        List<ChoiceImpl> choices = new ArrayList<ChoiceImpl>();
        choices.add(firstChoice);
        choices.add(secondChoice);
        QuestionImpl firstQuestion = new QuestionImpl("alabel", choices,choices , AnswerConstraint.ONE_RESPONSE);


        QuestionImpl secondQuestion = new QuestionImpl("otherlabel", choices,choices , AnswerConstraint.ONE_RESPONSE);
        Assert.assertNotEquals(firstQuestion, secondQuestion);


        secondQuestion = new QuestionImpl("alabel", choices, choices, AnswerConstraint.ALL_THAT_APPLY);
        Assert.assertNotEquals(firstQuestion, secondQuestion);

        List<ChoiceImpl> otherChoices = new ArrayList<ChoiceImpl>();
        otherChoices.add(firstChoice);
        secondQuestion = new QuestionImpl("alabel", otherChoices, otherChoices, AnswerConstraint.ALL_THAT_APPLY);
        Assert.assertNotEquals(firstQuestion, secondQuestion);
    }

    @Test
    public void testGoodChoiceIsSelectedByUser() {
        List<ChoiceImpl> choices = new ArrayList<ChoiceImpl>();
        choices.add(firstChoice);
        choices.add(secondChoice);
        Mockito.when(firstChoice.isSelected()).thenReturn(true);
        List<ChoiceImpl> theCorrectchoices = new ArrayList<ChoiceImpl>();
        theCorrectchoices.add(firstChoice);
        QuestionImpl question = new QuestionImpl("theQuestionLabel", choices, theCorrectchoices, AnswerConstraint.ONE_RESPONSE);
        List<ChoiceImpl> selectedChoices = new ArrayList();
        selectedChoices.add(firstChoice);

        question.setSelectedChoices(selectedChoices);

        Assert.assertTrue(question.answerIsCorrect());


    }


}
