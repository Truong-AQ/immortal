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
public abstract class StaticCharacter extends Character{
    
}
class Grass extends StaticCharacter{

    public Grass(int i, int j) {
        ii = new ImageIcon(getClass().getResource("/bom/resources/icon/grass.png"));
        this.setIcon(ii);
        this.setBounds(j*sizeIcon, sizeTimeAndScore + i*sizeIcon, sizeIcon, sizeIcon);
    }
    
}
class Wall extends StaticCharacter{

    public Wall(int i, int j) {
        ii = new ImageIcon(getClass().getResource("/bom/resources/icon/wall.png"));
        this.setIcon(ii);
        this.setBounds(j*sizeIcon, sizeTimeAndScore + i*sizeIcon, sizeIcon, sizeIcon);
    }
}
class Brick extends StaticCharacter{
    public Brick(int i, int j){
        ii = new ImageIcon(getClass().getResource("/bom/resources/icon/brick.png"));
        this.setIcon(ii);
        this.setBounds(j*sizeIcon, sizeTimeAndScore + i*sizeIcon, sizeIcon, sizeIcon);
    }
}
class Portal extends StaticCharacter{
    
    public Portal(int i, int j) {
        ii = new ImageIcon(getClass().getResource("/bom/resources/icon/brick.png"));
        this.setIcon(ii);
        this.setBounds(j*sizeIcon, sizeTimeAndScore + i*sizeIcon, sizeIcon, sizeIcon);
    }
    public void appearPortal(){
        ii = new ImageIcon(getClass().getResource("/bom/resources/icon/portal.png"));
        this.setIcon(ii);
    }
}