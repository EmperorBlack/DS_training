package graphbasics.removeMaxEdgeByKrushkal;


import java.util.ArrayList;
import java.util.Arrays;

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

public class RemoveMaxEdgeDSU {

    public static void main(String[] args) {
//                System.out.println(new Solution().maxNumEdgesToRemove(4,new int[][]{{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}}));
//        System.out.println(new Solution().maxNumEdgesToRemove(4,new int[][]{{3,1,2},{3,2,3},{1,1,4},{2,1,4}}));
        System.out.println(new Solution().maxNumEdgesToRemove(13,new int[][]{{1,1,2},{2,1,3},{3,2,4},{3,2,5},{1,2,6},{3,6,7},{3,7,8},{3,6,9},{3,4,10},{2,3,11},{1,5,12},{3,3,13},{2,1,10},{2,6,11},{3,5,13},{1,9,12},{1,6,8},{3,6,13},{2,1,4},{1,1,13},{2,9,10},{2,1,6},{2,10,13},{2,2,9},{3,4,12},{2,4,7},{1,1,10},{1,3,7},{1,7,11},{3,3,12},{2,4,8},{3,8,9},{1,9,13},{2,4,10},{1,6,9},{3,10,13},{1,7,10},{1,1,11},{2,4,9},{3,5,11},{3,2,6},{2,1,5},{2,5,11},{2,1,7},{2,3,8},{2,8,9},{3,4,13},{3,3,8},{3,3,11},{2,9,11},{3,1,8},{2,1,8},{3,8,13},{2,10,11},{3,1,5},{1,10,11},{1,7,12},{2,3,5},{3,1,13},{2,4,11},{2,3,9},{2,6,9},{2,1,13},{3,1,12},{2,7,8},{2,5,6},{3,1,9},{1,5,10},{3,2,13},{2,3,6},{2,2,10},{3,4,11},{1,4,13},{3,5,10},{1,4,10},{1,1,8},{3,3,4},{2,4,6},{2,7,11},{2,7,10},{2,3,12},{3,7,11},{3,9,10},{2,11,13},{1,1,12},{2,10,12},{1,7,13},{1,4,11},{2,4,5},{1,3,10},{2,12,13},{3,3,10},{1,6,12},{3,6,10},{1,3,4},{2,7,9},{1,3,11},{2,2,8},{1,2,8},{1,11,13},{1,2,13},{2,2,6},{1,4,6},{1,6,11},{3,1,2},{1,1,3},{2,11,12},{3,2,11},{1,9,10},{2,6,12},{3,1,7},{1,4,9},{1,10,12},{2,6,13},{2,2,12},{2,1,11},{2,5,9},{1,3,8},{1,7,8},{1,2,12},{1,5,11},{2,7,12},{3,1,11},{3,9,12},{3,2,9},{3,10,11}}));
    }

}
class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {

        Arrays.sort(edges,(o1, o2) -> o2[0]-o1[0]);

        DisjointSet s1 = new DisjointSet(n);
        DisjointSet s2 = new DisjointSet(n);
        int count = 0;
        for (int i = 0; i < edges.length; i++) {
            int weight = edges[i][0];
            int src = edges[i][1];
            int dst = edges[i][2];

            boolean aliceEdge = false;
            if(weight == 3 || weight ==1){
                aliceEdge = s1.addBySize(src,dst);
            }
            boolean bobEdge = false;
            if((weight == 3 || weight ==2)){
                bobEdge= s2.addBySize(src,dst);
            }

            if(weight == 3 ){
                if(!aliceEdge || !bobEdge){
                    count++;
                }
            }
           if(weight == 2 && !bobEdge){
                count++;
            }
           if(weight == 1 && !aliceEdge){
                count++;
            }



        }

        if(s1.size.get(s1.findParent(1)) != n || s2.size.get(s2.findParent(1)) != n){
            return -1;
        }else {
            return count;
        }
    }
}


//    public int maxNumEdgesToRemove(int n, int[][] edges) {
//
//        Arrays.sort(edges,(o1, o2) -> o2[0]-o1[0]);
//
//        DisjointSet s1 = new DisjointSet(n);
//        DisjointSet s2 = new DisjointSet(n);
//        int count = 0;
//        int aliceVisit = 0;
//        int bobVisit = 0;
//        for (int i = 0; i < edges.length; i++) {
//            int weight = edges[i][0];
//            int src = edges[i][1];
//            int dst = edges[i][2];
//
//            boolean aliceEdge = false;
//            if(weight == 3 || weight ==1){
//                aliceEdge = s1.addBySize(src,dst);
//            }
//            boolean bobEdge = false;
//            if((weight == 3 || weight ==2)){
//                bobEdge= s2.addBySize(src,dst);
//            }
//
//            if(weight == 3 ){
//
//                if(aliceEdge && bobEdge){
//                    aliceVisit++;
//                    bobVisit++;
//                }else {
//                    count++;
//                }
//
//            }
//            if(weight == 2 && bobEdge){
//                bobVisit++;
//            }else if(weight == 2 && !bobEdge){
//                count++;
//            }
//            if(weight == 1 && aliceEdge){
//                aliceVisit++;
//            }else if(weight == 1 && !aliceEdge){
//                count++;
//            }
//
//
//
//        }
//
//        if(aliceVisit != n-1 || bobVisit!= n-1){
//            return -1;
//        }else {
//            return count;
//        }
//    }

