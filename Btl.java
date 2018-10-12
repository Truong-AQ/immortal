/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author Genius
 */
class Word{
    private String word_target, word_explain;

    public Word(String word_target, String word_explain) {
        this.word_target = word_target;
        this.word_explain = word_explain;
    }

    public String getWord_target() {
        return word_target;
    }

    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }

    public String getWord_explain() {
        return word_explain;
    }

    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }
    
}

class Dictionary extends Vector <Word>{

    public Dictionary(int initialCapacity) {
        super(initialCapacity);
    }

    public Dictionary() {
    }    
}
class DictionaryManagement{
    Dictionary my;

    public Dictionary getMy() {
        return my;
    }

    public void setMy(Dictionary my) {
        this.my = my;
    }
    
    public void insertFromCommandline(){
        Scanner input = new Scanner(System.in);
        my = new Dictionary(input.nextInt());
        input.nextLine();
        for(int i = 0;i < my.size();i ++)
            my.add(i, new Word(input.nextLine(), input.nextLine()));
    }
    public void insertFromFile(){
        File file = new File("dictionaries.txt");
        my = new Dictionary();
        try(Scanner sc = new Scanner(file)){
            String s;
            while(sc.hasNext()){
                s = sc.nextLine();
                for(int i = 0;i < s.length();i ++)
                    if(s.charAt(i) == 9){
                        my.add(new Word(s.substring(0, i), s.substring(i + 1)));
                        break;
                    }
            }
        } catch(Exception e){
            
        }
    }
    public int dictionaryLookup(String word_target){
        int vt1 = 0, vt2 = my.size() - 1;
        while(vt1 <= vt2){
            int vttg = (vt1 + vt2)/2, kq = my.elementAt(vttg).getWord_target().compareTo(word_target);
            if(kq == 0)
                return vttg;
            else if(kq < 0){
                vt1 = vttg + 1;
            }
            else{
                vt2 = vttg - 1;
            }
        }
        return vt2;
    }
    public void dictionaryExportToFile(){
        File file = new File("dictionaries.txt");
        char c = 9;
        try(PrintWriter pw = new PrintWriter(file)) {
           for(int i = 0;i < my.size();i ++){
               pw.println(my.elementAt(i).getWord_target() + c + my.elementAt(i).getWord_explain());
           }
        } catch (Exception e) {
        }
    }
    public void push(Word w){
        int vt = this.dictionaryLookup(w.getWord_target());
        if(vt == -1)
            my.add(0, w);
        else if(vt != -1)
        if(!my.elementAt(vt).equals(w))
        my.add(vt + 1, w);
    }
    public void remove(Word w){
        int vt = dictionaryLookup(w.getWord_target());
        if(my.elementAt(vt).equals(w))
        my.remove(vt);
    }
    public void repair(Word w, Word q){//sua tu q thanh w
        int vt = dictionaryLookup(w.getWord_target());
        if(my.elementAt(vt).equals(w)){
            my.elementAt(vt).setWord_target(q.getWord_target());
            my.elementAt(vt).setWord_explain(q.getWord_explain());
        }
    }
}
class DictionaryCommandline extends DictionaryManagement{
    public void showAllWords(){
        System.out.println("English |     |  Vietnam");
        for (Word j : my) {
            System.out.println(j.getWord_target() + "  |     |  " + j.getWord_explain());
        }
    }
}
class DictionayCommandLine extends DictionaryCommandline{
    public void DictionaryBasic(){
        this.insertFromCommandline();
        this.showAllWords();
    }
    public void DictionaryAdvanced(){
        this.insertFromFile();
        this.showAllWords();
        String s;
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
        int vt = this.dictionaryLookup(s);
        if(vt != -1)
        if(my.elementAt(vt).getWord_target().equals(s))
        System.out.println(my.elementAt(vt).getWord_explain());
    }
    public void dictionarySeacher(String s){
        int vt1 = 0, vt2 = my.size() - 1, lS = s.length();
        while(vt1 <= vt2){
            int vttg = (vt1 + vt2)/2, kq = my.elementAt(vttg).getWord_target().substring(0, lS).compareTo(s);
            if(kq == 0){
                for(int i = vttg;i >= 0;i --)
                    if(my.elementAt(i).getWord_target().substring(0, lS).compareTo(s) != 0){
                        vttg = i + 1;
                        break;
                    }
                    else if(i == 0)
                        vttg = 0;
                for(int i = vttg;i < my.size();i ++)
                    if(my.elementAt(i).getWord_target().substring(0, lS).compareTo(s) == 0)
                        System.out.println(my.elementAt(i).getWord_target());
                return;
            }
            if(kq < 0)
                vt1 = vttg + 1;
            else
                vt2 = vttg - 1;
        }
    }
}
public class Btl {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DictionayCommandLine t = new DictionayCommandLine();
        t.DictionaryAdvanced();
    }    
}