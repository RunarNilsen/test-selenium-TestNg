package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Guideline:  Please create test scripts from 1 through 5 in the same class,
 * with implementing @Before method for driver setup, and @After method for
 * driver close. Also, do the same thing for tests cases from 9 through 12.
 * <p>
 * Optional: If you want to to be a real selenium hero, use @DataProvider for for tests cases from 9 through 12.
 * Please use following documentation: https://testng.org/doc/documentation-main.html#parameters-dataprovidersTest case #9 Step 1.
 */
public class WebDriverPracticeWebsite_9_to_12 {
    WebDriver driver;

    @BeforeMethod
    public void set() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Status Codes")).click();
    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }

    /**
     * Test case #9
     * Step 1. Go to “https://practice- cybertekschool.herokuapp.com”
     * Step 2. And click on “Status Codes”.
     * Step 3. Then click on “200”.
     * Step 4. Verify that following message is displayed: “This page returned a 200 status code”
     */
    @Test
    public void test9() {
        driver.findElement(By.linkText("200")).click();
        String msg = driver.findElement(By.tagName("p")).getText();
        boolean contains = msg.contains("This page returned a 200 status code");
        Assert.assertTrue(contains);
    }

    /**
     * Test case #10
     * Step 1. Go to “https://practice- cybertekschool.herokuapp.com”
     * Step 2. And click on “Status Codes”.
     * Step 3. Then click on “301”.
     * Step 4. Verify that following message is displayed: “This page returned a 301 status code”
     */
    @Test
    public void test10() {
        driver.findElement(By.linkText("301")).click();
        String msg = driver.findElement(By.tagName("p")).getText();
        boolean contains = msg.contains("This page returned a 301 status code");
        Assert.assertTrue(contains);
    }

    /**
     * Test case #11
     * Step 1. Go to “https://practice- cybertekschool.herokuapp.com”
     * Step 2. And click on “Status Codes”.
     * Step 3. Then click on “404”.
     * Step 4. Verify that following message is displayed: “This page returned a 404 status code”
     */
    @Test
    public void test11() {
        driver.findElement(By.linkText("404")).click();
        String msg = driver.findElement(By.tagName("p")).getText();
        boolean contains = msg.contains("This page returned a 404 status code");
        Assert.assertTrue(contains);
    }

    /**
     * Test case #12
     * Step 1. Go to “https://practice- cybertekschool.herokuapp.com”
     * Step 2. And click on “Status Codes”.
     * Step 3. Then click on “500”.
     * Step 4. Verify that following message is displayed: “This page returned a 200 status code”
     */
    @Test
    public void test12() {
        driver.findElement(By.linkText("500")).click();
        String msg = driver.findElement(By.tagName("p")).getText();
        boolean contains = msg.contains("This page returned a 500 status code");
        Assert.assertTrue(contains);


    }

    /**
     * Go to “https://practice-cybertekschool.herokuapp.com”
     * Step 2. And click on “Status Codes”.
     * Step 3. Then click on “200”.
     * Step 4. Verify that following message is displayed: “This page returned a 200 status code”
     *
     * @param code
     * @param message
     * @throws InterruptedException
     */
    @Test(dataProvider = "getData")
    public void statCodes(String code, String message) throws InterruptedException {
        driver.findElement(By.linkText(code)).click();
        String msg = driver.findElement(By.tagName("p")).getText();
        boolean contains = msg.contains(message);
        Assert.assertTrue(contains);
    }

    @DataProvider
    public Object[][] getData() {

        Object[][] data = new Object[4][2];
        //first column = > error code
        //second column => er¬ror message

        // test case 9
        data[0][0] = "200";
        data[0][1] = "This page returned a 200 status code";

        // test case 10
        data[1][0] = "301";
        data[1][1] = "This page returned a 301 status code";

        // test case 11
        data[2][0] = "404";
        data[2][1] = "This page returned a 404 status code";

        // test case 12
        data[3][0] = "500";
        data[3][1] = "This page returned a 500 status code";
        return data;
    }
}