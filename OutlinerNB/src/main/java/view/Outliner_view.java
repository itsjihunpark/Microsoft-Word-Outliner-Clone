/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author jihun
 */
public class Outliner_view extends JFrame
{
    private static final Outliner_view INSTANCE = new Outliner_view();
    private Outliner_view()
    {
        this.setLayout(new BorderLayout());
        this.setTitle("Outliner Coursework Application");
        this.setSize(400,600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static Outliner_view getInstance() //SINGLETON GETTER
    {
        return INSTANCE;
    }
}
