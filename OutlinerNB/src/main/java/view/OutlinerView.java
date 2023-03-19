/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author jihun
 */
public class OutlinerView extends JFrame{
    private JTabbedPane tabbedPane;
    private SectionPanel sectionPanel= new SectionPanel();
    private SectionPanel sectionPanel1 = new SectionPanel();
    private SectionPanel sectionPanel2 = new SectionPanel();
    private SectionPanel sectionPanel3 = new SectionPanel();
    
    
    private UserPanel userPanel= new UserPanel();
    
    private AddPanel addPanel = new AddPanel();
    private EditPanel editPanel = new EditPanel();
    private DeletePanel deletePanel=new DeletePanel();
    
    private static final OutlinerView INSTANCE = new OutlinerView();
    
    public static OutlinerView getInstance()
    {
        return INSTANCE;
    }
    
    
    private OutlinerView(){

        editPanel.add(sectionPanel);
        
        JPanel addTabPanel = new JPanel();
        addTabPanel.setLayout(new BorderLayout());
        addTabPanel.add(sectionPanel2,BorderLayout.CENTER);
        addTabPanel.add(addPanel,BorderLayout.SOUTH);
        
        
        
        
        JPanel editTabPanel = new JPanel();
        editTabPanel.setLayout(new BorderLayout());
        editTabPanel.add(sectionPanel1, BorderLayout.CENTER);
        editTabPanel.add(editPanel, BorderLayout.SOUTH);
        
        JPanel deleteTabPanel=new JPanel();
        deleteTabPanel.setLayout(new BorderLayout());
        deleteTabPanel.add(sectionPanel3,BorderLayout.CENTER);
        deleteTabPanel.add(deletePanel, BorderLayout.SOUTH);
        
        tabbedPane = new JTabbedPane();
        tabbedPane.add("outline",sectionPanel);
        tabbedPane.add("add", addTabPanel);
        tabbedPane.add("edit", editTabPanel);
        tabbedPane.add("delete", deleteTabPanel);
        tabbedPane.add("assign a user", userPanel); //another column on csv probably
        
        
        this.add(tabbedPane, BorderLayout.CENTER);
        this.setSize(500,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public void alertBox(String s)
    {
        JOptionPane.showMessageDialog(null, s);
    }
    
    
    //getter/setter

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    public void setTabbedPane(JTabbedPane tabbedPane) {
        this.tabbedPane = tabbedPane;
    }

    public SectionPanel getSectionPanel() {
        return sectionPanel;
    }

    public void setSectionPanel(SectionPanel sectionPanel) {
        this.sectionPanel = sectionPanel;
    }

    public SectionPanel getSectionPanel1() {
        return sectionPanel1;
    }

    public void setSectionPanel1(SectionPanel sectionPanel1) {
        this.sectionPanel1 = sectionPanel1;
    }

    public SectionPanel getSectionPanel2() {
        return sectionPanel2;
    }

    public void setSectionPanel2(SectionPanel sectionPanel2) {
        this.sectionPanel2 = sectionPanel2;
    }

    public SectionPanel getSectionPanel3() {
        return sectionPanel3;
    }

    public void setSectionPanel3(SectionPanel sectionPanel3) {
        this.sectionPanel3 = sectionPanel3;
    }
    
    

    public AddPanel getAddPanel() {
        return addPanel;
    }

    public void setAddDeletePanel(AddPanel addDeleteEditPanel) {
        this.addPanel = addDeleteEditPanel;
    }

    public EditPanel getEditPanel() {
        return editPanel;
    }

    public void setEditPanel(EditPanel editPanel) {
        this.editPanel = editPanel;
    }

    public DeletePanel getDeletePanel() {
        return deletePanel;
    }

    public void setDeletePanel(DeletePanel deletePanel) {
        this.deletePanel = deletePanel;
    }

    public UserPanel getUserPanel() {
        return userPanel;
    }

    public void setUserPanel(UserPanel userPanel) {
        this.userPanel = userPanel;
    }

    

    
}
