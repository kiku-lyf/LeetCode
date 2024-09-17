package org.example;

import org.junit.Test;

import java.util.Arrays;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        if (nums.length==0)
            return 0;


        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;

        for (int it : nums) {
            if(it>max)
                max=it;
            if(it<min)
                min=it;
        }

        int [] hash=new int[max-min+1];
        for (int it:nums)
            hash[it-min]=1;

        if(min==max)
            return 1;

        int i=0;
        int j=0;
        int maxLen=1;
        while(j<max-min+1){
            if(hash[j]==1)
                j++;
            if(j==max-min+1)
                if(j-i>maxLen)
                    maxLen=j-i;
            if(j<max-min+1&&hash[j]==0)
            {
                if(j-i>maxLen)
                    maxLen=j-i;
                while (j<max-min+1&&hash[j]==0)
                    j++;
                i=j;
            }
        }
        return  maxLen;

    }

    @Test
    public  void test() {
        int [] nums=new int[]{0,3,7,2,5,8,4,6,0,1};
        System.out.println(this.longestConsecutive(nums));

    }

}
