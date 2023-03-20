/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

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
public class UserPanel extends JPanel{
    private JButton loadBttn;
    private JTextArea text;
    private JScrollPane scrollPane;
    
    public UserPanel()
    {
        this.setLayout(new BorderLayout());
        loadBttn=new JButton("Display User");
        loadBttn.setActionCommand("userView");
        
        
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

    public JButton getLoadBttn() {
        return loadBttn;
    }

    public void setLoadBttn(JButton loadBttn) {
        this.loadBttn = loadBttn;
    }
    
    
}
