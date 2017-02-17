package com.baretto.mcq.datamodel;

import com.baretto.mcq.datamodel.AnswerConstraint;
import com.baretto.mcq.datamodel.Choice;
import com.baretto.mcq.datamodel.Question;
import com.baretto.mcq.datamodel.Question;
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
    private Choice firstChoice;
    @Mock
    private Choice secondChoice;


    @Test
    public void testShouldBeEquals() {
        List<Choice> choices = new ArrayList<Choice>();
        choices.add(firstChoice);
        choices.add(secondChoice);

        Question firstQuestion = new Question("alabel", choices,choices , AnswerConstraint.ONE_RESPONSE);
        Question secondQuestion = new Question("alabel", choices,choices , AnswerConstraint.ONE_RESPONSE);

        Assert.assertEquals(firstQuestion, secondQuestion);
        Assert.assertEquals(secondQuestion, firstQuestion);
        Assert.assertEquals(firstQuestion, firstQuestion);

    }

    @Test
    public void testShouldBeNotEquals() {
        List<Choice> choices = new ArrayList<Choice>();
        choices.add(firstChoice);
        choices.add(secondChoice);
        Question firstQuestion = new Question("alabel", choices,choices , AnswerConstraint.ONE_RESPONSE);


        Question secondQuestion = new Question("otherlabel", choices,choices , AnswerConstraint.ONE_RESPONSE);
        Assert.assertNotEquals(firstQuestion, secondQuestion);


        secondQuestion = new Question("alabel", choices, choices, AnswerConstraint.ALL_THAT_APPLY);
        Assert.assertNotEquals(firstQuestion, secondQuestion);

        List<Choice> otherChoices = new ArrayList<Choice>();
        otherChoices.add(firstChoice);
        secondQuestion = new Question("alabel", otherChoices, otherChoices, AnswerConstraint.ALL_THAT_APPLY);
        Assert.assertNotEquals(firstQuestion, secondQuestion);
    }

    @Test
    public void testGoodChoiceIsSelectedByUser() {
        List<Choice> choices = new ArrayList();
        choices.add(firstChoice);
        choices.add(secondChoice);
        Mockito.when(firstChoice.isSelected()).thenReturn(true);
        List<Choice> theCorrectchoices = new ArrayList();
        theCorrectchoices.add(firstChoice);
        Question question = new Question("theQuestionLabel", choices, theCorrectchoices, AnswerConstraint.ONE_RESPONSE);
        List<Choice> selectedChoices = new ArrayList();
        selectedChoices.add(firstChoice);

        question.setSelectedChoices(selectedChoices);

        Assert.assertTrue(question.answerIsCorrect());


    }


    @Test
    public void testTooMuchChoiceIsSelectedByUser() {
        List<Choice> choices = new ArrayList();
        choices.add(firstChoice);
        choices.add(secondChoice);
        Mockito.when(firstChoice.isSelected()).thenReturn(true);
        Mockito.when(secondChoice.isSelected()).thenReturn(true);
        List<Choice> theCorrectchoices = new ArrayList();
        theCorrectchoices.add(firstChoice);
        Question question = new Question("theQuestionLabel", choices, theCorrectchoices, AnswerConstraint.ONE_RESPONSE);
        List<Choice> selectedChoices = new ArrayList();
        selectedChoices.add(firstChoice);
        selectedChoices.add(secondChoice);

        question.setSelectedChoices(selectedChoices);

        Assert.assertFalse(question.answerIsCorrect());


    }

}
