package LeetCode75.rightSideView;

import java.util.ArrayList;
import java.util.List;

public class RightSideViewDriver {
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
    int currLevel =-1;
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        findRightSideView(root,result,0);
        return result;
    }

    public void findRightSideView(TreeNode root,List<Integer> result ,int level){

        if(root == null){
            return;
        }
        if(currLevel < level){
            result.add(root.val);
            currLevel = level;
        }
        findRightSideView(root.right,result,level+1);
        findRightSideView(root.left,result,level+1);

    }
}