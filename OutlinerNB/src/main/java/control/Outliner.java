/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.ArrayList;
import model.DataAccess;
import model.Section;

/**
 *
 * @author jihun
 */
public class Outliner 
{
    public static void main(String arg[])
    {
        //data access
        ArrayList<Section> sections = DataAccess.getSectionFromCSVFile();
        
        
        
        //Controls go under here
        for(Section s: sections)
        {
            if(s.getSubSectionOf() != 0 )
            {
                sections.get(s.getSubSectionOf()-1).addSubSection(s);
            }
        }
        
        ArrayList<Section> rootSections = new ArrayList();
        
        for(Section s: sections)
        {
            if(s.getSubSectionOf() ==0)
            {
                rootSections.add(s);
            }
        }
        
        for(Section s: rootSections)
        {
            System.out.println(s.getText());
            for(Section subSection: s.getSubSection())
            {
                System.out.println("    "+subSection.getText());
            }
        }
       
        
        
        
        //Views generated here
    }
}
