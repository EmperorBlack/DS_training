package distinctIsland;

import java.util.*;

class Pair{
    int i;
    int j;
    Pair(int i, int j){
        this.i = i;
        this.j = j;
    }

    @Override
    public boolean equals(Object obj) {
        return this.i == ((Pair)obj).i && this.j == ((Pair)obj).j;
    }

    @Override
    public int hashCode() {
        return (i+j)%4095;
    }

    @Override
    public String toString() {
        return String.format("i=%d,j=%d",i,j);
    }
}

public class DistinctIslandDriver {
    public static void main(String[] args) {

        Set<List<Integer>> set = new HashSet<>();
        List<Integer> ls1 = new ArrayList<>();
        List<Integer> ls2 = new ArrayList<>();
        ls1.add(1);
        ls1.add(2);ls1.add(3);

        ls2.add(1);
        ls2.add(2);ls2.add(3);
        set.add(ls1);
        set.add(ls2);

        System.out.println(set);
        System.out.println(ls1.equals(ls2));

        System.out.println(countDistinctIslands(new int[][]{{1 ,1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 1},
                {0, 0, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 1},
                {0, 0, 0, 1, 1, 1}}));

    }
    public static int countDistinctIslands(int[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Set<List<Pair>> result = new HashSet<>();

        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && !visited[i][j]){
                    visited[i][j] = true;
                    bfs(i,j,grid,visited,result);

                }

            }

        }
        return result.size();
    }

    public static void bfs(int i,int j,int[][] grid, boolean[][] visited,Set<List<Pair>> result){

        Queue<Pair> queue = new ArrayDeque<>();
        List<Pair> temp = new ArrayList<>();
        temp.add(new Pair(0,0));
        queue.offer(new Pair(i,j));

        while (!queue.isEmpty()){
            Pair pair = queue.poll();
            for (int k = -1; k <= 1; k++) {
                    if(((pair.i + k) >=0 && (pair.i+k) < grid.length)
                            && (grid[pair.i+k][pair.j] == 1) && !visited[pair.i+k][pair.j]){
                        visited[pair.i+k][pair.j] = true;
                        queue.offer(new Pair(pair.i+k,pair.j));
                        temp.add(new Pair((pair.i+k) - i,(pair.j)-j));
                    }
            }
            for (int z = -1; z <= 1; z++) {
                if(((pair.j + z) >=0 && (pair.j+z) < grid[0].length)

                        && (grid[pair.i][pair.j+z] == 1) && !visited[pair.i][pair.j+z]){
                    visited[pair.i][pair.j+z] = true;
                    queue.offer(new Pair(pair.i,pair.j+z));
                    temp.add(new Pair((pair.i) - i,(pair.j+z)-j));
                }
            }

        }
        result.add(temp);
    }
}
