package longestDivisiableSubset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestDivisiableSubSetDriver {

    public static void main(String[] args) {
        System.out.println(Solution.divisibleSet(new int[]{1,16,7,8,4}));
    }
}

class Solution {
    public static List< Integer > divisibleSet(int []arr) {
        int dp[] = new int[arr.length];
        int hash[] = new int[arr.length];

        Arrays.fill(dp,1);
        Arrays.sort(arr);
        List<Integer> result = new ArrayList<>();
        int maxi = 1;
        int lastIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            hash[i] = i;
            for (int j = i-1; j >= 0; j--) {
                if(arr[i] % arr[j] ==0 && dp[i] < 1+dp[j]){
                   dp[i] = 1+dp[j];
                   hash[i] = j;
                   break;
                }
            }
            if(dp[i] > maxi){
                maxi = dp[i];
                lastIndex = i;
            }

        }

        hash[0] = -1;
        while ( lastIndex >= 0){
            result.add(arr[lastIndex]);
            lastIndex = hash[lastIndex];
        }
    return result;

    }
}
