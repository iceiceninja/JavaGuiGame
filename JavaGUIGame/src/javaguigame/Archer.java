/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaguigame;

/**
 *
 * @author Josh Bonham
 */
public class Archer extends Character{

    public Archer(String name)
    {
        this.weapon = new BowAndArrow();
        this.health = 7;
        this.name = name;
    }
    @Override
    public void fight(Character target) {
//        System.out.println("Archer Fights!");
        battleSim.addText("Archer Fights");
        int damage = weapon.useWeapon();
        target.health -= damage;
        battleSim.addText(target.name+" has taken " + damage + " damage!");
    }
    
}
