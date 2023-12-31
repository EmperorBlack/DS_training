package graphbasics.waysToDestinationBFS;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class NumberOfWaysToDestinationDriver {

    public static void main(String[] args) {

        System.out.println(new Solution().countPaths(6,new int[][]{{0,1,1000000000},{0,3,1000000000},{1,3,1000000000},{1,2,1000000000},{1,5,1000000000},{3,4,1000000000},{4,5,1000000000},{2,5,1000000000}}));
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

class Pair{
    int node;
    long distance;

    public Pair(int node, long distance) {
        this.node = node;
        this.distance = distance;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {

        ArrayList<Edge>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < roads.length; i++) {
           graph[roads[i][0]].add(new Edge(roads[i][0],roads[i][1],roads[i][2]));
            graph[roads[i][1]].add(new Edge(roads[i][1],roads[i][0],roads[i][2]));
        }

        long[] dist = new long[n];
        long[] ways = new long[n];

        for (int i = 0; i < n; i++) {
            dist[i] = Long.MAX_VALUE;
        }
        ways[0] = 1;
        dist[0] =0;

        Queue<Pair> pq = new PriorityQueue<>((x,y)->Long.compare(x.distance,y.distance));
        pq.offer(new Pair(0,0));

        long mod = 1000000007;
        while(!pq.isEmpty()){
            Pair p = pq.poll();

            for (int i = 0; i < graph[p.node].size(); i++) {

                Edge e = graph[p.node].get(i);
                long newDistance = p.distance+e.weight;
                if(dist[e.j] > newDistance){
                    dist[e.j] = newDistance;
                    pq.offer(new Pair(e.j,newDistance));
                    ways[e.j] = ways[p.node];
                } else if (dist[e.j] == newDistance) {

                    ways[e.j] = (ways[e.j]+ways[p.node])%mod;

                }
            }
        }
        return (int)(ways[n-1]%mod);
    }
}
