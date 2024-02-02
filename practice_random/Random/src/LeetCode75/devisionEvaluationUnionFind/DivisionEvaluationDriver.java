package LeetCode75.devisionEvaluationUnionFind;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DivisionEvaluationDriver {
    public static void main(String[] args) {

    }
}

class Pair{
    String key;
    Double value;

    public Pair(String key, Double value) {
        this.key = key;
        this.value = value;
    }
}

class Solution {
    private Map<String, Pair> parents = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values,
                                 List<List<String>> queries) {
        // Step 1: build union groups
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);

            String u = equation.get(0), v = equation.get(1);
            double w = values[i];

            union(u, v, w);
        }

        // Step 2. try to make the query
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String u = query.get(0), v = query.get(1);

            // case 1:  u or v never appear before
            if (!parents.containsKey(u) || !parents.containsKey(v)) {
                res[i] = -1.0;
                continue;
            }


            Pair uPair = find(u);
            Pair vPair = find(v);

            String uParent = uPair.key;
            double uWeight = uPair.value;

            String vParent = vPair.key;
            double vWeight = vPair.value;

            if (!uParent.equals(vParent))
                // case 2:  u & v NOT belong to the same group
                res[i] = -1.0;
            else
                /* case 3:  u & v belong to the same group  <==>  uPar == vPar
                            Then we want to query u / v:

                Assuming we have:
                    1. u = uPar * uWei
                    2. v = vPar * vWei = uPar * vWei

                Thus  u / v = uWei / vWei                    */
                res[i] = uWeight / vWeight;

        }
        return res;
    }

    private Pair find(String u) {
        if (!parents.containsKey(u)) {
            parents.put(u, new Pair(u, 1.0));
            return parents.get(u);
        }

        if (!parents.get(u).key.equals(u)) {
            Pair uParentPair = parents.get(u);
            Pair uGrandParentPair = find(uParentPair.key);

            parents.put(u, new Pair(uGrandParentPair.key,
                    uParentPair.value * uGrandParentPair.value));
        }
        return parents.get(u);
    }


    private void union(String u, String v, Double w) {
        Pair uPair = find(u);
        Pair vPair = find(v);

        String uParent = uPair.key;
        double uWeight = uPair.value;

        String vParent = vPair.key;
        double vWeight = vPair.value;

        if (!uParent.equals(vParent)) {
            parents.put(uParent, new Pair(vParent, vWeight / uWeight * w));
        }
    }
}
