package com.example.chen.broadcastbestpractice;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
/*    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }*/
    @Test
    public void testAddActivity(){
        assertEquals(0,ActivityCollector.activities.size());
        LoginActivity loginActivity=new LoginActivity();
        ActivityCollector.addActivity(loginActivity);
        assertEquals(1,ActivityCollector.activities.size());
        ActivityCollector.addActivity(loginActivity);
        assertEquals(1,ActivityCollector.activities.size());
    }
}