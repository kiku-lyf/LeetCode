package org.example.Array;

import org.junit.Test;

import java.util.*;

public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int max=0;
        for (int i = 0; i <heights.length ; i++) {
            int left=i;
            int right=i;
            while (left>=0&&heights[left]>=heights[i])
                left--;
            left++;

            while (right<heights.length&&heights[right]>=heights[i])
                right++;
            right--;
            max=Math.max(max,(right-left+1)*heights[i]);



        }
        return max;

    }
    @Test
    public void  test(){
        Map<Integer, List<Integer>> map=new HashMap<>();
        List temp= new ArrayList<>();
        temp.add(1);
        temp.add(2);
        map.put(1,temp);
        List temp1= new LinkedList<>();
        temp1.add(1);
        temp1.add(2);
        map.put(2,temp1);
//        map.getOrDefault(2,"bbb");
        map.get(2).add(3);
        System.out.println(map.get(2));


    }
}



