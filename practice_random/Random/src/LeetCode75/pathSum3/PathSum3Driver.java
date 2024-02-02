package LeetCode75.pathSum3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PathSum3Driver {
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
    int count =0;
    public int pathSum(TreeNode root, int targetSum) {

        countPathSum(root,new ArrayList<>(),targetSum);
        return count;

    }

    public void countPathSum(TreeNode root, List<Long> sums,int targetSum){
        if(root == null ){
            return;
        }
        List<Long> temp = new ArrayList<>();
        temp.add(Long.valueOf(root.val));
        if(root.val == targetSum){
            count++;
        }
        for (Long num : sums
             ) {
            if(num+root.val == targetSum){
                count++;
            }
            temp.add(num+root.val);
        }
        countPathSum(root.left,temp,targetSum);
        countPathSum(root.right,temp,targetSum);

    }

    public void countPathSumKadane(TreeNode root, Map<Long,Long> map, int targetSum,Long current){
        if(root == null ){
            return;
        }
        current = current+ root.val;
        count += map.getOrDefault(current-targetSum,0l);

        map.put(current,map.getOrDefault(current,0l)+1);

        countPathSumKadane(root.left,map,targetSum,current);
        countPathSumKadane(root.right,map,targetSum,current);
        map.put(current,map.get(current)-1);

    }
}