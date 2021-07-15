package com.cybertek.tests.day16_ddf;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFWithDataProvider {


    // @DataProvider  annotation allows us to run test case based on number of the data that we provide
    @DataProvider
    public Object [][] testData(){
        String [][] data = {
                        {"Person of Interest", "10"},
                        {"Sherlock", "9"},
                        {"Breaking Bad", "9"},
                        {"The Office", "8"},
                        {"Friends", "7"},
                        {"Westworld", "10"},
                        {"Gotham", "9"}
                            };

        return data;
    }


    // connecting DataProvider with the Test CASE
    @Test(dataProvider = "testData")
    public void test1(String  tvShow, String rating){

        System.out.println("Tv Show: " + tvShow + " has rating: " + rating);

    }



}
