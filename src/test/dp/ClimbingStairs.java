package test.dp;

import org.testng.annotations.Test;

public class ClimbingStairs {

    @Test
    public void TestClimbingStairs(){

        System.out.println(climbStairs(2));
    }
    public int climbStairs(int n) {

        int first = 1;
        int second = 1;

        for (int i = 0; i < n-1; i++){
            int temp = first;
            first = first+second;
            second = temp;
        }

        return first;
    }
}
