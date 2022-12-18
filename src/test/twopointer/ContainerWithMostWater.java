package test.twopointer;

import org.testng.annotations.Test;

public class ContainerWithMostWater {

    @Test
    public void TestContainerWithMostWater(){

        int[] nums = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(nums));

    }
    public int maxArea(int[] height) {

        int max = 0 ;
        int l = 0;
        int r = height.length-1;

        while (l < r ){
            int area = (r -l) * Math.min(height[l],height[r]);
            max = Math.max(area,max);
            if (height[l] > height[r]){
                r--;
            }else{
                l++;
            }
        }

        return max;
    }

}
