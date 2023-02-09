/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaguigame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javaguigame.JavaGUIGame.decipherInput;
import static javaguigame.JavaGUIGame.input;
import static javaguigame.JavaGUIGame.output;


/**
 *
 * @author Josh Bonham
 */
public class Speed extends Ability implements ActionListener{
    int extraTurnCounter;
    boolean abilityFinished = false;
    public Speed()
    {
        name =  "Speed";
        description = "A surge of energy runs through your veins! You can now make two more actions!";
        cooldown = 4;
        extraTurnCounter = 0;
    }
    @Override
    public boolean use() {
        input.removeActionListener(JavaGUIGame.input.getActionListeners()[0]);        
        input.addActionListener(new Speed());
        JavaGUIGame.addText("Action obtained");
//        for(ActionListener al : battleSim.input.getActionListeners())
//        {
//            battleSim.addText(al.toString());
//        }
        currentCooldown += cooldown;
        return abilityFinished == true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == JavaGUIGame.input)
        {
            output.append("\n" + input.getText());
            String lastInput = input.getText();
            input.setText("");
            if(decipherInput(lastInput))
            {
                extraTurnCounter++;
                battleSim.battle.endOfRoundCleanup();
                if(extraTurnCounter%2 == 0)
                {
                    abilityFinished = true;
                    input.removeActionListener(JavaGUIGame.input.getActionListeners()[0]);
                    input.addActionListener(new JavaGUIGame());
                    JavaGUIGame.addText("Speed finished");
                }
            }
        }
    }
    
}
