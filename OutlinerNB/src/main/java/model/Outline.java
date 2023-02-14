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
    private static ArrayList<Section> rootSections;
    
    public static void addRootSection(Section r)
    {
        rootSections.add(r);
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
