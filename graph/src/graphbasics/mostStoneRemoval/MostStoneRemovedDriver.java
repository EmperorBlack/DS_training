package graphbasics.mostStoneRemoval;

import java.util.*;

public class MostStoneRemovedDriver {
}

class DisjointSet{
    ArrayList<Integer> size = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();

    public DisjointSet(int nodeNum) {
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
class Solution {
    public int removeStones(int[][] stones) {

        int maxRow =0;
        int maxCol =0;
        for (int i = 0; i < stones.length; i++) {
            maxRow = Math.max(maxRow,stones[i][0]);
            maxCol = Math.max(maxCol,stones[i][1]);
        }
        DisjointSet dsu = new DisjointSet(maxRow+maxCol+1);

        Set<Integer> stoneNode = new HashSet<>();
        for (int i = 0; i < stones.length; i++) {
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] +1 +maxRow;
            dsu.unionBySize(nodeRow,nodeCol);
            stoneNode.add(nodeRow);
            stoneNode.add(nodeCol);
        }

        int cnt = 0;

        for(Integer it : stoneNode){
            if(dsu.findParent(it) == it){
                cnt++;
            }
        }
        return stones.length-cnt;

    }
}

