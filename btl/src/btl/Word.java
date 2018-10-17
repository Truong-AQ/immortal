/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl;

import java.util.Objects;


/**
 *
 * @author Genius
 */
class Word implements Comparable{
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

    @Override
    public int compareTo(Object o) {
        if(o instanceof Word){
            Word obj = (Word)o;
            return (this.word_target.compareTo(obj.getWord_target()));
        }
        return -2;
    }    
}