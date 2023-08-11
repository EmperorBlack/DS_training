package IslandCount;

import java.util.*;

class Pair{
    int i;
    int j;
    Pair(int i, int j){
        this.i = i;
        this.j = j;
    }
}
public class CountIslandMain {
    public static void main(String[] args) {
        Set<List<Integer>> set = new HashSet<>();

//        set.add(Arrays.asList(0,1,2,3));
//        set.add(Arrays.asList(0,1,2,3));
//        List arrayList = new ArrayList<>();
//        System.out.println(set);
//        System.out.println(Arrays.asList(0,1,2,3).equals(Arrays.asList(0,1,2,3)));

        System.out.println(numIslands(new char[][]{{4,2},{0,1},{1,0},{1,1},{1,0}}));
    }

    public static int numIslands(char[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && !visited[i][j]){
                    count++;
                    visited[i][j] = true;
                    bfs(i,j,grid,visited);

                }

            }

        }
        return count;
    }

    public static void bfs(int i,int j,char[][] grid, boolean[][] visited){

        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(i,j));

        while (!queue.isEmpty()){
            Pair pair = queue.poll();
            for (int k = -1; k <= 1; k++) {
                for (int z = -1; z <= 1; z++) {

                    if(((pair.i + k) >=0 && (pair.i+k) < grid.length) && ((pair.j + z) >=0 && (pair.j+z) < grid[0].length)

                    && (grid[pair.i+k][pair.j+z] == 1) && !visited[pair.i+k][pair.j+z]){
                        visited[pair.i+k][pair.j+z] = true;
                        queue.offer(new Pair(pair.i+k,pair.j+z));
                    }

                }
            }
        }

    }
}
