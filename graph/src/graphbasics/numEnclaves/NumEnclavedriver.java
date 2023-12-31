package graphbasics.numEnclaves;

public class NumEnclavedriver {
    public static void main(String[] args) {

    }
}

class Solution {
    public int numEnclaves(int[][] grid) {

        boolean visited[][] = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            if(grid[i][0] == 1 && !visited[i][0]){
                dfs(grid,visited,i,0);
            }

            if(grid[i][grid[0].length-1] == 1 && !visited[i][grid[0].length-1]){
                dfs(grid,visited,i,grid[0].length-1);
            }
        }

        for (int i = 0; i < grid[0].length; i++) {
            if(grid[0][i] == 1 && !visited[0][i]){
                dfs(grid,visited,0,i);
            }

            if(grid[grid.length-1][i] == 1 && !visited[grid.length-1][i]){
                dfs(grid,visited,grid.length-1,i);
            }
        }

        int count =0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if(!visited[i][j] && grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;

    }

    public void dfs(int[][] grid, boolean[][] visited, int i, int j){

        if(i >=0 && i < grid.length && j >=0 && j< grid[0].length && !visited[i][j] && grid[i][j] == 1){

            visited[i][j] = true;
            dfs(grid, visited,i+1,j);
            dfs(grid, visited,i-1,j);
            dfs(grid, visited,i,j+1);
            dfs(grid, visited,i,j-1);
        }

    }
}
