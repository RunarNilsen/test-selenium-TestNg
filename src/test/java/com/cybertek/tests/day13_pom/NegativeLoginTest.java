package com.cybertek.tests.day13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    @Test
    public void testLoginWithWrongPassword() {
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        // connecting this class with the Login Page Object class
        // create object from loginPage class. By doing this we can reach our locators.
        LoginPage loginPage = new LoginPage();
        // reaching username element and send keys
        loginPage.usernameInput.sendKeys("user1");
        loginPage.passwordInput.sendKeys("somepassword");
        loginPage.loginButton.click(); // clicking the login button

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login", "verify that url doesn't change");

    }

    @Test
    public void testLoginWithWrongUsername() {
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        // connecting this class with the Login Page Object class
        // create object from loginPage class. By doing this we can reach our locators.
        LoginPage loginPage = new LoginPage();
        // reaching username element and send keys
        loginPage.usernameInput.sendKeys("someusername");
        loginPage.passwordInput.sendKeys("UserUser123");
        loginPage.loginButton.click(); // clicking the login button

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login", "verify that url doesn't change");

    }


    }
