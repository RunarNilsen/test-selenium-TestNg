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



}
