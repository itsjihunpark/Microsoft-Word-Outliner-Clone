/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author jihun
 */
public class Outliner_view extends JFrame
{
   
    private JTextArea outlinerTextArea;
    private String text;
    
    //singleton class
    private static final Outliner_view INSTANCE = new Outliner_view();
    public static Outliner_view getInstance()
    {
        return INSTANCE;
    }
    
    private Outliner_view()
    {
        
        
    }

    public void startViewer()
    {
        //Config
        this.setLayout(new BorderLayout());
        this.setTitle("Outliner Coursework Application");
        //Config End
        
        
        outlinerTextArea = new JTextArea();
        outlinerTextArea.setText(text);
        this.add(outlinerTextArea);
        
        //Config
        this.setSize(400,600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Config End
        
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
}
