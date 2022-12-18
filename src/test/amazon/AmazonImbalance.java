package test.amazon;

import org.testng.annotations.Test;

import java.util.*;

public class AmazonImbalance {


    @Test
    public void TestImbalance(){
        int[] nums = new int[]{3,1,2};
        List<Integer> n = new ArrayList<>();
        for (int i : nums){
            n.add(i);
        }
        System.out.println(findTotalImbalance(n));
    }
    public static long findTotalImbalance(List<Integer> rank) {
        // Write your code here

        int ans = 0;

        Collections.sort(rank);

        List<List<Integer>> groups = new ArrayList<>();
        dfs(0,rank,new ArrayList<>(), groups);

        for (List<Integer> current: groups) {

            if (current.size() < 2){
                continue;
            }

            for (int i = 0; i < current.size()-1; i++){
                int diff = current.get(i+1) - current.get(i);
                if (diff > 1){
                    ans += diff -1;
                }
            }
        }

        return ans;

    }

    public static void dfs(int i, List<Integer> rank, List<Integer> current, List<List<Integer>> lists) {

        if (i >= rank.size()){
            lists.add(new ArrayList<>(current));
            return;
        }

        current.add(rank.get(i));
        dfs(i+1, rank, current, lists);
        current.remove(rank.get(i));
        dfs(i+1, rank,current,lists);

    }
}
