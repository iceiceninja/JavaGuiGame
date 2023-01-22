/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaguigame;
/**
 *
 * @author Josh Bonham
 */
public class Sword implements weaponBehavior{
    @Override
    public int useWeapon()
    {
//        return Math.floor(Math.random()*(max-min+1)+min);
        return (int) Math.floor(Math.random()*(10-3+1)+3);
    }
}
