package test.canWeColor;



public class CanWeColorDriver {

    public static void main(String[] args) {
        boolean graph[][] = new boolean[4][4];
        graph[0][1] = true;
        graph[1][2] = true;
        graph[2][3] = true;
        graph[3][0] = true;
        graph[0][2] = true;

        System.out.println(graphColoring(graph,3,4));
    }

    public static boolean graphColoring(boolean graph[][], int m, int n) {
        int colors[] = new int[n];
        return graphColoringHelper(0,colors,m,n,graph);
    }

    public static boolean graphColoringHelper(int node, int[] color, int m, int N, boolean graph[][]) {
        // Your code here

        if(node == N){
            return true;
        }
        
        for (int i = 1; i <= m ; i++) {
            
            if(isSafe(node,color,graph,N,i)){
                color[node] = i;
                if(graphColoringHelper(node+1,color,m,N,graph)){
                    return true;
                }
                color[node] = 0;
                
            }
        }
        return false;
    }
    
    
    public static boolean isSafe(int node,int[] colours, boolean graph[][],int n,int col){


        for (int i = 0; i < n; i++) {


            if(i != node && graph[i][node] && colours[i] == col){
                return false;
            }
        }
        return true;
        
    }
}
