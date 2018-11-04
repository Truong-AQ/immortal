/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bom;

import static bom.ScreenPlay.sizeIcon;
import static bom.ScreenPlay.sizeTimeAndScore;
import javax.swing.ImageIcon;

/**
 *
 * @author Genius
 */
public class Bomb extends MotionCharacter{
    protected int i, j;
    ImageIcon allStatus[] = {
        new ImageIcon(getClass().getResource("/bom/resources/icon/bomb.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/bomb_1.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/bomb_2.png"))
    };
    private int nStatus = allStatus.length;
    private int cycle = 4, numericalOrder = 0;
    public Bomb(int i, int j){
        this.i = i;
        this.j = j;
        ii = allStatus[0];
        this.setIcon(ii);
        x = j*sizeIcon;
        y = sizeTimeAndScore + i*sizeIcon;
        this.setBounds(x, y, sizeIcon, sizeIcon);
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public void updateBomb(){
        if(cycle == 0){
            explosiveBomb();
            return;
        }
        else{
            if(numericalOrder == nStatus - 1)
                cycle --;
            numericalOrder = (numericalOrder + 1)%nStatus;
        }
        ii = allStatus[numericalOrder];
        this.setIcon(ii);
    }
    public void explosiveBomb(){
        
    }

}
