package org.example;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] num) {

       Arrays.sort(num);

        List<List<Integer>> result= new ArrayList<>();
        if(num[0]==0&&num[num.length-1]==0)
        {
            List list =new ArrayList<Integer>();
            list.add(0);
            list.add(0);
            list.add(0);
            result.add(list);
            return result;
        }
        for (int j = 1; j< num.length-1; j++)
        {

            int i=j-1;
            int k=j+1;
            while (i>=0&&k<= num.length-1)
            {

                if(num[i]+ num[j]+ num[k]>0)
                {
                    i--;

                }
                else if(num[i]+ num[j]+ num[k]<0)
                {
                    k++;

                }
                else{
                    List list =new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(num[j]);
                    list.add(num[k]);
                    result.add(list);
                    i--;
                }
            }
        }
        Set<List<Integer>> set=new HashSet(result);
        List<List<Integer>> res=new ArrayList(set);
        return res;

    }
}
