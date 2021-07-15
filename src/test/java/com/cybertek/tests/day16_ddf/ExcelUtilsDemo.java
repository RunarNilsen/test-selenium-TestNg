package com.cybertek.tests.day16_ddf;

import com.cybertek.utilities.ExcelUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo {

    @Test
    public void readExcelFile(){

        // Create ExcelUtils object from ExcelUtils.class
        ExcelUtils qa3short = new ExcelUtils("src/test/resources/VytrackTestData.xlsx", "QA3-short");

        // How many rows in the sheet
        System.out.println("qa3short.rowCount() = " + qa3short.rowCount());

        // How many columns in the sheet
        System.out.println("qa3short.columnCount() = " + qa3short.columnCount());

        // Get all column names. It returns list of strings
        System.out.println("qa3short.getColumnsNames() = " + qa3short.getColumnsNames());

        // Get all data in list of maps
        // Ech row in the excel sheet refers to one map. map consists of key and value pairs
        List<Map<String, String>> dataList = qa3short.getDataList();
        for (Map<String, String> oneRow : dataList) {
            System.out.println(oneRow);
        }

        // get "Nona" as a value
        System.out.println("dataList.get(2) = " + dataList.get(2)); // it return the 3rd row as a map
        System.out.println("firstname = " + dataList.get(2).get("firstname"));

        // get "Harber" as a lastname value
        System.out.println("lastname = " + dataList.get(8).get("lastname"));

        // get all data in 2d array
        String [][] dataArray = qa3short.getDataArray();
        //Printing values inside the 2d arrays. Takes the header part also.
        System.out.println(Arrays.deepToString(dataArray));
    }


}
