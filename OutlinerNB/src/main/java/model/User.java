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
public class User {
    private int id;
    private String name;
   
    public User(int id, String name)
    {
        this.id = id;
        this.name=name;
    }
    
    
    //To String

    @Override
    public String toString() {
        String userObject = "user id: " + this.id + " Name: " + this.name;
        return userObject;
    }

    //getter setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
