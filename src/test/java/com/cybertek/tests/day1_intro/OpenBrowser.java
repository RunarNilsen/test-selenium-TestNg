package com.cybertek.tests.day1_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenBrowser {

    public static void main(String[] args) {

        // aşağıdaki linki chrome browserında otomatik olarak açacağız.

        // we have to enter this line every time we want to open Chrome Browser
        // This line makes Chrome ready for automation.
        WebDriverManager.chromedriver().setup(); //  WebDriverManager Selenium ile browserların iletişimini sağlar.

        // buradaki driver nesnesi bir chrome u temsil eder.
        // Burada driver nesnesi WebDriver dan değilde ChromeDriver classından oluşturuluyor. Burada interfaceler
        // üzerinden bir polimorfizm var.
        // WebDriver ile driver nesnesine sen bir browsersın diyoruz ve new ChromDriver ile de driver browserına sen bir Chrome Browsersın diyoruz.
        WebDriver driver = new ChromeDriver();  // bu polimorfizm e bir örnektir.
        driver.get("https://cybertekschool.com");

        // FOR FİREFOX BROWSER
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver1 = new FirefoxDriver();  // bu polimorfizm e bir örnektir.
        driver1.get("https://amazon.com");





    }
}
