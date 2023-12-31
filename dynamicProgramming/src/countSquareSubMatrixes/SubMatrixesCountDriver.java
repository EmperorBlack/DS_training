package countSquareSubMatrixes;

public class SubMatrixesCountDriver {

    public static void main(String[] args) {

    }
}

class Solution {
    public static int countSquares(int n, int m, int[][] arr) {

        int dp[][] = new int[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if(i==0 || j==0){
                    dp[i][j] = arr[i][j];
                }else{

                    if(arr[i][j] == 1){

                        int min =Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]);
                        dp[i][j] = min+1;

                    }

                }
                if(dp[i][j] != 0){
                    count = count+dp[i][j];
                }
            }

        }
        return count;
        // Write your code here.
    }
}
