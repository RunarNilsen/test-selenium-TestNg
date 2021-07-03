package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassNameTest {
    public static void main(String[] args) throws InterruptedException {
        // Test case step1: Open web browser
        WebDriver driver = WebDriverFactory.getDriver("CHROME");

        driver.get("http://practice.cybertekschool.com/sign_up");
        Thread.sleep(1000);

        String fullName = "Mike Smith";
        WebElement homeLink = driver.findElement(By.className("nav-link")); // Home button a git
        homeLink.click(); //Home buttona tıkla

        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        System.out.println(driver.findElement(By.className("h3")).getText());


        // NOOOT: EGER CLASSNAME DE BOSLUK VARSA BUNU LOCATOR OLARAK İŞLEMLERDE KULLANAMAYIZ. CSS DE OLURSA KULLANIRIZ.
        // çoklu işlemler yaparken locatorlarla her bir işlemde locatorların aynı degere sahip olmaları lazım.
        // bu da genelde className ve tagName lerde olur.

    }
}
