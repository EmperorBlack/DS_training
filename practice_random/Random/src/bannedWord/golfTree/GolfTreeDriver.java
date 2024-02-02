package bannedWord.golfTree;
import java.util.*;

public class GolfTreeDriver {
    public static void main(String[] args) {



        System.out.println(new Solution().cutOffTree(Arrays.asList(Arrays.asList(1,2,3),Arrays.asList(0,0,4),Arrays.asList(7,6,5))));

    }
}


class Pair {
    int i;
    int j;

    int height;

    public Pair(int i, int j,int height) {
        this.i = i;
        this.j = j;
        this.height = height;
    }

    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

class Solution {

    public int cutOffTree(List<List<Integer>> forest) {

        if(forest.get(0).get(0) ==0){
            return -1;
        }

        int row = forest.size();
        int col = forest.get(0).size();

        Queue<Pair> queue = new PriorityQueue<>((p1,p2)->p1.height-p2.height);
        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {

               if((i!=0 || j !=0) && forest.get(i).get(j) > 1){
                   queue.offer(new Pair(i,j,forest.get(i).get(j)));
               }
            }
        }

        int lastI =0;
        int lastJ =0;
        int countStep =0;
        while(!queue.isEmpty()){

            Pair pair = queue.poll();
            int distance = bfs(lastI,lastJ,pair.i, pair.j,forest);
            lastI= pair.i;lastJ= pair.j;
            if(distance == Integer.MAX_VALUE){
                return -1;
            }
            countStep += distance;

        }

        return countStep;
    }

    public int bfs(int srcI,int srcJ,int dstI, int dstJ,List<List<Integer>> forest){

        int rSize = forest.size();
        int cSize = forest.get(0).size();
        boolean[][] visited = new boolean[rSize][cSize];

        int delRow[] = {1,0,-1,0};
        int delCol[] = {0,1,0,-1};

        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(srcI,srcJ));

        int count = 0;
        while (!queue.isEmpty()){

            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Pair pair = queue.poll();
                visited[pair.i][pair.j] = true;
                if(pair.i == dstI && pair.j == dstJ){
                    return count;
                }

                for (int i = 0; i < 4; i++) {

                    int row = pair.i+ delRow[i];
                    int col = pair.j+ delCol[i];

                    if(row >= 0 && row < rSize && col >=0 && col < cSize && !visited[row][col] && forest.get(row).get(col) !=0 ){

                        queue.offer(new Pair(row,col));
                    }

                }

            }
            count++;

        }
        return Integer.MAX_VALUE;
    }
}
