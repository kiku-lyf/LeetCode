package org.example.dfs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Partition {

    List<List<String>> resullt=new ArrayList<>();
    List<String> cur=new ArrayList<>();
    String s;

    public List<List<String>> partition(String s) {
        this.s=s;
        dfs(0);
        return resullt;


    }

    void dfs(int start)
    {
        if(start>=s.length())
        {
            resullt.add(new ArrayList<>(cur)); //易错点
            return;
        }
        for (int i = start; i <s.length() ; i++) {
            if(isPalindrome(start,i))
            {
                cur.add(s.substring(start,i+1));  //左闭右开
                dfs(i+1);
                cur.remove(cur.size()-1);
            }
        }

    }
    boolean isPalindrome(int start,int end)
    {
       int i=start;
       int j=end;
       while (i<=j){
           if(s.charAt(i)!=s.charAt(j))
               return false;
           i++;j--;
       }
       return true;
    }

    @Test
    public void test()
    {
        partition("a");
    }


}
