/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author jihun
 */
public class Outline 
{
    //Attributes
    private ArrayList<Section> roots;
    private ArrayList<Section> sections;
    
    public Outline(ArrayList<Section> roots, ArrayList<Section> section)
    {
        
    }

    //Getter/Setter
    public ArrayList<Section> getRoots() {
        return roots;
    }

    public void setRoots(ArrayList<Section> roots) {
        this.roots = roots;
    }

    public ArrayList<Section> getSections() {
        return sections;
    }

    public void setSections(ArrayList<Section> sections) {
        this.sections = sections;
    }
    
    
    
}
