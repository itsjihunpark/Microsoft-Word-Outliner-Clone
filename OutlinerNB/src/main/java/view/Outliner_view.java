
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import control.TextController;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author jihun
 */
public class Outliner_view extends JFrame
{
     
    private JTextArea text = new JTextArea();
    private JScrollPane scrollPane;
    private JButton printSelectedButton;
    private JMenuItem menuLoadBtn;
    private JMenuItem menuAddBtn;
    private JMenuItem menuOpen;
    private JFileChooser fileSelector;
    private JButton submitBtn;
    private JLabel editTextAreaLabel;
    private JLabel editSubSectionOfAreaLabel;
    private JTextArea editTextArea;
    private JTextArea editSubSectionOf;
    private JPanel inputArea;
    private JLabel deleteSectionLabel;
    private JTextArea deleteIdSection;
    private JButton deleteBtn; 
    private JPanel deletePanel;
    private JMenuBar menuBar;
    
    //singleton class
    private static final Outliner_view INSTANCE = new Outliner_view();
    public static Outliner_view getInstance()
    {
        return INSTANCE;
    }
    

    public void startViewer()
    {
        //Config
        this.setLayout(new BorderLayout());
        this.setTitle("Outliner Coursework Application");
        //Config End
        //Components start
        
        menuLoadBtn = new JMenuItem("Load Button");
        menuLoadBtn.setActionCommand("loadFile");
        menuLoadBtn.addActionListener(new TextController());
        //menuExitBtn.addActionListener(this);

        
       
        
        
        menuBar = new JMenuBar();
        menuBar.add(menuLoadBtn);

        
        
        
        scrollPane = new JScrollPane(text);
        
        inputArea = new JPanel();
        inputArea.setLayout(new GridLayout(8,1));
        
        printSelectedButton = new JButton("Print Selected");
        printSelectedButton.setActionCommand("textSelected");
        printSelectedButton.addActionListener(new TextController());
        
        //new section text input area
        editTextAreaLabel = new JLabel("Enter new section data here:");
        editTextArea = new JTextArea();
        editSubSectionOfAreaLabel = new JLabel("Sub-section of which section? type 0 if root section");
        editSubSectionOf = new JTextArea();
        
        submitBtn = new JButton("Add new Section");
        submitBtn.setActionCommand("addNewSection");
        submitBtn.addActionListener(new TextController());
        
        //delete section input area
        deleteSectionLabel= new JLabel("Enter the id of the section you'd like to delete below");
        deletePanel = new JPanel(new GridLayout(1,2));
        deleteIdSection = new JTextArea();
        deleteBtn = new JButton("delete this section");
        deleteBtn.setActionCommand("deleteSubmit");
        deleteBtn.addActionListener(new TextController());
        deletePanel.add(deleteIdSection);
        deletePanel.add(deleteBtn);
        
        //adding new section elements
        inputArea.add(editTextAreaLabel);
        inputArea.add(editTextArea);
        inputArea.add(editSubSectionOfAreaLabel);
        inputArea.add(editSubSectionOf);
        inputArea.add(submitBtn);
        inputArea.add(printSelectedButton);
        //
        inputArea.add(deleteSectionLabel);
        inputArea.add(deletePanel);
        //adding Components to frame
      
        this.add(menuBar, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(inputArea, BorderLayout.SOUTH);
        
        
        //Config
        this.setSize(500,600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Config End
        
    }
    
    
    public void alertBox(String s)
    {
        JOptionPane.showMessageDialog(null, s);
    }
    
    
    
    public JTextArea getText() 
    {
        return text;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public JButton getPrintSelectedButton() {
        return printSelectedButton;
    }

    public void setPrintSelectedButton(JButton printSelectedButton) {
        this.printSelectedButton = printSelectedButton;
    }

    public JMenuItem getMenuLoadBtn() {
        return menuLoadBtn;
    }

    public void setMenuLoadBtn(JMenuItem menuLoadBtn) {
        this.menuLoadBtn = menuLoadBtn;
    }

    public JMenuItem getMenuAddBtn() {
        return menuAddBtn;
    }

    public void setMenuAddBtn(JMenuItem menuAddBtn) {
        this.menuAddBtn = menuAddBtn;
    }

    public JMenuItem getMenuOpen() {
        return menuOpen;
    }

    public void setMenuOpen(JMenuItem menuOpen) {
        this.menuOpen = menuOpen;
    }

    public JFileChooser getFileSelector() {
        return fileSelector;
    }

    public void setFileSelector(JFileChooser fileSelector) {
        this.fileSelector = fileSelector;
    }

    public JButton getSubmitBtn() {
        return submitBtn;
    }

    public void setSubmitBtn(JButton submitBtn) {
        this.submitBtn = submitBtn;
    }

    public JLabel getEditTextAreaLabel() {
        return editTextAreaLabel;
    }

    public void setEditTextAreaLabel(JLabel editTextAreaLabel) {
        this.editTextAreaLabel = editTextAreaLabel;
    }

    public JLabel getEditSubSectionOfAreaLabel() {
        return editSubSectionOfAreaLabel;
    }

    public void setEditSubSectionOfAreaLabel(JLabel editSubSectionOfAreaLabel) {
        this.editSubSectionOfAreaLabel = editSubSectionOfAreaLabel;
    }

    public JTextArea getEditTextArea() {
        return editTextArea;
    }

    public void setEditTextArea(JTextArea editTextArea) {
        this.editTextArea = editTextArea;
    }

    public JTextArea getEditSubSectionOf() {
        return editSubSectionOf;
    }

    public void setEditSubSectionOf(JTextArea editSubSectionOf) {
        this.editSubSectionOf = editSubSectionOf;
    }

    public JPanel getInputArea() {
        return inputArea;
    }

    public void setInputArea(JPanel inputArea) {
        this.inputArea = inputArea;
    }

    public JLabel getDeleteSectionLabel() {
        return deleteSectionLabel;
    }

    public void setDeleteSectionLabel(JLabel deleteSectionLabel) {
        this.deleteSectionLabel = deleteSectionLabel;
    }

    public JTextArea getDeleteIdSection() {
        return deleteIdSection;
    }

    public void setDeleteIdSection(JTextArea deleteIdSection) {
        this.deleteIdSection = deleteIdSection;
    }

    public JButton getDeleteBtn() {
        return deleteBtn;
    }

    public void setDeleteBtn(JButton deleteBtn) {
        this.deleteBtn = deleteBtn;
    }

    public JPanel getDeletePanel() {
        return deletePanel;
    }

    public void setDeletePanel(JPanel deletePanel) {
        this.deletePanel = deletePanel;
    }

    public void setMenuBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
    }

    
    
}
