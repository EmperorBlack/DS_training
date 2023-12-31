package graphbasics.dijkstraAlgorithm;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

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

public class DijkstraAlgoDriver {

    public static void main(String[] args) {

//        findShrotestPath(createWeightedGraph());

        findShrotestPathVisitedArry(createWeightedGraph());
    }

    public static void findShrotestPath(ArrayList<Edge>[] graph){

//        for already visited you can take an extra array or you can check if in distance array have less value than yours distance value that means it's already visited

        int []distance = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {

            distance[i] = Integer.MAX_VALUE;
        }

        Queue<DistancePair> queue = new PriorityQueue<>((x,y)->x.distance-y.distance);
        queue.offer(new DistancePair(0,0));
        distance[0] = 0;

        while (!queue.isEmpty()){

            DistancePair pair = queue.poll();

            if(distance[pair.node] >= pair.distance){
                for (int i = 0; i < graph[pair.node].size(); i++) {

                    Edge e = graph[pair.node].get(i);
                    int newDistance = distance[e.dst] > pair.distance+e.weight ? pair.distance+e.weight : distance[e.dst];
                    distance[e.dst] = newDistance;
                    queue.offer(new DistancePair(e.dst,newDistance));

                }
            }

        }

        System.out.println(Arrays.toString(distance));


    }


    public static void findShrotestPathVisitedArry(ArrayList<Edge>[] graph){

//        for already visited you can take an extra array or you can check if in distance array have less value than yours distance value that means it's already visited

        int []distance = new int[graph.length];
        boolean []visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {

            distance[i] = Integer.MAX_VALUE;
        }

        Queue<DistancePair> queue = new PriorityQueue<>((x,y)->x.distance-y.distance);
        queue.offer(new DistancePair(0,0));
        distance[0] = 0;

        while (!queue.isEmpty()){

            DistancePair pair = queue.poll();
            if(!visited[pair.node]){
                visited[pair.node] = true;
                for (int i = 0; i < graph[pair.node].size(); i++) {

                    Edge e = graph[pair.node].get(i);
                    int newDistance = distance[e.dst] > pair.distance+e.weight ? pair.distance+e.weight : distance[e.dst];
                    distance[e.dst] = newDistance;
                    queue.offer(new DistancePair(e.dst,newDistance));

                }
            }

        }

        System.out.println(Arrays.toString(distance));


    }

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {

        int []distance = new int[V];
        boolean []visited = new boolean[V];
        for (int i = 0; i < V; i++) {

            distance[i] = Integer.MAX_VALUE;
        }

        Queue<DistancePair> queue = new PriorityQueue<>((x,y)->x.distance-y.distance);
        queue.offer(new DistancePair(S,0));
        distance[S] = 0;

        while (!queue.isEmpty()){

            DistancePair pair = queue.poll();
            if(!visited[pair.node]){
                visited[pair.node] = true;
                ArrayList<ArrayList<Integer>> adjList = adj.get(pair.node);
                for (int i = 0; i < adjList.size(); i++) {
                    ArrayList<Integer> edge = adjList.get(i);
                    int newDistance = distance[edge.get(0)] > pair.distance+edge.get(1) ? pair.distance+edge.get(1) : distance[edge.get(0)];
                    distance[edge.get(0)] = newDistance;
                    queue.offer(new DistancePair(edge.get(0),newDistance));

                }
            }

        }
        return distance;
    }


    public static ArrayList<Edge>[] createWeightedGraph(){
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,7));

        graph[2].add(new Edge(2,4,3));
        graph[3].add(new Edge(3,5,7));
        graph[4].add(new Edge(4,5,5));
        graph[4].add(new Edge(4,3,2));

        return graph;
    }
}
