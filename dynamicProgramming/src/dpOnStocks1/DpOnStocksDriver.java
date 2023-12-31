package dpOnStocks1;

import java.util.ArrayList;

public class DpOnStocksDriver {
    public static void main(String[] args) {

    }
}

class Solution{
    public static int maximumProfit(ArrayList<Integer> prices){
       int min = prices.get(0);
       int maxProfit = 0;
        for (int i = 1; i < prices.size(); i++) {

            int cost = prices.get(i)- min;
            maxProfit = Math.max(maxProfit,cost);
            min = Math.min(min,prices.get(i));
        }
        return maxProfit;
    }
}
