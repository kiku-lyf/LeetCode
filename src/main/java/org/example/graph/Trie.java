package org.example.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {
    Character ch;
    Map<Character,Trie> children=new HashMap<>();
    boolean isEnd;


    public Trie() {

    }
    public Trie(Character ch,boolean isEnd) {
        this.ch=ch;
        this.isEnd=isEnd;

    }

    public void insert(String word) {
        Trie temp=this;
        int i=0;
        while (i<word.length()){
            if(temp.children.containsKey(word.charAt(i))){
            temp=temp.children.get(word.charAt(i));
            i++;
            }
            else
                break;
        }
        if(i==word.length()) {
            temp.isEnd = true;
            return;
        }
        while (i<word.length()){
            if(i==word.length()-1) {
                temp.children.put(word.charAt(i), new Trie(word.charAt(i), true));
                return;
            }
            else
                temp.children.put(word.charAt(i),new Trie(word.charAt(i),false));
            temp=temp.children.get(word.charAt(i));
            i++;
        }




    }

    public boolean search(String word) {
        Trie temp=this;
        int i=0;
        while (i<word.length()){
            if(!temp.children.containsKey(word.charAt(i)))
                return false;
            temp=temp.children.get(word.charAt(i));
            i++;
        }
        if(temp.isEnd==false)
            return false;
        return true;
    }

    public boolean startsWith(String prefix) {
        Trie temp=this;
        int i=0;
        while (i<prefix.length()){
            if(temp.children.containsKey(prefix.charAt(i))){
                temp=temp.children.get(prefix.charAt(i));
                i++;
            }
            else
                break;
        }
        if(i==prefix.length())
            return true;
        return false;

    }
}
