public class UniquePath {
    public static void main(String args[]){

        System.out.println(findUniqueWays(3,7));
        System.out.println(findUniqueWaysRecursive(2,2));
    }
    public static int findUniqueWays(int m, int n){
        int grid[][]  = new int[m][n];
        for(int i=0;i<n;i++){
            grid[0][i] = 1;
        }
        for(int i=0;i<m;i++){
            grid[i][0] = 1;
        }

        for(int i =1;i<m;i++){
            for(int j =1;j<n;j++){
                grid[i][j] = grid[i-1][j]+grid[i][j-1];
            }
        }

        return grid[m-1][n-1];
    }

    public static int findUniqueWaysRecursive(int m, int n){
       int numberOfPath = createNode(0,0,m,n);
       return numberOfPath;
    }

    public static int createNode(int i,int j,int m, int n){

        if(i>=m || j>=n){
            return 0;
        }
        if(i == m-1 && j == (n-1)){
            return 1;
        }

        return createNode(i+1,j,m,n)+createNode(i,j+1,m,n);
    }
}
