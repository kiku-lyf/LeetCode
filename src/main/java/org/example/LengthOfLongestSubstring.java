package org.example;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int maxLen=0;
        Map<Character,Integer>map=new HashMap();
        int i=0;
        int j=0;

        while (j<s.length())
        {
            while (j<s.length()&&(map.get(s.charAt(j))==null||map.get(s.charAt(j))<i))
            {
                map.put(s.charAt(j),j);
                j++;
                maxLen=Math.max(j-i,maxLen);
            }
            if(j<s.length())
            {
                i=map.get(s.charAt(j))+1;
                map.put(s.charAt(j),j);
                j++;
                maxLen=Math.max(j-i,maxLen);
            }

        }

        return maxLen;

    }
}
