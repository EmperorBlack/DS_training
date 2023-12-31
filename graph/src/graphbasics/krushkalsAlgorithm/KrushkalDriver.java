package graphbasics.krushkalsAlgorithm;

import java.util.ArrayList;
import java.util.Collections;

public class KrushkalDriver {

    public static void main(String[] args) {

        findMSTCost(createWeightedGraph());
    }

    public static void findMSTCost(ArrayList<Edge>[] graph){

        ArrayList<Edge> list = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                list.add(graph[i].get(j));
            }
        }

        Collections.sort(list,(o1, o2) -> o1.weight- o2.weight);
        DisjointSet d = new DisjointSet(graph.length);
        int cost =0;
        for (Edge e:list
             ) {
            if(d.addBySize(e.src,e.dst)){
                cost= cost+e.weight;
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

class DisjointSet{
    ArrayList<Integer> size = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {

            size.add(1);
            parent.add(i);
        }
    }

    public int findParent(int node){
        if(parent.get(node) == node){
            return node;
        }

        int ulP = findParent(parent.get(node));
        parent.set(node,ulP);
        return ulP;
    }
    public boolean addBySize(int u, int v){
        int ulPu = findParent(u);
        int ulPv = findParent(v);
        int sizeU = size.get(ulPu);
        int sizeV = size.get(ulPv);
        if(ulPu == ulPv){
            return false;
        }
        if(sizeU > sizeV){
            parent.set(ulPv,ulPu);
            size.set(ulPu,sizeU+sizeV);
        }else {
            parent.set(ulPu,ulPv);
            size.set(ulPv,sizeU+sizeV);
        }
        return true;
    }
}
