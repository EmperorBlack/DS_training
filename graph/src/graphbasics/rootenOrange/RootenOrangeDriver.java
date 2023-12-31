package graphbasics.rootenOrange;

import java.util.ArrayDeque;
import java.util.Queue;

public class RootenOrangeDriver {


    public static void main(String[] args) {

        System.out.println(new Solution().orangesRotting(new int[][]{{1,2}}));
//        System.out.println(new Solution().orangesRotting(new int[][]{{2,1,1},{0,1,1},{1,0,1}}));
    }
}

class Pair {
    int i;int j;

    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {

        int freshOrange =0;
        Queue<Pair> rottenQueue = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if(grid[i][j] == 1){
                    freshOrange++;
                }
                if(grid[i][j] == 2){
                    rottenQueue.offer(new Pair(i,j));
                }
            }
        }

        if(freshOrange ==0){
            return 0;
        }
        int minute =0;
        while(!rottenQueue.isEmpty()){
            minute++;
            int length = rottenQueue.size();
            for (int i = 0; i < length; i++) {

                Pair pair = rottenQueue.poll();
                if(pair.i-1 >= 0 && grid[pair.i-1][pair.j] == 1){
                    rottenQueue.offer(new Pair(pair.i-1,pair.j));
                    grid[pair.i-1][pair.j] = 2;
                    freshOrange--;
                }
                if(pair.i+1 < grid.length && grid[pair.i+1][pair.j] == 1){
                    rottenQueue.offer(new Pair(pair.i+1,pair.j));
                    grid[pair.i+1][pair.j] = 2;
                    freshOrange--;
                }
                if(pair.j+1 < grid[0].length && grid[pair.i][pair.j+1] == 1){
                    rottenQueue.offer(new Pair(pair.i,pair.j+1));
                    grid[pair.i][pair.j+1] = 2;
                    freshOrange--;
                }
                if(pair.j-1 >= 0 && grid[pair.i][pair.j-1] == 1){
                    rottenQueue.offer(new Pair(pair.i,pair.j-1));
                    grid[pair.i][pair.j-1] = 2;
                    freshOrange--;
                }
            }
            if(freshOrange <= 0){
                return minute;
            }

        }
        return -1;
    }
}
