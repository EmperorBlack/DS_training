package graphbasics.BinaryMaze;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryMazeDriver {

    public static void main(String[] args) {

        System.out.println(new Solution().shortestPath(new int[][]
                {{1,1,1,1,1},
                        {1,1,1,1,1},
                        {1,1,1,1,0},
                        {1,0,1,0,1}},new int[]{0,0},new int[]{3,4}));
    }
}
class  Pair{
    int i;
    int j;

    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,-1,0,1};

        int[][] distance = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(source[0],source[1]));
        distance[source[0]][source[1]] = 0;

        while (!queue.isEmpty()){
            Pair pair = queue.poll();
            if(pair.i == destination[0] && pair.j == destination[1]){
                return distance[pair.i][pair.j];
            }
            int cost = distance[pair.i][pair.j];
            for (int i = 0; i < 4; i++) {

                int row = pair.i+delRow[i];
                int col = pair.j+delCol[i];
                int newCost = cost+1;

                if(row >= 0&& col >=0 && row < grid.length && col<grid[0].length && grid[row][col] ==1 && newCost < distance[row][col] ){

                    distance[row][col]= newCost;
                    queue.offer(new Pair(row,col));

                }

            }
        }
        return -1;
    }
}
