package com.cybertek.tests.day7_testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgAssertionsDemo {

    @Test
    public void test1(){
        // import Assert class from testNg like  "import org.testng.Assert;"
        // If Assert gives fail, we can close browser by using AfterMethod.
        Assert.assertEquals("title", "title");

        Assert.assertEquals("url", "url");
    }

    // ASSERT TRUE EXAMPLE
    @Test
    public void test2(){
        String expectedTitle = "Cyb";
        String actualTitle = "Cybertek";

        // If we want to check if actual value starts with expected value, we use Strings method of starts with...
        // It returs true or false. We can use "Assert.assertTrue()" to check the result.
        Assert.assertTrue(actualTitle.startsWith(expectedTitle), "Verify title starts with Cyb");

    }

    @Test
    public void test3(){

        String email = "Smith@cybertek.com";
        Assert.assertTrue(email.contains("@"), "Verify email contains @");

    }


    // ASSERT FALSE EXAMPLE
    @Test
    public void test4(){
        String email = "Smith@cybertek.com";
        Assert.assertFalse(email.contains("gmail"), "Verify email not contains gmail");
    }


    // ASSERT NOT EQUAL EXAMPLE :ıt returns true if two things are not equal to each other.
    @Test
    public void test5(){
        String email1 = "Ali@cybertek.com";
        String email2 = "Smith@cybertek.com";
        Assert.assertNotEquals(email1, email2);
    }









}
