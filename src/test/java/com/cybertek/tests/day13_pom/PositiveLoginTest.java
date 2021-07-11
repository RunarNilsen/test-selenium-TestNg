package com.cybertek.tests.day13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {

    // In these two Test case we have common actions like "loginPage.usernameInput.sendKeys(username);"
    // we can call this common action under action class for loginpage class. I will do it in loginAsStoreManager test.

    @Test
    public void loginAsDriver(){
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        // connecting this class with the Login Page Object class
        // create object from loginPage class. By doing this we can reach our locators.
        LoginPage loginPage = new LoginPage();
        // reaching username element and send keys
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginButton.click(); // clicking the login button



        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/", "verify that url is expected one");
    }

    @Test
    public void loginAsStoreManager(){
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        // connecting this class with the Login Page Object class
        // create object from loginPage class. By doing this we can reach our locators.
        LoginPage loginPage = new LoginPage();
        // reaching username element and send keys
        //loginPage.usernameInput.sendKeys(username);
        //loginPage.passwordInput.sendKeys(password);
        //loginPage.loginButton.click(); // clicking the login button

        loginPage.login(username, password);

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/", "verify that url is expected one");
    }

    //---------------------------------------------------------------------------------------------------
    // WE CAN CREATE METHOD INSIDE THE LoginPage CLASS FOR EACH TYPE OF USER. HERE WE DO FOR STORE MANAGER
    @Test
    public void loginAsStoreManager2(){
        // connecting this class with the Login Page Object class
        // create object from loginPage class. By doing this we can reach our locators.
        LoginPage loginPage = new LoginPage();

        loginPage.loginAsStoreManager();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/", "verify that url is expected one");
    }

    @Test
    public void loginAsDriver2(){
        // connecting this class with the Login Page Object class
        // create object from loginPage class. By doing this we can reach our locators.
        LoginPage loginPage = new LoginPage();

        loginPage.loginAsDriver();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/", "verify that url is expected one");
    }


}
