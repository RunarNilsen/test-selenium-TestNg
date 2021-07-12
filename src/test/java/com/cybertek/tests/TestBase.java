package com.cybertek.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    /*
    We need to write BeforeMethod and AfterMethod in every single class which is not efficient.
    Instead of this, we will create one class that includes the methods and all new classes
    will inherent from the class.
     */

    // we use either protected or public here to use driver in other classes that inherent this class
    protected WebDriver driver;  // we declare webDriver class in class that we can reach driver in anywhere in that class.
    protected Actions actions;
    protected WebDriverWait wait;
    // This class is used for starting and building reports
    protected ExtentReports report;
    // This class is used to create HTML report file
    protected ExtentHtmlReporter htmlReporter;
    // This will define a test, enables adding logs, authors and test steps
    protected ExtentTest extentLogger;


    @BeforeTest
    public void setUpTest(){
        // we create reports after all test cases end.Therefore we create Before and AfterTest
        // They will run after all test cases finish to run

        // we will initialize our class here

        // Initialize Extent Report
        report = new ExtentReports();
        // create a report path. (we should position the path in our main file that everybody can use it later on dynamically )
        String projectPath = System.getProperty("user.dir"); //This is our project path
        String reportPath = projectPath + "/test-output/report.html";

        // Initialize HTML Report
        // Initialize the html reporter with the report path
        htmlReporter = new ExtentHtmlReporter(reportPath);

        // Attach the html report to report object
        // we are connecting report with our main object that we will create the report
        report.attachReporter(htmlReporter);

        // Title in report
        htmlReporter.config().setReportName("Vytrack Smoke Test"); // change here based on your project

        // Set environment information that we use in testing
        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name")); // Operating System
    }



    @BeforeMethod
    public void setUp(){
        // It will run before each test case
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        actions = new Actions(driver); // initialize the action class here
        wait = new WebDriverWait(driver, 10); // initialize wait object here.
        driver.get(ConfigurationReader.get("url")); // get the url from configuration.properties file for each test case
    }

    // ITestResult class describes the result of a test in TestNG
    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException, IOException {
        // here "result" argument has all information of the test execution
        // If test case is fail, we need to take screenshot and put it in the report before closing the browser.
        // Also we need to throw exception
        if (result.getStatus()==ITestResult.FAILURE){
            // record the name of fail test case
            extentLogger.fail(result.getName());
            // Take the screenshot and return location of screenshot (In BrowserUtils Class we have created this method)
            String screenshotPath = BrowserUtils.getScreenshot(result.getName());
            // Attach the screenshot to the report
            extentLogger.addScreenCaptureFromPath(screenshotPath); // Adding screenshot to the report

            // capture the exception and put inside the report
            extentLogger.fail(result.getThrowable());

        }


        Thread.sleep(2000);
        Driver.closeDriver(); // closing the driver at the end.

    }

    @AfterTest
    public void tearDownTest(){
        // this is when the report is actually created
        report.flush(); // this shows html report in test-output file
    }




}
