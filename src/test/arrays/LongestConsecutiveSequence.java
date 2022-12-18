package test.arrays;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutiveSequence {

    @Test
    public void TestLongest() {
        int[] nums = new int[]{0,-1};
        System.out.println(longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        int ans = 0;

        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }


        HashMap<Integer, Integer> mem = new HashMap<>();

        for (int i : nums){
            ans = Math.max(ans,dfs(i,set,mem));
        }

        return ans;
    }

    public int dfs( int current,HashSet<Integer> set,  HashMap<Integer,Integer> mem) {
        if (mem.containsKey(current)){
            return mem.get(current);
        }

        if (!set.contains(current)){
            return 0;
        }

        int ans = 1 + dfs(current+1, set,mem);
        mem.put(current,ans);
        return ans;

    }
}
