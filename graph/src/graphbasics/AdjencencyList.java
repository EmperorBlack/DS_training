package graphbasics;

import java.util.ArrayList;
import java.util.Arrays;

class Edge{
    int src;
    int dst;

    public Edge(int src, int dst) {
        this.src = src;
        this.dst = dst;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "src=" + src +
                ", dst=" + dst +
                '}';
    }
}

public class AdjencencyList {

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {

            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,2));
        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,3));
        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,2));






        System.out.println(Arrays.toString(graph));


    }
}
