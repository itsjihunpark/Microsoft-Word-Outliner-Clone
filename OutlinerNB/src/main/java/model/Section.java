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
    
    private String index; //eg) 1, 1.1, 1.1.1
    private int level;
    private String text;
    private ArrayList<Section> subSections = new ArrayList();
    private User user;
    
    public Section(int level, String text)
    {
        this.level = level;
        this.text = text;
    }
    
    public void addSubsection(int level, String text)
    {
        this.subSections.add(new Section(level, text));
    }
    public void addSubsection(Section subSection)
    {
        this.subSections.add(subSection);
    }
    
    
    public String getIndex() {
        return index;
    }

    //Getters and Setters
    public void setIndex(String index) {    
        this.index = index;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<Section> getSubSections() {
        return subSections;
    }

    public void setSubSection(ArrayList<Section> subSection) {
        this.subSections = subSection;
    }

    @Override
    public String toString() {
        return "level "+this.level+"|  "+this.text;
    }
    
    
}