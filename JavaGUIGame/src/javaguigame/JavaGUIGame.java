/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaguigame;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Josh Bonham
 */

public class JavaGUIGame implements ActionListener{
    static JFrame mainFrame;
    static JTextArea output;
    static JTextField input;
    static JScrollPane scroll;
    static String lastInput;
    static JScrollBar vertical;
    static LocationManager locationManager;
    static Location currentLocation;
    static battleSim battleManager; 
    static public int gold = 12;
    public static Inventory inventory;
    public static void main(String[] args)
    {
        initializeGUI();
        
        addText("When you enter commands, enter them like [VERB] [NOUN] Ex:");
        addText("fight archer");
        addText("or, take sword");
        addText("There are also some one word commands, ex: health");
        addText("Type \"help\" for a list of commands");
                
        battleManager = new battleSim();
        locationManager = new LocationManager();
        currentLocation = new Tavern();
        currentLocation.enter();
        inventory = new Inventory();
//        battleManager = new battleSim();
        battleSim.initializeBattle();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == input)
        {           
            addText(input.getText());
            setLastInput(input.getText());
            input.setText("");
            if(decipherInput(lastInput))
            {
                battleSim.checkCurrentBattle();
            }
        }
    }
    
    void setLastInput(String text)
    {
        lastInput = text;
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
                    return battleSim.handleFight(noun);
    
                case "use":
//                    System.out.println(battleSim.handleAbilities(noun) || inventory.useAnItem(noun));
                    return (battleSim.handleAbilities(noun) || inventory.useAnItem(noun));
                   
                case "enemies":
                    Battle.printEnemies();
                    break;
                case "health":
                    addText("Player Health: " + battleSim.player.health);
                    break;
                case "abilities":
                    battleSim.player.displayAbilities();
                    break;
                case "help":
                   String[] commands = {"health","enemies","use","fight","help","abilities","skip","inventory","gold","class"};
                    for (String command : commands) {
                        addText(command);
                    }
                    break;
                case "skip":
                    return true;
                case "gold":
                    addText("You have " + gold + " gold");
                    return false;
                case "inventory":
                    inventory.display();
                    return false;
                case "class":
                    battleSim.changeClass(noun);
                    return false;
                default:
                    if(currentLocation.interactions(words))
                    {
                        return true;
                    }else
                    {
                        addText("Verb not recognized: " + verb);
                        return false;
                    }
                               
        }
        return false;
    }
    
    static void addText(String text)
    {
        output.append("\n" + text);
        scroll.validate();
        vertical.setValue(vertical.getMaximum());
    }
    public static void initializeGUI()
    {
        mainFrame = new JFrame();
        output = new JTextArea();
        input = new JTextField();
        scroll = new JScrollPane (output, 
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        vertical = scroll.getVerticalScrollBar();
        
        output.setLineWrap(true);
//        output.setText("When you enter commands, enter them like [VERB] [NOUN] Ex:");        
        output.setEditable(false);
              
        mainFrame.setLayout(new GridLayout());
        mainFrame.add(scroll);
        mainFrame.add(input);
        
        input.addActionListener(new JavaGUIGame());
        input.setSize(100, 200);
        
        mainFrame.setSize(700,500);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
