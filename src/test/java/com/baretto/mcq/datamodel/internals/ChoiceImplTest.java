package com.baretto.mcq.datamodel.internals;

import com.baretto.mcq.datamodel.ChoiceImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mehdi on 07/01/17.
 */
public class ChoiceImplTest {


    @Test
    public void testShouldBeEquals() {
        ChoiceImpl firstChoice = new ChoiceImpl("aLabel");
        ChoiceImpl secondChoice = new ChoiceImpl("aLabel");

        Assert.assertEquals(firstChoice, secondChoice);
        Assert.assertEquals(secondChoice, firstChoice);
        Assert.assertEquals(firstChoice, firstChoice);


    }

    @Test
    public void testShouldBeNotEquals() {
        ChoiceImpl firstChoice = new ChoiceImpl("aLabel");
        ChoiceImpl secondChoice = new ChoiceImpl("otherLabel");


        Assert.assertNotEquals(firstChoice, secondChoice);
        Assert.assertNotEquals(secondChoice, firstChoice);
    }
}
