package graphbasics.AlienDictionary;

import java.util.ArrayList;
import java.util.Stack;

public class AlienDictionaryDriver {
    public static void main(String[] args) {

        System.out.println(new Solution().findOrder(new String[]{"baa","abcd","abca","cab","cad"},5,4));
    }


}

class Edge{
    int i,j;

    public Edge(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        ArrayList<Edge>[] graph = new ArrayList[K];
        for (int i = 0; i < K; i++) {
            graph[i] = new ArrayList<>();
        }



        for (int i = 1; i < dict.length; i++) {
            String s1 = dict[i-1];
            String s2 = dict[i];

            int len = Math.min(s1.length(),s2.length());
            for (int j = 0; j < len; j++) {
                if(s1.charAt(j) != s2.charAt(j)){
                    graph[s1.charAt(j)-'a'].add(new Edge(s1.charAt(j)-'a',s2.charAt(j)-'a'));
                    break;

                }
            }


        }


        boolean[] visited = new boolean[K];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < K; i++) {

            if(!visited[i]){
                topologicalSort(graph,i,visited,stack);
            }
        }

        String s = "";
        while (!stack.isEmpty()){
            s=s+(char)(stack.pop()+97);
        }

return s;
    }

    public static void topologicalSort(ArrayList<Edge>[] graph, int curr, boolean[] visited, Stack<Integer> sortedElement){

        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!visited[e.j]){
                topologicalSort(graph, e.j, visited, sortedElement);
            }
        }
        sortedElement.push(curr);
    }
}
