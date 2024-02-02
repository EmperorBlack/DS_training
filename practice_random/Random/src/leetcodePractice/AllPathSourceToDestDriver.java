package leetcodePractice;

import java.util.ArrayList;
import java.util.List;

public class AllPathSourceToDestDriver {
    public static void main(String[] args) {

        System.out.println(new Solution1().allPathsSourceTarget(new int[][]{{1,2},{3},{3},{}}));
    }
}

class Solution1 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean []visited = new boolean[graph.length];
        temp.add(0);
        findAllPath(graph,0,graph.length-1,visited,temp,result);
        return result;

    }

    public void findAllPath(int[][] graph,int curr, int dst,boolean[] visited,List<Integer> temp,List<List<Integer>> result){

        if(curr == dst){
            result.add(new ArrayList<>(temp));
        }
        visited[curr] = true;
        for (int i = 0; i < graph[curr].length; i++) {
            int adj = graph[curr][i];
            if(!visited[adj]){
                temp.add(adj);
                findAllPath(graph,adj,dst,visited,temp,result);
                visited[adj] = false;
                temp.remove(temp.size()-1);
            }
        }


    }


}
