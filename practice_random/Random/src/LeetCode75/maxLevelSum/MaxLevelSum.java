package LeetCode75.maxLevelSum;

import java.util.HashMap;
import java.util.Map;

public class MaxLevelSum {
    public static void main(String[] args) {

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    int maxSumLevel = -1;
    int maxSum = Integer.MIN_VALUE;
    public int maxLevelSum(TreeNode root) {
    Map<Integer,Integer> map = new HashMap<>();
    findMaxSumLevel(root,map,1);
        for (Map.Entry<Integer,Integer> keyValue: map.entrySet()
             ) {

            if(keyValue.getValue() > maxSum){
                maxSum = keyValue.getValue();
                maxSumLevel = keyValue.getKey();
            }
        }
    return maxSumLevel;


    }

    public void findMaxSumLevel(TreeNode root, Map<Integer,Integer> map,int level){
        if(root == null){
            return;
        }
        int sum = map.getOrDefault(level,0) + root.val;
        map.put(level,sum);
        findMaxSumLevel(root.left,map,level+1);
        findMaxSumLevel(root.right,map,level+1);

    }
}
