/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import model.DataAccess;
import model.Section;
import view.Outliner_view;

/**
 *
 * @author jihun
 */
public class Outliner 
{
    private static ArrayList<Section> sections = DataAccess.getSectionInOrder();
    private static String view;
    private static final Outliner INSTANCE = new Outliner();
    public static Outliner getInstance()
    {
        return INSTANCE;
    }  
    
    
    public static void main(String arg[])
    {
        //data access
        
        //Reads all csv and spits out rootsection which is the point of access  
        DataAccess.readSectionsFromCSVFile("sections.csv");

        //Controls go under here
        
        
        //builds the string view
        createView();
        
        //System.out.println(view);
        
        //Views generated here
        Outliner_view ov = Outliner_view.getInstance();
        //Outliner_view.setText(outline);
        ov.startViewer();
    }
    

    public  ArrayList<Section> getSections() {
        return sections;
    }

    public void setSections(ArrayList<Section> sections) {
        Outliner.sections = sections;
    }

    public static String getView() {
        return view;
    }

    public static void setView(String view) {
        Outliner.view = view;
    }


    
    /**
     * manipulates array within this class 
     */
    
    public static void addSection(Section newSection)
    {
        DataAccess.writeToCSVNewSection(newSection);
        sections = DataAccess.getSectionInOrder();
        createView();
    }
    public static void deleteSection(int id)
    {
        DataAccess.deleteSectionAndUpdateCSV(id);
        sections = DataAccess.getSectionInOrder();
        createView();
    }

    public static void createView()
    {
        Outliner.view = "";
        for(Section s: sections)
        {
            view = view + s.getText()+"| id:"+s.getId()+System.lineSeparator();
        }
    }
}

