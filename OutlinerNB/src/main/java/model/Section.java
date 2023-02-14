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
class Section {
    

    private String text;
    private ArrayList<Section> subSections = new ArrayList();
    private User user;
    
    public Section(String text)
    {
        this.text = text;
    }
    
    public void addSubsection(Section subSection)
    {
        this.subSections.add(subSection);
    }
    

    public ArrayList<Section> getSubSections() {
        return subSections;
    }

    public void setSubSection(ArrayList<Section> subSection) {
        this.subSections = subSection;
    }

    
    
}