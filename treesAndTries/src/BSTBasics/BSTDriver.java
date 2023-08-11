package BSTBasics;

import java.util.*;

public class BSTDriver {

    public static void main(String[] args) {



//        TreeNode root = new TreeNode(4);
//        TreeNode newTree = insertIntoBST(insertIntoBST(insertIntoBST(insertIntoBST(root, 2), 7), 1), 3);

//        TreeNode searchNode = searchBST(root,2);
//
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(4);
//        root.right.left = new TreeNode(2);
//recoverTree(root);

//        findSuccessor(root, 2);

        TreeNode root = new TreeNode(5);
        TreeNode newTree = insertIntoBST(insertIntoBST(insertIntoBST(insertIntoBST(insertIntoBST(root, 3), 2), 4), 6),7);
        System.out.println(new BSTDriver().findTarget2(newTree,9));
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {

        TreeNode current = root;
        while (true) {
            if (val < current.val) {
                if (current.left == null) {
                    current.left = new TreeNode(val);
                    break;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new TreeNode(val);
                    break;
                }
                current = current.right;
            }
        }
        return root;
    }

    public static TreeNode searchBST(TreeNode root, int val) {

        while (root != null) {
            if (root.val == val) {
                return root;
            } else if (root.val > val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return root;
        }
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return constructNode(nums, 0, nums.length - 1);
    }

    public static TreeNode constructNode(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode temp = new TreeNode(nums[mid]);
        temp.left = constructNode(nums, start, mid - 1);
        temp.right = constructNode(nums, mid + 1, end);
        return temp;

    }

    public boolean isValidBST(TreeNode root) {

        return checkIfValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean checkIfValidBST(TreeNode root, long min, long max) {

        if (root == null) {
            return true;
        }
        if (root.val > min && root.val < max) {
            return checkIfValidBST(root.left, min, root.val) && checkIfValidBST(root.right, root.val, max);
        } else
            return false;
    }

    static int idx = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return buildBST(preorder, Long.MIN_VALUE, Long.MAX_VALUE);
    }


    public static TreeNode buildBST(int[] preorder, long min, long max) {
        if (idx >= preorder.length) {
            return null;
        }

        if (preorder[idx] > min && preorder[idx] < max) {
            TreeNode node = new TreeNode(preorder[idx]);
            idx++;
            node.left = buildBST(preorder, min, node.val);
            node.right = buildBST(preorder, node.val, max);
            return node;
        } else {
            return null;
        }
    }

    static int index = 0;

    public static void recoverTree(TreeNode root) {
        index = 0;
        List<Integer> list = new ArrayList<>();
        inOrder(root, list, false);
        Collections.sort(list);
        inOrder(root, list, true);


    }

    public static void inOrder(TreeNode root, List<Integer> list, boolean isSwapping) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list, isSwapping);
        if (isSwapping) {
            if (list.get(index) != root.val) {
                root.val = list.get(index);
            }
            index++;
        } else {
            list.add(root.val);
        }
        inOrder(root.right, list, isSwapping);
    }

    TreeNode first;
    TreeNode second;
    TreeNode third;
    TreeNode prev;

    public void recoverTree2(TreeNode root) {
        first = second = third = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inOrderForRecoveringTree(root);
        if (first != null && third != null) {
            int temp = second.val;
            second.val = first.val;
            ;
            first.val = temp;
        } else if (first != null && second != null) {
            int temp = first.val;
            first.val = third.val;
            ;
            third.val = temp;
        }
    }

    public void inOrderForRecoveringTree(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderForRecoveringTree(root.left);
        if ((root.val < prev.val)) {
            if (first == null) {
                first = prev;
                second = root;
            } else {
                third = root;
            }
        }
        prev = root;
        inOrderForRecoveringTree(root.right);
    }

    static TreeNode sus = null;

    public static void findSuccessor(TreeNode root, int val) {
        successorOfTreeNode(root, val);
        System.out.println(sus.val);

    }

    public static void successorOfTreeNode(TreeNode root, int val) {

        if (root == null)
            return;

        if (val >= root.val) {

            successorOfTreeNode(root.right, val);
        } else if(val < root.val){
            sus = root;
            successorOfTreeNode(root.left, val);

        }
//        }else{
//            successorOfTreeNode(root.right,val);
//        }
    }

    int count = 0;
    int kthSmall;
    public int kthSmallest(TreeNode root, int k) {

        kthSmall = Integer.MIN_VALUE;
        preOrderCount(root,k);
        return kthSmall;
    }

    public void preOrderCount(TreeNode root, int k){
        if(root == null || count >= k){
            return;
        }
        preOrderCount(root.left,k);
        count++;
        if(count == k){
            kthSmall = root.val;
        }preOrderCount(root.right,k);
    }

    class BSTIterator {

        Stack<TreeNode> stack = new Stack<>();
        public BSTIterator(TreeNode root) {
            pushAll(root);
        }

        public int next() {
            TreeNode temp = stack.pop();
            if(temp.right != null){
                pushAll(temp.right);
            }
            return temp.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        private void pushAll(TreeNode root){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
        }
    }

    public boolean findTarget(TreeNode root, int k) {

        List<Integer> list= new ArrayList<>();
        inOrder(root,list);
        int front = 0;
        int back = list.size()-1;
        while(front < back){

            if((list.get(front) + list.get(back)) < k){
                front++;
            }else if((list.get(front) + list.get(back)) > k){
                back--;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }


    class BSTFullIterator {

        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();
        public BSTFullIterator(TreeNode root) {
            pushAllLeft(root);
            pushAllRight(root);
        }

        public int getLeft() {
            TreeNode temp = leftStack.pop();
            if(temp.right != null){
                pushAllLeft(temp.right);
            }
            return temp.val;
        }

        public TreeNode checkRight() {
            TreeNode temp = rightStack.peek();
            return  temp;
        }

        public TreeNode checkLeft() {
            return leftStack.peek();
        }

        public int getRight() {
            TreeNode temp = rightStack.pop();
            if(temp.left != null){
                pushAllRight(temp.left);
            }
            return temp.val;
        }

        private void pushAllLeft(TreeNode root){
            while (root!=null){
                leftStack.push(root);
                root = root.left;
            }
        }
        private void pushAllRight(TreeNode root){
            while (root!=null){
                rightStack.push(root);
                root = root.right;
            }
        }
    }

    public boolean findTarget2(TreeNode root, int k) {

        BSTFullIterator bst = new BSTFullIterator(root);
        while(bst.checkRight() != bst.checkLeft()){
            if((bst.checkLeft().val + bst.checkRight().val) < k){
                bst.getLeft();
            } else if((bst.checkLeft().val + bst.checkRight().val) > k){
                bst.getRight();
            }else {
                return true;
            }
        }
        return false;
    }



}
