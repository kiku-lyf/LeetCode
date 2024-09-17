package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
        dps(nums,temp,result,0);
        return result;

    }
    void dps(int[] nums,List<Integer>temp,List<List<Integer>> result,int depth)
    {
        depth++;
        for (int i = 0; i <nums.length ; i++) {
            if (!temp.contains(nums[i]))
            {

                temp.add(nums[i]);
                if(depth== nums.length)
                {

                    result.add(new ArrayList<>(temp));
                    temp.remove(temp.size()-1);
                    return;
                }
                dps(nums,temp,result,depth);
                temp.remove(temp.size()-1);

            }
        }
    }
    @Test
    public void test()
    {
        int[] nums=new int[]{1,2,3};
        permute(nums);
    }

}
