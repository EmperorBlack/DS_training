package LeetCode75.equalRowCol;

import java.util.HashMap;
import java.util.Map;

public class EqualRowColDriver {
    public static void main(String[] args) {

        System.out.println(new Solution().equalPairs(new int[][]{{3,2,1},{1,7,6},{2,7,7}}));
    }
}

class Solution {
    public int equalPairs(int[][] grid) {
        Map<String,Integer> row = new HashMap<>();
        Map<String,Integer> col = new HashMap<>();

        for (int i = 0; i < grid.length; i++) {

            StringBuilder rowString = new StringBuilder();
            StringBuilder colString = new StringBuilder();
            for (int j = 0; j < grid[0].length; j++) {
                rowString.append(grid[i][j]+"-");
                colString.append(grid[j][i]+"-");
            }
            row.put(rowString.toString(), row.getOrDefault(rowString.toString(),0)+1);
            col.put(colString.toString(), col.getOrDefault(colString.toString(),0)+1);
        }

        int count =0;
        for (Map.Entry<String,Integer> r: row.entrySet()
             ) {

            if(col.containsKey(r.getKey())){
                count += r.getValue() * col.get(r.getKey());
            }

        }
        return count;

    }
}
