package test.greedy;

import org.testng.annotations.Test;

public class MaximumSubArrayTest {

    @Test
    public void TestMaximumSubArray() {

        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
//        int[] nums = new int[]{-2,-1};
        System.out.println(maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {

        int ans = nums[0];
        int current = ans;

        for (int i =1; i < nums.length; i ++ ){
            current = Math.max(current+nums[i], nums[i]);
            ans  = Math.max(current,ans);
        }

        return ans;

    }

}
