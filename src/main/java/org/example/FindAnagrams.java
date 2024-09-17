package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> list=new ArrayList<>();

        for (int i = 0; i <s.length()-p.length()+1 ; i++)
        {
            int j=i;
            StringBuffer buffer=new StringBuffer(p);
            while (j-i<p.length())
            {
                if(buffer.indexOf(String.valueOf(s.charAt(j)))!=-1)
                    buffer.deleteCharAt(buffer.indexOf(String.valueOf(s.charAt(j))));
                else {
                    break;
                }

                if(buffer.length()==0)
                    list.add(i);
                j++;
                if(j==s.length())
                    break;
            }
        }
        return list;

    }
    @Test
    public void test()
    {
        String s="cbaebabacd";
        String p="abc";
        System.out.println(findAnagrams(s,p));
    }
}
