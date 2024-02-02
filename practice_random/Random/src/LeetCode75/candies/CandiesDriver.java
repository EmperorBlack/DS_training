package LeetCode75.candies;

import java.util.ArrayList;
import java.util.List;

public class CandiesDriver {
    public static void main(String[] args) {

        System.out.println(new Solution().kidsWithCandies(new int[]{2,3,5,1,3},3));
    }
}

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int i : candies){
            if(i > max){
                max = i;
            }
        }

        for(int i =0;i<candies.length;i++){

            if(candies[i]+ extraCandies >= max){
                result.add(true);
            }else{
                result.add(false);
            }
        }

        return result;

    }
}