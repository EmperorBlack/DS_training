package graphPractice.AlienDictionary;

import java.util.ArrayList;
import java.util.Stack;

public class AlienDictionaryDriver {

    public static void main(String[] args) {
        System.out.println(Solution.getAlienLanguage(new String[]{"bcbbcccb", "bcbbaa","bac","c" ,"c" ,"cabbcbaaa" ,"caaaacbcb" ,"a" ,"abcbcbabca" ,"abcbcc" ,"acbbbcccc" ,"accbbcca" ,"aa" ,"aaaaccac"},3));
    }
}

class Edge{
    int src;
    int dst;

    public Edge(int src, int dst) {
        this.src = src;
        this.dst = dst;
    }
}

class Solution {
    public static String getAlienLanguage(String []dictionary, int k) {

        ArrayList<Edge>[] graph = new ArrayList[k];
        for (int i = 0; i < k; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < dictionary.length; i++) {

            String s1 = dictionary[i-1];
            String s2 = dictionary[i];

            int len = Math.min(s1.length(),s2.length());
            for (int j = 0; j < len; j++) {
                if(s1.charAt(j) != s2.charAt(j)){
                    graph[s1.charAt(j)-'a'].add(new Edge(s1.charAt(j)-'a',s2.charAt(j)-'a'));
                    break;
                }
            }
        }

        Stack<Integer> orderAlphabet = new Stack<>();
        boolean visited[] = new boolean[k];
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]){
                topoSort(graph,i,visited,orderAlphabet);
            }
        }

        String alienOrder = "";
        while (!orderAlphabet.isEmpty()){
            alienOrder=alienOrder+(char)(orderAlphabet.pop()+97);
        }
        return alienOrder;




    }

    public static void topoSort(ArrayList<Edge>[] graph , int curr, boolean visited[], Stack<Integer> order){
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!visited[e.dst]){
                topoSort(graph, e.dst, visited, order);
            }
        }
        order.push(curr);
    }
}
