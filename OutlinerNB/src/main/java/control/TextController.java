/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.DataAccess;
import model.Section;
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
                Outliner_view.getInstance().getText().setText(Outliner.getInstance().getView());
                break;
            // replace text generated from data access to one generated from outliner app
            case "textSelected":
                System.out.println(Outliner_view.getInstance().getText().getSelectedText());
                break;
            //use Outliner singleton class functions to link to buttons to add, delete, and save functionality
            case "addNewSection":
                
                String sectionText = Outliner_view.getInstance().getEditTextArea().getText();
                String subSectionOf = Outliner_view.getInstance().getEditSubSectionOf().getText();
                if(subSectionOf.equals("") && sectionText.equals(""))
                {
                    System.out.println("Value not filled in");
                    Outliner_view.getInstance().alertBox("Value not filled in");
                    break;
                }
                
                if(subSectionOf.equals("") && !sectionText.equals(""))
                {
                    subSectionOf ="0";
                }
                
                Outliner.addSection(new Section(Integer.parseInt(subSectionOf),sectionText));
                Outliner_view.getInstance().getText().setText(Outliner.getInstance().getView());
                break;
        }
        
    }
    
}
