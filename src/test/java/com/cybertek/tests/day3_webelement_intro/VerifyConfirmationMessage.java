package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyConfirmationMessage {
    public static void main(String[] args) throws InterruptedException {

        // Test case step1: Open web browser
        WebDriver driver = WebDriverFactory.getDriver("CHROME");

        // Test case step2: Navigate to the website(Link)
        driver.get("http://practice.cybertekschool.com/forgot_password");
        Thread.sleep(1000);

        // Test case step3: find email_box and type email there
        String expectedEmail = "mike@cybertek.com";
        // Eğer web element olarak id yoksa name e bakarız.
        WebElement emailInputBox = driver.findElement(By.name("email")); // it returns webElement
        emailInputBox.sendKeys(expectedEmail); // typing email in the email_box

        // Test case step4: Verify that email entered is displayed in the input box
        // FOR THİS WE SHOULD GET TEXT from web element. There are 2 ways for getting text element
        // 1. getText()--> it will work %99 ant it will return string . not working for input box
        // 2. getAttribute("value") --> second way of getting text especially input boxes

        String actualEmail = emailInputBox.getAttribute("value");
        if(expectedEmail.equals(actualEmail)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("actualEmail = " + actualEmail);
            System.out.println("expectedEmail = " + expectedEmail);
        }


        // Test case step5: Find and click "retrieve password"  button
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit")); // it returns webElement
        retrievePasswordButton.click(); // click the "retrieve password"  button

        // Test case step6: Verify that confirmation message says "Your e-mail's been sent!" .
        WebElement actualConfirmationMessage = driver.findElement(By.name("confirmation_message"));
        // IMPORTANT : This one return web element. to get confirmation text from the web element we use getText method.
        String actualMessage = actualConfirmationMessage.getText();
        String expectedConfirmationMessage = "Your e-mail's been sent!";
        if(actualMessage.equals(expectedConfirmationMessage)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("actualConfirmationMessage = " + actualMessage);
            System.out.println("expectedConfirmationMessage = " + expectedConfirmationMessage);
        }

        driver.quit();




    }
}
