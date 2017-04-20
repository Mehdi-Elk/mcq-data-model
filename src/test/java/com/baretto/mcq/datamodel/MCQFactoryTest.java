package com.baretto.mcq.datamodel;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;


/**
 * Created by mehdi on 13/04/17.
 */
public class MCQFactoryTest {


    @Test
    public void testGenerateMCQFromXlsx(){
        String excelFilePath = "src/test/resources/questions.xlsx";


        MCQ mcq = MCQFactory.generateFromXlsx(new File(excelFilePath));
        Gson gson = new Gson();
        System.out.println(gson.toJson(mcq.getQuestions()));

        Assert.assertEquals(1, mcq.getQuestions().size());
        Assert.assertEquals(AnswerConstraint.N_RESPONSES, mcq.getQuestions().get(0).getAnswerConstraint());
    }

}