/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaguigame;
import java.util.ArrayList;
import static javaguigame.battleSim.addText;
/**
 *
 * @author Josh Bonham
 */
public class Battle {
    ArrayList<Character> enemies = new ArrayList<>();
    Character player;
    Battle (Character player)
    {
        enemies.clear();
        this.player = player;
    }
//    public void playerTurn()
//    {
//        //CODE
//        enemyTurn();
//    }
    public void enemyTurn()
    {
        //CODE
        addText("=======ENEMY TURN=======");
        for(Character enemy : enemies)
        {     
            enemy.fight(player);
        }
        addText("=======PLAYER TURN=======");
        addText("Player Health: " + player.health);
//        playerTurn();
    }
    void addEnemy(Character enemy)
    {
        enemies.add(enemy);
    }
    void removeEnemy(Character enemy)
    {
        enemies.remove(enemy);
    }
    boolean isBattle()
    {
        return !enemies.isEmpty();
    }
//    Character getEnemy(int index)
//    {
//        return enemies.get(index);
//    }
    Character getEnemyByName(String name)
    {
        for(Character enemy : enemies)
        {
            if(enemy.name.toLowerCase().equals(name.toLowerCase()))
            {
                return enemy;
            }
        }
        addText("No enemy found named: " + name);
        return null;
    }
    void endOfRoundCleanup()
    {
        for(int i = 0; i < enemies.size(); i++)
        {
            if(enemies.get(i).health <= 0)
            {
                addText("Enemy has perished: " + enemies.get(i).name);
                removeEnemy(enemies.get(i));
            }
        }
    }
    void printEnemies()
    {
        addText("You see the following enemies:");
        for(Character enemy : enemies)
        {
            addText(enemy.name);
        }
    }
}
