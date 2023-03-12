/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import control.Outliner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 *
 * @author jihun
 */
public class DataAccess 
{
    private static ArrayList<Section> sectionInOrder = new ArrayList();
    private static ArrayList<Section> sections = new ArrayList();
    public static final Comparator<Section> BY_ID = new DataAccess.ById();
    
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
                getSectionByIdFromUnOrderedList(s.getSubSectionOf()).addSubSection(s);
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
            text = text.replaceAll("\t", "");
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
       
    
    public static void deleteSectionAndUpdateCSV(int id)
    {
        sectionInOrder.remove(getSectionByIdFromOrderedList(id));
        ArrayList<Section> orderedById = new ArrayList();
        for(Section s: sectionInOrder)
        {
            orderedById.add(s);
        }
        Collections.sort(orderedById, BY_ID);
        String csv = "";
        for(Section s: orderedById)
        {
            String text = s.getText();
            text = text.replaceAll("\t", "");
            csv = csv + s.getId() +","+s.getSubSectionOf()+","+text+","+s.getLevel()+System.lineSeparator();
        }
        
        
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("sections.csv"));
            bw.write(csv);
            bw.close();
        }
        catch(IOException ioe)
        {
            
        }
        sectionInOrder = new ArrayList();
        readSectionsFromCSVFile("sections.csv");
        updateCSVToLatest();

    }
    
    
    public static void editSection(int id, String newText)
    {
        int level=DataAccess.getSectionByIdFromOrderedList(id).getLevel();
        String indent="";
        for(int i=0; i<level; i++)
        {
            indent=indent+"\t";
        }
        DataAccess.getSectionByIdFromOrderedList(id).setText(indent+newText);
        DataAccess.updateCSVToLatest();
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
    public static Section getSectionByIdFromOrderedList(int id)
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
    public static Section getSectionByIdFromUnOrderedList(int id)
    {
        Section section = new Section();
        for(Section s: sections)
        {
            if(s.getId() == id)
            {
                section = s;
            }
        }
        return section;
    }
    //deletes all hanging sections
    public static void updateCSVToLatest()
    {
        ArrayList<Section> updatedAndReOrdered = new ArrayList();
        for(Section s:sectionInOrder)
        {
            updatedAndReOrdered.add(s);
        }
        Collections.sort(updatedAndReOrdered, BY_ID);
        String csv = "";
        for(Section s: updatedAndReOrdered)
        {
            String text = s.getText();
            text = text.replaceAll("\t", "");
            csv = csv + s.getId() +","+s.getSubSectionOf()+","+text+","+s.getLevel()+System.lineSeparator();
        }
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("sections.csv"));
            bw.write(csv);
            bw.close();
        }
        catch(IOException ioe)
        {
            
        }
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
    
    private static class ById implements Comparator<Section> 
    {
        @Override
        public int compare(Section s1, Section s2) {
            return s1.getId().compareTo(s2.getId());
        }   
    }
    
    
}
