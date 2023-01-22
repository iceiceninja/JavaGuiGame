/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaguigame;

/**
 *
 * @author Josh Bonham
 */
public abstract class Character{
    
    weaponBehavior weapon;
    armorBehavior armor;
    String name;
    int health;
    
    
    void setWeapon(weaponBehavior w)
    {
        this.weapon = w;
    }
    void setArmor(armorBehavior a)
    {
        this.armor = a;
    }
    public abstract void fight(Character target);
}
