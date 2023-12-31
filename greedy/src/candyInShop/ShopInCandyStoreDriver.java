package candyInShop;

import java.util.ArrayList;
import java.util.Arrays;

public class ShopInCandyStoreDriver {
    public static void main(String[] args) {

        System.out.println(Solution.candyStore(new int[]{3,2,1,4},4,2));
    }
}

class Solution{
    static ArrayList<Integer> candyStore(int candies[], int N, int K){
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        Arrays.sort(candies);
        int i =0, j= N-1;
        int minCost = 0;
        while(i<=j){
            minCost = minCost+candies[i];
            i++;
            j = j-K;
        }

        int maxCost = 0;
        i=N-1;j=0;
        while (i>=j){
            maxCost= maxCost+candies[i];
            i--;
            j +=K;
        }
        result.add(minCost);
        result.add(maxCost);
        return result;
    }
}
