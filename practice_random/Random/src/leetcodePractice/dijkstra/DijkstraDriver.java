package leetcodePractice.dijkstra;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class DijkstraDriver {
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

class DistancePair{
    int node;
    int distance;

    public DistancePair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

class Solution{

    public int[] findShortestDistance(ArrayList<Edge>[] graph, int src){

        boolean visited[] = new boolean[graph.length];
        int distance[] = new int[graph.length];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[src] = 0;
        Queue<DistancePair> queue = new PriorityQueue<>((x,y)-> Integer.compare(x.distance,y.distance));
        queue.offer(new DistancePair(src,0));

        while(!queue.isEmpty()){
            DistancePair pair = queue.poll();

            if(!visited[pair.node]){
                visited[pair.node] =true;

                for (int i = 0; i < graph[pair.node].size(); i++) {

                    Edge e = graph[pair.node].get(i);
                    distance[e.dst] = pair.distance + e.weight < distance[e.dst] ? pair.distance + e.weight : distance[e.dst];
                    queue.offer(new DistancePair(e.dst,distance[e.dst]));
                }

            }

        }
        return distance;
    }

    public static void bellManford(ArrayList<Edge>[] graph,int src, int V){

        int []distance = new int[V];
        for (int i = 0; i < V; i++) {

            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < V-1; i++) {
            for (int j = 0; j < graph.length; j++) {

                for (int k = 0; k < graph[j].size(); k++) {

                    Edge e = graph[j].get(k);
                    if(distance[e.src] != Integer.MAX_VALUE && distance[e.src] + e.weight < distance[e.dst]){
                        distance[e.dst] = distance[e.src] + e.weight;
                    }


                }

            }
        }

    }
}
