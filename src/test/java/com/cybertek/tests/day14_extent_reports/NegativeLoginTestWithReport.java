package com.cybertek.tests.day14_extent_reports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {

    @Test
    public void testLoginWithWrongPassword() {
        // Adding report to the test
        extentLogger = report.createTest("Wrong Password Test"); // First, giving test report name


        // connecting this class with the Login Page Object class
        // create object from loginPage class. By doing this we can reach our locators.
        LoginPage loginPage = new LoginPage();
        // reaching username element and send keys
        loginPage.usernameInput.sendKeys("user1");
        extentLogger.info("Enter Username: User1");
        loginPage.passwordInput.sendKeys("somepassword");
        extentLogger.info("Enter Password: somepassword");
        loginPage.loginButton.click(); // clicking the login button
        extentLogger.info("Click the Login Button");

        extentLogger.info("Verify Page URL");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login", "verify that url doesn't change");
        extentLogger.pass("Wrong Password Test is Passed");
    }

    @Test
    public void testLoginWithWrongUsername() {
        // Adding report to the test
        extentLogger = report.createTest("Wrong Username Test"); // First, giving test report name

        // connecting this class with the Login Page Object class
        // create object from loginPage class. By doing this we can reach our locators.
        LoginPage loginPage = new LoginPage();
        // reaching username element and send keys
        loginPage.usernameInput.sendKeys("someusername");
        extentLogger.info("Enter Username: someusername");
        loginPage.passwordInput.sendKeys("UserUser123");
        extentLogger.info("Enter Password: UserUser123");
        loginPage.loginButton.click(); // clicking the login button
        extentLogger.info("Click the Login Button");

        extentLogger.info("Verify Page URL");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login", "verify that url doesn't change");
        extentLogger.pass("Wrong Username Test is Passed");
    }
}
