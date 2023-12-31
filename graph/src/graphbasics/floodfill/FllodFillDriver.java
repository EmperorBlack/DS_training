package graphbasics.floodfill;


import java.util.ArrayDeque;
import java.util.Queue;

class Pair{
    int i;
    int j;

    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class FllodFillDriver {

    public static void main(String[] args) {


        int[][] matrix = new int[][]{{0,0,0},{0,1,0}};
        new Solution().floodFill(matrix,1,1,2);
        for (int[] array:matrix
             ) {
            for (int element:array
                 ) {
                System.out.print(element+" ");
            }
            System.out.println();
        }
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if(image[sr][sc] == color){
            return image;
        }


        floodFillDfs(image,sr,sc,image[sr][sc],color);
        return image;

//        Queue<Pair> queue = new ArrayDeque<>();
//        queue.offer(new Pair(sr,sc));
//        boolean[][] visited = new boolean[image.length][image[0].length];
//
//        int initialPixel = image[sr][sc];
//
//        while(!queue.isEmpty()){
//            Pair p = queue.poll();
//            image[p.i][p.j] = color;
//            visited[p.i][p.j] = true;
//
//            if(p.i-1 >=0 && image[p.i-1][p.j] == initialPixel && !visited[p.i-1][p.j]){
//                queue.offer(new Pair(p.i-1,p.j));
//            }
//            if(p.i+1 <image.length && image[p.i+1][p.j] == initialPixel  && !visited[p.i+1][p.j]){
//                queue.offer(new Pair(p.i+1,p.j));
//            }
//
//            if(p.j-1 >=0 && image[p.i][p.j-1] == initialPixel && !visited[p.i][p.j-1]){
//                queue.offer(new Pair(p.i,p.j-1));
//            }
//            if(p.j+1 <image[0].length && image[p.i][p.j+1] == initialPixel && !visited[p.i][p.j+1]){
//                queue.offer(new Pair(p.i,p.j+1));
//            }
//        }
//
//        return image;
    }

    public void floodFillDfs(int[][] image, int row, int col,int old, int color) {

        if(row < image.length && row >= 0 && col < image[0].length && col >= 0 && image[row][col] == old) {
            image[row][col] = color;
            floodFillDfs(image,row - 1, col, old, color);
            floodFillDfs(image,row, col - 1, old, color);
            floodFillDfs(image,row + 1, col, old, color);
            floodFillDfs(image,row, col + 1, old, color);
        }

    }

}
