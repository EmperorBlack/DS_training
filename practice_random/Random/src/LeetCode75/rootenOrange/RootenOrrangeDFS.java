package LeetCode75.rootenOrange;

public class RootenOrrangeDFS {
    public static void main(String[] args) {

    }
}

class Solution {
    public int orangesRotting(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==2){
                    dfs(grid,i,j,2);
                }
            }
        }
        int minute = 2;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                    return -1;
                }
                if(grid[i][j]>minute){
                    minute = grid[i][j];
                }
            }
        }
        return minute-2;



    }

    public void dfs(int[][] grid,int row, int col,int minute){

        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] ==0 ||
                (grid[row][col] > 1 && grid[row][col]<minute) ){
            return;
        }
        grid[row][col] = minute;
        dfs(grid, row+1, col, minute+1);
        dfs(grid, row-1, col, minute+1);
        dfs(grid, row, col+1, minute+1);
        dfs(grid, row, col-1, minute+1);

    }
}