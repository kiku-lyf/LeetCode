package org.example.dfs;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    int depth;
    int[] tag;
    List<List<Integer>> result;
    int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        this.depth=nums.length;
        tag=new int[nums.length];
        result=new ArrayList<>();
        this.nums=nums;
        dfs(0);
        return result;

    }

    public void dfs(int depth){
        if(depth==this.depth) {
            List<Integer> currentResult=new ArrayList<>();
            for (int i = 0; i <nums.length; i++) {
                if(tag[i]==1)
                    currentResult.add(nums[i]);
            }
            result.add(currentResult);
            return;
        }
        for (int i = 0; i <2 ; i++) {
            tag[depth]=i;
            dfs(depth+1);

        }

    }


}
