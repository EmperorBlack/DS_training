package graphbasics.BFS;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

class Edge{
    int src;
    int dst;

    public Edge(int src, int dst) {
        this.src = src;
        this.dst = dst;
    }
}



public class BFSDriver {

    public static void main(String[] args) {

        ArrayList<Edge>[] graph = createGraph();
//          ArrayList<Edge>[] graph = createUndirectedCyclicGraph();
//        bfs(graph,0);
//        myBfs(graph,0);

        boolean[] visited = new boolean[graph.length];
        dfs2(graph,0,visited);
//        dfsStack(graph,0,visited);
//        visited[0] = true;
//        allPath(graph,0,5,visited,"");
//        allPath2(graph,0,5,visited,"0");

//
//        boolean[] visited = new boolean[graph.length];
//        boolean[] rec = new boolean[graph.length];
//        System.out.println(isCycleExist(graph,0,visited,rec));

//        doTopologicalSort();

//        System.out.println(detectCycleUndirected(graph,0,-1,visited));
//        topologicalSortBFS(createDAGGraph());

//        System.out.println(detectCycleKahnAlgo(createCycleGraph()));
//        System.out.println(detectCycleUndirectedBFS(createUndirectedCyclicGraph()));
    }

    public static void bfs(ArrayList<Edge>[] graph,int start){
        Queue<Integer> q = new ArrayDeque<>();
        int V = graph.length;
        boolean[] visited = new boolean[V];
        q.offer(start);

        while (!q.isEmpty()){

            int curr = q.poll();
            if(!visited[curr]){
                System.out.println(curr);
                visited[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    q.offer(graph[curr].get(i).dst);
                }
            }
        }
    }

    public static void myBfs(ArrayList<Edge>[] graph, int start) {
        Queue<Integer> q = new ArrayDeque<>();
        int V = graph.length;
        boolean[] visited = new boolean[V];
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {

            int curr = q.poll();
            System.out.println(curr);
            for (int i = 0; i < graph[curr].size(); i++) {
                int neigh = graph[curr].get(i).dst;
                if (!visited[neigh]) {
                    q.offer(neigh);
                    visited[neigh] = true;
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr,boolean visited[]) {

        if(!visited[curr]){
            System.out.println(curr);
            visited[curr] = true;
            for (int i = 0; i < graph[curr].size(); i++) {

               dfs(graph,graph[curr].get(i).dst,visited);

            }
        }
    }

    public static void dfs2(ArrayList<Edge>[] graph, int curr, boolean visited[]) {


        System.out.println(curr);
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {

            if (visited[graph[curr].get(i).dst] == false)
                dfs(graph, graph[curr].get(i).dst, visited);

        }
    }


    public static void dfsStack(ArrayList<Edge>[] graph, int start,boolean visited[]) {

        Stack<Integer> s = new Stack<>();
        s.push(start);
        while (!s.isEmpty()){
            int curr = s.pop();
            if(!visited[curr]){
                System.out.println(curr);
                visited[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    s.push(graph[curr].get(i).dst);
                }
            }
        }
    }

    public static void allPath(ArrayList<Edge>[] graph, int curr, int dst,boolean visited[], String path){
        path = path+curr+"_";
        if(curr == dst){
            System.out.println(path);
            return;
        }

        for (int i = 0; i < graph[curr].size(); i++) {
            int neigh = graph[curr].get(i).dst;
            if (!visited[neigh]){
                visited[neigh] = true;
                allPath(graph,neigh,dst,visited,path);
                visited[neigh] = false;
            }

        }
    }

    public static void allPath2(ArrayList<Edge>[] graph, int curr, int dst,boolean visited[], String path){
        if(curr == dst){
            System.out.println(path);
            return;
        }

        for (int i = 0; i < graph[curr].size(); i++) {
            int neigh = graph[curr].get(i).dst;
            if (!visited[neigh]){
                visited[curr] = true;
                allPath2(graph,neigh,dst,visited,path+neigh);
                visited[curr] = false;
            }

        }
    }

    public static boolean isCycleExist(ArrayList<Edge>[] graph,int curr,boolean[] visited,boolean rec[]){
        visited[curr] = true;
        rec[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {

            Edge e = graph[curr].get(i);

            if (rec[e.dst]){
                return true;
            }
            if(!visited[e.dst]){
                if(isCycleExist(graph, e.dst, visited, rec))
                    return true;
            }
        }
        rec[curr] = false;
        return false;
    }

    public static boolean detectCycleKahnAlgo(ArrayList<Edge>[] graph){
        Queue<Integer> queue = new ArrayDeque<>();
        int[] inDegrees = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                inDegrees[e.dst]++;
            }
        }

        for (int i = 0; i < inDegrees.length; i++) {
            if(inDegrees[i] == 0){
                queue.offer(i);
            }
        }

        int count =0;
        while (!queue.isEmpty()){

            int e = queue.poll();
            count++;
            for (int i = 0; i < graph[e].size(); i++) {
                Edge edg = graph[e].get(i);
                inDegrees[edg.dst]--;
                if(inDegrees[edg.dst] == 0){
                    queue.offer(edg.dst);
                }
            }
        }

        if(count != graph.length){
            return true;
        }
        return false;

    }

    public static void doTopologicalSort(){

        ArrayList<Edge>[] graph = createDAGGraph();
        Stack<Integer> stack = new Stack<>();
        boolean []visited = new boolean[graph.length];

        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]){
                topologicalSort(graph,i,visited,stack);
            }
        }

      while (!stack.isEmpty()){
          System.out.println(stack.pop());
      }

    }
    public static void topologicalSort(ArrayList<Edge>[] graph,int curr,boolean[] visited,Stack<Integer> sortedElement){

        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!visited[e.dst]){
                topologicalSort(graph, e.dst, visited, sortedElement);
            }
        }
        sortedElement.push(curr);
    }

    public static void topologicalSortBFS(ArrayList<Edge>[] graph){

        Queue<Integer> queue = new ArrayDeque<>();
        int[] inDegrees = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                inDegrees[e.dst]++;
            }
        }

        for (int i = 0; i < inDegrees.length; i++) {
            if(inDegrees[i] == 0){
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()){

            int e = queue.poll();
            System.out.println(e);
            for (int i = 0; i < graph[e].size(); i++) {
                Edge edg = graph[e].get(i);
                inDegrees[edg.dst]--;
                if(inDegrees[edg.dst] == 0){
                    queue.offer(edg.dst);
                }
            }
        }



    }


    public static boolean detectCycleUndirected(ArrayList<Edge>[] graph,int curr,int parent,boolean[] visited){
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if( visited[e.dst] && parent!=e.dst){
                return true;
            }
            else if(!visited[e.dst]){
                if(detectCycleUndirected(graph, e.dst,curr, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    static class ParentInfo{
        int node;
        int parentNode;

        public ParentInfo(int node, int parentNode) {
            this.node = node;
            this.parentNode = parentNode;
        }
    }

    public static boolean detectCycleUndirectedBFS(ArrayList<Edge>[] graph){
        Queue<ParentInfo> queue = new ArrayDeque<>();
         boolean visited[] = new boolean[graph.length];
         queue.offer(new ParentInfo(0,-1));

         while(!queue.isEmpty()){

             ParentInfo info = queue.poll();
             visited[info.node] = true;
             for (int i = 0; i < graph[info.node].size(); i++) {
                 Edge e = graph[info.node].get(i);
                 if(info.parentNode != e.dst){

                     if(visited[e.dst]){
                         return true;
                     }else{
                         queue.offer(new ParentInfo(e.dst,info.node));
                     }
                 }
             }

         }
         return false;

    }

    public static ArrayList<Edge>[] createGraph(){
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,5));
        graph[3].add(new Edge(3,4));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,5));
        graph[4].add(new Edge(4,3));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));
        return graph;
    }

    public static ArrayList<Edge>[] createCycleGraph(){
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,4));
        graph[2].add(new Edge(2,3));


        graph[3].add(new Edge(3,0));

        return graph;
    }

    public static ArrayList<Edge>[] createDAGGraph(){
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }


        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,1));
        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));
        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));

        return graph;
    }

    public static ArrayList<Edge>[] createUndirectedCyclicGraph(){
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }


        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,4));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));
//        graph[1].add(new Edge(1,4));


        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,2));

        graph[4].add(new Edge(4,0));
//        graph[4].add(new Edge(4,1));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,4));
        return graph;
    }
}
