/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import control.Outliner;
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
import model.Section;

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
                
                String inputValue="";
                if(clickedText.equals("")){
                    System.out.println("user wants to create a new section"); //complete
                    
                    do{
                        inputValue= JOptionPane.showInputDialog("Enter new section value"); 
                    }
                    while(inputValue.isEmpty());

                    Outliner.addSection(new Section(0,inputValue));
                    
                }
                else{ //case where a valid section was clicked
                    
                    int id = clickedText.lastIndexOf("id:")+3;
                    int clickedSectionId = Integer.parseInt(clickedText.substring(id).trim());
                    
                    Object[] possibleValues= {"Add subsection","Edit", "Delete", "Assign a user"};
                    Object selectedValue = JOptionPane.showInputDialog(null,"What do you want to do?","Input",
                                                                        JOptionPane.INFORMATION_MESSAGE, null,possibleValues, possibleValues[0]);
                    
                    if(selectedValue.equals("Add subsection")){ //complete
                        System.out.println("user wants to create a new subsection");
                        System.out.println("user is creating a sub section of id: "+ clickedSectionId);
                        do{
                            inputValue= JOptionPane.showInputDialog("Enter new section value"); 
                        }
                        while(inputValue.isEmpty());
                        Outliner.addSection(new Section(clickedSectionId,inputValue));
                        
                        
                        
                    }
                    else if(selectedValue.equals("Delete")){ //complete
                        System.out.println("user wants to delete this section");
                        Outliner.deleteSection(clickedSectionId);
                        
                    }
                    else if(selectedValue.equals("Edit"))
                    {
                        System.out.println("User wants to edit this section");
                        do{
                            inputValue= JOptionPane.showInputDialog("Enter updated text for this section"); 
                        }
                        while(inputValue.isEmpty());
                        Outliner.editSection(clickedSectionId, inputValue);
                        
                    }
                    else if(selectedValue.equals("Assign a user")){
                        System.out.println("User wants to assign a user");
                        do{
                            inputValue= JOptionPane.showInputDialog("Enter user name"); 
                        }
                        while(inputValue.isEmpty());
                        Outliner.assignUser(clickedSectionId, inputValue);
                    }
                    
                }
                OutlinerView.getInstance().getSectionPanel().getText().setText(Outliner.getInstance().getView());
            }
        });
        
        
        
        scrollPane = new JScrollPane(text);
        
        //this.add(loadBttn, BorderLayout.SOUTH);
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
