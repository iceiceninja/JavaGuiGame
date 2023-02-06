/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaguigame;

/**
 *
 * @author Josh Bonham
 */
public abstract class Ability {
    String name;
    String description;
    int currentCooldown = 0;
    int cooldown;
    public abstract boolean use();
    
}
