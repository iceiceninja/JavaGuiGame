/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaguigame;

/**
 *
 * @author Josh Bonham
 */
public class Ale extends Item{
    int drinksLeft = 3;
    public Ale()
    {
        name = "Ale";
        description = "A mug of stale, yet foaming ale.";
        value = 5;
    }
    @Override
    public void interact() {
        JavaGUIGame.addText("You sip on your ale");
        drinksLeft--;
        if(drinksLeft == 0)
        {
            JavaGUIGame.addText("You gulp down the rest of your ale and feel a little tipsy...");
            JavaGUIGame.inventory.removeItem(this);
        }
    }
    
}
