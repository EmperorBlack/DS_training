package graphbasics.disjointSetUnion;

import java.util.ArrayList;

class DisjointSet{
    ArrayList<Integer> rank = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();

    public DisjointSet(int nodeNum) {
        for (int i = 0; i <= nodeNum ; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    public int findParent(int node){
        if(parent.get(node) ==node){
            return node;
        }
        int umParent = findParent(parent.get(node));
        parent.set(node,umParent);
        return umParent;
    }

    public void unionByRank(int u ,int v){
        int uPu = findParent(u);
        int uPv = findParent(v);
        int rankU = rank.get(uPu);
        int rankV = rank.get(uPv);
        if(uPu == uPv){
            return;
        }
        if(rankU < rankV){
            parent.set(uPu,uPv);
        } else if (rankU > rankV) {
            parent.set(uPv,uPu);
        }else{
            parent.set(uPv,uPu);
            rank.set(uPu,rankU+1);
        }
    }
}

class DisjointSet2{
    ArrayList<Integer> size = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();

    public DisjointSet2(int nodeNum) {
        for (int i = 0; i <= nodeNum ; i++) {
            size.add(1);
            parent.add(i);
        }
    }

    public int findParent(int node){
        if(parent.get(node) ==node){
            return node;
        }
        int umParent = findParent(parent.get(node));
        parent.set(node,umParent);
        return umParent;
    }

    public void unionBySize(int u ,int v){
        int uPu = findParent(u);
        int uPv = findParent(v);
        int sizeU = size.get(uPu);
        int sizeV = size.get(uPv);
        if(uPu == uPv){
            return;
        }
        if(sizeU < sizeV){
            parent.set(uPu,uPv);
            size.set(uPv,sizeU+sizeV);
        } else if (sizeU > sizeV) {
            parent.set(uPv,uPu);
            size.set(uPu,sizeU+sizeV);
        }else{
            parent.set(uPv,uPu);
            size.set(uPu,sizeU+sizeV);
        }
    }
}

public class DisjointSetDriver {

    public static void main(String[] args) {
        DisjointSet2 ds = new DisjointSet2(7);
        ds.unionBySize(1,2);
        ds.unionBySize(2,3);
        ds.unionBySize(4,5);
        ds.unionBySize(6,7);
        ds.unionBySize(5,6);

        if(ds.findParent(3) == ds.findParent(7)){
            System.out.println("same");

        }else {
            System.out.println("not same");
        }

        ds.unionBySize(3,7);
        if(ds.findParent(3) == ds.findParent(7)){
            System.out.println("same");

        }else {
            System.out.println("not same");
        }


    }
}
