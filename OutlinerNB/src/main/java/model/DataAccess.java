/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author jihun
 */
public class DataAccess 
{
    
    public static ArrayList<Section> getSectionFromCSVFile()
    {
        ArrayList<Section> sections = new ArrayList();
        String data="";    
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("sections.csv"));
            while((data = br.readLine())!=null)
            {
                String[] s = data.split(",");
                Section section = new Section(Integer.parseInt(s[0]), Integer.parseInt(s[1]), s[2]);
                sections.add(section);
            }
            br.close();
        }
        catch(IOException ioe)
        {
            System.out.println("File not found");
        }
        return sections;
    }
    
}
