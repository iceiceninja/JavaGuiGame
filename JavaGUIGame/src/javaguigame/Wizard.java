/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaguigame;

/**
 *
 * @author Josh Bonham
 */
public class Wizard extends Character{
//    Ability[] spellBook;
    public Wizard(String name)
    {
        this.weapon = new Staff();
        this.health = 5;
        this.name = name;
        abilityList = new Ability[] {new FireBall()};
    }
    @Override
    public void fight(Character target) {
        battleSim.addText("Wizard Fights");
        int damage = weapon.useWeapon();
        target.health -= damage;
        battleSim.addText(target.name+" has taken " + damage + " damage!");
    }
    
}
