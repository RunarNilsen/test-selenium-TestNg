package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;

public class WebDriverFactory {

    // burada webDrive (browser) ile ilgili testin içinde yapacağımız ortak işlemleri tutacagız ve çağırması kolay olacak.

    // Task:
    // write a static method that takes a string parameters nase: browserType based on the value of parameters
    // it will setup the browser and the method vill return chromedriver or firefoxdriver object
    // name of the method: getDriver
    public static WebDriver getDriver(String browserType){
            WebDriver driver =null;
            switch (browserType.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }
        // açılan browserın boyutunu tam ekran yapar.
        //driver.manage().window().maximize();
        return driver;
    }


}
