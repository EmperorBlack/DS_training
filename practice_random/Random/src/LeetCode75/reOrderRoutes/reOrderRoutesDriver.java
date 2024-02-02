package LeetCode75.reOrderRoutes;

import java.util.ArrayList;
import java.util.Arrays;

public class reOrderRoutesDriver {
    public static void main(String[] args) {

//        [[0,1],[1,3],[2,3],[4,0],[4,5]]

        System.out.println(new Solution().minReorder(6,new int[][]{{0,1},{1,3},{2,3},{4,0},{4,5}}));
    }
}

class Edge{
    int src;
    int dst;

    boolean isReal;

    public Edge(int src, int dst,boolean isReal) {
        this.src = src;
        this.dst = dst;
        this.isReal = isReal;
    }
}

class Solution {
    int count = 0;
    public int minReorder(int n, int[][] connections) {

        ArrayList<Edge> graph[] = new ArrayList[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < connections.length; i++) {
            int src = connections[i][0];
            int dst = connections[i][1];
            graph[src].add(new Edge(src,dst,true));
            graph[dst].add(new Edge(dst,src,false));
        }

        boolean visited[] = new boolean[n];
        dfs(graph,visited,0);
        return count;


    }

    public void dfs(ArrayList<Edge> graph[],boolean visited[], int curr){

        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
              if(!visited[e.dst]){
                  if(e.isReal){
                      count++;
                  }
                  dfs(graph,visited,e.dst);
              }
        }

    }
}
