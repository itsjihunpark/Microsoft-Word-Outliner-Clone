/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.kingston.ci5105.outliner;

import control.Outliner;
import model.DataAccess;
import model.Section;
import view.OutlinerView;

/**
 *
 * @author jihun
 */
public class Tests {
    
    public static boolean testAddNewSection()
    {
        System.out.println("Testing adding new section");//edit here
        Section testSection = new Section(0,"Test new section");
        int testId = testSection.getId();
        Outliner.addSection(testSection);
        OutlinerView.getInstance().getSectionPanel().getText().setText(Outliner.getInstance().getView());
        
        if(DataAccess.getSectionByIdFromUnOrderedList(testId).getId() == testId)
        {
            System.out.println("New section added");
            return true;
        }
        else{
            return false;
        }  
    }
    public static boolean testSectionConstrutorIdAllocation()
    {
        System.out.println("Testing correct allocation of new section ID");
        if(Outliner.getInstance().getSections().get(0).getId() == 1)
        {
            System.out.println("Correct ID allocated");
            return true;
        }
        else
        {
            return false;
        }
       
    }
    
    public static boolean testAddSubSection()
    {
        System.out.println("Testing adding subsection"); //edit here
        Outliner.addSection(new Section(1, "New subsection test"));
        OutlinerView.getInstance().getSectionPanel().getText().setText(Outliner.getInstance().getView());
        String subSectionText = Outliner.getInstance().getSections().get(0).getSubSections().get(0).getText().trim();
        if(subSectionText.equals("New subsection test"))
        {
            System.out.println("new subsection added");
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean testEditSection()
    {
        System.out.println("Testing editing section");//edit here
        Outliner.editSection(1, "test edit");
        OutlinerView.getInstance().getSectionPanel().getText().setText(Outliner.getInstance().getView());
        String editedText = Outliner.getInstance().getSections().get(0).getText();
        if(editedText.equals("test edit"))
        {
            System.out.println("Section edited");
            return true;
        }
        else{
            return false;
        }  
    }
    public static boolean testDeleteSection()
    {
        System.out.println("Testing deleting section");//edit here
        Outliner.deleteSection(1);
        OutlinerView.getInstance().getSectionPanel().getText().setText(Outliner.getInstance().getView());
        if(Outliner.getInstance().getSections().size()==0)
        {
            System.out.println("Section deleted");
            return true;   
        }
        else{
            return false;
        }
        
    }
    
}
