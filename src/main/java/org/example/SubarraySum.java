package org.example;

public class SubarraySum {

    public int subarraySum(int[] nums, int k) {
        int[] sum=new int[nums.length];
        int sum1=0;
        int count=0;
        for (int i = 1; i < nums.length; i++) {
            sum1+=nums[i];
            sum[i]=sum1;
        }
        for (int i = 0; i <nums.length ; i++)
            for (int j = i; j <nums.length ; j++) {
                if (sum[j]-sum[i]+nums[i]==k)
                    count++;
            }
       return count;
    }
}
