package com.baretto.mcq.datamodel.internals;

import com.baretto.mcq.datamodel.Choice;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mehdi on 07/01/17.
 */
public class ChoiceImplTest {


    @Test
    public void testShouldBeEquals() {
        Choice firstChoice = new ChoiceImpl("aLabel", true);
        Choice secondChoice = new ChoiceImpl("aLabel", true);

        Assert.assertEquals(firstChoice, secondChoice);
        Assert.assertEquals(secondChoice, firstChoice);
        Assert.assertEquals(firstChoice, firstChoice);


    }

    @Test
    public void testShouldBeNotEquals() {
        Choice firstChoice = new ChoiceImpl("aLabel", true);
        Choice secondChoice = new ChoiceImpl("otherLabel", true);


        Assert.assertNotEquals(firstChoice, secondChoice);
        Assert.assertNotEquals(secondChoice, firstChoice);


        secondChoice = new ChoiceImpl("aLabel", false);
        Assert.assertNotEquals(firstChoice, secondChoice);

    }
}
