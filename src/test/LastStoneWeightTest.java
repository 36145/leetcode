package test;

import java.util.*;

public class LastStoneWeightTest {

    public int lastStoneWeight(int[] stones) {

        int ans = 0;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i: stones) {
            maxHeap.add(i);
        }

        while (maxHeap.size() > 1) {
            Integer first = maxHeap.poll();
            Integer second = maxHeap.poll();

            int diff = Math.abs( first -second);
            if (diff > 0)
                maxHeap.add(diff);
        }

        if (maxHeap.size()> 0)
            ans = maxHeap.peek();

        return ans;

    }
}
