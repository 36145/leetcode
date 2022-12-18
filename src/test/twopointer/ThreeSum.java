package test.twopointer;

import org.testng.annotations.Test;

import java.util.*;

public class ThreeSum {

    @Test
    public void TestThreeSum(){
//        int[] nums = new int[]{-1,0,1,2,-1,-4};
        int[] nums = new int[]{0,0,0,0};
        System.out.println(threeSum(nums));

    }

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();


        Arrays.sort(nums);
        Integer prev = null;
        for (int i=0;  i < nums.length-2; i++){
            int n = nums[i];
            if (prev != null && n == prev){
                continue;
            }
            int targetSum = -n;
            int l = i+1;
            int r = nums.length -1;
            while (l < r){
                int currentSum = nums[l] + nums[r];
                if (currentSum == targetSum){
                    ans.add(List.of(n,nums[l],nums[r]));
                    while(l < nums.length-1 && nums[l] == nums[l+1])
                        l++;
                    l++;
                }else if (currentSum > targetSum){
                    r--;
                }else {
                    l++;
                }

            }
            prev= n;

        }
        return ans;
    }
}
