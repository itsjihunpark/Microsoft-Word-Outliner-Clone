/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import control.Outliner;
import java.util.ArrayList;

/**
 *
 * @author jihun
 */
public class Section 
{
    //Class attributes
    private User user;
    private Integer id;
    private Integer subSectionOf;
    private String text;
    private Integer level;
    private ArrayList<Section> subSection = new ArrayList();
    
    //constructors
    //constructor when instatiating from csv
    public Section(int id, int subSectionOf, String text, int level)
    {
        this.id = id;
        this.subSectionOf = subSectionOf;
        this.level = level;
        String space = "";
        for(int i = 0; i< level; i++)
        { 
            space = space + "      ";
        }
        //"      "
        //"           "
        this.text = space+text;
        
    }
    //constructor when instatiating from add new section method
    public Section()
    {
        
    }
    public Section(int subSectionOf, String text)
    {
        //this.id = Outliner.getInstance().getSections().size()+1;
        //this.id = Outliner.getInstance().getSections().get(Outliner.getInstance().getSections().size()-1).id+1;
        this.id = DataAccess.getSections().get(DataAccess.getSections().size()-1).id + 1;
        //System.out.println(DataAccess.getSections().get(DataAccess.getSections().size()-1).id + 1);
        this.subSectionOf = subSectionOf;
        if(subSectionOf ==0)
        {
            this.level = 0;
        }
        else
        {   
            this.level = DataAccess.getSectionByIdFromOrderedList(subSectionOf).getLevel()+1;
        }
        
        String space = "";
        for(int i = 0; i< this.level; i++)
        { 
            space = space + "      ";
        }
        //"      "
        //"           "
        this.text = space+text;
    }
    public void addSubSection(Section s)
    {
        this.subSection.add(s);
    }    

    @Override
    public String toString() {
        return this.text;
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
    public ArrayList<Section> getSubSections() {
        return subSection;
    }

    public void setSubSection(ArrayList<Section> subSection) {
        this.subSection = subSection;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
    
}
