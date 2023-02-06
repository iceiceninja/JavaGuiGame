/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaguigame;

import java.util.ArrayList;

/**
 *
 * @author Josh Bonham
 */
public class FireBall extends Ability{
    public FireBall()
    {
        name = "Fireball";
        description = "An explosive orb of bright orange shoots towards your foes!";
        cooldown = 2;
    }
    @Override
    public boolean use() {
        for(Character enemy : battleSim.battleManager.enemies)
        {
            int damage = (int) Math.floor(Math.random()*(8-4+1)+4);
            battleSim.addText(enemy.name + " has taken " + damage + " damage");
            enemy.health -= damage;
        }  
        currentCooldown += cooldown;
        return true;
    }
}
