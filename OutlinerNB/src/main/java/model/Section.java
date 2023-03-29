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
    private String user;
    private Integer id;
    private Integer subSectionOf;
    private String text;
    private Integer level;
    private ArrayList<Section> subSection = new ArrayList();
    
    //constructors
    /**
     * this constructor is used when Sections are instantiated from a csv format containing the attributes of a section
     * @param id id of the section
     * @param subSectionOf the id of the parenting section
     * @param text the actual section content
     * @param level the level of the section to determine the amount it will be tabbed by
     * @param user the user assigned to this new section
     * 
    */
    public Section(int id, int subSectionOf, String text, int level, String user)
    {
        this.id = id;
        this.subSectionOf = subSectionOf;
        this.level = level;
        String space = "";
        for(int i = 0; i< level; i++)
        { 
            space = space + "\t";
        }
        //"      "
        //"           "
        this.text = space+text;
        this.user=user;
    }
    //constructor when instatiating from add new section method
    public Section()
    {
        
    }
    
    /**
     * this constructor is used when sections are created from the application to be written to the csv
     * @param subSectionOf id of the parenting section, set as zero when there are no parenting section 
     * @param text the text itself of a section
     */
    public Section(int subSectionOf, String text)
    {
        //this.id = Outliner.getInstance().getSections().size()+1;
        //this.id = Outliner.getInstance().getSections().get(Outliner.getInstance().getSections().size()-1).id+1;
        if(DataAccess.getSections().size()==0)
        {
            this.id = 1;
        }
        else
        {
            this.id = DataAccess.getSections().get(DataAccess.getSections().size()-1).id + 1;
        }
        
        
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
            space = space + "\t";
        }
        //"      "
        //"           "
        this.text = space+text;
        this.user = "n/a";
    }
    /**
     * adds the supplied section to this section as its sub section
     * @param s adds this section to the parenting section as a subsection
     */
    public void addSubSection(Section s)
    {
        this.subSection.add(s);
    }    

    

    /**
     * returns the id of this section
     * @return id
     */
    public Integer getId() {
        return id;
    }
    /**
     * sets the id of this section
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * returns the id of the parenting section of this section
     * @return the id of the parenting section 
     */
    public Integer getSubSectionOf() {
        return subSectionOf;
    }

    /**
     * sets the id of the parenting section of this section
     * @param subSectionOf 
     */
    public void setSubSectionOf(Integer subSectionOf) {
        this.subSectionOf = subSectionOf;
    }
    /**
     * returns the text of this section
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * sets the text of this section
     * @param text 
     */
    public void setText(String text) {
        this.text = text;
    }
    /**
     * returns the arraylist of the subsection that this section has
     * @return subSection
     */
    public ArrayList<Section> getSubSections() {
        return subSection;
    }
    /**
     * sets the list of subsections of this section
     * @param subSection 
     */
    public void setSubSection(ArrayList<Section> subSection) {
        this.subSection = subSection;
    }
    /**
     * returns the user assigned to this section
     * @return user
     */
    public String getUser() {
        return user;
    }

    /**
     * sets user to this section
     * @param user 
     */
    public void setUser(String user) {
        this.user = user;
    }
    /**
     * returns the level of this section
     * @return level
     */
    public Integer getLevel() {
        return level;
    }
    /**
     * sets the level of this section
     * @param level 
     */
    public void setLevel(Integer level) {
        this.level = level;
    }
    
}
