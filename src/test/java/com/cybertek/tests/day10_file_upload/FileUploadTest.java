package com.cybertek.tests.day10_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest {
    /*
    Since we go to the desktop while uploading a file, the element there is no longer a web element,
    becomes an element of our desktop application. There are several ways to click elements in this case here.

    - 1. If the "choose file" button has the argument like  type="file", We can use Selenium"sendKeys" method with
    file path to upload the file..
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
    public void testUploadFileWithSelenium() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/upload");
        // choose the element
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        // we are passing the path of the file that we want to upload
        // For dynamic way of choosing folder:
        // 1. create resources directory under test directory (everything must be under same directory),
        // 2. use projectPath that is unique for each computer
        // 3. use relativeFilePath that is common for all users.
        String projectPath = System.getProperty("user.dir");
        String relativeFilePath = "/src/test/resources/textfile.txt" ;
        String fullPath = projectPath + relativeFilePath;
        chooseFile.sendKeys(fullPath);
        // Click the upload button
        driver.findElement(By.id("file-submit")).click();
        Thread.sleep(2000);


        //getting the file name from the browser
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        String expectedFileName = "textfile.txt";
        // verify the file name is file.txt
        Assert.assertEquals(expectedFileName, actualFileName, "verify actual file name is file.txt");




    }
// /Users/muhammet/Desktop/CybertekKendiCalismam/Selenium/src/test/resources/textfile.txt







}
