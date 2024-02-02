package LeetCode75.longestZigZag;

public class LongestZigZagDriver {
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
    int max = Integer.MIN_VALUE;
    public int longestZigZag(TreeNode root) {

       int left = findMaxZigZag(root.left,true);
       int right = findMaxZigZag(root.right,false);
        max = Math.max(left+1,max);
        max = Math.max(right+1,max);
        return max-1;

    }

    public int findMaxZigZag(TreeNode root,boolean isLeft){

        if(root == null){
            return 0;
        }

        int left = findMaxZigZag(root.left,true);
        int right = findMaxZigZag(root.right,false);

        max = Math.max(left+1,max);
        max = Math.max(right+1,max);

        if(isLeft){
            return right+1;
        }else{
            return left+1;
        }

    }
}
