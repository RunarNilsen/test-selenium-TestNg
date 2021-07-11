package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {

    /*
    ==========TEST CASE for testPageSubtitle========
    1. Open chrome browser
    2. Login as a Driver
    3. Verify that page subtitle is "Quick Launchpad"
    4. Go to  "Calendar Events" in "Activities" tab
    5. Verify that page subtitle is "Calendar Events"
     */

    @Test
    public void testPageSubtitle(){

        // 1. Open chrome browser
        // initialize login object
        LoginPage loginPage = new LoginPage();

        // 2. Login as a Driver
        loginPage.loginAsDriver();

        // 3. Verify that page subtitle is "Quick Launchpad"
        String expectedSubtitle = "Quick Launchpad";
        // create DashboardPage object to access subtitle methods.
        DashboardPage dashboardPage = new DashboardPage();
        String actualSubtitle = dashboardPage.getPageSubTitle();
        Assert.assertEquals(actualSubtitle, expectedSubtitle, "Verify subtitle");

        //4. Go to  "Calendar Events" in "Activities" tab
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        // 5. Verify that page subtitle is "Calendar Events"
        // we will now work on Calendar Event Page.That's why we need to create "CalendarEventsPage" class Although we don't use anything from there
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        Assert.assertEquals(calendarEventsPage.getPageSubTitle(), "Calendar Events", "Verify Calendar Events Subtitle:");
    }







}
