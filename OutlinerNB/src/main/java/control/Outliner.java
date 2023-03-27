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

    /**
     * @see gets one and only instance of an outliner object
     * 
     */
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
    
    /**
     * 
     * @return returns an ArrayList of sections 
     */
    public ArrayList<Section> getSections(){
        return sections;
    }
    /**
     * 
     * @param sections is an ArrayList of section to be set
     */
    public void setSections(ArrayList<Section> sections) {
        Outliner.sections = sections;
    }

    /**
     * 
     * @return a string of the view
     */
    public static String getView() {
        return view;
    }

    /**
     * 
     * @param view sets the view with the supplied string
     */
    public static void setView(String view) {
        Outliner.view = view;
    }


    
    /**
     * @param id id of the section to assign a user to
     * @param user string storing the name of the user to be assigned to the selected section
     */
    public static void assignUser(int id, String user)
    {
        DataAccess.getSectionByIdFromOrderedList(id).setUser(user);
        DataAccess.updateCSVToLatest();
        sections = DataAccess.getSectionInOrder();
        createView();
    }
    
    /**
     * 
     * @param newSection a section object to be added to the outliner section
     */
    public static void addSection(Section newSection)
    {
        DataAccess.writeToCSVNewSection(newSection);
        sections = DataAccess.getSectionInOrder();
        createView();
    }
    /**
     * 
     * @param id id of the section to be deleted
     */
    public static void deleteSection(int id)
    {
        DataAccess.deleteSectionAndUpdateCSV(id);
        sections = DataAccess.getSectionInOrder();
        createView();
    }
    /**
     * 
     * @param id id of the section to be edited
     * @param newText text to be updated to the selected Section
     */
    public static void editSection(int id, String newText)
    {
        DataAccess.editSection(id, newText);
        sections = DataAccess.getSectionInOrder();
        createView();
    }
    /**
     * @see this goes through all sections in the ArrayList<Section> section to build a string view
     */
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


}

