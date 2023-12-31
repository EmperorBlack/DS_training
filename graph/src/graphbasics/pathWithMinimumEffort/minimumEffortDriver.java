package graphbasics.pathWithMinimumEffort;


import java.util.PriorityQueue;
import java.util.Queue;

public class minimumEffortDriver {
    public static void main(String[] args) {



    }
}

class Config{
    int i;
    int j;
    int efforts;

    public Config(int i, int j, int efforts) {
        this.i = i;
        this.j = j;
        this.efforts = efforts;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,-1,0,1};
        int[][] efforts = new int[heights.length][heights[0].length];

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                efforts[i][j] = Integer.MAX_VALUE;
            }
        }

        Queue<Config> pq = new PriorityQueue<>((x,y)->x.efforts- y.efforts);
        pq.offer(new Config(0,0,0));

        while (!pq.isEmpty()){
            Config config = pq.poll();
            int effort = config.efforts;
            if(config.i == heights.length-1 && config.j == heights[0].length-1){
                return effort;
            }
            for (int i = 0; i < 4; i++) {

                int row = config.i+delRow[i];
                int col = config.j+delCol[i];
                if(row >= 0&& col >=0 && row < heights.length && col<heights[0].length ){

                    int newEffort = Math.max(Math.abs(heights[row][col]-heights[config.i][config.j]),effort);
                    if(newEffort < efforts[row][col]){
                        pq.offer(new Config(row,col,newEffort));
                        efforts[row][col] = newEffort;
                    }


                }

            }


        }
        return 0;
    }
}
