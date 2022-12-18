package test.amazon;

import org.testng.annotations.Test;

import java.util.*;

public class TestAmazon {

    @Test
    public void TestPerfectSet() {
        List<Integer> l = new ArrayList<>();
        l.add(3);
        l.add(9);
        l.add(4);
        l.add(2);
        l.add(16);

        System.out.println(maxSetSize(l));
    }

    public static int maxSetSize(List<Integer> riceBags) {
        // Write your code here
        int ans = -1;
//        Collections.sort(riceBags);

        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < riceBags.size(); i++){

            int current =  riceBags.get(i);
            map.put(current, i);
        }

        HashSet<Integer> newSet  = new HashSet<>();
        for (int current : riceBags) {
            if (map.containsKey(current * current)) {
                newSet.add(current);
            }
        }

        for (Integer num : newSet) {
            int currentMax = 0;
            int current = num;
            while (map.containsKey(current)){
                currentMax++;
                ans = Math.max(currentMax, ans);
                current *= current;
            }
        }

        return ans;
    }


}
