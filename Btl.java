/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
    public String getInfo(){
        return (word_target + "     " + word_explain);
    }
}
class Dictionary{
    Vector <Word> arr;
    Dictionary() {
        this.arr = new Vector();
    }
    Dictionary(int size) {
        this.arr = new Vector(size);
    }
    public void add(Word w){
        this.arr.add(w);
    }
}
class DictionaryManagement{
    public Dictionary insertFromCommandline(){
        int size;
        Scanner input = new Scanner(System.in);
        size = input.nextInt();
        input.nextLine();
        Dictionary my = new Dictionary(size);
        for(int i = 0;i < size;i ++){
            Word w = new Word(input.nextLine(), input.nextLine());
            my.add(w);
        }
        return my;
    }
    public Dictionary insertFromFile(){
               BufferedReader br = null;
               Dictionary my = new Dictionary();

        try {   
            br = new BufferedReader(new FileReader("C:\\Users\\Genius\\Documents\\dictionary.txt"));       
            String s;

            while ((s = br.readLine()) != null) {
                s = br.readLine();
                for(int i = 0;i < s.length();i ++){
                    if(s.charAt(i) == 9){
                        Word w = new Word(s.substring(0, i - 1), s.substring(i + 1));
                        my.add(w);
                        break;
                    } else {
                    }
                }
            }
        } catch (IOException e) {
        } finally {
            try {
                br.close();
            } catch (IOException e) {
            }
        }
        return my;
    }
}
class DictionaryCommandline{
    public void showAllWords(Dictionary my){
        for (Word j : my.arr) {
            System.out.println(j.getInfo());
        }
    }
}
class DictionayCommandLine{

    public void DictionaryBasic(){
        DictionaryManagement t = new DictionaryManagement();
        Dictionary my = t.insertFromFile();
        DictionaryCommandline t1 = new DictionaryCommandline();
        t1.showAllWords(my);
    }
}
class Btl {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DictionayCommandLine t = new DictionayCommandLine();
        t.DictionaryBasic();
    }
    
}
