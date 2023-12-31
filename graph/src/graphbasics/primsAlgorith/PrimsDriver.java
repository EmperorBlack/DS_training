package graphbasics.primsAlgorith;


import java.util.ArrayList;
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

class Pair{
    int node;
    int cost;

    public Pair(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}

public class PrimsDriver {
    public static void main(String[] args) {
        findMSTCost(createWeightedGraph());

    }

    public static void findMSTCost(ArrayList<Edge>[] graph){


        boolean []visited = new boolean[graph.length];
        Queue<Pair> queue = new PriorityQueue<>((x,y)->x.cost-y.cost);

        queue.offer(new Pair(0,0));
        int cost = 0;
        while (!queue.isEmpty()){
            Pair p = queue.poll();
            if(!visited[p.node]) {
                visited[p.node] = true;
                cost = cost + p.cost;
                for (int i = 0; i < graph[p.node].size(); i++) {
                    Edge e = graph[p.node].get(i);
                    if (!visited[e.dst]) {
                        queue.offer(new Pair(e.dst, e.weight));
                    }

                }
            }
        }

        System.out.println(cost);

    }
    public static ArrayList<Edge>[] createWeightedGraph(){
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,2,15));
        graph[0].add(new Edge(0,3,30));

        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,3,40));

        graph[2].add(new Edge(2,0,15));
        graph[2].add(new Edge(2,3,50));


        graph[3].add(new Edge(3,1,40));
        graph[3].add(new Edge(3,0,30));
        graph[3].add(new Edge(3,2,50));

        return graph;
    }
}
