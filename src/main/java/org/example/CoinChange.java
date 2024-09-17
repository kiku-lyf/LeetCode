package org.example;

import org.junit.Test;

public class CoinChange {
      private final int maxNum =(int)Math.pow(2,31)-1;
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for (int i=0;i<=amount;i++)
            dp[i]=maxNum;

        for (int i=0;i<coins.length;i++)
            if(coins[i]<=amount)
            dp[coins[i]]=1;
        dp[0]=0;

        for (int i=0;i<amount;i++)
          for (int j=0;j<coins.length;j++)
        if(dp[i]!=maxNum&&i+coins[j]<=amount&&i+coins[j]>0&&dp[i]+1<dp[i+coins[j]])
            dp[i+coins[j]]=dp[i]+1;
        System.out.println(dp);
        if(dp[amount]!=maxNum)
        return dp[amount];
        else return -1;
    }

    @Test
    public void test()
    {
        System.out.println(-1<<31-1);
        int[] coins=new int[]{357,239,73,52};
        int amount=9832;
        coinChange(coins,amount);


    }
}
