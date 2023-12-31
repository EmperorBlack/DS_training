package graphbasics.numberOfIsland2;

import java.util.ArrayList;
import java.util.List;

public class IslandOnlineQueries {
    public static void main(String[] args) {
        System.out.println(new Solution().numOfIslands(4,5,new int[][]{{1,1},{0,1},{3,3},{3,4}}));
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
class Solution {

    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {

        int n = rows*cols;
        DisjointSet dsu = new DisjointSet(n);
        List<Integer> result = new ArrayList<>();
        boolean[][] vis = new boolean[rows][cols];
        int delRow[] = {1,0,-1,0};
        int delCol[] = {0,1,0,-1};

        int islandCount =0;

        for (int i = 0; i < operators.length; i++) {

            int row = operators[i][0];
            int col = operators[i][1];

            if(vis[row][col]){
                result.add(islandCount);
            }else{

                vis[row][col] = true;
                islandCount++;

                for (int j = 0; j < 4; j++) {

                    int adjROw = row+delRow[j];
                    int adjCol = col+delCol[j];

                    if(adjROw >= 0 && adjCol >=0 && adjROw < rows && adjCol < cols && vis[adjROw][adjCol]){
                        int node = (row*cols)+col;
                        int adjNode = (adjROw*cols)+adjCol;
                        if(dsu.findParent(node) != dsu.findParent(adjNode)){
                            islandCount--;
                            dsu.unionByRank(node,adjNode);
                        }
                    }
                }
                result.add(islandCount);
            }
        }


return result;
    }

}
