package test;

import org.testng.annotations.Test;
import org.testng.internal.collections.Pair;

import java.util.*;

public class KClosestTest {


    @Test
    public void TestKClosest() {

        int[][] points = new int[][]{{0, 1}, {1, 0}};
        int k = 2;

        System.out.println(Arrays.deepToString(kClosest(points, k)));
    }

    public static class Points implements Comparable<Points> {

        private int distance;

        public int getDistance() {
            return distance;
        }

        public int[] getPoint() {
            return point;
        }

        private int[] point;


        public Points(int distance, int[] point) {
            this.distance = distance;
            this.point = point;
        }


        @Override
        public int compareTo(Points o) {
            return Integer.compare(this.distance,o.distance);
        }
    }

    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Points> maxHeap = new PriorityQueue<>();

        for (int[] point : points) {
            int distance = (point[0] * point[0]) + (point[1] * point[1]);
            maxHeap.add(new Points(distance, point));
        }


        int[][] ans = new int[k][];
        for (int i = 0; i < k; i++) {
            ans[i] = maxHeap.poll().getPoint();
        }


        return ans;
    }
}
