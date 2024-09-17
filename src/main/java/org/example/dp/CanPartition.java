package org.example.dp;

public class CanPartition {

    public boolean canPartition(int[] nums) {

        int sum=0;
        for (int i = 0; i <nums.length ; i++) {
            sum+=nums[i];
        }
        if(sum%2!=0)
            return false;

        int[] dp=new int[sum/2+1];
        for (int i = 0; i < dp.length; i++) {
            if(i>=nums[0])
                dp[i]=nums[0];
        }

        for (int i = 1; i <nums.length ; i++) {
            for (int j = dp.length-1; j >=0 ; j--) {
                if(j-nums[i]>=0)
                dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        if (dp[dp.length-1]==dp.length-1)
            return true;
        else return false;


    }
}
