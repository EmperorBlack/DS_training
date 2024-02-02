package LeetCode75.nonOverLapping;

import java.util.Arrays;

public class NonOverLappingDriver {
    public static void main(String[] args) {
//        System.out.println(new Solution().eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}}));
        System.out.println(new Solution().eraseOverlapIntervals(new int[][]{{1,100},{11,22},{1,11},{2,12}}));
    }
}
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));


        int count =0;
        int last = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < last){
                count++;
                last = Integer.min(intervals[i][1],last);
            }else{
                last = intervals[i][1];
            }
        }
        return count;

    }
}