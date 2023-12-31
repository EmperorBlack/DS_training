package graphbasics.tarjanAlgo;

import java.util.ArrayList;

class Edge{
    int src;
    int dst;

    public Edge(int src, int dst) {
        this.src = src;
        this.dst = dst;
    }
}


public class FindBridgeDriver {
    public static void main(String[] args) {

        new Solutions().getBridge(createUndirectedCyclicGraph());
    }

    public static ArrayList<Edge>[] createUndirectedCyclicGraph(){
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }


        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));


        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));


        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));

        return graph;
    }
}

class Solutions{


    static int time =0;
    public void getBridge(ArrayList<Edge>[] graph){


        int dt[] = new int[graph.length];
        int low[] = new int[graph.length];
        boolean visited[] = new boolean[graph.length];
        tarjanDFS(graph,0,-1,dt,low,visited);

    }

    public void tarjanDFS(ArrayList<Edge>[] graph,int curr,int parent,int dt[],int[] low,boolean visited[]){

        visited[curr] = true;
        dt[curr] = low[curr] = ++time;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(e.dst == parent)
                continue;

            if(!visited[e.dst]){
                tarjanDFS(graph,e.dst,curr,dt,low,visited);
                low[curr] = Math.min(low[curr],low[e.dst]);
                if(dt[curr] < low[e.dst]){
                    System.out.println(String.format("bridge %s ---> %s",curr,e.dst));
                }
            }else{
                low[curr] = Math.min(low[curr],dt[e.dst]);
            }


        }


    }

}
