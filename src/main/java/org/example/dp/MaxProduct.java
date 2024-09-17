package org.example.dp;

public class MaxProduct {

    public int maxProduct(int[] nums) {  //由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin。
        if (nums.length==1)
            return nums[0];
        int [] dp=new int[nums.length];
        int [] dp1=new int[nums.length];
        dp[0]=nums[0];
        dp1[0]=nums[0];
        for (int i = 1; i <dp.length ; i++) {
            dp[i]=Math.max(dp[i-1]*nums[i],nums[i]);
            dp[i]=Math.max(dp[i],dp1[i-1]*nums[i]);

            dp1[i]=Math.min(dp1[i-1]*nums[i],nums[i]);
            dp1[i]=Math.min(dp1[i],dp[i-1]*nums[i]);

        }
        int max=dp[0];
        for (int i = 0; i <dp.length ; i++) {
            max=Math.max(dp[i],max);
        }
        return  max;


    }

}
