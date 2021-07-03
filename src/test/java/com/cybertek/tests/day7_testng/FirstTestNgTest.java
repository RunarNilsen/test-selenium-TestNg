package com.cybertek.tests.day7_testng;

import org.testng.annotations.Test;

public class FirstTestNgTest {
    // we have to import @Test from org.testng.annotations.Test
    // @Test annotation runs the test cases and we use it instead of the main method
    @Test
    public void test1(){
        System.out.println("My first test case");
    }

    @Test
    public void test2(){
        System.out.println("My second test case");
    }



}
