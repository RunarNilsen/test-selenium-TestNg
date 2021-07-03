package com.cybertek.tests.day7_testng;

import org.testng.annotations.*;

public class BeforeAfterMethod {

    // It is executed one time before the all test case, Not before each of test cases
    @BeforeClass
    public void setUpClass(){
        System.out.println("---BEFORE CLASS---");
        System.out.println("executed one time before the all test case");
    }

    // It is executed one time AFTER the all test case, Not AFTER each of test cases
    @AfterClass
    public void teatDownClass(){
        System.out.println("---AFTER CLASS---");
        System.out.println("executed one time after the all test case");
    }


    @Test
    public void test1(){

        /*
        One of the important feature of TestNg:
        We can write what we repeat in the beginning and at the end for each seperate test, and testNg will run
        this annotations for each of test cases.

        We can use BeforMethod and AfterMethod for this.
         */
        System.out.println("First Test Case");
    }

    // @Ignore      if we write this before @Test, it will not the run this unique test.
    @Test
    public void test2(){
        System.out.println("Second Test Case");
    }

    @Test
    public void test3(){
        System.out.println("Second Test Case");
    }

    @BeforeMethod
    public void setUp(){
        // For each test case, we need to start openning a web browser.
        System.out.println("Webdriver, Ipening Browser");
    }

    @AfterMethod
    public void tearDown(){
        // For each test case, we need to end with closing a web browser.
        System.out.println("Closing Browser Quit");
    }


}
