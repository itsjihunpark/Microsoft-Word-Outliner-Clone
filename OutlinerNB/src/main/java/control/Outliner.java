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
     * 
     *  gets one and only instance of an outliner object
     *  @return Outliner instance
     */
    public static Outliner getInstance()
    {
        return INSTANCE;
    }  
    
    /**
     * Starts the whole program
     * @param arg
     */
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
     * returns the list of sections ordered by how they will be displayed
     * @return returns an ArrayList of sections 
     */
    public ArrayList<Section> getSections(){
        return sections;
    }
    /**
     * sets the list of section a view will be created from
     * @param sections is an ArrayList of section to be set
     */
    public void setSections(ArrayList<Section> sections) {
        Outliner.sections = sections;
    }

    /**
     * returns a string view of how the sections will be displayed
     * @return a string of the view
     */
    public static String getView() {
        return view;
    }

    /**
     * sets the view with the supplied string
     * @param view sets the view with the supplied string
     */
    public static void setView(String view) {
        Outliner.view = view;
    }


    
    /**
     * Assigns the user represented by the string supplied to the selected id
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
     * adds the supplied section to the outliner view
     * @param newSection a section object to be added to the outliner section
     */
    public static void addSection(Section newSection)
    {
        DataAccess.writeToCSVNewSection(newSection);
        sections = DataAccess.getSectionInOrder();
        createView();
    }
    /**
     * deletes the section with the supplied id
     * @param id id of the section to be deleted
     */
    public static void deleteSection(int id)
    {
        DataAccess.deleteSectionAndUpdateCSV(id);
        sections = DataAccess.getSectionInOrder();
        createView();
    }
    /**
     * edits the section with the supplied id with the new text supplied as a string
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
     * iteratively goes through the arraylist of sections in outliner to create a string view of the outliner
     * this goes through all sections in the ArrayList&lt;Section&gt; section to build a string view
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

