package LeetCode75.countBits;

public class CountBitsDriver {
    public static void main(String[] args) {

    }


}

class Solution {
//    if num is x the bit in x is x/2+1 if odd number else x/2
    public int[] countBits(int n) {

        int dp[] = new int[n+1];
        for (int i = 1; i <= n; i++) {

//            if(i%2 == 0){
//                dp[i] = dp[i/2];
//            }else{
//                dp[i] = dp[i/2]+1;
//            }
            dp[i] = dp[i>>1] + i&1;

        }
        return dp;

    }
}
