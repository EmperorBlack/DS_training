package fractionalKnapSack;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class Pair{
    double unitPrice;
    int weight;


    public Pair(double unitPrice, int weight) {
        this.unitPrice = unitPrice;
        this.weight = weight;
    }
}
public class FractionalKnapSackDriver {
    public static void main(String[] args) {

        Item [] items = new Item[]{new Item(60,10),new Item(100,20),new Item(120,30)};

        System.out.println(new Solution().fractionalKnapsack(50,items,3));

    }
}



class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n)
    {

        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair((double)(arr[i].value)/arr[i].weight,arr[i].weight);
        }

        Arrays.sort(pairs,((o1, o2) -> Double.compare(o2.unitPrice, o1.unitPrice)));

        double prices = 0d;

        for (int i = 0; i < n && W>0; i++) {
            Pair pair = pairs[i];
            int weightToTake = Math.min(W,pair.weight);
            W = W-weightToTake;
            prices += weightToTake* pair.unitPrice;

        }
        return prices;
    }
}
