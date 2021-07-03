package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TagNameLocator {
    public static void main(String[] args) throws InterruptedException {

        // Test case step1: Open web browser
        WebDriver driver = WebDriverFactory.getDriver("CHROME");

        driver.get("http://practice.cybertekschool.com/sign_up");
        Thread.sleep(1000);

        String fullName = "Mike Smith";
        WebElement fullNameInputBox = driver.findElement(By.tagName("input"));
        fullNameInputBox.sendKeys(fullName);

        /*
        tagName i locator olarak kullanırken dikkatli olmalıyız çünkü birden fazla yerde
        aynı tagName olabilir. Bu durumda selenium her defasında ilk buldugu tagName lokasyonuna
        işlem yapar. tagName i sadece bir tane varsa veya yukarıdan asagıya ilk gelen tagName e işlem yapmak
        istiyorsak kullanmalıyız.
         */


    }
}
