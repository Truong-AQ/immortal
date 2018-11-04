/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bom;

import static java.lang.Math.random;

/**
 *
 * @author Genius
 */
public class Bom {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        long timePrevious, timePresent;
        long timeUpdate = 180;
        new ScreenPlay().setVisible(true);
        timePrevious = System.currentTimeMillis();
        while(true){
            timePresent = System.currentTimeMillis();
            if(timePresent - timePrevious > timeUpdate){
                timePrevious = timePresent;
                for(int j = 0;j < ScreenPlay.monster.size();j ++)
                    ScreenPlay.monster.elementAt(j).move();
            }
        }
    }
}
