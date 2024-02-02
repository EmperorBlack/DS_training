package graphPractice.bipatrite;

public class BipatriteDriver {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean isBipartite(int[][] graph) {

        int color[] = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            color[i] = -1;
        }

        for (int i = 0; i < graph.length; i++) {

            if(color[i] ==-1 && !isThisBipatrite(graph,i,color,0)){
                return false;
            }
        }
        return true;
    }

    public boolean isThisBipatrite(int[][] graph, int curr, int[] color, int currClr)
    {
        color[curr] = currClr;
        int childClr = 1-currClr;
        for (int i = 0; i < graph[curr].length; i++) {

            int e = graph[curr][i];
            if(color[e] ==-1){
                if(!isThisBipatrite(graph,e,color,childClr)){
                    return false;
                }
            }
            if(color[curr] == color[e]){
                return false;
            }


        }
        return true;
    }
}
