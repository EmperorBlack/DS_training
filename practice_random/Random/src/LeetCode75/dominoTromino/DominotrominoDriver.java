package LeetCode75.dominoTromino;

public class DominotrominoDriver {
    public static void main(String[] args) {

    }
}

class Solution {
    public int numTilings(int n) {

        int m = (10^9)+7;

        if(n==1 || n==2){
            return n;
        }

        int dp[] = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;

        for (int i = 4; i <= n; i++) {

            dp[i] = ((2* dp[i-1]) + dp[i-3])%m;
        }
        return dp[n];

    }
}
