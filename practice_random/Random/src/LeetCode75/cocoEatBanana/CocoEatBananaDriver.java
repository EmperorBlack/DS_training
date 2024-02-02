package LeetCode75.cocoEatBanana;

public class CocoEatBananaDriver {


    public static void main(String[] args) {

        System.out.println(new Solution().minEatingSpeed(new int[]{3,6,7,11},8));

    }
}

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = 1000000000;

        while(start<=end){

            int mid = start+ (end-start)/2;
            long hours = takeHours(piles,mid);
            if (hours <= h) {
                end=mid-1;
            }else{
                start = mid+1;
            }

        }

        return start;
    }

    public long takeHours(int []piles, int h){

        long result = 0;
        for (int pile: piles
             ) {

            result = result + pile/h;

            if(pile%h !=0){
                result++;
            }
        }
        return result;
    }
}