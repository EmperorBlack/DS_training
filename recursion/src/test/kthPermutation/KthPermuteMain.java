package test.kthPermutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthPermuteMain {
    public static void main(String[] args) {

        System.out.println(getPermutation(3,3));
    }

    public static String getPermutation(int n, int k) {

        StringBuilder result = new StringBuilder("");
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <=n; i++) {
            nums.add(i);
        }
        k=k-1;
        int fact = findFactorial(n-1);
        while (nums.size() >1 ){

            int key = k/fact;
            k = k%fact;
            fact = fact/(n-1);
            n=n-1;
            result.append(nums.get(key));
            nums.remove(key);
        }
        result.append(nums.get(0));

        return result.toString();
    }

    public static int findFactorial(int n){
        if(n<=1){
            return 1;
        }
        return n*findFactorial(n-1);

    }
}
