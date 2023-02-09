/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaguigame;

import static javaguigame.JavaGUIGame.addText;
import static javaguigame.JavaGUIGame.locationManager;

/**
 *
 * @author Josh Bonham
 */
public class Tavern extends Location{
    public Tavern()
    {
        super();
        name = "Tavern";
        description = "A grimy tavern filled with nasty folk. Cheap wooden furniture surrounds you and there are few civilized folk here. There is a sticky wooden door to your south.";
        refId = 11; // reference Id decoder: (townNumber)(Building/area number)
//        boolean[] exits = {false,false,true,false};
//        boolean[] entrances = {}; 
        locationManager.addLocation(this);
    }
    
    
    @Override
    boolean interactions(String[] userInput) 
    {
        String verb = userInput[0];
        switch(verb)
        {
            case "talk":
                addText("You talk to the barmaid.");
                addText("Barmaid: Hey! Welcome to the Drunken Dragon! Would you like some ale? (if you do, type \'buy ale\')");                
                return true;
            case "buy":
                return buy(userInput[1]);
            default:
                return false;
        }
    }
    boolean buy(String item)
    {
        switch(item)
        {
            case "ale":
                addText("You give the barmaid some of your hard earned gold and she give you a foaming brew");
                Item ale = new Ale();
                JavaGUIGame.inventory.addItem(ale);
                JavaGUIGame.gold -= ale.value;
                return true;
            default:
                addText("We don't sell " + item);
                return false;
        }
    }
}
