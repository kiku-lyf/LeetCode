package org.example;
import java.math.*;
public class MaxArea {

    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int maxArea=0;
        while(i<j)
        {
            if(height[i]<height[j])
                i++;
            else j--;
            if((j-i)*Math.min(height[j],height[i])>maxArea)
               maxArea= (j-i)*Math.min(height[j],height[i]);

        }
        return maxArea;


    }
}
