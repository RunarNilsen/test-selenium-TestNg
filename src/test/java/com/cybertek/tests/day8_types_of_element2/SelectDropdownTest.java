package com.cybertek.tests.day8_types_of_element2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropdownTest {
    // If the dropdown element has tagname of "select", it will be easier to reach the element,
    // BUT if it doesnot have "select", we need to

    WebDriver driver;  // we declare webDriver class in class that we can reach driver in anywhere in that class.

    @BeforeMethod
    public void setUp(){
        // It will run before each test case
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }

    @Test
    public void testWithSelect() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dropdown");

        // we have select tag and its id value = "state". We locate webelement by using id attribute.
        WebElement dropDownElement = driver.findElement(By.id("state"));

        // create Select object
        // Selenium has special class named "Select"
        Select stateDropdown = new Select(dropDownElement); // Select's construtor need argument of web element

        // We are creating object from Select class because we will have very useful methods for drowdown elements.
        List<WebElement> options = stateDropdown.getOptions(); // it gives all options in the dropdown menu
        System.out.println("options.size() : " + options.size());

        // print the options one by on.
        for (WebElement option : options) {
            System.out.println("option.getText() = " + option.getText());

        }
    }

        // verify that first selection is Select a state
        @Test
        public void testWithSelect2() throws InterruptedException {
            driver.get("http://practice.cybertekschool.com/dropdown");

            // we have select tag and its id value = "state". We locate webelement by using id attribute.
            WebElement dropDownElement = driver.findElement(By.id("state"));

            // create Select object
            // Selenium has special class named "Select"
            Select stateDropdown = new Select(dropDownElement); // Select's construtor need argument of web element

            // verify that first selection is Select a state
            String expectedOption = "Select a State";
            String actualOption = stateDropdown.getFirstSelectedOption().getText();
            Assert.assertEquals(expectedOption, actualOption, " verify first selection");

    }


    // Selecting something from dropdown
    @Test
    public void testWithSelect3() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dropdown");

        // we have select tag and its id value = "state". We locate webelement by using id attribute.
        WebElement dropDownElement = driver.findElement(By.id("state"));

        // create Select object
        // Selenium has special class named "Select"
        Select stateDropdown = new Select(dropDownElement); // Select's construtor need argument of web element
        Thread.sleep(2000);
        stateDropdown.selectByVisibleText("Virginia"); // we can write the name of the option.It will be chosen.

        // verify if you selected "Virginia" option
        // above we selected the Virginia. It means now firstoption should be Virginia.
        String expectedOption = "Virginia";
        String actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption, actualOption, " verify if you selected \"Virginia\" option: ");

        // we can also select by using index.
        Thread.sleep(2000);
        stateDropdown.selectByIndex(51); // gives last option because we have 52 options in dropdown menu
        expectedOption = "Wyoming";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption, actualOption, " verify if you selected \"Wyoming\" option: ");


        // we can also select by using value attribute.
        Thread.sleep(2000);
        stateDropdown.selectByValue("AL"); // allows to select  Alabama

        expectedOption = "Alabama";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption, actualOption, " verify if you selected \"Alabama\" option: ");




    }





}

