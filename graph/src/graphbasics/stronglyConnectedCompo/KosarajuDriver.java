package graphbasics.stronglyConnectedCompo;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


class Edge{
    int src;
    int dst;

    public Edge(int src, int dst) {
        this.src = src;
        this.dst = dst;
    }
}
public class KosarajuDriver {

    public static void main(String[] args) {
        findStronglyConnectedComponent(createSCCGraph());
    }


    public static void findStronglyConnectedComponent(ArrayList<Edge>[] graph){
        boolean[] visited = new boolean[graph.length];
        Stack<Integer> topoSort = new Stack<>();
        topologicalSort(graph,0,visited,topoSort);

        ArrayList<Edge>[] reverseGraph = new ArrayList[graph.length];
        for (int i = 0; i < reverseGraph.length; i++) {
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                reverseGraph[e.dst].add(new Edge(e.dst,e.src));
            }
        }

        List<ArrayList<Integer>> result = new ArrayList<>();
        visited = new boolean[graph.length];
        while (!topoSort.isEmpty()){
            int src = topoSort.pop();
            if(!visited[src]){
                ArrayList<Integer> scc = new ArrayList<>();
                traverseComponent(reverseGraph,src,visited,scc);
                result.add(scc);
            }
        }

        System.out.println(result);

    }

    public  static void traverseComponent(ArrayList<Edge>[] graph, int curr, boolean[] visited, ArrayList<Integer> scc){

        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!visited[e.dst]){
                traverseComponent( graph,  e.dst, visited, scc);
            }
        }
        scc.add(curr);
    }

    public static void topologicalSort(ArrayList<Edge>[] graph, int curr, boolean[] visited, Stack<Integer> sortedElement) {

        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dst]) {
                topologicalSort(graph, e.dst, visited, sortedElement);
            }
        }
        sortedElement.push(curr);
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
