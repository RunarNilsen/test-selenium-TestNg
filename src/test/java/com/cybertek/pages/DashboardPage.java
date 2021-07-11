package com.cybertek.pages;

public class DashboardPage extends BasePage{

    //*** IMPORTANT: If you need to access any element in a page, you will create the class of that page in the pages package and it will inherit from BasePage."""

    // this DashboardPage is created to reach subtitle. We have same menu therefore we "extends BasePage"

    // no need to explicitly write constructor, because it will use its parents constructor(BasePage's constructor)

    //subtitle element is common for all pages. That's why we write its locator and getText() method on BasePage class.

    /* ========================= IMPORTANT: ==============================
    If I were to use an element that only belongs to this page,
    I should define the locator of that element here, and
    if there will be a method belonging to that element, I should define it here.
     */

}
