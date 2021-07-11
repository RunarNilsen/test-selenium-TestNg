package com.cybertek.tests.day13_pom;

import com.cybertek.pages.*;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatOptionsTest extends TestBase {

    /*
    ==========TEST CASE for Radio Buttons========
    1. Open chrome browser
    2. Login as a Driver
    3. Go to  "Calendar Events" in "Activities" tab
    4. Click on "Create Calendar Event" button
    5. Click on "repeat"
    6. Verify that repeat every days is checked
    7. Verify that repeat weekday is not checked
     */
    @Test
    public void testRadioButton(){
        // 1. Open chrome browser
        LoginPage loginPage = new LoginPage();
        // 2. Login as a Driver
        loginPage.loginAsDriver();
        // 3. Go to  "Calendar Events" in "Activities" tab
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        // 4. Click on "Create Calendar Event" button
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();

        // 5. Click on "repeat"
        // now we are on Create Calendar Events Page, therefore first we create " CreateCalendarEventPage" object
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();
        Assert.assertTrue(createCalendarEventsPage.days.isSelected(), "verify the repeat is selected");

        // 7. Verify that repeat weekday is not checked
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected(), "Verify that weekday is NOT selected");

    }

    /*
    ==========TEST CASE for Repeat Options========
    1. Open chrome browser
    2. Login as a Driver
    3. Go to  "Calendar Events" in "Activities" tab
    4. Click on "Create Calendar Event" button
    5. Click on "repeat checkbox"
    6. Verify that repeat options are Daily, Weekly, Monthly, and Yearly in order.

     */
    @Test
    public void testRepeatOptionsOrder(){
        // 1. Open chrome browser
        LoginPage loginPage = new LoginPage();
        // 2. Login as a Driver
        loginPage.loginAsDriver();
        // 3. Go to  "Calendar Events" in "Activities" tab
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        // 4. Click on "Create Calendar Event" button
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();

        // 5. Click on "repeat checkbox"
        // now we are on Create Calendar Events Page, therefore first we create " CreateCalendarEventPage" object
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();

        // 6. Verify that repeat options(dropdown button) are Daily, Weekly, Monthly, and Yearly in order.
        // In dropdown menu, we should check first if there is "select" tag on the locator. In here we have "select" tag
        // We use Selenium Select class inside the CreateCalendarEventsPage class.
        Select repeatsDropdown = createCalendarEventsPage.repeatOptionsList(); // creating Select Object
        List<String> expectedList = Arrays.asList("Daily", "Weekly", "Monthly", "Yearly");
        List<String> actualList = new ArrayList<>();

        List<WebElement> actualOptions = repeatsDropdown.getOptions();// getting all dropdown list as a WebElement
        for (WebElement actualOption : actualOptions) {
            actualList.add(actualOption.getText());
        }

        // we have created method for getting text inside the web element list.
        // List<String> actualList = BrowserUtils.getElementsText(actualOptions);
        Assert.assertEquals(expectedList, actualList, "Verify the order of the dropdown");





    }




}
