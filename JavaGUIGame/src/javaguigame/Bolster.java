/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaguigame;

/**
 *
 * @author Josh Bonham
 */
public class Bolster extends Ability{
    public Bolster()
    {
        this.name = "Bolster";
        this.description = "You bolster your health! Gain 15 HP";
        cooldown = 2;
    }

    @Override
    public boolean use() {
        battleSim.player.health += 15;
        currentCooldown += cooldown;
        return true;
    }
}
