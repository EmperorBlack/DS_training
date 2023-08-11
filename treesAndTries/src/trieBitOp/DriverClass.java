package trieBitOp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class TrieNode{
    TrieNode[] children;

    TrieNode(){
        children = new TrieNode[2];
    }

    public TrieNode getNode(int c){
        return children[c];
    }

    public void setNode(int c){
        children[c] = new TrieNode();
    }
}

class Trie{

    TrieNode root = new TrieNode();

    public void insert(int num){
        TrieNode current = root;
        for (int i = 5; i >= 0 ; i--) {

            int bit = num >> i & 1;

            if(current.getNode(bit) == null) {
                current.setNode(bit);
            }
            current = current.getNode(bit);

        }
    }

    public int getMaxXorElement(int num){
        TrieNode current = root;
        int max = 0;
        for (int i = 5; i >= 0 ; i--) {

            int bit = num >> i & 1;
            int maxBit = bit ^ 1;

            if(current.getNode(maxBit) != null){
                current = current.getNode(maxBit);
                max = max | (1 << i);
            }else {
                current = current.getNode(bit);
            }

        }
        return max;
    }

}



public class DriverClass {

    public static void main(String[] args) {

//        maximumXor( new int[]{2 ,1 ,4});

        System.out.println(new DriverClass().maximizeXor(new int[]{0,1,2,3,4},new int[][]{{3,1},{1,3},{5,6}}));

    }

    public static int maximumXor(int[] A) {

        int[] arr1 = new int[]{1,7,1, 8,0,2};
        int[] arr2 = new  int[]{6,6,0,6,8,5,6};

        Trie trie = new Trie();
        for (int a: arr1
        ) {
            trie.insert(a);
        }
        int max = 0;
        for (int a : arr2){
            int maxBit = trie.getMaxXorElement(a);
            if(maxBit > max){
                max = maxBit;
            }
        }
        System.out.println(max);
        return max;
    }

    public int findMaximumXOR(int[] nums) {

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {

                if(j!=i){
                    if((nums[i] ^ nums[j]) > max){
                        max = nums[i] ^ nums[j];
                    }
                }
            }
        }
        return max;

    }
    public int findMaximumXOR2(int[] nums) {

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {

                if(j!=i){
                    if((nums[i] ^ nums[j]) > max){
                        max = nums[i] ^ nums[j];
                    }
                }
            }
        }
        return max;

    }

    public int[] maximizeXor(int[] nums, int[][] queries) {

        Arrays.sort(nums);

        ArrayList<ArrayList<Integer>> offlineQueries = new ArrayList<>();
        int m = queries.length;
        for (int i = 0; i < m; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(queries[i][0]);
            temp.add(queries[i][1]);
            temp.add(i);
            offlineQueries.add(temp);
        }

        Collections.sort(offlineQueries,(o1, o2) -> o1.get(1).compareTo(o2.get(1)));


        int[] ans = new int[m];
        int idx = 0;

        Trie trie = new Trie();

        for (int i = 0; i < m; i++) {

            ArrayList<Integer> query = offlineQueries.get(i);
            while (idx < nums.length && nums[idx] <= query.get(1)){
                trie.insert(nums[idx]);
                idx++;
            }

            if(idx != 0){
                int max = trie.getMaxXorElement(query.get(0));
                ans[query.get(2)] = max;
            }else {
                ans[query.get(2)] = -1;
            }
        }
        return ans;
    }




}
