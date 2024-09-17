package org.example.dfs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates=candidates;
        this.target=target;
        dfs(0,0);
        return  result;

    }


    int target;
    List<List<Integer>> result=new ArrayList<>();
    int[] candidates;
    List<Integer> curRes=new ArrayList<>();

    void dfs(int cur,int sum){

        if(sum>target)
            return;

        if (sum==target)
        {
            //   curRes.add(candidates[cur]);
           // result.add(curRes);   错误添加 curRes全局变量始终不变  需要创建一个新的List
            result.add(new ArrayList<>(curRes));
            return;
        }
        for (int i = cur; i <candidates.length ; i++) {
            if(sum+candidates[i]>target)  //剪枝
                break;
            curRes.add(candidates[i]);
            sum+=candidates[i];
            dfs(i,sum);
            sum-=candidates[i];
            curRes.remove(curRes.size()-1);

        }

    }
    @Test
    public void test()
    {
        int[] candidates=new int[]{2,3,6,7};
        combinationSum(candidates,7);
    }




}
