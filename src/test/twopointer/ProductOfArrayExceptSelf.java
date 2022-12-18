package test.twopointer;

import org.testng.annotations.Test;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    @Test
    public void TestProductOfArray(){

        int[] nums = new int[]{1,2,3,4};
//        System.out.println(Arrays.toString(productExceptSelfLong(nums)));
        System.out.println(Arrays.toString(productExceptSelf(nums)));
        //prefix = {1,1,2,6}
        //postfix= [24,12,4,1}
        //optimized postfix = {24,12,4,1}
        //ans = {24,12,8,6}
    }

    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            if (i == 0){
                ans[0] = 1;
                continue;
            }
            ans[i] = ans[i-1] * nums[i-1];
        }

        int postfix = 1;
        for (int i = nums.length-2; i >=0;i--){
            postfix *= nums[i+1];

            ans[i] *= postfix;
        }
        return ans;
    }


    public int[] productExceptSelfLong(int[] nums) {

        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];

        for (int i = 0; i < nums.length; i++){
            if (i == 0){
                prefix[0] = 1;
                continue;
            }

            prefix[i] = prefix[i-1] * nums[i-1];
        }

        for (int i = nums.length-1; i >= 0; i--){
            if (i==nums.length-1){
                postfix[i] = 1;
                continue;
            }

            postfix[i] = postfix[i+1] * nums[i+1];
        }

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            ans[i] = prefix[i] * postfix[i];
        }

        return ans;

    }

}
