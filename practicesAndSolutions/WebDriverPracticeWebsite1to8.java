package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Guideline:  Please create test scripts from 1 through 5 in the same class,
 * with implementing @Before method for driver setup, and @After method for
 * driver close. Also, do the same thing for tests cases from 9 through 12.
 */
public class WebDriverPracticeWebsite_1_to_8 {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();

    }

    /**
     * Test case #1
     * Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
     * Step 2. Click on “Registration Form”
     * Step 3. Enter “wrong_dob” into date of birth input box.
     * Step 4. Verify that warning message is displayed: “The date of birth is not valid”
     */
    @Test
    public void test1() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[@href='/registration_form']")).click();
        driver.findElement(By.name("birthday")).sendKeys("wrong_dob");
        String actualresult = driver.findElement(By.xpath("//small[text()='The date of birth is not valid']")).getText();
        String expectedresult = "The date of birth is not valid";
        Assert.assertEquals(expectedresult, actualresult);

    }


    /**
     * Test case #2
     * Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
     * Step 2. Click on “Registration Form”
     * Step 3. Verify that following options for programming languages are displayed: c++, java, JavaScript
     */
    @Test
    public void test2() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[@href='/registration_form']")).click();
        List<WebElement> button = driver.findElements(By.cssSelector(".form-check-label"));
        Assert.assertEquals(button.get(0).getText(), "C++");
        Assert.assertEquals(button.get(1).getText(), "Java");
        Assert.assertEquals(button.get(2).getText(), "JavaScript");
    }

    /**
     * Test case #3
     * Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
     * Step 2. Click on “Registration Form”
     * Step 3. Enter only one alphabetic character into first name input box.
     * Step 4. Verify that warning message is displayed: “first name must be more than 2 and less than 64 characters long”
     */
    @Test
    public void test3() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[@href='/registration_form']")).click();
        driver.findElement(By.name("firstname")).sendKeys("a");
        String actualresult = driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']")).getText();
        String expectedresult = "first name must be more than 2 and less than 64 characters long";

        Assert.assertEquals(actualresult, expectedresult);
    }

    /**
     * Test case #4
     * Step 1. Go to https://practice-cybertekschool.herokuapp.com
     * Step 2. Click on “Registration Form”
     * Step 3. Enter only one alphabetic character into last name input box.
     * Step 4. Verify that warning message is displayed: “The last name must be more than 2 and less than 64 characters long”
     */
    @Test
    public void test4() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[@href='/registration_form']")).click();
        driver.findElement(By.name("lastname")).sendKeys("a");
        String actualresult = driver.findElement(By.xpath("//small[text()='The last name must be more than 2 and less than 64 characters long']")).getText();
        String expectedresult = "The last name must be more than 2 and less than 64 characters long";
        Assert.assertEquals(actualresult, expectedresult);


    }

    /**
     * Test case #5
     * Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
     * Step 2. Click on “Registration Form”
     * Step 3. Enter any valid first name.
     * Step 4. Enter any valid last name.
     * Step 5. Enter any valid user name.
     * Step 6. Enter any valid password.
     * Step 7. Enter any valid phone number.
     * Step 8. Select gender.
     * Step 9. Enter any valid date of birth.
     * Step 10. Select any department.
     * Step 11. Enter any job title.
     * Step 12. Select java as a programming language.
     * Step 13. Click Sign up.
     * Step 14. Verify that following success message is displayed: “You've successfully completed registration!”
     * Note: for using dropdown, please refer to the documentation: https://selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/Select.html or,
     * please watch short video about drop-downs that is posted on canvas
     *
     * @throws InterruptedException
     */
    @Test
    public void test5() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[@href='/registration_form']")).click();
        driver.findElement(By.name("firstname")).sendKeys("Bledar");
        driver.findElement(By.name("lastname")).sendKeys("Dakaj");
        driver.findElement(By.name("username")).sendKeys("Dakaj07");
        driver.findElement(By.name("email")).sendKeys("bledar@cybertekschool.com");
        driver.findElement(By.name("password")).sendKeys("BledarDakaj07");
        driver.findElement(By.name("phone")).sendKeys("012-012-0123");
        driver.findElement(By.cssSelector("input[value='male']")).click();
        driver.findElement(By.name("birthday")).sendKeys("07/07/1992");
        WebElement dropdown = driver.findElement(By.name("department"));
        Select departdrop = new Select(dropdown);
        departdrop.selectByVisibleText("Tourism Office");
        WebElement jobtitle = driver.findElement(By.name("job_title"));
        Select jbs = new Select(jobtitle);
        jbs.selectByVisibleText("Product Owner");
        List<WebElement> button = driver.findElements(By.cssSelector(".form-check-label"));
        button.get(1).click();
        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(4000);
        String expectedresult = "You've successfully completed registration!";
        String actualresult = driver.findElement(By.xpath("//div/p")).getText();
        Assert.assertEquals(actualresult, expectedresult);
    }

    /**
     * Test case #6
     * Step 1. Go to "https://www.tempmailaddress.com/"
     * Step 2. Copy and save email as a string.
     * Step 3. Then go to “https://practice-cybertekschool.herokuapp.com”
     * Step 4. And click on “Sign Up For Mailing List".
     * Step 5. Enter any valid name.
     * Step 6. Enter email from the
     * Step 2.Step 7. Click Sign Up
     * Step 8. Verify that following message is displayed: “Thank you for signing up. Click the button below to return to the home page.”
     * Step 9. Navigate back to the “https://www.tempmailaddress.com/”
     * Step 10. Verify that you’ve received an email from “do-not-reply@practice.cybertekschool.com”
     * Step 11. Click on that email to open it.
     * Step 12. Verify that email is from: “do-not-reply@practice.cybertekschool.com”
     * Step 13. Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”
     *
     * @throws InterruptedException
     */
    @Test
    public void test6() throws InterruptedException {
        driver.get("https://www.tempmailaddress.com/");
        String email = driver.findElement(By.id("email")).getText();
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[@href='/sign_up']")).click();
        driver.findElement(By.name("full_name")).sendKeys("BledarDakaj");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("wooden_spoon")).click();
        String expectedresult = "Thank you for signing up. Click the button below to return to the home page.";
        Assert.assertEquals(driver.findElement(By.className("subheader")).getText(), expectedresult);
        driver.navigate().to("https://www.tempmailaddress.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String actualText = driver.findElement(By.xpath("//*[contains(., 'do-not-reply')]")).getText();
        Assert.assertTrue(actualText.contains("do-not-reply@practice.cybertekschool.com"));
        driver.findElement(By.xpath("//div[@id='home']/div/table/tbody/tr[1]")).click();
        Assert.assertEquals(driver.findElement(By.id("odesilatel")).getText(), "do-not-reply@practice.cybertekschool.com");
        Assert.assertEquals(driver.findElement(By.cssSelector("#predmet")).getText(), "Thanks for subscribing to practice.cybertekschool.com!");
    }

    /**
     * Test case #7
     * Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
     * Step 2. And click on “File Upload".
     * Step 3. Upload any file with .txt extension from your computer.
     * Step 4. Click “Upload” button.
     * Step 5. Verify that subject is: “File Uploaded!”
     * Step 6. Verify that uploaded file name is displayed.
     * Note: use element.sendKeys(“/file/path”) with specifying path to the file for uploading. Run this method against “Choose File” button.
     */
    @Test
    public void test7() {
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[@href='/upload']")).click();
        WebElement chooseFile = driver.findElement(By.name("file"));
        chooseFile.sendKeys(System.getProperty("user.dir") + "/some-file.txt");
        driver.findElement(By.id("file-submit")).click();
        String actualresult = driver.findElement(By.xpath("//div[@class='panel text-center']")).getText();
        Assert.assertEquals(actualresult, "some-file.txt");
    }

    /**
     * Test case #8
     * Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
     * Step 2. And click on “Autocomplete”.
     * Step 3. Enter “United States of America” into country input box.
     * Step 4. Verify that following message is displayed: “You selected: United States of America”
     */
    @Test
    public void test8() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.cssSelector("[href='/autocomplete']")).click();

        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        driver.findElement(By.cssSelector("input[type='button']")).click();

        WebElement message = driver.findElement(By.id("result"));
        Assert.assertTrue(message.isDisplayed());
    }

}