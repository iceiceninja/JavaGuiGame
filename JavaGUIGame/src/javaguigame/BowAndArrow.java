/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaguigame;

/**
 *
 * @author Josh Bonham
 */
public class BowAndArrow implements weaponBehavior{

    @Override
    public int useWeapon() {
        return (int) Math.floor(Math.random()*(10-1+1)+1);
    }
    
}
