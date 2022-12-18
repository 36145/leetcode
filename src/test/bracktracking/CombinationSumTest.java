package test.bracktracking;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumTest {


    @Test
    public void TestCombinationSum() {
        int[] nums = new int[]{2, 3, 6, 7};
        int target = 7;

        System.out.println(combinationSum(nums, target));

    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        dfs(candidates, target, 0, 0, ans, new ArrayList<>());
        return ans;
    }


    public void dfs(int[] nums, int target, int i, int currentSum, List<List<Integer>> ans, List<Integer> current) {

        if (currentSum == target) {
            ans.add(new ArrayList<>(current));
            return;
        }

        if (i >= nums.length || currentSum > target) {
            return;
        }

        int currentValue = nums[i];

        current.add(currentValue);
        dfs(nums, target, i, currentSum + currentValue, ans,current);
        current.remove(current.size() - 1);
        //proceed without adding
        dfs(nums, target, i + 1, currentSum, ans, current);
    }
}
