/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bom;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Genius
 */
public class ScreenPlay extends JFrame{
    final static int sizeIcon = 32, sizeTimeAndScore = 20;
    private int width, height = 39;
    public static Character[][] allCharacter;
    Level lv;
    public static JPanel pane;
    public static Vector <Monster> monster = new Vector();
    Bomber characterMain;
    public ScreenPlay(){
          lv = new Level();
          allCharacter = new Character[lv.getRow()][lv.getColumn()];
          width = (lv.getColumn() + 1)*sizeIcon;
          height += lv.getRow()*sizeIcon + sizeTimeAndScore;
          pane = (JPanel) this.getContentPane();
          pane.setLayout(null);
          for(int i = 0;i < allCharacter.length;i ++)
              for(int j = 0;j < allCharacter[i].length;j ++){
                  if(Level.map[i].charAt(j) == '#')
                      allCharacter[i][j] = new Wall(i, j);
                  else if(Level.map[i].charAt(j) == '*')
                      allCharacter[i][j] = new Brick(i, j);
                  else if(Level.map[i].charAt(j) == 'b')
                      allCharacter[i][j] = new BombItem(i, j);
                  else if(Level.map[i].charAt(j) == 'f')
                      allCharacter[i][j] = new FlameItem(i, j);
                  else if(Level.map[i].charAt(j) == 's')
                      allCharacter[i][j] = new SpeedItem(i, j);
                  else if(Level.map[i].charAt(j) == 'x')
                      allCharacter[i][j] = new Portal(i, j);
                  else if(Level.map[i].charAt(j) == 'p'){
                      allCharacter[i][j] = new Grass(i, j);
                      characterMain = new Bomber(i, j);
                      pane.add(characterMain);
                      continue;
                  }
                  else if(Level.map[i].charAt(j) == '1'){
                      allCharacter[i][j] = new Grass(i, j);
                      monster.add(new Ballon(i, j));
                      pane.add(monster.elementAt(monster.size() - 1));
                      continue;
                  }
                  else if(Level.map[i].charAt(j) == '2'){
                      allCharacter[i][j] = new Grass(i, j);
                      monster.add(new Oneal(i, j));
                      pane.add(monster.elementAt(monster.size() - 1));
                      continue;
                  }
                  else{
                      allCharacter[i][j] = new Grass(i, j);
                      continue;
                  }
                  pane.add(allCharacter[i][j]);
              }
          //loi gi khong biet nhung ma chen Grass o tren la khong nhin thay monster
          for(int i = 0;i < allCharacter.length;i ++)
              for(int j = 0;j < allCharacter[i].length;j ++)
                  if(allCharacter[i][j] instanceof Grass)
                      pane.add(allCharacter[i][j]);
          settingsScreenPlay();
      }
      public void handlKeyBoardInput(char input){
          if(input == 'w'
                 || input == 's'
                 || input == 'a'
                 || input == 'd')
              characterMain.move(input);
          else if(input == 'l'){
              characterMain.putBoms();
          }
      }

    private void settingsScreenPlay() {
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                handlKeyBoardInput(evt.getKeyChar());
            }
        });
    }
}