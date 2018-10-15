/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dohoa;

/**
 *
 * @author Admin
 */
import static dohoa.viewdictionary.listDict;
/**
 *
 * @author PC
 */
public class NextId {

    AcessDatabase acessDatabase = new AcessDatabase();

    public static String maxId() {
        viewdictionary viewDictionary = new viewdictionary();
        String id = "'" + String.valueOf(viewDictionary.listDict.get(listDict.size()-1).getId()+1) + "'";
        return id;
    }
}
