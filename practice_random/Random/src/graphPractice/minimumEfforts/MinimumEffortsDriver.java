package graphPractice.minimumEfforts;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumEffortsDriver {

    public static void main(String[] args) {

    }
}

class Efforts{
    int i;
    int j;
    int efforts;

    public Efforts(int i, int j, int efforts) {
        this.i = i;
        this.j = j;
        this.efforts = efforts;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {

        int delI[] = {0,1,0,-1};
        int delJ[] = {1,0,-1,0};
        int[][] distance = new int[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            Arrays.fill(distance[i],Integer.MAX_VALUE);
        }

        distance[0][0] = 0;
        Queue<Efforts> queue = new PriorityQueue<>((x,y)-> x.efforts-y.efforts);
        queue.offer(new Efforts(0,0,0));

        while (!queue.isEmpty()){
            Efforts effort = queue.poll();
            if(effort.i == heights.length-1 && effort.j == heights[0].length-1){
                return effort.efforts;
            }

            for (int i = 0; i < 4; i++) {
                int row = effort.i+delI[i];
                int col = effort.j+delJ[i];

                if((row >=0 && row < heights.length) && (col >=0 && col < heights[0].length)){

                    int newEfforts = Math.max(Math.abs(heights[row][col] - heights[effort.i][effort.j]),effort.efforts);
                    if(newEfforts < distance[row][col]){
                        queue.offer(new Efforts(row,col,newEfforts));
                        distance[row][col]= newEfforts;
                    }
                }

            }

        }

        return 0;



    }
}
