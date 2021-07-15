package com.cybertek.tests.day15_review;

import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyContactInfoTest extends TestBase {

    /*
    =======0Test Case========
    1. open the chrome
    2. go to qa1.vytrack
    3. login as a sales manager
    4. navigate to customers ->contacts
    5. click on email mbrackstone9@example.com
    6. verify that full name is Mariam Brackstone
    7. verify that email is mbrackstone9@example.com
    8. verify that phone number is +18982323434
     */
    @Test
    public void contactDetailsTest() throws InterruptedException {
        extentLogger = report.createTest("Vytrack Verification Test"); // First, giving test report name
        LoginPage loginPage = new LoginPage();
        String username =ConfigurationReader.get("salesmanager_username");
        String password =ConfigurationReader.get("salesmanager_password");
        // 3. login as a sales manager
        loginPage.login(username, password); // login as a sales manager
        extentLogger.info("Enter Username:" + username);
        extentLogger.info("Enter Password:" + password);
        // 4. navigate to customers ->contacts
        // DashboardPage dashboardPage = new DashboardPage();
        BrowserUtils.waitForPageToLoad(5);
        new DashboardPage().navigateToModule("Customers", "Contacts"); // if you use this one time, don't create object, use like that
        BrowserUtils.waitForPageToLoad(10);
        extentLogger.info("Navigate to customers ->contacts);");
        // 5. click on email mbrackstone9@example.com
        ContactsPage contactsPage = new ContactsPage();
        contactsPage.waitUntilLoaderScreenDisappear();
        contactsPage.getContactEmail("mbrackstone9@example.com").click();
        Thread.sleep(5);
        extentLogger.info("Click on the email of mbrackstone9@example.com");

        // 6. verify that full name is Mariam Brackstone
        ContactInfoPage contactInfoPage = new ContactInfoPage();

        extentLogger.info("Verify full name is Mariam Brackstone");
        Assert.assertEquals(contactInfoPage.fullName.getText(), "Mariam Brackstone", "Verify full Name: ");

        // 7. verify that email is mbrackstone9@example.com
        extentLogger.info("Verify email is mbrackstone9@example.com");
        Assert.assertEquals(contactInfoPage.email.getText(), "mbrackstone9@example.com", "Verify email address: ");

        // 8. verify that phone number is +18982323434
        extentLogger.info("Verify phone is +18982323434");
        Assert.assertEquals(contactInfoPage.phone.getText(), "+189823234341", "Verify phone number: ");

        extentLogger.info("Vytrack Verification Test has been PASSED");

    }



}
