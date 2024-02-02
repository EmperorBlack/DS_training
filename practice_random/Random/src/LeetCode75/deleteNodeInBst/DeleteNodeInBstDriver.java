package LeetCode75.deleteNodeInBst;

import com.sun.source.tree.Tree;

public class DeleteNodeInBstDriver {
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
    public TreeNode deleteNode(TreeNode root, int key) {


        return findRootOfNode(root, key);

    }

    public TreeNode findRootOfNode(TreeNode curr, int key){
        if(curr == null ){
            return null;
        }
        if(key > curr.val){
             curr.right = findRootOfNode(curr.right,key);
             return curr;

        } else if (key < curr.val) {
             curr.left = findRootOfNode(curr.left,key);
             return curr;
        }

        if(curr.left == null){
            return curr.right;
        } else if (curr.right == null) {
            return curr.left;
        }else{

            TreeNode min = curr.right;
            while (min.left!=null){
                min = min.left;
            }
            curr.val = min.val;
            curr.right = findRootOfNode(curr.right, min.val);
            return curr;
        }

    }

    public TreeNode findRootOfNode2(TreeNode curr, int key){
        if(curr == null ){
            return null;
        }
        if(key > curr.val){
            curr.right = findRootOfNode2(curr.right,key);
            return curr;

        } else if (key < curr.val) {
            curr.left = findRootOfNode2(curr.left,key);
            return curr;
        }

        if(curr.left == null){
            return curr.right;
        } else if (curr.right == null) {
            return curr.left;
        }else{

            TreeNode min = curr.right;
            TreeNode temp = null;
            while (min.left!=null){
                temp = min;
                min = min.left;
            }
            curr.val = min.val;
            if(temp!=null){
                temp.left = min.right;
            }else{
                curr.right = min.right;
            }
            return curr;
        }

    }
}
