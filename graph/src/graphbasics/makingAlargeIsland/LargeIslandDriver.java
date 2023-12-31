package graphbasics.makingAlargeIsland;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LargeIslandDriver {
    public static void main(String[] args) {

//        int[][] grid = {
//                {1, 1, 0, 1, 1, 0}, {1, 1, 0, 1, 1, 0},
//                {1, 1, 0, 1, 1, 0}, {0, 0, 1, 0, 0, 0},
//                {0, 0, 1, 1, 1, 0}, {0, 0, 1, 1, 1, 0}
//        };
        int grid[][] = new int[][]{{1,1},{1,1}};

        Solution obj = new Solution();
        int ans = obj.largestIsland(grid);
        System.out.println("The largest group of connected 1s is of size: " + ans);

    }
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
    public int largestIsland(int[][] grid) {

        int n = grid.length;
        DisjointSet dsu = new DisjointSet(n*n);
        int delRow[] = {1,0,-1,0};
        int delCol[] = {0,1,0,-1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if(grid[i][j] ==1){
                    int node = i*n+j;
                    for (int k = 0; k < 4; k++) {
                        int adjRow = i+delRow[k];
                        int adjCol = j+delCol[k];

                        if(adjRow >=0 && adjCol>=0 && adjRow < n && adjCol < n && grid[adjRow][adjCol] ==1){
                            int adjNode = adjRow*n+adjCol;
                            dsu.unionBySize(node,adjNode);
                        }

                    }

                }

            }

        }

        int max = 0;
        int numberOf1 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {


                if(grid[i][j] == 0){

                    int countSize = 1;
                    Set<Integer> set = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int adjRow = i+delRow[k];
                        int adjCol = j+delCol[k];
                        if(adjRow >=0 && adjCol>=0 && adjRow < n && adjCol < n && grid[adjRow][adjCol] ==1){
                            int adjNode = adjRow*n+adjCol;
                            set.add(dsu.findParent(adjNode));
                        }
                    }
                    for (Integer node:set
                         ) {
                        countSize+=dsu.size.get(node);
                    }
                    if(countSize > max){
                        max = countSize;
                    }
                }else {
                    numberOf1++;
                }

            }
        }
        if(numberOf1 == (n*n)){
            return numberOf1;
        }
return max;
    }
}