package dynamicProgramming.ninjaTrainning;

public class NinjaTrainningDriver {

    public static void main(String[] args) {
        System.out.println(Solution.ninjaTraining(3,new int[][]{{1 ,2 ,5},
                {3 ,1 ,1},
                {3 ,3 ,3}}));
    }
}

class Solution {
    public static int ninjaTraining(int n, int points[][]) {


        int dp[][] = new int[n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                dp[i][j] = -1;
            }

        }
        return findMax(n-1,3,points,dp);

    }


    public static int findMax(int day, int last, int[][] points,int dp[][]){

        if(day == 0 ){
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                if(i != last && max < points[0][i]){
                    max = points[0][i];
                }
            }
            return dp[day][last] = max;
        }

        if(dp[day][last] != -1){
            return dp[day][last];
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            if(i != last){

                int prv = findMax(day-1,i,points,dp)+points[day][i];

                max = Math.max(prv,max);
            }
        }

        return dp[day][last] = max;

    }

}