package test.dp;

import org.testng.annotations.Test;

import java.util.HashMap;

public class MinCostClimbingStairsCopy {

    @Test
    public void TestMinCostClimbingStairs() {

        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    public static int minCostClimbingStairs(int[] cost) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return Math.min(calculateMinCost(cost, 0, memo), calculateMinCost(cost,1, memo));
    }

    public static int calculateMinCost(int[] cost, int index, HashMap<Integer, Integer> memo){
        if(memo.containsKey(index)) return memo.get(index);
        if(index >= cost.length) return 0;
        int oneClimbCost = cost[index] + calculateMinCost(cost, index+1, memo);
        int twoClimbCost = cost[index] + calculateMinCost(cost, index+2, memo);
        int result = Math.min(oneClimbCost, twoClimbCost);
        memo.put(index, result);
        return result;
    }
}
