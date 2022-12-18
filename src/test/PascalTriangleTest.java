package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class PascalTriangleTest {

    @Test
    public void TestPascalTriangle(){


        String ans = GetEncryptedNum(new ArrayList<>(Arrays.asList(4, 5, 6, 7)));

        String expected = "93";

        Assert.assertEquals(ans,expected);
    }

    public String GetEncryptedNum(ArrayList<Integer> nums) {

        Deque<Integer> deq = new LinkedList<>(nums);

        while(deq.size() > 2){
            Integer first = deq.removeFirst();
            Integer second = deq.removeFirst();
            deq.add((first+second)%10);
        }


        return deq.removeFirst().toString()+deq.removeFirst().toString();
    }
}
