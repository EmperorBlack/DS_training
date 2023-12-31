package graphbasics.removeMaxEdgesByPrims;


import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

class Pair{
    int node;
    int weight;

    public Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

class Edge{
    int src;
    int dst;
    int weight;

    public Edge(int weight,int src, int dst) {
        this.src = src;
        this.dst = dst;
        this.weight = weight;
    }
}

public class DriverMaxEdges {
    public static void main(String[] args) {

//        System.out.println(new Solution().maxNumEdgesToRemove(4,new int[][]{{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}}));
//        System.out.println(new Solution().maxNumEdgesToRemove(4,new int[][]{{3,1,2},{3,2,3},{1,1,4},{2,1,4}}));
        System.out.println(new Solution().maxNumEdgesToRemove(4,new int[][]{{3,1,2}, {3,3,4}, {1,1,3},{2,2,4}}));
    }
}

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {


        ArrayList<ArrayList<Edge>> aliceEdges = new ArrayList<>();
        ArrayList<ArrayList<Edge>> bobEdges = new ArrayList<>();


        for (int i = 0; i <= n; i++) {
            aliceEdges.add(new ArrayList<>());
            bobEdges.add(new ArrayList<>());
        }


        for (int i = 0; i < edges.length; i++) {
            int weight = edges[i][0];
            int src = edges[i][1];
            int dst = edges[i][2];
            if(weight == 3){

                    ArrayList<Edge> aliceList =  aliceEdges.get(src);
                    aliceList.add(new Edge(weight,src,dst));

                    ArrayList<Edge> bobList =  bobEdges.get(src);
                bobList.add(new Edge(weight,src,dst));

            } else if (weight == 2) {
                ArrayList<Edge> bobList =  bobEdges.get(src);
                bobList.add(new Edge(weight,src,dst));
            }else {
                ArrayList<Edge> aliceList =  aliceEdges.get(src);
                aliceList.add(new Edge(weight,src,dst));
            }

        }

        int count = 0;
        int visitCount =0;
        boolean []visited = new boolean[aliceEdges.size()+1];
        Queue<Pair> queue = new PriorityQueue<>((x, y)-> y.weight-x.weight);

        queue.offer(new Pair(1,4));
        while (!queue.isEmpty()){
            Pair p = queue.poll();
            if(!visited[p.node]) {
                visited[p.node] = true;
                visitCount++;
                for (int i = 0; i < aliceEdges.get(p.node).size(); i++) {
                    Edge e  = aliceEdges.get(p.node).get(i);
                    if (!visited[e.dst]) {
                        queue.offer(new Pair(e.dst, e.weight));
                    }
                }
            }else{
                count++;
            }
        }
        if (visitCount != aliceEdges.size()-1){
            return -1;
        }
        visitCount =0;
        visited = new boolean[bobEdges.size()+1];
        queue.clear();
        queue.offer(new Pair(1,4));
        while (!queue.isEmpty()){
            Pair p = queue.poll();
            if(!visited[p.node]) {
                visited[p.node] = true;
                visitCount++;
                for (int i = 0; i < bobEdges.get(p.node).size(); i++) {
                    Edge e  = bobEdges.get(p.node).get(i);
                    if (!visited[e.dst]) {
                        queue.offer(new Pair(e.dst, e.weight));
                    }
                }
            }else{
                count++;
            }
        }
        if (visitCount != bobEdges.size()-1){
            return -1;
        }

    return count;
    }
}
