/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.Objects;
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

    public Word() {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.word_target);
        hash = 13 * hash + Objects.hashCode(this.word_explain);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Word){
            Word w = (Word) obj;
            return (this.word_target.equals(w.getWord_target())
                    && this.word_explain.equals(w.getWord_explain()));
        }
        return false;
    }
    
}

@SuppressWarnings("serial")
class Dictionary extends Vector <Word>{

    public Dictionary(int initialCapacity) {
        super(initialCapacity);
    }

    public Dictionary() {
    }    
}
class DictionaryManagement{
    Dictionary td;

    public DictionaryManagement(Dictionary td) {
        this.td = td;
    }

    public DictionaryManagement() {
        td = new Dictionary();
    }

    public Dictionary getTd() {
        return td;
    }

    public void setTd(Dictionary td) {
        this.td = td;
    }
    //doc du lieu tu ban phim
    public void insertFromCommandline(){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        for(int i = 0;i < n;i ++)
            td.add(i, new Word(input.nextLine(), input.nextLine()));
    }
    //doc du lieu tu file
    public void insertFromFile(){
        File file = new File("dictionaries.txt");
        try(Scanner sc = new Scanner(file)){
            String s;
            while(sc.hasNext()){
                s = sc.nextLine();
                for(int i = 0;i < s.length();i ++)
                    if(s.charAt(i) == 9){
                        td.add(new Word(s.substring(0, i), s.substring(i + 1)));
                        break;
                    }
            }
        } catch(Exception e){
            
        }
    }
    //tim vi tri tu tieng anh trong tu dien
    public int dictionaryLookup(String word_target){
        int vt1 = 0, vt2 = td.size() - 1;
        while(vt1 <= vt2){
            int vttg = (vt1 + vt2)/2, kq = td.elementAt(vttg).getWord_target().compareTo(word_target);
            if(kq == 0)
                return vttg;
            else if(kq < 0){
                vt1 = vttg + 1;
            }
            else{
                vt2 = vttg - 1;
            }
        }
        return vt2;//tra ve vi tri tu be hon gan nhat tu can tim trong tu dien
    }
    //ghi du lieu tu dien vao file
    public void dictionaryExportToFile(){
        File file = new File("dictionaries.txt");
        char c = 9;
        try(PrintWriter pw = new PrintWriter(file)) {
           for(int i = 0;i < td.size();i ++){
               pw.println(td.elementAt(i).getWord_target() + c + td.elementAt(i).getWord_explain());
           }
        } catch (Exception e) {
        }
    }
    //them tu w vao tu dien
    public void push(Word w){
        int vt = this.dictionaryLookup(w.getWord_target());
        if(vt == -1)
            td.add(0, w);
        else if(vt != -1)
        if(!td.elementAt(vt).equals(w))
        td.add(vt + 1, w);
    }
    //loai tu w khoi tu dien
    public void remove(Word w){
        int vt = dictionaryLookup(w.getWord_target());
        if(vt != -1){
            if(td.elementAt(vt).equals(w))
                td.remove(vt);
        }
    }
    //sua tu w trong tu dien thanh tu q
    public void repair(Word w, Word q){
        int vt = dictionaryLookup(w.getWord_target());
        if(vt != -1){
            if(td.elementAt(vt).equals(w)){
            td.elementAt(vt).setWord_target(q.getWord_target());
            td.elementAt(vt).setWord_explain(q.getWord_explain());
            }
        }
    }
}
class DictionayCommandLine extends DictionaryManagement{
    //hien thi danh sach tu dien
    public void showAllWords(){
        char c = 9;
        System.out.println("English|" + c + "|Vietnam");
        for (int j = 0;j < td.size();j ++) {
            System.out.println(td.elementAt(j).getWord_target() + "|" + c + "|" + td.elementAt(j).getWord_explain());
        }
    }
    public void DictionaryBasic(){
        this.insertFromCommandline();
        this.showAllWords();
    }
    public void DictionaryAdvanced(){
        this.insertFromFile();
        System.out.println("Hien thi tu dien: ");
        this.showAllWords();
        System.out.println("Nhap tu can tra: ");
        String s;
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
        int vt = this.dictionaryLookup(s);
        if(vt != -1)
            if(td.elementAt(vt).getWord_target().equals(s)){
                System.out.println(td.elementAt(vt).getWord_explain());
                return;
            }
        System.out.println("Khong tim thay tu " + s);
    }
    //ham hien thi danh sach tu goi y
    public void dictionarySeacher(String s){
        int vt = this.dictionaryLookup(s), l = s.length();
        int n = 5;//so tu goi y toi da can hien thi
        for(int j = vt + 1;j < td.size() ;j ++){
            if(n == 0)
                break;
            if(td.elementAt(j).getWord_target().length() >= l){
                if(td.elementAt(j).getWord_target().substring(0, l).equals(s))
                    System.out.println(td.elementAt(j).getWord_target());
                else
                    break;
            }
            else
                break;
            n --;
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
        System.out.println("Nhap tu can them (Tieng Anh / Tieng Viet): ");
        Scanner ip = new Scanner(System.in);
        t.push(new Word(ip.nextLine(), ip.nextLine()));
        System.out.println("Tu dien sau khi them: ");
        t.showAllWords();
        System.out.println("Nhap tu can xoa (Tieng Anh / Tieng Viet): ");
        t.remove(new Word(ip.nextLine(), ip.nextLine()));
        System.out.println("Tu dien sau khi xoa: ");
        t.showAllWords();
        System.out.println("Nhap tu can sua (Tieng Anh / Tieng Viet): ");
        Word w = new Word(ip.nextLine(), ip.nextLine());
        System.out.println("Ban muon sua tu do thanh tu (Tieng Anh / Tieng Viet): ");
        t.repair(w, new Word(ip.nextLine(), ip.nextLine()));
        System.out.println("Tu dien sau khi sua: ");
        t.showAllWords();
        System.out.println("Nhap tu ban muon biet goi y: ");
        String s = ip.nextLine();
        System.out.println("Goi y cua ban la: ");
        t.dictionarySeacher(s);
    }    
}