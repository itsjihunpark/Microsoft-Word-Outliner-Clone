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
public class DeletePanel extends JPanel{
    private JPanel deletePanel;
    private JLabel deleteSectionLabel;
    private JTextArea deleteSection;
    private JButton deleteBttn;
    
    public DeletePanel()
    {
        this.setLayout(new GridLayout(3,1));
        deleteSectionLabel=new JLabel("DELETE Enter the id of the section you'd like to delete below");
        deleteSection=new JTextArea();
        deleteBttn=new JButton("delete this section");
        deleteBttn.setActionCommand("deleteSubmit");
        deleteBttn.addActionListener(new TextController());
        this.add(deleteSectionLabel);
        this.add(deleteSection);
        this.add(deleteBttn);  
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

    
}
