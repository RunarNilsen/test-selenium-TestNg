package com.cybertek.tests.day14_extent_reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentDemoTest {
    // We will do demo for reporting  here  that's why it doesn't take inheretence from TestBase.

    // This class is used for starting and building reports
    ExtentReports report;
    // This class is used to create HTML report file
    ExtentHtmlReporter htmlReporter;
    // This will define a test, enables adding logs, authors and test steps
    ExtentTest extentLogger;


    @BeforeMethod
    public void setup(){
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
        htmlReporter.config().setReportName("Vytrack Smoke Test");

        // Set environment information that we use in testing
        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name")); // Operating System


    }

    @Test
    public void reportDemoTest(){
        // Give name to current report
        extentLogger = report.createTest("TC123 Login as Driver Test");

        // Adding test steps
        extentLogger.info("Open Chrome browser");
        extentLogger.info("Go to this url ");
        extentLogger.info("Enter Driver username and password");
        extentLogger.info("Click Login button");
        extentLogger.info("Verify logged in");

        // pass() -- marks test case as passed.
        extentLogger.pass(" TC123 is passed");


    }

    @AfterMethod
    public void teardown(){
        // this is when the report is actually created
        report.flush(); // this shows html report in test-output file

    }



}
