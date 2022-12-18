package test.arrays;

import org.testng.annotations.Test;

import java.util.*;

public class TopKFrequentElementsTest {

    @Test
    public void TestTopK(){

        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }

    /*
    Input: nums = [1,1,1,2,2,3], k = 2
    Output: [1,2]
     */

    public int[] topKFrequent(int[] nums, int k) {

        //N : Frequency
        // sortedFrequency : N

        HashMap<Integer,Integer> frequency = new HashMap<>();
        HashMap<Integer, List<Integer>> order = new HashMap<>();
        for (int n : nums ){

            Integer currentCount = frequency.getOrDefault(n,0);
            currentCount++;
            frequency.put(n,currentCount);
        }

        for (Map.Entry<Integer,Integer> e : frequency.entrySet()){
            List<Integer> pos =  order.getOrDefault(e.getValue(),new ArrayList<>());
            pos.add(e.getKey());
            order.put(e.getValue(),pos);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = nums.length; i >= 0; i--){

            List<Integer> l =  order.getOrDefault(i, new ArrayList<>());
            for (int n : l){
                if (ans.size() < k){
                    ans.add(n);
                }else {
                    break;
                }
            }
        }

       return ans.stream().mapToInt(i -> i).toArray();

    }
}
