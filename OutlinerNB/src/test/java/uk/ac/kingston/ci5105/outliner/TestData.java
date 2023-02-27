/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.kingston.ci5105.outliner;

import java.io.File;
import model.Section;

/**
 *
 * @author jihun
 */
public class TestData 
{
    //static methods that returns a value that will be fed through to the test class
    public static String testCreateSectionFromCsvLine()
    {
        //System.out.println("Testing [TEST ID] test1: testCreateSectionFromCsvLine"); 
        return "1,0,RootSection instantiation";
    }
    public static String testCreateSectionsFromCsvFile()
    {
        //System.out.println("Testing [TEST ID] test2: testCreateSectionsFromCsvFile");      
        return "testdata"+File.separator + "testSections.csv";
    }
  
}
