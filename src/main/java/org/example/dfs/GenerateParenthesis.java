package org.example.dfs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        this.depth=2*n;
        dfs(0,0,0,"");
        return result;

    }
    int depth;
    List<String> result=new ArrayList<>();
    public void dfs(int left,int right,int depth,String temp){
        if(right>left||right>this.depth/2||left>this.depth/2)
            return;
        if(depth==this.depth)
        {
            result.add(temp);
            return;
        }
        dfs(left+1,right,depth+1,temp+'(');
        dfs(left,right+1,depth+1,temp+')');

    }


}
