/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaguigame;
//import javax.swing.

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 *
 * @author Josh Bonham
 */
public class battleSim implements ActionListener{
    
    static JFrame mainFrame;
    static JTextArea output;
    static JTextField input;
    static JScrollPane scroll;
    static String lastInput;
    static Character knight;
    static Character archer;
    static Character player;
    static Battle battleManager;
    public static void main(String[] args)
    {
        initializeGUI();
        knight = new Knight("Knight");
        archer = new Archer("Archer");
        player = new Wizard("Player");

        addText("A drunken knight approaches you, wearing a set of full metal armor...");

        battleManager = new Battle(player);  
        battleManager.addEnemy(knight);
        battleManager.addEnemy(archer);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == input)
        {
            output.append("\n" + input.getText());
            setLastInput(input.getText());
            input.setText("");
            if(decipherInput(lastInput))
            {
                battleManager.endOfRoundCleanup();
                if(battleManager.isBattle())
                {
                    battleManager.enemyTurn();
                }
                
            }
        }
    }
    
    void setLastInput(String text)
    {
        lastInput = text;
    }
    static void addText(String text)
    {
        output.append("\n" + text);
    }
    static boolean decipherInput(String text)
    {
        String[] words = text.split(" ");
        String verb = words[0];
        String noun;
        try{
            noun = words[1];
        }
        catch(Exception e){
            noun = "";
        }
        switch(verb){
                case "fight":
                    if(battleManager.getEnemyByName(noun) == null)
                    {
                        addText("Invalid target");
                        return false;
                    }
                    player.fight(battleManager.getEnemyByName(noun));
                    return true;
                case "talk":
                    return true;
                case "drink":
                    return true;
                case "use":
                    return true;
                case "enemies":
                    battleManager.printEnemies();
                    break;
                case "health":
                    addText("Player Health: " + player.health);
                    break;
                case "cast":
                    break;
                case "help":
                   String[] commands = {"cast","health","enemies","use","drink","talk","fight","help"};
                    for (String command : commands) {
                        addText(command);
                    }
                    break;
                default:
                    addText("Verb not recognized: " + verb);
        }
        return false;
    }
    public static void initializeGUI()
    {
        mainFrame = new JFrame();
        output = new JTextArea();
        input = new JTextField();
        scroll = new JScrollPane (output, 
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        output.setText("When you enter commands, enter them like [VERB] [NOUN] Ex:");
        addText("fight archer");
        addText("or, take sword");
        addText("There are also some one word commands, ex: health");
        addText("Type \"help\" for a list of commands");
       
        output.setEditable(false);
                
        scroll.getVerticalScrollBar().addAdjustmentListener((AdjustmentEvent e) -> {
            e.getAdjustable().setValue(e.getAdjustable().getMaximum());
        });
        
        mainFrame.setLayout(new GridLayout());
        mainFrame.add(scroll);
        mainFrame.add(input);
        
        input.addActionListener(new battleSim());
        input.setSize(100, 200);
        
        mainFrame.setSize(700,500);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
