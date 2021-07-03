package com.cybertek.tests.day5_xPath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Xpath_assignment1 {
    public static void main(String[] args) throws InterruptedException {

        /*

        Task:
        - go to amazon.com
        - search for selenium
        - click search button
        - verify 1-48 of 190 result for "selenium"
         */

        // Test case step1: Open web browser
        WebDriver driver = WebDriverFactory.getDriver("CHROME");

        // Test case step2: Navigate to the website(Link)
        driver.get("http://amazon.com");
        Thread.sleep(1000);

        // search for selenium
        WebElement typeSerchBox = driver.findElement(By.xpath("//input[@id = 'twotabsearchtextbox']")); // it returns webElement
        typeSerchBox.sendKeys("selenium"); // click the "retrieve password"  button


        // click search button
        WebElement xpathClickSearchButton = driver.findElement(By.xpath("//input[@id = 'nav-search-submit-button']")); // it returns webElement
        xpathClickSearchButton.click();


        // click search button
        WebElement xpathCheckTextFirst = driver.findElement(By.xpath("//div[@class = 'a-section a-spacing-small a-spacing-top-small']/span[1]")); // it returns webElement
        xpathCheckTextFirst.getText();

        // click search button
        WebElement xpathCheckTextSecond = driver.findElement(By.xpath("//div[@class = 'a-section a-spacing-small a-spacing-top-small']/span[3]")); // it returns webElement
        xpathCheckTextSecond.getText();

        String expectedText= "1-48 of 190 results for \"selenium\"";
        String actualText= xpathCheckTextFirst.getText() + " " + xpathCheckTextSecond.getText();

        if(expectedText.equals(actualText)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }



    }
}
