package ChocoDistribution;

import java.util.ArrayList;
import java.util.Collections;

public class ChocoDistributionDriver {
    public static void main(String[] args) {

    }
}

class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        Collections.sort(a);
        int index = m-1;
        long minValue = Integer.MAX_VALUE;
        for (int i = index; i < n; i++) {
            int min = a.get(i) - a.get(i-index);
            if(min < minValue){
                minValue = min;
            }

        }
        return minValue;
    }
}
