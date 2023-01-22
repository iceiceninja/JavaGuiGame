/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaguigame;

/**
 *
 * @author Josh Bonham
 */
public class FireBall extends Spell{

    @Override
    public int cast() {
        return (int) Math.floor(Math.random()*(8-4+1)+4);
    }
    
}
