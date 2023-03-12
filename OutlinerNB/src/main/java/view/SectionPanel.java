/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import control.TextController;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author jihun
 * Panel object that will have the text view of Outliner
 */
public class SectionPanel extends JPanel{
    private JButton loadBttn;
    private JTextArea text;
    private JScrollPane scrollPane;
    
    public SectionPanel()
    {
        this.setLayout(new BorderLayout());
        loadBttn=new JButton("load");
        loadBttn.setActionCommand("loadFile");
        loadBttn.addActionListener(new TextController());
        
        text = new JTextArea();
        scrollPane = new JScrollPane(text);
        
        this.add(loadBttn, BorderLayout.SOUTH);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    public JTextArea getText() {
        return text;
    }

    public void setText(JTextArea text) {
        this.text = text;
    }
    
    
}
