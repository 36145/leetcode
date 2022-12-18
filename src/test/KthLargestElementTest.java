package test;

import org.testng.annotations.Test;

import java.util.PriorityQueue;

public class KthLargestElementTest {

    @Test
    public void TestKth(){

        KthLargest obj = new KthLargest(3, new int[]{4, 5, 8, 2});

    }

    public static class KthLargest {

        private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        private int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int i : nums) {
                minHeap.add(i);
            }

            while (minHeap.size() > k){
                minHeap.poll();
            }
        }

        public int add(int val) {

           minHeap.add(val);
            if (minHeap.size()> k){
                minHeap.poll();
            }


            return minHeap.peek();
        }
    }
}
