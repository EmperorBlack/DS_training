package graphbasics.findCheapestPrice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class FindCheapestFLightDriver {

    public static void main(String[] args) {


        new Solution().findCheapestPrice(4,new int[][]{{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}},0,3,1);
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
    int stops;
    int node;
    int cost;

    public Tuple(int stops, int node, int cost) {
        this.stops = stops;
        this.node = node;
        this.cost = cost;
    }
}

class Solution {
    static int minCost = Integer.MAX_VALUE;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {

            int[] flight = flights[i];
            graph[flight[0]].add(new Edge(flight[0],flight[1],flight[2]));
        }

        boolean []visited = new boolean[n];
        visited[src] = true;

        findCheapRoute(graph,src,dst,k,0,0,visited);
        System.out.println(minCost);

        if(minCost == Integer.MAX_VALUE){
            return -1;
        }
        return minCost;
    }

    public void findCheapRoute( ArrayList<Edge>[] graph,int curr, int dst, int k,int stops,int routeCost,boolean[] visited){

        if(curr == dst){
            if(routeCost < minCost){
                minCost = routeCost;
            }
            return;
        }

        if(stops > k){
            return;
        }


        for (int i = 0; i < graph[curr].size(); i++) {

            Edge e = graph[curr].get(i);
            if(!visited[e.dst]){
                visited[curr] = true;
                findCheapRoute(graph,e.dst,dst,k,stops+1,routeCost+e.weight,visited);
                visited[e.dst] = false;
            }

        }


    }

    public int findCheapestPriceStriver(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {

            int[] flight = flights[i];
            graph[flight[0]].add(new Edge(flight[0],flight[1],flight[2]));
        }


        Queue<Tuple> queue = new ArrayDeque<>();

        queue.offer(new Tuple(0,src,0));
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

      while (!queue.isEmpty()){
          Tuple it = queue.poll();
          if(it.stops > k || it.node == dst){
              continue;
          }
          for (int i = 0; i <graph[it.node].size() ; i++) {
              Edge e = graph[it.node].get(i);

              if(it.cost+e.weight < dist[e.dst] ){
                  dist[e.dst] = it.cost+e.weight;
                  queue.add(new Tuple(it.stops+1,e.dst,it.cost+e.weight));
              }

          }


      }

      if(dist[dst] == Integer.MAX_VALUE){
          return -1;
      }
      return dist[dst];
    }
}
