package org.example.dp;

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        dp[0][0]=grid[0][0];
        for (int i = 0; i <m ; i++) {
            if(i==0) continue;;
            dp[i][0]=grid[i][0]+dp[i-1][0];
        }
        for (int i = 0; i <n ; i++) {

            if(i==0) continue;;
            dp[0][i]=grid[0][i]+dp[0][i-1];
            
        }


        for (int i = 0; i <m ; i++) {
            if(i==0) continue;
            for (int j = 0; j <n ; j++) {
                if(j==0) continue;
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
            
        }
        return dp[m-1][n-1];


    }
}


