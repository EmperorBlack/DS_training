package graphPractice.DSU;

import java.util.ArrayList;
import java.util.List;

public class DSUDriver {
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionByRank(1,2);
        ds.unionByRank(2,3);
        ds.unionByRank(4,5);
        ds.unionByRank(6,7);
        ds.unionByRank(5,6);

        if(ds.findParent(3) == ds.findParent(7)){
            System.out.println("same");

        }else {
            System.out.println("not same");
        }

        ds.unionByRank(3,7);
        if(ds.findParent(3) == ds.findParent(7)){
            System.out.println("same");

        }else {
            System.out.println("not same");
        }
    }
}

class DisjointSet{

    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    DisjointSet(int node){

        for (int i = 0; i <= node; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    public int findParent(int node){
        if(parent.get(node) == node){
            return node;
        }
        int up = findParent(parent.get(node));
        parent.set(node,up);
        return up;
    }

    public void  unionByRank(int u, int v){
        int up = findParent(u);
        int vp = findParent(v);
        int rup = rank.get(up);
        int rvp = rank.get(vp);
        if(up == vp){
            return;
        }

        if(rup > rvp ){
            parent.set(vp,up);
        } else if (rup < rvp) {
            parent.set(up,vp);
        }else{
            parent.set(vp,up);
            rank.set(up,rup+1);
        }
    }
}
