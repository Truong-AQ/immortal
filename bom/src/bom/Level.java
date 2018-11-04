/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bom;

import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author Genius
 */
public class Level {
    private int level, row, column;
    public static String[] map;

    public Level() {
        loadFromFile();
    }
    
    public void loadFromFile(){
        InputStream stream = Bom.class.getResourceAsStream("/bom/resources/levels/Level1.txt");
        try(Scanner sc = new Scanner(stream)) {
            level = Integer.parseInt(sc.nextLine());
            row = Integer.parseInt(sc.nextLine());
            column = Integer.parseInt(sc.nextLine());
            map = new String[row];
            int j = 0;
            while(sc.hasNext())
                map[j ++] = sc.nextLine();
            sc.close();
        } catch (Exception e) {
            
        }
    }

    public int getLevel() {
        return level;
    }
    
    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }
}