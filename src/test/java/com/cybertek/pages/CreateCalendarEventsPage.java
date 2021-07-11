package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateCalendarEventsPage {
    public CreateCalendarEventsPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[id^='recurrence-repeat-view']")
    public WebElement repeat;

    @FindBy(css = "[id^='recurrence-repeats-view']")
    public WebElement repeatOptions;

    @FindBy(className = "select2-chosen")
    public WebElement selectedOwner;

    @FindBy(css = "input[id^='oro_calendar_event_form_title-']")
    public WebElement title;

    @FindBy(css = "input[id^='date_selector_oro_calendar_event_form_start']")
    public WebElement startDate;
    @FindBy(css = "input[id^='date_selector_oro_calendar_event_form_end']")
    public WebElement endDate;

    @FindBy(xpath = "(//input[@type='radio'])[1]")
    public WebElement days;

    @FindBy(xpath = "(//input[@type='radio'])[2]")
    public WebElement weekday;

    @FindBy(xpath = "(//input[@type='radio'])[3]")
    public WebElement never;

    @FindBy(xpath = "(//input[@type='radio'])[4]")
    public WebElement after;

    @FindBy(xpath = "(//input[@type='radio'])[5]")
    public WebElement by;


    // we have this method because our dropdown tagname has "Select"
    public Select repeatOptionsList(){
        // It will return "select object" that is created from Selenium Select Class
        return new Select(repeatOptions); // taking dropdown element as an argument
    }

    // dynamic way of selecting dropdowns
    public Select returnSelect(WebElement element){
        // It will return "select object" that is created from Selenium Select Class
        return new Select(element); // taking dropdown element as an argument
    }


}
