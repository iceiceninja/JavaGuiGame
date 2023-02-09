/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaguigame;

/**
 *
 * @author Josh Bonham
 */
public class Knight extends Character{
    
    public Knight(String name)
    {
        this.weapon = new Sword();
        this.armor = new plateArmor();
        this.health = 10;
        this.name = name;
        abilityList = new Ability[]{new Bolster()};
    }
    
    @Override
    public void fight(Character target)
    {
        
            JavaGUIGame.addText("Knight Fights");
            int damage = weapon.useWeapon();
            try{
                target.health -= damage;
                JavaGUIGame.addText(target.name+" has taken " + damage + " damage!");
            }catch(Exception e)
            {
                JavaGUIGame.addText("Invalid Target");
            }
            
    }

}
