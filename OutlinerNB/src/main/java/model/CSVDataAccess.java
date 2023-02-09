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
public class CSVDataAccess 
{
    private static ArrayList<User> users = new ArrayList();
    
     public static void readUsersCSVFile()
    {
        String data = "";
        String line = "";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("users.csv"));
            while((data = br.readLine())!=null)
            {
                String[] user = data.split(",");
                User u = new User(Integer.parseInt(user[0]), user[1]);
                CSVDataAccess.users.add(u);
            }
            br.close();
        }
        catch(IOException ioe)
        {
            System.out.println("File not found");
        }
        //users csv file columns
        //1)fullName
        //2)RootSection
        //3)uniqueID fk
    }
     
    public void readRootSectionCSVFile()
    {
        //Outlines csv file columns
        //1)UserUniqueID fk
        //2)Sections
        
    }
    public void readSectionsCSVFile()
    {
        
    }
    public void writeToUsersCSVFile()
    {
        
    }
    public void writeToSectionsCSVFile()
    {
    }
    
    
    
    //Setter Getter

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void setUsers(ArrayList<User> users) {
        CSVDataAccess.users = users;
    }
    
}
