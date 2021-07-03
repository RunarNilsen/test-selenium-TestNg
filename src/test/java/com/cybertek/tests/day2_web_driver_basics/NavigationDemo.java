package com.cybertek.tests.day2_web_driver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://amazon.com");

        // navigate().to()  ile get in yaptığını yapabiliriz. Şöyle bir durum var bundan önce amazon açık onu
        // nrk.no sitesine yönlendirir. Yani yeni bir chrome veya tab acmaz.
        driver.navigate().to("https://nrk.no");

        // Thread source kısmından yükleniyor yani ayrı bir kütüphane olarak import edilmiyor.
        Thread.sleep(3000); // Thread java kodudur. işlem arasında 3 sn bekle diyoruz.

        driver.navigate().back(); // back ile tekrar amazon.com a geri döneriz.
        Thread.sleep(3000);
        driver.navigate().forward(); // forward ile tekrar nrk.no ya gideriz.
        Thread.sleep(3000);
        driver.navigate().refresh(); // halihazırdaki sayfayı yeniler



    }
}
