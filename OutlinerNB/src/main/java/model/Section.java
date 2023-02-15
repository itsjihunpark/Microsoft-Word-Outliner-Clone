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
public class Section 
{
    //Class attributes
    private Integer id;
    private Integer subSectionOf;
    private String text;
    private ArrayList<Section> subSection = new ArrayList();
    
    //constructors
    public Section(int id, int subSectionOf, String text)
    {
        this.id = id;
        this.subSectionOf = subSectionOf;
        this.text = text;
    }
    
    public void addSubSection(Section s)
    {
        this.subSection.add(s);
    }    
    
    //All getters and Setters
    
    //Getter/Setter id
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    //Getter/Setter subSectionOf
    public Integer getSubSectionOf() {
        return subSectionOf;
    }

    public void setSubSectionOf(Integer subSectionOf) {
        this.subSectionOf = subSectionOf;
    }
    //Getter/Setter text
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    //Getter/Setter ArrayList<Section> subSection
    public ArrayList<Section> getSubSection() {
        return subSection;
    }

    public void setSubSection(ArrayList<Section> subSection) {
        this.subSection = subSection;
    }
    
    
}
