package test.dp;

import org.testng.annotations.Test;

import java.util.HashMap;

public class HouseRobberTest {


    @Test
    public void RobHouseTest(){

        int[] nums = new int[]{2,7,9,3,1};
        System.out.println(rob(nums));
    }

    public int rob(int[] nums) {
        HashMap<Integer,Integer> mem = new HashMap<>();
        return Math.max(dfs(0, nums, mem), dfs(1,nums,mem));
    }


    public int dfs(int i , int[] nums, HashMap<Integer,Integer> mem) {

        if (mem.containsKey(i)){
            return mem.get(i);
        }

        if (i >= nums.length){
            return 0;
        }

        int first = nums[i] + dfs(i+2,nums,mem);
        int second = nums[i] + dfs(i+3, nums,mem);

        int ans = Math.max(first,second);
        mem.put(i,ans);
        return ans;
    }
}
