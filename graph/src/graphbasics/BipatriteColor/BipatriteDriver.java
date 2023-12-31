package graphbasics.BipatriteColor;

public class BipatriteDriver {
    public static void main(String[] args) {

//        System.out.println(new Solution().isBipartite(new int[][]{{1,3},{0,2},{1,3},{0,2}}));
        System.out.println(new Solution().isBipartite(new int[][]{{},{2,4,6},{1,4,8,9},{7,8},{1,2,8,9},{6,9},{1,5,7,8,9},{3,6,9},{2,3,4,6,9},{2,4,5,6,7,8}}));
    }
}

class Solution {
    public boolean isBipartite(int[][] graph) {

        int[] color = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            color[i] = -1;
        }

        for (int i = 0; i < color.length; i++) {

            if (color[i] ==-1 && !bipatriteDfs(graph,color,i,0)){
                return false;
            }

        }

        return true;
    }

    public boolean bipatriteDfs(int[][] graph,int[] color, int curr, int currClr){
        color[curr] = currClr;
        int childClr = 1-currClr;

        for (int i = 0; i < graph[curr].length; i++) {
            int node = graph[curr][i];
            if(color[node] == -1){
                if(!bipatriteDfs(graph,color,node,childClr)){
                    return false;
                }
            }
            else if(color[node] != -1 && color[node] == currClr){
                return false;
            }
        }
        return true;


    }
}
