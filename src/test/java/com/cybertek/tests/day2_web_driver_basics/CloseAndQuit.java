package com.cybertek.tests.day2_web_driver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
        Thread.sleep(2000);

        // aynı chrome da yeni bir sayfa açar.
        driver.get("http://practice.cybertekschool.com/new_tab");
        Thread.sleep(3000);
        driver.close(); // Close the current window (tab), quitting the browser if it's the last window currently open.

        driver = new ChromeDriver(); // Browser ı yeniden tanımlıyoruz.çünkü browserı kapattık.
        driver.get("http://practice.cybertekschool.com/");
        Thread.sleep(2000);
        driver.quit();  // Quits this driver, closing every associated window

    }
}
