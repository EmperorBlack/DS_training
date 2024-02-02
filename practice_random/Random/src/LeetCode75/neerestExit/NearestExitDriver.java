package LeetCode75.neerestExit;

import java.util.ArrayDeque;
import java.util.Queue;

public class NearestExitDriver {
    public static void main(String[] args) {

    }
}

class Pair{
    int i;
    int j;

    int step;

    public Pair(int i, int j,int step) {
        this.i = i;
        this.j = j;
        this.step = step;
    }
}

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {

        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(entrance[0],entrance[1],0));
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int delRow[] = {1,0,-1,0};
        int delCol[] = {0,1,0,-1};
        visited[entrance[0]][entrance[1]] = true;
        while (!queue.isEmpty()){

            Pair p = queue.poll();
            if(p.step > 0 && (p.i == 0 || p.j ==0 || p.i == maze.length-1 || p.j== maze[0].length-1)){
                return p.step;
            }
            for (int i = 0; i < 4; i++) {
                int row = p.i+delRow[i];
                int col = p.j+delCol[i];

                if(row >= 0 && col >=0 && row < maze.length && col <maze[0].length && maze[row][col] == '.' && !visited[row][col]){
                    queue.offer(new Pair(row,col,p.step+1));
                    visited[row][col] = true;
                }

            }


        }
        return -1;

    }
}

class Solution1 {
    public int nearestExit(char[][] maze, int[] entrance) {

        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(entrance[0],entrance[1],0));
        maze[entrance[0]][entrance[1]] = '+';
        int delRow[] = {1,0,-1,0};
        int delCol[] = {0,1,0,-1};

        while (!queue.isEmpty()){

            Pair p = queue.poll();
            if(p.step > 0 && (p.i == 0 || p.j ==0 || p.i == maze.length-1 || p.j== maze[0].length-1)){
                return p.step;
            }
            for (int i = 0; i < 4; i++) {
                int row = p.i+delRow[i];
                int col = p.j+delCol[i];

                if(row >= 0 && col >=0 && row < maze.length && col <maze[0].length && maze[row][col] == '.'){
                    queue.offer(new Pair(row,col,p.step+1));
                    maze[row][col]= '+';
                }

            }


        }
        return -1;

    }
}
