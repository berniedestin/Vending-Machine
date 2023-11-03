package com.techelevator.view;

import com.techelevator.Change;
import org.junit.Assert;
import org.junit.Test;

public class ChangeTest {
    @Test
    public void TEST_getChange_5194(){
        Change change = new Change(5194);

        String result = change.getChange();

        Assert.assertEquals("Your change is 10 $5 bills, 1 $1 bill, 3 quarters, 1 dime, 1 nickel, 4 pennies", result);
    }
    @Test
    public void TEST_getChange_0(){
        Change change = new Change(0);

        String result = change.getChange();

        Assert.assertEquals("There is no change", result);
    }
}
