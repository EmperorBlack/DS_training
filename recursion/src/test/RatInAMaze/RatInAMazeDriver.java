package test.RatInAMaze;

import java.util.ArrayList;
import java.util.List;

public class RatInAMazeDriver {
    public static void main(String[] args) {

        int m[][] = {{1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}};
        System.out.println(findPath(m,4));
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> list = new ArrayList<>();
        boolean visited[][] = new boolean[n][n];
        if(m[0][0] == 1)
            findPathHelper(0,0,m,n,list,visited,"");
        return list;
    }



    public  static void findPathHelper(int i, int j, int[][] m, int n, List<String> result,boolean[][] visited,String path){
        if(i ==n-1 && j ==n-1){
            result.add(path);
            return ;
        }

        if(i+1 < n && !visited[i+1][j] && m[i+1][j] == 1){
            visited[i][j] = true;
            findPathHelper(i+1,j,m,n,result,visited,path+"D");
            visited[i][j] = false;
        }
        if(j-1 >= 0 && !visited[i][j-1] && m[i][j-1] == 1){
            visited[i][j] = true;
            findPathHelper(i,j-1,m,n,result,visited,path+"L");
            visited[i][j] = false;
        }
        if(j+1 < n && !visited[i][j+1] && m[i][j+1] == 1){
            visited[i][j] = true;
            findPathHelper(i,j+1,m,n,result,visited,path+"R");
            visited[i][j] = false;
        }
        if(i-1 >=0 && !visited[i-1][j] && m[i-1][j] == 1){
            visited[i][j] = true;
            findPathHelper(i-1,j,m,n,result,visited,path+"U");
            visited[i][j] = false;
        }




    }
}
