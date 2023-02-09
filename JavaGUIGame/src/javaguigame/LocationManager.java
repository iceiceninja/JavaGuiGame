/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaguigame;

import java.util.Arrays;


/**
 *
 * @author Josh Bonham
 */
public class LocationManager {
    Location[] locations = new Location[5];
    int numOfLocations = 0;
    
    void addLocation(Location location)
    {
        if(numOfLocations < locations.length)
        {
            locations[numOfLocations] = location;
        }else
        {
            Location[] copyLocations = new Location[numOfLocations*2];
            for(int i = 0; i<numOfLocations; i++)
            {
                copyLocations[i] = locations[i];
            }
            locations = copyLocations;
        }
        numOfLocations++;
    }
    void showLocations()
    {
        System.out.println(Arrays.toString(locations));
    }
    
}
