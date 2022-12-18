package test.dp;

import org.testng.annotations.Test;

import java.util.HashMap;

public class MinCostClimbingStairs {

    @Test
    public void TestMinCostClimbingStairs() {

        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    public int minCostClimbingStairs(int[] cost) {

        HashMap<Integer,Integer> mem = new HashMap<>();
        return Math.min(dfs(0, cost,  mem), dfs(1, cost,  mem));
    }

    public int dfs(int i, int[] cost, HashMap<Integer, Integer> mem) {

        if (i >= cost.length) {
            return 0;
        }

        if (mem.containsKey(i)) {
            return mem.get(i);
        }

        int ans = Math.min(
                cost[i] +dfs(i + 1, cost,  mem),
                cost[i] + dfs(i + 2, cost,  mem));

        mem.put(i, ans);
        return ans;

    }


}
