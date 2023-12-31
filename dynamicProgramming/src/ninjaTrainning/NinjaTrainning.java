package ninjaTrainning;

import java.awt.*;
import java.util.Arrays;

public class NinjaTrainning {

    public static void main(String[] args) {

    }
}

//class Solution {
//    public static int ninjaTraining(int n, int points[][]) {
//
//        int dp[][] = new int[n][3];
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < 3; j++) {
//                dp[i][j] = -1;
//            }
//
//        }
//
//       return findMax(points,n-1,3,dp);
//    }
//
//    public static int findMax(int points[][],int  index,int last,int[][] dp){
//
//        if(index == 0){
//
//
//            int max = Integer.MIN_VALUE;
//            for (int i = 0; i < 3; i++) {
//                if(i!= last){
//                    if(max < points[index][i]){
//                        max = points[index][i];
//                    }
//                }
//            }
//            return max;
//        }
//
//
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < 3; i++) {
//
//            if(i != last){
//                int subMax = 0;
//                if(dp[index][i] != -1){
//                    subMax = dp[index][i];
//                }else {
//                    subMax = findMax(points,index-1,i,dp)+points[index][i];
//                    dp[index][i] = subMax;
//                }
//                if(max < subMax){
//                    max = subMax;
//                }
//            }
//
//        }
//
//        return max;
//    }
//
//
//}

class Solution {
    public static int ninjaTraining(int n, int points[][]) {



        int dp[][] = new int[n][4];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                dp[i][j] = -1;
            }

        }

        return findMax(points,n-1,3,dp);
    }

    public static int findMax(int points[][],int  index,int last,int[][] dp){

        if(dp[index][last] != -1){
            return dp[index][last];
        }

        if(index == 0){
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                if(i!= last){
                    if(max < points[index][i]){
                        max = points[index][i];
                    }
                }
            }
            return dp[index][last] = max;
        }


        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {

            if(i != last){

                    int subMax = findMax(points,index-1,i,dp)+points[index][i];

                if(max < subMax){
                    max = subMax;
                }
            }

        }

        return dp[index][last] = max;
    }

    public static int findMaxTab  (int points[][],int  n) {


        int dp[][] = new int[n][4];
        dp[0][0] = Math.max(points[0][1],points[0][2]);
        dp[0][1] = Math.max(points[0][0],points[0][2]);
        dp[0][2] = Math.max(points[0][0],points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0; // Initialize the maximum points for the current day and last activity
                // Consider each possible task for the current day
                for (int task = 0; task <= 2; task++) {
                    if (task != last) { // Ensure that the current task is different from the last
                        // Calculate the points for the current activity and add it to the maximum points from the previous day
                        int activity = points[day][task] + dp[day - 1][task];
                        // Update the maximum points for the current day and last activity
                        dp[day][last] = Math.max(dp[day][last], activity);
                    }
                }
            }
        }
        return dp[n-1][3];

    }


}
