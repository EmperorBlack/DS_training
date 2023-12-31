package graphbasics.connectingGraph;

import java.util.ArrayList;

public class ConnectingGraphDriver {
    public static void main(String[] args) {
        System.out.println(new Solution().makeConnected(6,new int[][]{{0,1},{0,2},{0,3},{1,2}}));
    }
}

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

        if(node == parent.get(node)){
            return node;
        }
        int ulParent = findParent(parent.get(node));
        parent.set(node,ulParent);
        return ulParent;
    }

    public boolean unionByRank(int u ,int v){

        int parentU = findParent(u);
        int parentV = findParent(v);
        int rankU = rank.get(parentU);
        int rankV = rank.get(parentV);

        if(parentU != parentV){
            if(rankU > rankV){
                parent.set(parentV,parentU);

            } else if (rankU < rankV) {
                parent.set(parentU,parentV);
            }else{
                parent.set(parentV,parentU);
                rank.set(parentU,rankU+1);
            }
            return true;
        }else{
            return false;
        }

    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {

        DisjointSet dsu = new DisjointSet(n);
        int numberOfDuplicate = 0;
        for (int i = 0; i < connections.length; i++) {
            if(!dsu.unionByRank(connections[i][0],connections[i][1])){
                numberOfDuplicate++;
            }
        }
        int numberOfConnectedComponent = 0;
        for (int i = 0; i < n; i++) {

            if(i == dsu.parent.get(i)){
                numberOfConnectedComponent++;
            }
        }
        if(numberOfDuplicate>=(numberOfConnectedComponent-1)){
            return numberOfConnectedComponent-1;
        }else {
            return -1;
        }

    }
}
