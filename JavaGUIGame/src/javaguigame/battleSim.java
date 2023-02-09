/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaguigame;
//import javax.swing.

import static javaguigame.JavaGUIGame.addText;
/**
 *
 * @author Josh Bonham
 */
public class battleSim{
        
    static Character knight;
    static Character archer;
    public static Character player;
    static Character wizard;
    static Battle battle;
    
    public battleSim()
    {
        knight = new Knight("Knight");
        archer = new Archer("Archer");
        wizard = new Wizard("Wizard");
        player = new Archer("Player");
    }
    static  void checkCurrentBattle()
    {
        battle.endOfRoundCleanup();
        if(battle.isBattle())
        {
            battle.enemyTurn();
        }
    }
    static boolean handleFight(String enemyName)
    {
        if(battle.getEnemyByName(enemyName) == null)
            {
                addText("Invalid target");
                return false;
            }
            player.fight(battle.getEnemyByName(enemyName));
            return true;
    }

    static boolean handleAbilities(String abilityName)
    {
        for(Ability ability : player.abilityList)
        {
            if(ability.name.toLowerCase().equals(abilityName.toLowerCase()) && 
                ability.currentCooldown == 0)
            {              
                addText(ability.description);
                return ability.use();
            }
        }
        return false;
    }
    static void initializeBattle()
    {
        
        addText("A drunken knight approaches you, wearing a set of full metal armor...");
        battle = new Battle(player);  
        battle.addEnemy(knight);
        battle.addEnemy(archer);
        battle.addEnemy(wizard);
    }
    public static void changeClass(String className)
    {
        switch (className.toLowerCase()) 
        {
            case "knight":
                battleSim.player = new Knight("Player");
                break;
            case "archer":
                battleSim.player = new Archer("Player");
                break;
            case "wizard":
                battleSim.player = new Wizard("Player");
                break;
            default:
                addText("Not a class");
                addText("Enter \'class (nameOfClass)\'");
                addText("Some examples of classes are: knight, wizard, or archer");
                break;
            }    
            battle.changePlayer(player);
        }
    
}
