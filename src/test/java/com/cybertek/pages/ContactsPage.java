package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends BasePage{
    // Since we are extending BasePage, we do not need explicit constructor for this class

    @FindBy(xpath = "//td[@data-column-label='Email'][contains(text(), 'mbrackstone9@example.com')]")
    public WebElement getEmail;

    // create a method to get email dynamically
    public WebElement getContactEmail(String email){
        String xpath="//td[@data-column-label='Email'][contains(text(), '"+ email +"')]"; // write email dynamically
        return Driver.get().findElement(By.xpath(xpath));
    }


}
