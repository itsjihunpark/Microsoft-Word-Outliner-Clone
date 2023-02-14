/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jihun
 */
public class RootSection 
{   
    private ArrayList<Section> rootSections = new ArrayList();
    private Map<Section,List<Section>> sectionMap = new HashMap();
    
    public RootSection()
    {
    }

    //getters and setters
    public ArrayList<Section> getRootSections() {
        return rootSections;
    }

    public void setRootSections(ArrayList<Section> rootSections) {
        this.rootSections = rootSections;
    }

    public Map<Section,List<Section>> getSectionMap() {
        return sectionMap;
    }

    public void setSectionMap(Map<Section,List<Section>> sectionMap) {
        this.sectionMap = sectionMap;
    }
 
    //methods
    
    public void addRootSection(int level, String text)
    {      
        rootSections.add(new Section(level,text));
    }
    public void addRootSection(Section rootSection)
    {
        rootSections.add(rootSection);
    }
    
    //Recursive method that takes an arraylist of rootsections and goes through all section and subsection of each section.
    public static void readAll(ArrayList<Section> parent)
    {
        for(Section child: parent)
        {
            ArrayList<Section> children = child.getSubSections();
            
            readAll(children);
            System.out.println(child);
            //add to a map.        
        }
    }
    
}
