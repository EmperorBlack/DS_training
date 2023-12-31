package HeapBasics.NCombination;

import java.util.*;

public class NCombinationDriver {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solve(new ArrayList<>(Arrays.asList(1, 4, 2, 3)),new ArrayList<>(Arrays.asList(2, 5, 1, 6)),4));

    }
}

class Pair{
    int i;
    int j;

    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public boolean equals(Object o) {
       if(this.i == ((Pair)o).i && this.j == ((Pair)o).j){
           return true;
       }
       return false;
    }

    @Override
    public int hashCode() {
        return (i+j)%4095;
    }
}

class Maxvalue{
    int value;
    Pair pair;

    public Maxvalue(int value, Pair pair) {
        this.value = value;
        this.pair = pair;
    }
}
class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {

        Collections.sort(A);
        Collections.sort(B);

        ArrayList<Integer> res = new ArrayList<>();
        Set<Pair> set = new HashSet<>();
        PriorityQueue<Maxvalue> pq = new PriorityQueue<>((x,y)-> y.value-x.value);

        pq.offer(new Maxvalue(A.get(A.size()-1)+B.get(B.size()-1),new Pair(A.size()-1,B.size()-1)));

        while (!pq.isEmpty()){

            Maxvalue maxValue = pq.poll();
            res.add(maxValue.value);
            if(res.size() ==C){
                return res;
            }

            Pair pair1 = new Pair(maxValue.pair.i-1,maxValue.pair.j);
            Pair pair2 = new Pair(maxValue.pair.i,maxValue.pair.j-1);
            if(maxValue.pair.i-1 >= 0 && !set.contains(pair1)){
                pq.offer(new Maxvalue(A.get(maxValue.pair.i-1)+B.get(maxValue.pair.j),pair1));
            }

            if(maxValue.pair.j-1 >= 0 && !set.contains(pair2)){
                pq.offer(new Maxvalue(A.get(maxValue.pair.i)+B.get(maxValue.pair.j-1),pair2));
            }


        }

        return res;
    }
}
