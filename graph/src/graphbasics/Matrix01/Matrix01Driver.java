package graphbasics.Matrix01;

import java.util.ArrayDeque;
import java.util.Queue;

public class Matrix01Driver {
    public static void main(String[] args) {
new Solution().updateMatrix(new int[][]{{0},{0},{0},{0},{0}});
    }
}
class Config{
    int i;
    int j;
    int distance;

    public Config(int i, int j, int distance) {
        this.i = i;
        this.j = j;
        this.distance = distance;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {

        boolean[][] visited = new boolean[mat.length][mat[0].length];
        Queue<Config> queue = new ArrayDeque<>();
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,-1,0,1};

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if(mat[i][j] ==0){
                    queue.offer(new Config(i,j,0));
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()){
            Config c = queue.poll();
            mat[c.i][c.j] = c.distance;


            for (int i = 0; i < 4; i++) {
                int row = c.i+delRow[i];
                int col = c.j+delCol[i];

                if(row >=0 && col >=0 && row < mat.length && col < mat[0].length && !visited[row][col] && mat[row][col] ==1){
                    queue.offer(new Config(row,col,c.distance+1));
                    visited[row][col] = true;
                }
            }
        }

        for (int[] array: mat
             ) {
            for (int a:array
                 ) {
                System.out.print(a+" ");
            }
            System.out.println();
        }
        return mat;
    }
}
