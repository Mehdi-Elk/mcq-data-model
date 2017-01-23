package com.baretto.mcq.datamodel.internals;

import com.baretto.mcq.datamodel.AnswerConstraint;
import com.baretto.mcq.datamodel.Choice;
import com.baretto.mcq.datamodel.Question;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * A MCQ (multiple choice questions) contain all the question for a test.
 * <p>
 * Created by WORK on 14/01/2017.
 */
public class MCQ implements Serializable {


    private Set<Question> questions;

    /**
     * generate a MCQ with "i" questions
     *
     * @param i
     */
    public MCQ(int i) {

        questions = generateQuestion(i);

    }

    /**
     * Temporary method for generate question.
     *
     * @param i
     * @return
     */
    private Set<Question> generateQuestion(int i) {
        Set<Question> theQuestions = new LinkedHashSet<Question>();
        for (int j = 0; j < i; j++) {
            Choice firstChoice = new ChoiceImpl(j + ".1 : " + "The Product Owner cannot accurately report progress to the stakeholders");
            Choice secondChoice = new ChoiceImpl(j + ".2 : " + "Impediments are raised and resolved more slowly");
            Choice thirdChoice = new ChoiceImpl(j + ".3 : " + "The Scrum Master loses the ability to update the Gantt chart properly");
            Choice fourthChoice = new ChoiceImpl(j + ".4 : " + "Oppprtunities to inspect and adapt the Sprint Backlog are lost");
            Choice fithChoice = new ChoiceImpl(j + ".5 : " + "The Sprint plan becomes inaccurate ");
            Choice sixthChoice = new ChoiceImpl(j + ".6 : " + "Too much work is spent updating the Scrum board before the meeting ");


            LinkedHashSet<Choice> choices = new LinkedHashSet<Choice>();
            choices.add(firstChoice);
            choices.add(secondChoice);
            choices.add(thirdChoice);
            choices.add(fourthChoice);
            choices.add(fithChoice);
            choices.add(sixthChoice);

            Set<Choice> correctChoices = new HashSet<Choice>();
            correctChoices.add(secondChoice);
            correctChoices.add(fourthChoice);
            correctChoices.add(fithChoice);


            final String questionLabel = "The Daily Scrum is an event that happens every day. What would be three key concerns if the frequency were to be lowered to every two or three days?";
            Question question = new QuestionImpl(" j : " + questionLabel, choices, correctChoices, AnswerConstraint.ALL_THAT_APPLY);
            theQuestions.add(question);
        }
        return theQuestions;

    }

    /**
     * get all the questions of the MCQ
     *
     * @return
     */
    public Set<Question> getQuestions() {
        return questions;
    }
}
