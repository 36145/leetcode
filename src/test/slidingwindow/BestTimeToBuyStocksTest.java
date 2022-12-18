package test.slidingwindow;

import org.testng.annotations.Test;

public class BestTimeToBuyStocksTest {

    @Test
    public void TestBuyStock() {

        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));

        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }

    public int maxProfit(int[] prices) {

        int ans = 0;

        int buy =0;
        int sell = 0;


        while (sell < prices.length){

            if (prices[buy] > prices[sell]){
                buy = sell;
            }

            ans = Math.max(ans, prices[sell] - prices[buy]);
            sell++;

        }

        return ans;
    }
}
