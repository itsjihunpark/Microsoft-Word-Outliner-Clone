/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import control.TextController;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author jihun
 */
public class AddPanel extends JPanel{
    
    private JPanel addPanel;
    private JLabel newSectionContentLabel;
    private JTextArea newSectionContent;
    private JLabel subSectionOfLabel;
    private JTextArea subSectionOf;
    private JButton submitNewSectionBttn;
    
    
    public AddPanel(){   
        //Panel to hold add section
        
        this.setLayout(new GridLayout(5,1));
        
        newSectionContentLabel=new JLabel("ADD Enter new section data here:");
        newSectionContent=new JTextArea();
        subSectionOfLabel=new JLabel("Sub-section of which section? type 0 if root section");
        subSectionOf=new JTextArea();
        submitNewSectionBttn=new JButton("Add new Section");
        submitNewSectionBttn.setActionCommand("addNewSection");
        submitNewSectionBttn.addActionListener(new TextController());
        
        this.add(newSectionContentLabel);
        this.add(newSectionContent);
        this.add(subSectionOfLabel);
        this.add(subSectionOf);
        this.add(submitNewSectionBttn);

    }  
    
    //getter setter

    public JPanel getAddPanel() {
        return addPanel;
    }

    public void setAddPanel(JPanel addPanel) {
        this.addPanel = addPanel;
    }

    public JLabel getNewSectionContentLabel() {
        return newSectionContentLabel;
    }

    public void setNewSectionContentLabel(JLabel newSectionContentLabel) {
        this.newSectionContentLabel = newSectionContentLabel;
    }

    public JTextArea getNewSectionContent() {
        return newSectionContent;
    }

    public void setNewSectionContent(JTextArea newSectionContent) {
        this.newSectionContent = newSectionContent;
    }

    public JLabel getSubSectionOfLabel() {
        return subSectionOfLabel;
    }

    public void setSubSectionOfLabel(JLabel subSectionOfLabel) {
        this.subSectionOfLabel = subSectionOfLabel;
    }

    public JTextArea getSubSectionOf() {
        return subSectionOf;
    }

    public void setSubSectionOf(JTextArea subSectionOf) {
        this.subSectionOf = subSectionOf;
    }

    public JButton getSubmitNewSectionBttn() {
        return submitNewSectionBttn;
    }

    public void setSubmitNewSectionBttn(JButton submitNewSectionBttn) {
        this.submitNewSectionBttn = submitNewSectionBttn;
    }
}
