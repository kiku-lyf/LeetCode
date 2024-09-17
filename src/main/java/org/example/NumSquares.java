package org.example;

public class NumSquares {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        if(n==1||n==0)
            return 1;
        if(n==2)
            return 2;
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        for (int i = 3; i <= n; i++)
            dp[i]=2^32-1;
        for (int i = 3; i <= n; i++)
         {
             if((int)Math.sqrt(i)*(int)Math.sqrt(i)==i)
             {
                 dp[i]=1; continue;
             }
             for (int j = 1; j <i ; j++)
             {
                 if(dp[j]+dp[i-j]<dp[i])
                     dp[i]=dp[j]+dp[i-j];
             }
         }
        return dp[n];

    }
}
