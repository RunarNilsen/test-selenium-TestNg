package com.cybertek.tests.day2_web_driver_basics;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFactory {

    public static void main(String[] args) {


        // bu sekilde her yerde ortak olan kodları utilities içinde method olarak topladık ve her istediğimiz yerde kullanabiliriz.
       WebDriver driver = WebDriverFactory.getDriver("chrome");
       driver.get("http://practice.cybertekschool.com/");

        String title = driver.getTitle(); // sitenin TITLE değerini alıp bir stringe atadık ve yazdırdık.
        System.out.println("title = " + title);


    }

}
