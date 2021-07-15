package com.cybertek.tests.day16_ddf;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFLoginTest extends TestBase {
    // In here we will use data from the excel sheet and we use dataProvider to apply these data to the TEST case

    @DataProvider
    public Object [][] userData(){
        // Create ExcelUtils object from ExcelUtils.class
        ExcelUtils qa3short = new ExcelUtils("src/test/resources/VytrackTestData.xlsx", "QA3-short");
        // get all data in 2d array
        String [][] dataArray = qa3short.getDataArrayWithoutFirstRow(); // first row is a header therefore we skip
        return dataArray;
    }

    @Test(dataProvider = "userData")
    public void test1(String username, String password, String firstname, String lastname){
        extentLogger =report.createTest("Test" + firstname + " " + lastname); //Adding testcase name

        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();

        String actualFullName = dashboardPage.getUserName(); // getting username from the web element
        String expectedFullName = firstname + " " + lastname;

        Assert.assertEquals(actualFullName, expectedFullName, "Verify the full name: ");
        extentLogger.pass("PASSED");





    }





}
