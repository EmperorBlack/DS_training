package runningSum;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] runningSum(int[] nums) {

        int[] result = new int[nums.length];
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            result[i] = sum;
        }
        return result;

    }
}
public class RunningSumMain {
    public static void main(String[] args) {

        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        l1.add(1);

        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(2);

        System.out.println(l1.equals(l2));

    }
}
