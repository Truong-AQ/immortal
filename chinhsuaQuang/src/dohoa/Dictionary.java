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
public class Dictionary {

    private int id;
    private String word;
    private String detail;

    public Dictionary() {
        super();
    }

    public Dictionary(int id, String word, String detail) {
        this.word = word;
        this.detail = detail;
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public String getWord() {
        return word;
    }

    public String getDetail() {
        return detail;
    }
}
