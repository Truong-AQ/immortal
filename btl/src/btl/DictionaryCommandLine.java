/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl;

import java.util.Scanner;
import javax.swing.DefaultListModel;

/**
 *
 * @author Genius
 */
class DictionaryCommandLine extends DictionaryManagement{
    //hien thi danh sach tu dien
    
    public DictionaryCommandLine(){
        this.insertFromFile();
    }

    public void showAllWords() {
        for (int j = 0;j < td.size();j ++) {
            System.out.println(td.elementAt(j).getWord_target() +'\n' + "Nghĩa: " + td.elementAt(j).getWord_explain());
        }
    }
    //ham hien thi danh sach tu goi y
    public void dictionarySeacher(DefaultListModel model, String s){
        int n = 16, l = s.length();//so tu goi y toi da can hien thi
        try {
            int vt = this.dictionaryLookup(s);
            if(td.elementAt(vt).getWord_target().indexOf(s) == 0){
                model.addElement(td.elementAt(vt).getWord_target());
                n --;
            }
            for(int j = vt + 1;j < td.size() ;j ++){
                if(n == 0)
                    break;
                if(td.elementAt(j).getWord_target().length() >= l){
                    if(td.elementAt(j).getWord_target().substring(0, l).equals(s))
                        model.addElement(td.elementAt(j).getWord_target());
                    else
                        break;
                }
                else
                    break;
                n --;
                }
            }
        catch (Exception e) {
        }
    }
}
