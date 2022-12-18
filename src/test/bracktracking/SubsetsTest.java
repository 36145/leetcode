package test.bracktracking;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SubsetsTest {

    @Test
    public void TestSubset(){

        int[] nums = new int[]{1,2,3};

        List<List<Integer>> ans = subsets(nums);

        System.out.println(ans);
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        subsetHelper(nums,0, new ArrayList<>(),ans);



        return ans;
    }

    private void subsetHelper(int[] nums, int i, List<Integer> current, List<List<Integer>> ans) {

        if (i >= nums.length){
            ans.add(current);
            return ;
        }

        //don't add
        subsetHelper(nums,i+1,new ArrayList<>(current),ans);

        //add
        int val = nums[i];
        current.add(val);
        subsetHelper(nums,i+1,new ArrayList<>(current),ans);

    }
}
