/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.DataAccess;
import model.Section;
import view.OutlinerView;
import view.Outliner_view;

/**
 *
 * @author jihun
 */
public class TextController implements ActionListener{
    //Action listener here
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        switch (e.getActionCommand())
        {
            case "loadFile":
                //Outliner_view.getInstance().getText().setText(Outliner.getInstance().getView());
                
                OutlinerView.getInstance().getSectionPanel().getText().setText(Outliner.getInstance().getView());
                OutlinerView.getInstance().getSectionPanel1().getText().setText(Outliner.getInstance().getView());
                OutlinerView.getInstance().getSectionPanel2().getText().setText(Outliner.getInstance().getView());
                OutlinerView.getInstance().getSectionPanel3().getText().setText(Outliner.getInstance().getView());
                break;
            // replace text generated from data access to one generated from outliner app
            case "textSelected":
                System.out.println(Outliner_view.getInstance().getText().getSelectedText());
                break;
            //use Outliner singleton class functions to link to buttons to add, delete, and save functionality
            case "addNewSection":
                
                //String sectionText = Outliner_view.getInstance().getEditTextArea().getText();
                //String subSectionOf = Outliner_view.getInstance().getEditSubSectionOf().getText();
                String sectionText = OutlinerView.getInstance().getAddPanel().getNewSectionContent().getText();
                String subSectionOf=OutlinerView.getInstance().getAddPanel().getSubSectionOf().getText();
                
                if(subSectionOf.equals("") && sectionText.equals(""))
                {
                    System.out.println("Value not filled in");
                    //Outliner_view.getInstance().alertBox("Value not filled in");
                    OutlinerView.getInstance().alertBox("Value not filled in");
                    break;
                }
                
                if(subSectionOf.equals("") && !sectionText.equals(""))
                {
                    subSectionOf ="0";
                }
                DataAccess.readSectionsFromCSVFile("sections.csv"); // could blow up in my face..
                Outliner.addSection(new Section(Integer.parseInt(subSectionOf),sectionText));
                
                //setting view section text
                //Outliner_view.getInstance().getText().setText(Outliner.getInstance().getView());
                OutlinerView.getInstance().getSectionPanel().getText().setText(Outliner.getInstance().getView());
                OutlinerView.getInstance().getSectionPanel1().getText().setText(Outliner.getInstance().getView());
                OutlinerView.getInstance().getSectionPanel2().getText().setText(Outliner.getInstance().getView());
                OutlinerView.getInstance().getSectionPanel3().getText().setText(Outliner.getInstance().getView());
                break;
            case "deleteSubmit":
               //if(Outliner_view.getInstance().getDeleteIdSection().getText().equals(""))
                if(OutlinerView.getInstance().getDeletePanel().getDeleteSection().getText().equals(""))
                {
                    //Outliner_view.getInstance().alertBox("Value not filled in");
                    OutlinerView.getInstance().alertBox("Value not filled in");
                    break;
                }  
                else{
                    //Outliner.deleteSection(Integer.parseInt(Outliner_view.getInstance().getDeleteIdSection().getText()));
                    Outliner.deleteSection(Integer.parseInt(OutlinerView.getInstance().getDeletePanel().getDeleteSection().getText()));
                    //setting view after deleting from the model
                    //Outliner_view.getInstance().getText().setText(Outliner.getInstance().getView());
                    OutlinerView.getInstance().getSectionPanel().getText().setText(Outliner.getInstance().getView());
                    OutlinerView.getInstance().getSectionPanel1().getText().setText(Outliner.getInstance().getView());
                    OutlinerView.getInstance().getSectionPanel2().getText().setText(Outliner.getInstance().getView());
                    OutlinerView.getInstance().getSectionPanel3().getText().setText(Outliner.getInstance().getView());
                    
                    
                    break;
                }
            case "edit":
                String sectionUpdateId = OutlinerView.getInstance().getEditPanel().getEditSectionId().getText();
                String sectionUpdateText = OutlinerView.getInstance().getEditPanel().getEditSection().getText();
                if(sectionUpdateId.equals("") || sectionUpdateText.equals(""))
                {
                    OutlinerView.getInstance().alertBox("Value not filled in");
                }
                else
                {
                    Outliner.editSection(Integer.parseInt(sectionUpdateId), sectionUpdateText);
                    OutlinerView.getInstance().getSectionPanel().getText().setText(Outliner.getInstance().getView());
                    OutlinerView.getInstance().getSectionPanel1().getText().setText(Outliner.getInstance().getView());
                    OutlinerView.getInstance().getSectionPanel2().getText().setText(Outliner.getInstance().getView());
                    OutlinerView.getInstance().getSectionPanel3().getText().setText(Outliner.getInstance().getView());
                }
                
                
                break;
            case "userView":
                
                OutlinerView.getInstance().getUserPanel().getText().setText(Outliner.getInstance().userView());
                break;
        }
        
    }
    
}
