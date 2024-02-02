import java.util.HashMap;
import java.util.Map;

public class GetPairCountDriver {
    public static void main(String[] args) {

    }
}

class Solution {
    int getPairsCount(int[] arr, int n, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if(!map.containsKey(arr[i])){
                map.put(arr[i],0);
            }
            map.put(arr[i],map.get(arr[i]) +1 );
        }
        int count =0;
        for (int i = 0; i < n; i++) {
            if(map.containsKey(k-arr[i])){
                count = count+ map.get(k-arr[i]);
            }
            if(arr[i] == k-arr[i]){
                count--;
            }
        }
        return count/2;
    }
}

class Solution2 {
    int getPairsCount(int[] arr, int n, int sum) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        // Store counts of all elements in map hm
        for (int i = 0; i < n; i++) {

            // initializing value to 0, if key not found
            if (!hm.containsKey(arr[i]))
                hm.put(arr[i], 0);

            hm.put(arr[i], hm.get(arr[i]) + 1);
        }
        int twice_count = 0;

        // iterate through each element and increment the
        // count (Notice that every pair is counted twice)
        for (int i = 0; i < n; i++) {
            if (hm.get(sum - arr[i]) != null)
                twice_count += hm.get(sum - arr[i]);

            // if (arr[i], arr[i]) pair satisfies the
            // condition, then we need to ensure that the
            // count is decreased by one such that the
            // (arr[i], arr[i]) pair is not considered
            if (sum - arr[i] == arr[i])
                twice_count--;
        }

        // return the half of twice_count
        return twice_count / 2;

    }



    int Countpair(int a[], int n, int sum) {
        int i = 0;
        int j = n - 1;
        int count = 0;
        while (i < j) {
            int arrSum = a[i] + a[j];
            if (arrSum > sum){
                j--;
            } else if (arrSum < sum) {
                i++;
            }else{
                count++;
                i++;
                j--;
            }


        }
        return count;
    }


}