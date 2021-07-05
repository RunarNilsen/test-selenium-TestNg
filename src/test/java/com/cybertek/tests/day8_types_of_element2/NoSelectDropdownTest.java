package com.cybertek.tests.day8_types_of_element2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.plaf.TableHeaderUI;
import java.util.List;

public class NoSelectDropdownTest {

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
    public void testWithoutSelect() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dropdown");

        // we have select tag and its id value = "state". We locate webelement by using id attribute.
        WebElement dropDownElement = driver.findElement(By.id("dropdownMenuLink"));

        // we dont have Select tag, so we need to follow regular way. we cannot use select class.
        //Click dropdown to see all options
        dropDownElement.click();

        // we can use findelements mentod.
        List<WebElement> elements = driver.findElements(By.cssSelector(".dropdown-item"));
        System.out.println("elements.size() = " + elements.size());

        // print them one by one
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }

        // clicking one of them
        elements.get(0).click();
        Thread.sleep(2000);

    }


}
