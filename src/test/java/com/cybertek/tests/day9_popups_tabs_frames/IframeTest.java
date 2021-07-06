package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeTest {

    /*
    Frames or Iframes are used to create HTML inside the HTML. It means in the webpage code, there can be more than 1 HTML part.
    This is problem for a tester. Because Like windows Selenium can point only one HTML at once time.
    We need to switch among Iframes like windows.
     */

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
    public void testIframe() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/iframe");

        // 1st WAY OF SWITCHING AMONG FRAMES
        // we switch to the Iframe by using Iframe's ID attribute value.
        driver.switchTo().frame("mce_0_ifr");
        Thread.sleep(2000);

        // clear the everything inside the frame
        driver.findElement(By.cssSelector("#tinymce")).clear();
        // Typing "MIKE SIMITH" inside the frame
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MIKE SIMITH");
        Thread.sleep(2000);


        // 2nd WAY OF SWITCHING AMONG FRAMES
        // goes back to first frame(main html)  (1st way)
        // In the nested frames this goes BACK TO THE MAIN PARENT
        // goes back to first frame, useful when we have switched multiple frames
        driver.switchTo().defaultContent();
        Thread.sleep(2000);

        // Switching frames with using INDEX
        // After main HTML, zero(0) index refers to first child frame.
        // So if we have just two HTML (MAİN and a child) we can use like that
        driver.switchTo().frame(0);
        // clear the everything inside the frame
        driver.findElement(By.cssSelector("#tinymce")).clear();
        // Typing "WE WRITE HERE AGAIN" inside the frame
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("WE WRITE HERE AGAIN");
        Thread.sleep(2000);


        // goes back to first frame(main html) (2nd way)
        // In the nested frames this goes only back to childs parent NOT MAIN PARENT
        driver.switchTo().parentFrame();


        // 3rd WAY OF SWITCHING AMONG FRAMES (by using web element)
        // locate element by using any attribute. If we have only one Iframe, we can use Iframe as a tagName
        WebElement iframeElement = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframeElement); // switching frame by using Web Element.
        // clear the everything inside the frame
        driver.findElement(By.cssSelector("#tinymce")).clear();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("WE WRITE HERE AGAIN BY USING WEB ELEMENT");
        Thread.sleep(2000);

    }


    @Test
    public void testNestedFrames() throws InterruptedException {

        /* In this example, HTML order is like that
        HTML
            Frame-top
                left
                middle
                right
            Frame-bottom

    we have total 6 nested HTML sections .

    NOTE:we CANNOT jump from 1st frame to 3rd frame, we should do it in order (one by one)
    NOTE2: we CANNOT switch among the siblings. First we need to go to their parents back, and then switch to desired child.
         */

        driver.get("http://practice.cybertekschool.com/nested_frames");

        // Switching the middle frame
        driver.switchTo().frame("frame-top");
        // frame-top has 3 different frames under it.(left, middle, right)
        // Switching the middle frame
        driver.switchTo().frame("frame-middle");  //    "//frame[@name="frame-middle"]" for xpath
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.id("content")).getText()); // getting text written in the middle frame

        // In the nested frames this goes only back to childs parent NOT MAIN PARENT
        driver.switchTo().parentFrame();

        // Switching to the "right" frame that is on the third index
        driver.switchTo().frame(2);
        Thread.sleep(1000);

        System.out.println(driver.findElement(By.tagName("body")).getText());



        // To go to "frame-bottom". first we need to go back to the MAIN FRAME and then we switch to the frame-bottom
        // Go back to the main HTML
        driver.switchTo().defaultContent();
        Thread.sleep(2000);

        driver.switchTo().frame(1); // switching to the frame-bottom
        System.out.println(driver.findElement(By.tagName("body")).getText());

    }







    }
