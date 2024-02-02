package graphPractice;


import java.util.*;

class Info{
    int node;
    int parent;

    public Info(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}

public class BFSPractice {
    public static void main(String[] args) {

//        new Solution().BFS1(buildEdges(),0);

//        boolean []visited = new boolean[4];
//        new Solution().dfs(buildEdges(),0,visited);

        boolean []visited = new boolean[7];
//        new Solution().printAllPath(buildEdges2(),0,5,visited,0+"");
        new Solution().bfsForTopoSort(buildEdges2());

    }


    public static ArrayList<Edge>[]  buildEdges(){
        ArrayList<Edge> list[] = new ArrayList[4];
        for (int i = 0; i < 4; i++) {
            list[i] = new ArrayList<>();
        }

        list[0].add(new Edge(0,2));
        list[1].add(new Edge(1,2));
        list[1].add(new Edge(1,3));
        list[2].add(new Edge(2,0));
        list[2].add(new Edge(2,1));
        list[2].add(new Edge(2,3));
        list[3].add(new Edge(3,1));
        list[3].add(new Edge(3,2));

        return list;
    }

    public static ArrayList<Edge>[]  buildEdges2(){
        ArrayList<Edge> list[] = new ArrayList[7];
        for (int i = 0; i < 7; i++) {
            list[i] = new ArrayList<>();
        }

        list[0].add(new Edge(0,1));
        list[0].add(new Edge(0,2));
        list[1].add(new Edge(1,3));
        list[2].add(new Edge(2,4));
        list[3].add(new Edge(3,5));
        list[4].add(new Edge(4,3));
        list[4].add(new Edge(4,5));
        list[5].add(new Edge(5,6));

        return list;
    }
}

class Solution{

    public void BFS1(ArrayList<Edge>[] edges, int src){

        boolean []visited = new boolean[edges.length];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(src);

        while(!queue.isEmpty()){

            int curr = queue.poll();
            if(!visited[curr]){
                visited[curr] = true;
                System.out.println(curr);
                ArrayList<Edge> adj = edges[curr];
                for (int i = 0; i < adj.size(); i++) {
                    Edge newNode = adj.get(i);
                    if(!visited[newNode.dst]){
                        queue.offer(newNode.dst);
                    }
                }
            }
        }
    }

    public void dfs(ArrayList<Edge>[] graph,int curr, boolean[] visited){

        visited[curr] = true;
        System.out.println(curr);
        for(int i =0; i< graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dst]){
                dfs(graph,e.dst,visited);
            }
        }
    }

    public void printAllPath(ArrayList<Edge>[] graph,int curr,int dst, boolean[] visited,String path){
        if(curr == dst){
            System.out.println(path);
            return;
        }
        visited[curr] = true;
        for(int i =0; i< graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dst]){
                printAllPath(graph,e.dst,dst,visited,path+"-"+e.dst);
                visited[e.dst] = false;

            }
        }
    }

    public boolean isCycleExist(ArrayList<Edge>[] graph,int curr, boolean[] visited,boolean[] recur){

        visited[curr] = true;
        recur[curr] = true;
        System.out.println(curr);
        for(int i =0; i< graph[curr].size();i++){
            Edge e = graph[curr].get(i);

                if(recur[e.dst]){
                    return true;
                }
                if(!visited[e.dst] && isCycleExist(graph,e.dst,visited,recur)){
                    return true;
                }
        }
        recur[curr] = false;
        return false;
    }

    public void printTopoSort(ArrayList<Edge> []graph){

        boolean visited[] = new boolean[graph.length];
        Stack<Integer> sorted = new Stack<>();
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]){
                dfsForTopo(graph,i,sorted,visited);
            }
        }

        while (!sorted.isEmpty()){
            System.out.println(sorted.pop());
        }


    }

    public void dfsForTopo(ArrayList<Edge> []graph, int curr, Stack<Integer> sorted,boolean[] visited){

        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!visited[e.dst]){
                dfsForTopo(graph,e.dst,sorted,visited);
            }
        }
        sorted.push(curr);

    }

    public void bfsForTopoSort(ArrayList<Edge> []graph){

       int[] indegree = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            ArrayList<Edge> edges = graph[i];
            for (int j = 0; j < edges.size(); j++) {
                indegree[edges.get(j).dst]++;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if(indegree[i] ==0){
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()){
            int curr = queue.poll();
            System.out.println(curr);
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indegree[e.dst]--;
                if(indegree[e.dst] <= 0 ){
                    queue.offer(e.dst);
                }
            }
        }

    }

    public boolean detectCycleUndirectedBFS(ArrayList<Edge>[] graph){

        Queue<Info> queue  = new ArrayDeque<>();
        boolean visited[] = new boolean[graph.length];
        queue.offer(new Info(0,-1));

        while(!queue.isEmpty()){

            Info info = queue.poll();
            if(visited[info.node]){

                visited[info.node] = true;

                for (int i = 0; i < graph[info.node].size(); i++) {
                    Edge e = graph[info.node].get(i);
                    if(e.dst != info.parent){
                        if(visited[e.dst]){
                            return true;
                        }
                        queue.offer(new Info(e.dst,info.node));
                    }

                }
                return false;


            }
        }

        return false;
    }
}
