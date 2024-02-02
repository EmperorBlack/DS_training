package leetcodePractice.stronglyConnectedComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StronglyConnectedCompoDriver {

    public static void main(String[] args) {

        System.out.println(new Solution().getStronglyCC(createSCCGraph()));
    }

    public static ArrayList<Edge>[] createSCCGraph(){
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,4));

        return graph;
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
    public List<List<Integer>> getStronglyCC(ArrayList<Edge>[] graph){

        Stack<Integer> sortedOdr  = new Stack<>();
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]){
                dfsTopo(graph,i,sortedOdr,visited);
            }
        }

        ArrayList<Edge>[] rGraph = new ArrayList[graph.length];
        for (int i = 0; i < rGraph.length; i++) {
            rGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                rGraph[e.dst].add(new Edge(e.dst,e.src));
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        visited = new boolean[rGraph.length];

       while (!sortedOdr.isEmpty()){
           int src = sortedOdr.pop();
           if(!visited[src]){
               List<Integer> scc = new ArrayList();
               dfsTraverse(rGraph,src,scc,visited);
               result.add(scc);
           }
       }

        return result;

    }

    public void dfsTopo(ArrayList<Edge>[] graph, int curr, Stack<Integer> sorted, boolean[] visited){

        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {

            Edge e = graph[curr].get(i);
            if(!visited[e.dst]){
                dfsTopo(graph,e.dst,sorted,visited);
            }
        }
        sorted.push(curr);
    }

    public void dfsTraverse(ArrayList<Edge>[] graph, int curr, List<Integer> scc,boolean[] visited){

        visited[curr] = true;
        scc.add(curr);
        for (int i = 0; i < graph[curr].size(); i++) {

            Edge e = graph[curr].get(i);
            if(!visited[e.dst]){
                dfsTraverse(graph,e.dst,scc,visited);
            }

        }
    }


}

