package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class GetMinimumCostTest {

    @Test
    public void TestGetMinCost(){

        ArrayList<Integer> parcels = new ArrayList<>(Arrays.asList(2,3,6,10,11));
        int k = 9;

        long expected = 17;
        long ans = GetMinimumCost(k,parcels);

        Assert.assertEquals(ans,expected);

    }

    public long GetMinimumCost(int k,ArrayList<Integer> parcels){
        long ans = 0;

        int capacity = k - parcels.size();

        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        for (Integer i: parcels) {
            hashMap.put(i,true);
        }

        int added = 0;
        for (int i =1;;i++){
            if( added >= capacity ){
                break;
            }

            if (!hashMap.containsKey(i)){
                ans += i;
                added++;
            }


        }

        return ans;
    }

    /*

    def getMinimumCost (parcels, k) :
# Write your code here
rem = k - Len (parcels)
parcels.sort()
ans, cur = 0, 1
i =0
while ; < len (parcels) and rem:
if cur==parcels[I]:
i+=1
else :
ans += cur
rem -=1
cur+=1

while rem>o:
ans += cur
cur+=1
rem-=1
return ans
     */
}
