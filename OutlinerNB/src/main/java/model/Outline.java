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
    private static ArrayList<RootSection> rootSections;
    
    public static void addRootSection(String text)
    {
        RootSection r = new RootSection(text);
        rootSections.add(r);
    }
    
}
