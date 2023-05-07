import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class MergeIntervals {

    public static void main(String args[]) {

        int interval[][] = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int [][]resukt = merge(interval);
        for (int[] res:resukt
             ) {
            System.out.println(Arrays.toString(res));
        }

    }

    public static int[][] merge(int[][] intervals) {

//        sort intervals

        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0],o2[0]));

//        merging
        int mergingCount = 0;
        for (int i = 0; i < intervals.length - 1; i++) {

            if(intervals[i][1] < intervals[i+1][0])
            {
                continue;
            }else if (intervals[i][1] >= intervals[i+1][0]) {
                intervals[i + 1] = new int[]{intervals[i][0] , intervals[i][1] > intervals[i + 1][1] ? intervals[i][1] : intervals[i + 1][1]};
                intervals[i] = null;
                mergingCount++;
            }
        }

        int[][] result = new int[intervals.length - mergingCount][];
        int count = 0;
        for (int[] res : intervals
        ) {
            if (res != null) {
                result[count] = res;
                count++;
            }
        }
//

        return result;

    }
}
