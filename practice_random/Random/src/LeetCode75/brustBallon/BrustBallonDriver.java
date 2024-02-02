package LeetCode75.brustBallon;

import java.util.Arrays;

public class BrustBallonDriver {
    public static void main(String[] args) {

        System.out.println(new Solution().findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}));

    }
}
class Solution {
    public int findMinArrowShots(int[][] points) {
        int arrows = points.length;

        Arrays.sort(points,(a,b)-> Integer.compare(a[0],b[0]));
        int count =0;
        int last = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if(points[i][0] < last){
                count++;
                last = Integer.min(points[i][1],last);
            }else{
                last = points[i][1];
            }
        }
        return arrows-count;
    }
}