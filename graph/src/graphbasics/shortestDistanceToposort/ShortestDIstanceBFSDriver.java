package graphbasics.shortestDistanceToposort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class ShortestDIstanceBFSDriver {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().shortestPath(10  ,24,new int[][]{{0,2,6},
                {0,3,7},
                {0,4,9},
                {0,6,8},
                {0,7,6},
                {1,2,6},
                {1,3,7},
                {1,5,10},
                {1,6,1},
                {1,7,4},
                {2,3,3},
                {2,6,10},
                {2,8,8},
                {2,9,10},
                {3,5,3},
                {3,6,10},
                {3,7,5},
                {5,6,9},
                {5,7,7},
                {6,7,7},
                {6,8,8},
                {6,9,8},
                {7,9,1},
                {8,9,6}})));
    }
}

class Edge{
    int src;
    int dst;
    int weight;

    public Edge(int src, int dst, int weight) {
        this.src = src;
        this.dst = dst;
        this.weight = weight;
    }
}

class Solution {

    public int[] shortestPath(int N,int M, int[][] edges) {

        ArrayList<Edge>[] graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] indegre = new int[N];
        int[] distance = new int[N];

        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dst = edges[i][1];
            int weight = edges[i][2];

            graph[src].add(new Edge(src,dst,weight));
            indegre[dst]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < indegre.length; i++) {
            if(indegre[i] ==0){
                queue.offer(i);
            }
        }

        Queue<Integer> topoQueue = new ArrayDeque<>();
        while (!queue.isEmpty()){
            int poll = queue.poll();
            topoQueue.offer(poll);

            for (int i = 0; i < graph[poll].size(); i++) {


                Edge e = graph[poll].get(i);
                indegre[e.dst]--;
                if(indegre[e.dst] ==0){
                    queue.offer(e.dst);
                }
            }

        }
        for (int k = 1; k < N; k++) {
            distance[k] = Integer.MAX_VALUE;
        }
        distance[0] =0;
        while (!topoQueue.isEmpty()){

            int node = topoQueue.poll();

            for (int i = 0; i < graph[node].size(); i++) {

                Edge e = graph[node].get(i);
                if(distance[node] != Integer.MAX_VALUE && distance[e.dst] > distance[node]+e.weight){
                    distance[e.dst] = distance[node]+e.weight;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (distance[i] == Integer.MAX_VALUE){
                distance[i] = -1;
            }
        }




        return  distance;
    }
}