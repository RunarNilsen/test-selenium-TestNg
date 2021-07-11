package com.cybertek.pages;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

    // converting this class to the page object model
    public LoginPage(){
        // PageFactory class allows us to use driver object with Selenium Page Object Model annotations
        PageFactory.initElements(Driver.get(), this); // "this" means pointing  the element in this page
    }


    // create locator here by using Selenium Page Object Model annotations
    // IF WE HAVE PROBLEM WITH ID IN THE FEATURE AND WE DECIDE TO USE NAME LOCATOR, COME HERE AND DELETE ID AND WRITE NAME INSTEAD OF IT.
    // web elements for login page.

    // driver.findElement(By.id("prependedInput"));
    @FindBy(id = "prependedInput")   // It represents driver.findElement method
    public WebElement usernameInput;

    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    @FindBy(id = "_submit")
    public WebElement loginButton;


    // METHODS FOR LOGIN PAGE


    // It will do common actions for Login module
    public void login(String username, String password){
        // reaching username element and send keys
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click(); // clicking the login button

    }


    // method for store manager
    public void loginAsStoreManager(){
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        // reaching username element and send keys
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click(); // clicking the login button

    }

    // method for store drivers
    public void loginAsDriver(){
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        // reaching username element and send keys
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click(); // clicking the login button

    }



}
