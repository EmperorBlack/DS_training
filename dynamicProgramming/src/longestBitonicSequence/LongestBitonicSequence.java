package longestBitonicSequence;

import java.util.Arrays;

public class LongestBitonicSequence {
    public static void main(String[] args) {

        System.out.println(Solution.longestBitonicSequence(new int[]{48,42,21,40,39,46,21},7));
    }
}

class Solution {
    public static int longestBitonicSequence(int[] arr, int n) {
        int dpInc[] = new int[arr.length];
        int dpDcr[] = new int[arr.length];
        Arrays.fill(dpInc,1);
        Arrays.fill(dpDcr,1);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {

                if(arr[j] < arr[i] && 1+dpInc[j] > dpInc[i]){
                   dpInc[i] = 1+dpInc[j];
                }
            }
        }
        for (int i = arr.length-1; i >= 0; i--) {
            for (int j = arr.length-1; j > i; j--) {

                if(arr[j] < arr[i] && 1+ dpDcr[j] > dpDcr[i]){
                    dpDcr[i] = 1+dpDcr[j];
                }
            }
        }

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max,dpInc[i]+dpDcr[i]-1);
        }

        return max;
    }
}
