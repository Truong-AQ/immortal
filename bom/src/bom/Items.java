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
public abstract class Items extends StaticCharacter{
    
    public Items(int i, int j) {
        ii = new ImageIcon(getClass().getResource("/bom/resources/icon/brick.png"));
        this.setIcon(ii);
        this.setBounds(j*sizeIcon, sizeTimeAndScore + i*sizeIcon, sizeIcon, sizeIcon);
    }
    
}
class BombItem extends Items{
    
    public BombItem(int i, int j) {
        super(i, j);
    }
    public void appearBombItem(){
        ii = new ImageIcon(getClass().getResource("/bom/resources/icon/powerup_bombs.png"));
        this.setIcon(ii);
    }
}
class FlameItem extends Items{
    
    public FlameItem(int i, int j) {
        super(i, j);
    }
    public void appearFlameItem(){
        ii = new ImageIcon(getClass().getResource("/bom/resources/icon/powerup_flames.png"));
        this.setIcon(ii);
    }    
}
class SpeedItem extends Items{
    
    public SpeedItem(int i, int j) {
        super(i, j);
    }
    public void appearSpeedItem(){
        ii = new ImageIcon(getClass().getResource("/bom/resources/icon/powerup_speed.png"));
        this.setIcon(ii);
    }
}