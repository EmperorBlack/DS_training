package leetcodePractice.chepestFlight;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ChepestFlighDriver {
    public static void main(String[] args) {

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
class Tuple{
    int node;
    int dist;
    int stop;

    public Tuple(int node, int dist, int stop) {
        this.node = node;
        this.dist = dist;
        this.stop = stop;
    }
}

class Solution{
//    src, dst, weight
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {

            int[] flight = flights[i];
            graph[flight[0]].add(new Edge(flight[0],flight[1],flight[2]));
        }


        int distance[] = new int[n];
        for (int i = 0; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        Queue<Tuple> queue = new ArrayDeque<>();
        distance[src] =0;
        queue.offer(new Tuple(src,0,0));

        while (!queue.isEmpty()){

            Tuple tuple = queue.poll();
            if(tuple.node == dst || tuple.stop > k){
                continue;
            }
            for (int i = 0; i < graph[tuple.node].size(); i++) {

                Edge edge = graph[tuple.node].get(i);
                if(distance[edge.dst] > tuple.dist + edge.weight ){
                    distance[edge.dst] = tuple.dist + edge.weight;
                    queue.offer(new Tuple(edge.dst,tuple.dist + edge.weight,tuple.stop+1));
                }
            }

        }

        if(distance[dst] == Integer.MAX_VALUE){
            return -1;
        }
        return distance[dst];

    }


}