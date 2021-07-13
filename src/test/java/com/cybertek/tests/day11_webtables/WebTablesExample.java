package com.cybertek.tests.day11_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesExample {

    WebDriver driver;  // we declare webDriver class in class that we can reach driver in anywhere in that class.

    @BeforeMethod
    public void setUp(){
        // It will run before each test case
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();

    }

    /*
     * Hover over each image in the website
     * verify each name:user text is displayed.
     * try to Use for loop. try to not use web element if it is possible
     */


    @Test
    public void printTable() throws InterruptedException {
        WebElement table1 = driver.findElement(By.xpath("//table[@id='table1']"));

        // printing the table
        System.out.println(table1.getText());

        // table1.getText()    keeps the all tables in a string variable.
        // We can get whatever we want by using "contains" string method
       // test if the table contains specific text.
        Assert.assertTrue(table1.getText().contains("jdoe@hotmail.com"), "verify that table contains the text");

    }

    // How many columns we have?
    @Test
    public void getAllHeaders() throws InterruptedException {
        // all headers list that belongs to the table1
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("headers.size() = " + headers.size());
        Assert.assertEquals(headers.size(), 6, "verify that table has 6 headers");

        for (WebElement header : headers) {
            System.out.println(header.getText());
        }

    }

    @Test
    public void printTableSize(){
        // all headers list that belongs to the table1
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("headers.size() = " + headers.size());

        // number of rows with header's row
        List<WebElement> rowsWithHeaderRow = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println("rowsWithHeaderRow.size() = " + rowsWithHeaderRow.size());

        // number of rows WITHOUT HEADER ROW
        // we get the tr inside the tbody
        List<WebElement> rowsInTbody = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println("rowsInTbody.size() = " + rowsInTbody.size());

    }

    @Test
    public void getRows(){
        // print the information of the second row
        WebElement row = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]"));
        System.out.println(row.getText());


        // printing all rows in table1 dynamically
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        for (int i = 1; i <= allRows.size(); i++) {
            WebElement uniqueRow = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]"));
            System.out.println(i + "-" + uniqueRow.getText());
        }

        // second way of printing all rows
        for (WebElement allRow : allRows) {
            System.out.println(allRow.getText());

        }
    }


    @Test
    public void getAllCellInOneRow(){
        // we will print each cell in a row separately.
        List<WebElement> allCellInOneRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));
        for (WebElement cell : allCellInOneRow) {
            System.out.println(cell.getText());
        }


    }
    @Test
    public void getAllCellInAllRows(){
        // we will print each cell in all row separately in table1.
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        for (int i = 1; i <=allRows.size() ; i++) {
            List<WebElement> allCellInOneRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr["+i+"]/td"));
            for (WebElement cell : allCellInOneRow) {
                System.out.println(cell.getText());
            }
        }

    }

    @Test
    public void getASingleCellByIndex(){
        // It gives information on the row 3 and column 5 in table 1.
        WebElement singleCell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]/td[5]"));
        System.out.println(singleCell.getText());
    }

    @Test
    public void printAllCellsByIndex(){
        int rowNumbers1 = getNumberOfRows();
        int columnNumbers1 = getNumberOfColumns();
        for (int i = 1; i <=rowNumbers1 ; i++) {
            for (int j = 1; j <=columnNumbers1 ; j++) {
                String elementPath = "//table[@id='table1']/tbody/tr["+i+"]/td["+j+"]";
                WebElement singleCell = driver.findElement(By.xpath(elementPath));
                System.out.println(singleCell.getText());
            }
        }
    }


    @Test
    public void getCellInRelationToAnotherCellInSameRow(){
        // find the email of a person
        String firstName = "John";
        WebElement relatedCell = driver.findElement(By.xpath("//table[@id='table1']//td[.='"+firstName+"']/../td[3]"));
        System.out.println(relatedCell.getText());
    }




    private int getNumberOfRows() {
        List<WebElement> rows1 = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        return rows1.size();
    }

    private int getNumberOfColumns() {
        List<WebElement> columns = driver.findElements(By.xpath("//table[@id='table1']//th"));
        return columns.size();
    }


}
