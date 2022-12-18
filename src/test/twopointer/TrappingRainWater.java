package test.twopointer;

import org.testng.annotations.Test;

public class TrappingRainWater {

    @Test
    public void TestTrap(){

        int[] nums = new int[]{4,2,0,3,2,5};
        System.out.println(trap(nums));
    }

    public int trap(int[] height) {
        int ans = 0 ;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        int left = 0;
        for(int i = 0; i < height.length; i++){
            if (i ==0){
                maxLeft[0] = 0;
                left = height[i];
                continue;
            }

            if (height[i] > left) {
                left = height[i];
            }
            maxLeft[i] = left;
        }

        int right = 0;
        for(int i = height.length-1; i >=0; i--){
            if (i == height.length-1){
                right = height[height.length-1];
                maxLeft[height.length-1] = 0;
                continue;
            }

            if (height[i] > right) {
                right = height[i];
            }
            maxRight[i] = right;
        }

        for (int i = 0; i < height.length; i++){
            int heightCheck = Math.min(maxLeft[i],maxRight[i]);
            int diff =  heightCheck - height[i] ;
            if (diff > 0){
                ans += diff;
            }
        }
        return ans;
    }
}
