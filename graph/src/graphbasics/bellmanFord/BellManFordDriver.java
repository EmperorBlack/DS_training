package graphbasics.bellmanFord;


import java.util.ArrayList;

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

public class BellManFordDriver {

    public static void main(String[] args) {

    }


    public static void bellManford(ArrayList<Edge>[] graph,int src, int V){

        int dist[] = new int[V];
        for (int i = 0; i < V; i++) {
            if(i!=src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < V-1; i++) {

            for (int j = 0; j < V; j++) {

                for (int k = 0; k < graph[j].size(); k++) {

                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dst;
                    if(dist[u] != Integer.MAX_VALUE && dist[u]+e.weight < dist[v]){
                        dist[v] = dist[u]+e.weight;
                    }

                }
            }


        }

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
