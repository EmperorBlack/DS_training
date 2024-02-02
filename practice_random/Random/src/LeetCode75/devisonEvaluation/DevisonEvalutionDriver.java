package LeetCode75.devisonEvaluation;

import java.util.*;

public class DevisonEvalutionDriver {

    public static void main(String[] args) {
        List<List<String>> equation = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c"));
        double[] values = new double[]{2.0, 3.0};
        List<List<String>> queries = Arrays.asList(Arrays.asList("a", "c"), Arrays.asList("b", "a"), Arrays.asList("a", "e"), Arrays.asList("a", "a"), Arrays.asList("x", "x"));


        double result[] = new Solution().calcEquation(equation,values,queries);
    }
}

class Pair{
    String dst;
    double value;

    public Pair(String dst, double value) {
        this.dst = dst;
        this.value = value;
    }
}

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String,List<Pair>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {

            String src = equations.get(i).get(0);
            String dst = equations.get(i).get(1);
            double val = values[i];
            List<Pair> pairs = graph.getOrDefault(src,new ArrayList<>());
            pairs.add(new Pair(dst,val));
            graph.put(src,pairs);
            List<Pair> rPairs = graph.getOrDefault(dst,new ArrayList<>());
            rPairs.add(new Pair(src,1.0d/val));
            graph.put(dst,rPairs);

        }

        double []result = new double[queries.size()];

        int i =0;
        for (List<String> query: queries
             ) {
            String src = query.get(0);
            String dst = query.get(1);
            double res = -1.0d;
            if(graph.containsKey(src) && graph.containsKey(dst)){
                findDfs(graph,new HashSet<>(),src,dst,1.0d,result,i);
                if(result[i] == 0d){
                    result[i] = -1.0d;
                }
                graph.get(src).add(new Pair(dst,result[i]));
                graph.get(dst).add(new Pair(src,1/result[i]));
                i++;
            }else{
                result[i++] = res;
            }


        }

        return result;

    }

    public void findDfs(Map<String,List<Pair>> graph,Set<String> visited,String curr,String dst,double product,double []result, int iQuery ){
        if(curr.equals(dst)){
            result[iQuery] = product;
            return;
        }
        visited.add(curr);

        List<Pair> pairs = graph.get(curr);
        for (int i = 0; i < pairs.size(); i++) {

            Pair p = pairs.get(i);
            if(!visited.contains(p.dst)){
                findDfs(graph, visited, p.dst, dst, product*p.value,result,iQuery);
            }
        }
    }
}


