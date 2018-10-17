/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl;

import java.io.File;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Genius
 */
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
    //doc du lieu tu file
    public void insertFromFile(){
        InputStream stream = Btl.class.getResourceAsStream("/btl/Dictionaries.txt");
        try(Scanner sc = new Scanner(stream)){
            String e = sc.nextLine().substring(1), v = "", t;
            while(sc.hasNext()){
                t = sc.nextLine();
                if(t.length() <= 1)
                    continue;
                if(t.charAt(0) == '@'){
                    td.add(new Word(e, v));
                    e = t.substring(1);
                    v ="";
                }
                else
                    v = v + t + '\n';
            }
            td.add(new Word(e, v));
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
        File file = new File("C:\\Users\\Genius\\Documents\\NetBeansProjects\\Dictionaries.txt");
        try(PrintWriter pw = new PrintWriter(file)) {
           for(int i = 0;i < td.size();i ++){
               pw.println("@" + td.elementAt(i).getWord_target());
               pw.println(td.elementAt(i).getWord_explain());
           }
        } catch (Exception e) {
        }
    }
    
}
