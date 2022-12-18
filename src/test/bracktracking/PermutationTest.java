package test.bracktracking;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PermutationTest {


    @Test
    public void TestPermutation() {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(permute(nums));

    }


    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, new ArrayList<>(), ans);

        return ans;
    }

    public void dfs(int[] nums, List<Integer> current, List<List<Integer>> ans) {

        if (current.size() == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int num : nums) {
            if (!current.contains(num)) {
                {
                    current.add(num);
                    dfs(nums, current, ans);
                    current.remove(current.size() - 1);
                }
            }
        }
    }

}
