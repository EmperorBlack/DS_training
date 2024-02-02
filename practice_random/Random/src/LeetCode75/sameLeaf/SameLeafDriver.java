package LeetCode75.sameLeaf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SameLeafDriver {
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> leaf1 = new ArrayList<>();
            List<Integer> leaf2 = new ArrayList<>();
            collectLeaf(root1,leaf1);
            collectLeaf(root2,leaf2);
            return leaf1.equals(leaf2);

    }

    public void collectLeaf(TreeNode root,List<Integer> leaf){

        if(root == null){
            return;
        }
        if(root.left == null && root.right ==null){
            leaf.add(root.val);
            return;
        }
        collectLeaf(root.left,leaf);
        collectLeaf(root.right,leaf);

    }
}



