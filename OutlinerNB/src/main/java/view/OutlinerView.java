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
    
    
    private UserPanel userPanel= new UserPanel();
    

    
    private static final OutlinerView INSTANCE = new OutlinerView();
    
    public static OutlinerView getInstance()
    {
        return INSTANCE;
    }
    
    
    private OutlinerView(){
        tabbedPane = new JTabbedPane();
        tabbedPane.add("outline",sectionPanel);

        
        
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

    public UserPanel getUserPanel() {
        return userPanel;
    }

    public void setUserPanel(UserPanel userPanel) {
        this.userPanel = userPanel;
    }

    

    
}
