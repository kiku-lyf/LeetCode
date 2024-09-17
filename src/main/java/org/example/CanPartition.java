package org.example;

import java.util.Arrays;

public class CanPartition {
    public boolean canPartition(int[] nums) {


        int sum=0;
        for (int i = 0; i <nums.length ; i++) {
            sum+=nums[i];
        }
        if(sum%2!=0)
            return false;
      int[] dp=new int[sum/2+1];
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]<dp.length)
                dp[nums[i]]=1;
        }

        return false;



    }
}
