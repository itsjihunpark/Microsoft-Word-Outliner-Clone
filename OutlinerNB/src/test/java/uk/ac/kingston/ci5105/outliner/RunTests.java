/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.kingston.ci5105.outliner;

import control.Outliner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        
        try {
            
            System.out.println(Tests.testAddNewSection());
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Tests.testSectionConstrutorIdAllocation());
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Tests.testAddSubSection());
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Tests.testEditSection());
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Tests.testDeleteSection());
            TimeUnit.SECONDS.sleep(1);
            System.out.println(DataAccess.getSections().size());
            
        
        } catch (InterruptedException ex) {
            Logger.getLogger(RunTests.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
