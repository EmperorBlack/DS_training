package numberOfWaysToDestination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfWaysToDestDriver {

    public static void main(String[] args) {



        Solution.countPaths(2,Arrays.asList(Arrays.asList(1,0,10)) );
//        time limit exceeds
    }
}

class Edge {
    int i,j,weight;

    public Edge(int i, int j, int weight) {
        this.i = i;
        this.j = j;
        this.weight = weight;
    }
}

class Solution {
    static int minDistance = Integer.MAX_VALUE;
    static int noOfWays = 0;

    static int countPaths(int n, List<List<Integer>> roads) {
        noOfWays = 0;
        minDistance = Integer.MAX_VALUE;

        ArrayList<Edge>[] graph = new ArrayList[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {

            graph[i] = new ArrayList<>();
        }

//        for (int i = 0; i < roads.length; i++) {
//           graph[roads[i][0]].add(new Edge(roads[i][0],roads[i][1],roads[i][2]));
//            graph[roads[i][1]].add(new Edge(roads[i][1],roads[i][0],roads[i][2]));
//        }

        for (int i = 0; i < roads.size(); i++) {
            graph[roads.get(i).get(0)].add(new Edge(roads.get(i).get(0),roads.get(i).get(1),roads.get(i).get(2)));
            graph[roads.get(i).get(1)].add(new Edge(roads.get(i).get(1),roads.get(i).get(0),roads.get(i).get(2)));
        }

        dfs(graph,visited,0,0,n-1);
        return noOfWays;

    }

    static void dfs(ArrayList<Edge>[] graph,boolean[] visited,int curr,int distance,int end){

        visited[curr] = true;
        if(distance > minDistance){
            return;
        }
        if(curr == end){
            if(distance < minDistance){
                minDistance = distance;
                noOfWays = 1;
            } else if (distance == minDistance) {
                noOfWays++;
            }
            return;
        }

        for (int i = 0; i < graph[curr].size(); i++) {

            Edge e = graph[curr].get(i);
            int newDistance = distance+e.weight;
            if(!visited[e.j] && newDistance <= minDistance){
                dfs(graph,visited,e.j,newDistance,end);
                visited[e.j] = false;
            }
        }

    }
}
