/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.kingston.ci5105.outliner;

import control.Outliner;
import model.DataAccess;
import view.OutlinerView;

/**
 *
 * @author jihun
 */
public class RunTests {
    public static void main(String[] args)
    {
        DataAccess.setFileName("testSections.csv");
        DataAccess.readSectionsFromCSVFile();
        Outliner.getInstance();
        Outliner.createView();
        OutlinerView.getInstance();
        OutlinerView.getInstance().getSectionPanel().getText().setText(Outliner.getView());   
        
        //tests go below here
        System.out.println(Tests.testAddNewSection());
        System.out.println(Tests.testSectionConstrutorIdAllocation());
        System.out.println(Tests.testAddSubSection());
        System.out.println(Tests.testEditSection());
        System.out.println(Tests.testDeleteSection());
    }
    
}
