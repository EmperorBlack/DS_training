package LeetCode75.isGoodNode;

import com.sun.source.tree.Tree;

import java.util.Stack;

public class CountGoodNodeDriver {
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
    int count = 0;
    public int goodNodes(TreeNode root) {

        return countGoodNodes(root,new Stack<>());

    }

    public int countGoodNodes(TreeNode root, Stack<Integer> stack){
        if(root == null){
            return 0;
        }
        int count = 0;
        if(stack.isEmpty() || stack.peek() <= root.val){
            stack.push(root.val);
            count++;
        }

        int left = countGoodNodes(root.left,stack);
        int right = countGoodNodes(root.right,stack);
        if(count == 1){
            stack.pop();
        }
        return count+left+right;

    }

    public void countGoodNodes2(TreeNode root,int max){
        if(root == null){
            return;
        }
        if(root.val >= max){
            count++;
        }
        int newMax = Math.max(root.val, max);

        countGoodNodes2(root.left,newMax);
        countGoodNodes2(root.right,newMax);

    }
}

