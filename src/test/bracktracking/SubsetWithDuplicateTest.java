package test.bracktracking;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SubsetWithDuplicateTest {

    @Test
    public void TestSubsetWithDuplicate() {
        int[] nums = new int[]{1, 2, 2};
        System.out.println(subsetsWithDup(nums));

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, ans, new ArrayList<>());
        return ans;
    }

    public void helper(int[] nums, int i, List<List<Integer>> ans, List<Integer> current) {

        if (i >= nums.length) {
                ans.add(new ArrayList<>(current));

            return;
        }

        current.add(nums[i]);
        helper(nums, i+1, ans, current);
        current.remove(current.size() - 1);
        while(i+1 < nums.length && nums[i] == nums[i+1]){
            i++;
        }
        helper(nums, i+1, ans, current);

    }
}
