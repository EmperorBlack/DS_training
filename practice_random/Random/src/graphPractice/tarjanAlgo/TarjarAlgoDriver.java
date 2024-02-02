package graphPractice.tarjanAlgo;

import java.util.ArrayList;

public class TarjarAlgoDriver {

    public static void main(String[] args) {

    }
}

class Edge{
    int src;
    int dst;

    public Edge(int src, int dst) {
        this.src = src;
        this.dst = dst;
    }
}

class Solution{

    static int time =0;

    public void findArticulationPoint(ArrayList<Edge>[] graph){

        boolean[] visited = new boolean[graph.length];
        int[] dt = new int[graph.length];
        int[] min = new int[graph.length];



    }

    public void findArticulationDFS(ArrayList<Edge>[] graph,int curr, int parent, int[] dt,int[] min,boolean[] visited){
        visited[curr] = true;
        dt[curr] = min[curr] = ++time;

        for (int i = 0; i < graph[curr].size(); i++) {

            Edge e = graph[curr].get(i);
            if(e.dst == parent){
                continue;
            }
            if(!visited[curr]){
                findArticulationDFS(graph,e.dst,curr,dt,min,visited);
                min[curr] = Math.min(min[curr],min[e.dst]);
                if(dt[curr] < min[e.dst]){
                    System.out.println("bridge in "+curr +" ---"+e.dst);
                }
            }else{
                min[curr] = Math.min(min[e.dst],min[curr]);
            }


        }

    }
}
