package LeetCode75.successfulPair;

import java.util.ArrayList;
import java.util.Arrays;

public class SuccessfulPairDriver {


}

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        Arrays.sort(potions);
        int n = potions.length;

        int[] result = new int[n];
        int i =0;
        for (int spell : spells
             ) {
            int index = getIndex(potions,0,potions.length-1,success,spell);
            result[i++] = n-index;
        }

        return result;

    }

    public int getIndex(int[] potions,int start, int end, long num,int mul){


        if(potions[start]*mul >= num){
            return 0;
        }

        while (start <= end){

            int mid = start+(end-start)/2;
            long prod = (long)mul * potions[mid];
            if(prod >= num){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return start;

    }
}
