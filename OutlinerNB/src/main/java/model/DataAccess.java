/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


/**
 *
 * @author jihun
 */
public class DataAccess 
{
    private static ArrayList<Section> sectionInOrder = new ArrayList();
    private static ArrayList<Section> sections = new ArrayList();
    
    public static void readSectionsFromCSVFile(String fileName)
    {
        sections = new ArrayList();
        String data="";    
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while((data = br.readLine())!=null)
            {
                String[] s = data.split(",");
                Section section = new Section(Integer.parseInt(s[0]), Integer.parseInt(s[1]), s[2], Integer.parseInt(s[3]));
                sections.add(section);
                //System.out.println(section.getId());
            }
            br.close();
        }
        catch(IOException ioe)
        {
            System.out.println("File not found");
        }
        
        //Loops through and adds all sub section items to the section they belong in
        for(Section s: sections)
        {
            if(s.getSubSectionOf() != 0 )
            {
                //gives indent to which ever one that's not root
                //s.setText("     "+s.getText());
                sections.get(s.getSubSectionOf()-1).addSubSection(s);
            }
        }
        
        //after all sub section gets added to the section it belongs to, root sections are added to arraylist of root sections
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
            DataAccess.sectionInOrder.add(s);
            readSection(s);
        }
        //All arrayList will be empty if no items in csv file
    }
    //write to csv new sections
    public static void writeToCSVNewSection(Section newSection)
    {
        try{
            String sectionsCsv = "";
            String data="";
            BufferedReader br = new BufferedReader(new FileReader("sections.csv"));
            while((data = br.readLine())!=null)
            {
                sectionsCsv = sectionsCsv+data+System.lineSeparator();
            }     
            String text = newSection.getText();
            text = text.replaceAll("  ", "");
            sectionsCsv = sectionsCsv+newSection.getId()+","+newSection.getSubSectionOf()+","+ text +","+newSection.getLevel()+System.lineSeparator();  
            
            BufferedWriter bw = new BufferedWriter(new FileWriter("sections.csv"));
            bw.write(sectionsCsv);
            bw.close();
        }
        catch(IOException ioe)
        {
            
        }
        sectionInOrder = new ArrayList();
        readSectionsFromCSVFile("sections.csv");
    }
       
    
    public static void writeUpdatedCSV(int id)
    {
        sectionInOrder.remove(getSectionById(id));     
    }
    
    //recursive method to go through all sections 
    private static boolean readSection(Section parent)
    {
        if(parent.getSubSections().size()!=0)
        {
            for(Section s: parent.getSubSections())
            {
                DataAccess.sectionInOrder.add(s);
                readSection(s);
            }
        }
        return true;
    }   

    public static ArrayList<Section> getSectionInOrder() {
        return sectionInOrder;
    }
    public static Section getSectionById(int id)
    {
        Section section = new Section();
        for(Section s: sectionInOrder)
        {
            if(s.getId() == id)
            {
                section = s;
            }
        }
        return section;
    }

    public static void setSectionInOrder(ArrayList<Section> sectionInOrder) {
        DataAccess.sectionInOrder = sectionInOrder;
    }

    public static ArrayList<Section> getSections() {
        return sections;
    }

    public static void setSections(ArrayList<Section> sections) {
        DataAccess.sections = sections;
    }
    
    
    
}
