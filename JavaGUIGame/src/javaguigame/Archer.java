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
        abilityList = new Ability[]{new Speed()};
    }
    @Override
    public void fight(Character target) {
//        System.out.println("Archer Fights!");
        JavaGUIGame.addText("Archer Fights");
        int damage = weapon.useWeapon();
        target.health -= damage;
        JavaGUIGame.addText(target.name+" has taken " + damage + " damage!");
    }
    
}
