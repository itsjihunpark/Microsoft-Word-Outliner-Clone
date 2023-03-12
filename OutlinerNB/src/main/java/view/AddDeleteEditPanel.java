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
public class AddDeleteEditPanel extends JPanel{
    
    private JPanel addPanel;
    private JLabel newSectionContentLabel;
    private JTextArea newSectionContent;
    private JLabel subSectionOfLabel;
    private JTextArea subSectionOf;
    private JButton submitNewSectionBttn;
    
    private JPanel deletePanel;
    private JLabel deleteSectionLabel;
    private JTextArea deleteSection;
    private JButton deleteBttn;
    
    private JPanel editPanel;
    private JLabel editSectionIdLabel;
    private JTextArea editSectionId;
    private JLabel editSectionLabel;
    private JTextArea editSection;
    private JButton editSectionBttn;
    
    
    
    public AddDeleteEditPanel(){   
        this.setLayout(new GridLayout(3,1));
        
        //Panel to hold add section
        addPanel = new JPanel();
        addPanel.setLayout(new GridLayout(5,1));
        
        newSectionContentLabel=new JLabel("ADD Enter new section data here:");
        newSectionContent=new JTextArea();
        subSectionOfLabel=new JLabel("Sub-section of which section? type 0 if root section");
        subSectionOf=new JTextArea();
        submitNewSectionBttn=new JButton("Add new Section");
        submitNewSectionBttn.setActionCommand("addNewSection");
        submitNewSectionBttn.addActionListener(new TextController());
        
        addPanel.add(newSectionContentLabel);
        addPanel.add(newSectionContent);
        addPanel.add(subSectionOfLabel);
        addPanel.add(subSectionOf);
        addPanel.add(submitNewSectionBttn);
        //Panel to delete section
        deletePanel = new JPanel();
        deletePanel.setLayout(new GridLayout(3,1));
        deleteSectionLabel=new JLabel("DELETE Enter the id of the section you'd like to delete below");
        deleteSection=new JTextArea();
        deleteBttn=new JButton("delete this section");
        deleteBttn.setActionCommand("deleteSubmit");
        deleteBttn.addActionListener(new TextController());
        deletePanel.add(deleteSectionLabel);
        deletePanel.add(deleteSection);
        deletePanel.add(deleteBttn);  
        
        //panel to edit section
        editPanel=new JPanel();
        editPanel.setLayout(new GridLayout(5,1));
        editSectionIdLabel=new JLabel("EDIT enter the id of the section you want to edit");
        editSectionId=new JTextArea();
        editSectionLabel=new JLabel("update this section below");
        editSection=new JTextArea();             
        editSectionBttn=new JButton("click to edit");
        editSectionBttn.setActionCommand("edit");
        editSectionBttn.addActionListener(new TextController());
        editPanel.add(editSectionIdLabel);
        editPanel.add(editSectionId);
        editPanel.add(editSectionLabel);
        editPanel.add(editSection);
        editPanel.add(editSectionBttn);
        
        
        this.add(addPanel);
        this.add(deletePanel);
        this.add(editPanel);
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

    public JPanel getDeletePanel() {
        return deletePanel;
    }

    public void setDeletePanel(JPanel deletePanel) {
        this.deletePanel = deletePanel;
    }

    public JLabel getDeleteSectionLabel() {
        return deleteSectionLabel;
    }

    public void setDeleteSectionLabel(JLabel deleteSectionLabel) {
        this.deleteSectionLabel = deleteSectionLabel;
    }

    public JTextArea getDeleteSection() {
        return deleteSection;
    }

    public void setDeleteSection(JTextArea deleteSection) {
        this.deleteSection = deleteSection;
    }

    public JButton getDeleteBttn() {
        return deleteBttn;
    }

    public void setDeleteBttn(JButton deleteBttn) {
        this.deleteBttn = deleteBttn;
    }

    public JPanel getEditPanel() {
        return editPanel;
    }

    public void setEditPanel(JPanel editPanel) {
        this.editPanel = editPanel;
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
