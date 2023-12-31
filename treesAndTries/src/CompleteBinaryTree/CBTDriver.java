package CompleteBinaryTree;


import java.util.ArrayDeque;
import java.util.Queue;

class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int val){
        this.val = val;
    }
}



public class CBTDriver {

    public static void main(String[] args) {

        TreeNode root = createCompleteBT(new int[]{1,2,3,4,5,6,7,8},0);
        TreeNode root2 = createCompleteBT2(new int[]{1,2,3,4,5,6,7,8});
    }

    public static TreeNode createCompleteBT(int[] nums,int i){
        if(i>=nums.length){
            return null;
        }

        TreeNode root = new TreeNode(nums[i]);
        root.left = createCompleteBT(nums,(2*i)+1);
        root.right = createCompleteBT(nums,(2*i)+2);
        return root;

    }

    public static TreeNode createCompleteBT2(int[] nums){

        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(nums[0]);
        queue.offer(root);
        int i = 1;
        while (i<nums.length){
            TreeNode temp = queue.poll();
            if(i<nums.length){
                temp.left = new TreeNode(nums[i++]);
                queue.offer(temp.left);
            }
            if(i<nums.length){
                temp.right = new TreeNode(nums[i++]);
                queue.offer(temp.right);
            }

        }
        return root;

    }
}
