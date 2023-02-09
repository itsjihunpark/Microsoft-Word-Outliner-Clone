/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import model.CSVDataAccess;

/**
 *
 * @author jihun
 */
public class Outliner {
    public static void main(String arg[])
    {
        CSVDataAccess.readUsersCSVFile();
        System.out.println(CSVDataAccess.getUsers());
    }
}
