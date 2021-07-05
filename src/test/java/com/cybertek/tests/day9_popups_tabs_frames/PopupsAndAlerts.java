package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsAndAlerts {

    // There are different types of popups. İf the pop-up can be inspected, it is good.
    // But some pop-ups(alerts) cannot be clicked.

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
    public void testClickablePopup() throws InterruptedException {
        driver.get("http://www.primefaces.org:8080/showcase/ui/overlay/confirmDialog.xhtml?jfwid=33fc5");

        // we have select tag and its id value = "state". We locate webelement by using id attribute.
        WebElement popupDownElement = driver.findElement(By.xpath("//*[@id='j_idt302:j_idt303']"));
        popupDownElement.click();

        // Click "NO button" on the popup
        driver.findElement(By.xpath("//button[.='No']")).click();
    }

    @Test
    public void testNotClickablePopup() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        // we have select tag and its id value = "state". We locate webelement by using id attribute.
        // we trigger the pop-up
        WebElement popupDownElement = driver.findElement(By.xpath("//button[@onclick = 'jsAlert()']"));
        popupDownElement.click();

        // we will switch to JS alert pop-up
        Alert alert = driver.switchTo().alert();
        alert.accept(); // we will click "OK"  BUTTON. This code will work on JavaScript alerts.
        Thread.sleep(2000);

        // ---------------------------------------------------
        // 2. We will click cancel by using "dismiss()" method.
        driver.findElement(By.xpath("//button[@onclick = 'jsConfirm()']")).click(); // click the second button
        Thread.sleep(2000);
        // click the cancel on the js alert
        alert.dismiss();


        // verify the result at we click "cancel" on the pop-up
        WebElement popupResult = driver.findElement(By.cssSelector("#result"));
        String expectedResult = "You clicked: Cancel";
        String actualResult =  popupResult.getText();

        Assert.assertEquals(expectedResult, actualResult, "Verify that we cancel the pop-up");

        // ---------------------------------------------------
        // 3. How to write text in the inputBox on the pop-up? we use "alert.sendKeys();"
        driver.findElement(By.xpath("//button[@onclick = 'jsPrompt()']")).click(); // click the second button
        Thread.sleep(2000);
        alert.sendKeys("I am here");
        Thread.sleep(2000);
        alert.accept();  // we click OK after typing text in the inputBox

        // IMPORTANT NOTE: YOU CANNOT USE "ALERT CLASS" FOR CHROME POP-UP NOTIFICATIONS.
        // THE ALERT İS JUST FOR JAVA SCRIPT POP-UPS
    }


    }
