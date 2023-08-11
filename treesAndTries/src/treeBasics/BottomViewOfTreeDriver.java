package treeBasics;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

class TreeNode{
    TreeNode left;
    TreeNode right;
    int index;
    int val;

    TreeNode(int val){
        this.val = val;
    }
}
public class BottomViewOfTreeDriver {
    static int idx = -1;
    public static void main(String[] args) {
        TreeNode root = buildTreePre(new int[]{1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1});
        bottomViewOfTree(root);
    }


    public static TreeNode buildTreePre(int nodes[]){
        idx++;
        if(nodes[idx] == -1){
            return null;
        }else{
            TreeNode temp = new TreeNode(nodes[idx]);
            temp.left = buildTreePre(nodes);
            temp.right = buildTreePre(nodes);
            return temp;
        }
    }

    public static void bottomViewOfTree(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        root.index = 0;
        queue.add(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode temp = queue.poll();
                map.put(temp.index,temp.val);
                if(temp.left!=null){
                    temp.left.index = temp.index+1;
                    queue.offer(temp.left);
                }
                if(temp.right!=null){
                    temp.right.index = temp.index-1;
                    queue.offer(temp.right);
                }
            }
        }
        System.out.println(map);
    }
}
