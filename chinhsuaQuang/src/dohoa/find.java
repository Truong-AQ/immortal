package dohoa;


import static dohoa.viewdictionary.listDict;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Genius
 */
public class find {

    public find() {
    }
    
    public int find(String text){
        int l = 0, r = listDict.size() - 1, position = -1;
       while(l <= r){
           int m = (l + r)/2, result = text.compareTo(listDict.get(m).getWord());
            if(result == 0){
               return m;
           }
           if(result > 0)
               l = m + 1;
           else
               r = m - 1;
       }
       return r;
    }
}