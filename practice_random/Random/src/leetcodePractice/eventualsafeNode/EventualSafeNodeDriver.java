package leetcodePractice.eventualsafeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class EventualSafeNodeDriver {
}

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        boolean visited[] = new boolean[graph.length];
        boolean []isSafe = new boolean[graph.length];
        boolean []recStack = new boolean[graph.length];

        for (int i = 0; i < visited.length; i++) {

            if(!visited[i]){
                dfsCycle(graph,i,isSafe,visited,recStack);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < isSafe.length; i++) {
            if(isSafe[i]){
                result.add(i);
            }
        }
return result;

    }

    public boolean dfsCycle(int[][] graph, int curr,boolean []isSafe,boolean visited[],boolean recStack[] ) {

        visited[curr] = true;
        recStack[curr] = true;

        for (int i = 0; i < graph[curr].length; i++) {

            int adj = graph[curr][i];
            if(recStack[adj]){
                return true;
            }
            if(!visited[adj] && dfsCycle(graph,adj,isSafe,visited,recStack)){
                return true;
            }
        }
        recStack[curr] = false;
        isSafe[curr] = true;
        return false;

    }

    public List<Integer> eventualSafeNodesBfs(int[][] graph) {

        boolean []isSafe = new boolean[graph.length];
        ArrayList<ArrayList<Integer>> reverseGraph = new ArrayList<>();
        int[] indegree = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            reverseGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                reverseGraph.get(graph[i][j]).add(i);
                indegree[i]++;
            }

        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < indegree.length; i++) {
            if(indegree[i] ==0){
                queue.offer(i);
            }

        }
        while (!queue.isEmpty()){

            int curr = queue.poll();
            isSafe[curr] = true;
            for (int i = 0; i < reverseGraph.get(curr).size(); i++) {
                indegree[reverseGraph.get(curr).get(i)]--;
                if(indegree[reverseGraph.get(curr).get(i)] ==0){
                    queue.offer(reverseGraph.get(curr).get(i));
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < isSafe.length; i++) {
            if(isSafe[i]){
                result.add(i);
            }
        }
return result;
    }
}
