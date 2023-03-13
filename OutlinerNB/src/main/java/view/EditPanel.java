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
public class EditPanel extends JPanel{
    
    private JLabel editSectionIdLabel;
    private JTextArea editSectionId;
    private JLabel editSectionLabel;
    private JTextArea editSection;
    private JButton editSectionBttn;
    
    public EditPanel()
    {
        this.setLayout(new GridLayout(5,1));
        editSectionIdLabel=new JLabel("EDIT enter the id of the section you want to edit");
        editSectionId=new JTextArea();
        editSectionLabel=new JLabel("update this section below");
        editSection=new JTextArea();             
        editSectionBttn=new JButton("click to edit");
        editSectionBttn.setActionCommand("edit");
        editSectionBttn.addActionListener(new TextController());
        this.add(editSectionIdLabel);
        this.add(editSectionId);
        this.add(editSectionLabel);
        this.add(editSection);
        this.add(editSectionBttn);

    }

    public JLabel getEditSectionIdLabel() {
        return editSectionIdLabel;
    }

    public void setEditSectionIdLabel(JLabel editSectionIdLabel) {
        this.editSectionIdLabel = editSectionIdLabel;
    }

    public JTextArea getEditSectionId() {
        return editSectionId;
    }

    public void setEditSectionId(JTextArea editSectionId) {
        this.editSectionId = editSectionId;
    }

    public JLabel getEditSectionLabel() {
        return editSectionLabel;
    }

    public void setEditSectionLabel(JLabel editSectionLabel) {
        this.editSectionLabel = editSectionLabel;
    }

    public JTextArea getEditSection() {
        return editSection;
    }

    public void setEditSection(JTextArea editSection) {
        this.editSection = editSection;
    }

    public JButton getEditSectionBttn() {
        return editSectionBttn;
    }

    public void setEditSectionBttn(JButton editSectionBttn) {
        this.editSectionBttn = editSectionBttn;
    }
    
    
}
