/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import control.TextController;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

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
        
        text.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                int line;
                String clickedText="";
                try {
                    line = text.getLineOfOffset( text.getCaretPosition() );
                    int start = text.getLineStartOffset( line );
                    int end = text.getLineEndOffset( line );
                    clickedText = text.getDocument().getText(start, end - start);
                    clickedText.trim();
                } catch (BadLocationException ex) {
                    Logger.getLogger(SectionPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                String inputValue = JOptionPane.showInputDialog("Enter new section value");
                if(clickedText.equals("")){
                    System.out.println("You're creating a new section");
                    
                }
                else{
                    
                    int id = clickedText.lastIndexOf("id:")+3;
                    int clickedSectionId = Integer.parseInt(clickedText.substring(id).trim());
                    System.out.println("You're creating a sub section of id: "+ clickedSectionId);
                }
   
            }
        });
        
        
        
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
