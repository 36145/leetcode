package test;

import java.util.PriorityQueue;

public class KthLargestElementArrayTest {




    public int findKthLargest(int[] nums, int k) {

        int ans = 0;


        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i : nums) {
            minHeap.add(i);
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }


        if (minHeap.size() > 0){
            ans = minHeap.peek();
        }


        return ans;
    }

}


