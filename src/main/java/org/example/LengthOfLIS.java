package org.example;

import java.util.Arrays;

public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        if (nums.length==1)
            return 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <i ; j++) {
                if(nums[j]<nums[i])
                    dp[i]=Math.max(dp[j]+1,dp[i]);
            }
        }
        int max=1;
        for (int i = 0; i <nums.length ; i++) {
            max=Math.max(max,dp[i]);
        }
        return max;





    }
}

