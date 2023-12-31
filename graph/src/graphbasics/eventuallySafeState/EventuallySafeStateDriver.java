package graphbasics.eventuallySafeState;



import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class EventuallySafeStateDriver {
    public static void main(String[] args) {

        System.out.println(new Solution().eventualSafeNodesBFS(new int[][]{{1,2},{2,3},{5},{0},{5},{},{}}));
    }
}


class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        boolean visited[]= new boolean[graph.length];
        boolean []recStack= new boolean[graph.length];
        boolean markSafe[]=new boolean[graph.length];


        for (int i = 0; i < graph.length; i++) {
            if(!visited[i]){
                dfs(graph,i,visited,recStack,markSafe);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < markSafe.length; i++) {
            if(markSafe[i]){
                list.add(i);
            }
        }
    return list;
    }

    public static boolean dfs(int[][] graph, int curr, boolean visited[],boolean []recStack,boolean markSafe[]) {

        System.out.println(curr);
        visited[curr] = true;
        recStack[curr] = true;
        for (int i = 0; i < graph[curr].length; i++) {

          if(!markSafe[graph[curr][i]]){
                if (!visited[graph[curr][i]]){
                    if(dfs(graph, graph[curr][i], visited,recStack,markSafe)){
                        return true;
                    }
                } else if (recStack[graph[curr][i]]) {
                    return true;
                }
            }
        }
        markSafe[curr] = true;
        recStack[curr] = false;
        return false;
    }

    public List<Integer> eventualSafeNodesBFS(int[][] graph) {

        int[] inDegrees= new int[graph.length];
        boolean[] safeNodes = new boolean[graph.length];
        List<Integer> result = new ArrayList<>();
        ArrayList<ArrayList<Integer>> reverseGraph = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            reverseGraph.add(new ArrayList<>());
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j : graph[i]
                 ) {
                reverseGraph.get(j).add(i);
                inDegrees[i]++;
            }
        }


        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < inDegrees.length; i++) {

            if(inDegrees[i] ==0){
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()){

            int safe = queue.poll();
            safeNodes[safe] = true;
            for (int i = 0; i < reverseGraph.get(safe).size(); i++) {
                inDegrees[reverseGraph.get(safe).get(i)]--;
                if(inDegrees[reverseGraph.get(safe).get(i)] ==0){
                    queue.offer(reverseGraph.get(safe).get(i));
                }

            }
        }

        for (int i = 0; i < safeNodes.length; i++) {
            if (safeNodes[i]){
                result.add(i);
            }
        }


        return result;
    }
}