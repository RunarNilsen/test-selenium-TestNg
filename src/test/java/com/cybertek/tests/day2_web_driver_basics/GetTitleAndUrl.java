package com.cybertek.tests.day2_web_driver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndUrl {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
        String title = driver.getTitle(); // sitenin TITLE değerini alıp bir stringe atadık ve yazdırdık.
        System.out.println("title = " + title);

        String currentUrl = driver.getCurrentUrl(); // sitenin URL değerini alıp bir stringe atadık ve yazdırdık.
        System.out.println("currentUrl = " + currentUrl);

        String pageSource = driver.getPageSource(); // sitenin pagesource unu alır.
        System.out.println("pageSource = " + pageSource);


    }
}
