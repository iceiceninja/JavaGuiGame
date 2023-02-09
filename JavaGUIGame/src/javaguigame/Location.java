/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaguigame;

/**
 *
 * @author Josh Bonham
 */
public abstract class Location {
    String name;
    String description;
    int refId; // reference Id decoder: (townNumber)(Building/area number)
    boolean[] exits;
    String[] actions;
    public Location(){}
    
    void enter()
    {
        System.out.println("Location entered: " + name);
        JavaGUIGame.addText(description);
    }
    
    abstract boolean interactions(String[] userInput);
}
