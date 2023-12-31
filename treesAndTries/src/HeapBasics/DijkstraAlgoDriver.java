package HeapBasics;

import java.util.*;

class Pair{
    int node;
    int distance;
    Pair(int distance, int node){
        this.distance = distance;
        this.node = node;
    }
}

public class DijkstraAlgoDriver {

    public static void main(String[] args) {

        SortedSet<Integer> set = new TreeSet<>();
        set.add(3);
        set.add(4);
        int V = 3, E=3,S=2;
        ArrayList<Integer> node1 = new ArrayList<Integer>() {{add(1);add(1);}};
        ArrayList<Integer> node2 = new ArrayList<Integer>() {{add(2);add(6);}};
        ArrayList<Integer> node3 = new ArrayList<Integer>() {{add(2);add(3);}};
        ArrayList<Integer> node4 = new ArrayList<Integer>() {{add(0);add(1);}};
        ArrayList<Integer> node5 = new ArrayList<Integer>() {{add(1);add(3);}};
        ArrayList<Integer> node6 = new ArrayList<Integer>() {{add(0);add(6);}};

        ArrayList<ArrayList<Integer>> inter1 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node1);
                add(node2);
            }
        };
        ArrayList<ArrayList<Integer>> inter2 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node3);
                add(node4);
            }
        };
        ArrayList<ArrayList<Integer>> inter3 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node5);
                add(node6);
            }
        };
        ArrayList<ArrayList<ArrayList<Integer>>> adj= new ArrayList<ArrayList<ArrayList<Integer>>>(){
            {
                add(inter1); // for 1st node
                add(inter2); // for 2nd node
                add(inter3); // for 3rd node
            }
        };
        //add final values of adj here.

        int[] res= dijkstra(V,adj,S);
        System.out.println(Arrays.toString(res));
    }

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S){

        int res[] = new int[V];
        for (int i = 0; i < V; i++) {
            res[i] = Integer.MAX_VALUE;
        }

        res[S] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.distance - y.distance);
        pq.offer(new Pair(0,S));

        while (!pq.isEmpty()){
            Pair pair = pq.poll();
            int dis = pair.distance;
            int node = pair.node;

            for (int i = 0; i < adj.get(node).size(); i++) {

                int adjNode = adj.get(node).get(i).get(0);
                int adjDistance = adj.get(node).get(i).get(1);

                if(dis+adjDistance < res[adjNode]){
                    res[adjNode] = dis+adjDistance;
                    pq.offer(new Pair(res[adjNode],adjNode));
                }

            }
        }


        return res;
    }
}
