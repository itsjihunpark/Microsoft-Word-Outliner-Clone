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
import view.OutlinerView;


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
        DataAccess.setFileName("sections.csv");
        DataAccess.readSectionsFromCSVFile();
        //builds the string view
        createView();
        
        //System.out.println(view);
        
        //Views generated here
        OutlinerView.getInstance();
        OutlinerView.getInstance().getSectionPanel().getText().setText(view);
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
    public static void assignUser(int id, String user)
    {
        DataAccess.getSectionByIdFromOrderedList(id).setUser(user);
        DataAccess.updateCSVToLatest();
        sections = DataAccess.getSectionInOrder();
        createView();
    }
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

    public static void editSection(int id, String newText)
    {
        DataAccess.editSection(id, newText);
        sections = DataAccess.getSectionInOrder();
        createView();
    }
    
    public static void createView()
    {
        Outliner.view = "";
        for(Section s: sections)
        {
            if(s.getUser().equals("n/a"))
            {
                view = view + s.getText()+"| id:"+s.getId()+System.lineSeparator();
            }
            else
            {
                view = view + s.getText()+" -> user: "+s.getUser()+"| id:"+s.getId()+System.lineSeparator();
            }
        }
    }
    public static String textView()
    {
        String view = "";
        for(Section s: sections)
        {
            view = view + s.getText()+"| id:"+s.getId()+System.lineSeparator();
        }
        return view;
    }
     public static String userView()
    {
        String view = "";
        for(Section s: sections)
        {
            view = view + s.getUser()+"| id:"+s.getId()+System.lineSeparator();
        }
        return view;
    }
}

