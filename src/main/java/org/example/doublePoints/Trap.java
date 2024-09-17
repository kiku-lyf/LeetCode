package org.example.doublePoints;

public class Trap {
    public int trap(int[] height) {
        int ll,lr,rr,rl;
        ll=height[0];
        rr=height[height.length-1];
        int i=0;
        int j=height.length-1;
        int sum=0;
        while (i<j){
            if(height[i]>=height[j])
            {
                rl=height[i];
                rr=Math.max(rr,height[j]);
                sum+=Math.min(rr,rl)-height[j];
                j--;
            }
            else {
                lr=height[j];
                ll=Math.max(ll,height[i]);
                sum+=Math.min(ll,lr)-height[i];
                i++;
            }
        }
        return sum;

    }

}
