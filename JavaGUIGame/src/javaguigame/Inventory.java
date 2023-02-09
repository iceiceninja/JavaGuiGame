/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaguigame;

import java.util.ArrayList;
import static javaguigame.JavaGUIGame.addText;

/**
 *
 * @author Josh Bonham
 */
public class Inventory {
    public static ArrayList<Item> inventory = new ArrayList<>();
    public Inventory(Item[] startingItems)
    {
        for(Item item : startingItems)
        {
            inventory.add(item);
        }
    }  
    public Inventory()
    {}
    public void display()
    {
        addText("Item name\titem value");
        for(Item item : inventory)
        {
            addText(item.name + "\t" + item.value);
        }
    }
    public void addItem(Item item)
    {
        inventory.add(item);
    }
    public void removeItem(Item item)
    {
        inventory.remove(item);
    }
    public boolean useAnItem(String itemName)
    {
        for(Item item : inventory)
        {
            if(item.name.toLowerCase().equals(itemName.toLowerCase()))
            {
                item.interact();
                return true;
            }
        }
        return false;
    }
}
