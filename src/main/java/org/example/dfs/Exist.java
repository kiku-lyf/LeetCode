package org.example.dfs;

public class Exist {

    public boolean exist(char[][] board, String word) {
        this.board=board;
        this.word=word;
        tag=new int[board.length][board[0].length];
        if (word.length()==1)
        {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if(word.toCharArray()[0]==board[i][j])
                        return true;
                }
            }
            return false;

        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(word.toCharArray()[0]==board[i][j]&&dfs(i,j,0))
                    return true;

            }
        }
        return false;

    }
    char[][] board;
    int[][] tag;
    String word;
    boolean dfs(int m,int n,int p){
        if(p>=word.length())
            return true;
        if(word.toCharArray()[p]!=board[m][n]||tag[m][n]==1)
            return false;
        tag[m][n]=1;
        boolean b1,b2,b3,b4;

        if(m-1>=0&&dfs(m-1,n,p+1))
            return true;

        else if(m+1<board.length&&dfs(m+1,n,p+1))
           return true;

        else if(n-1>=0&&dfs(m,n-1,p+1))
          return true;

        else if(n+1<board[0].length&&dfs(m,n+1,p+1))
            return true;

        else {
            tag[m][n]=0;
            return false;
        }

//        return dfs(m-1,n,p+1)||dfs(m+1,n,p+1)||dfs(m,n-1,p+1)
//                ||dfs(m,n+1,p+1);

    }
}
