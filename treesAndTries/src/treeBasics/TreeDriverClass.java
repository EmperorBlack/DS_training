package treeBasics;

import javax.swing.event.ListDataListener;
import java.util.*;
import java.util.stream.Collectors;

class Node{
    Node left;
    Node right;
    int val;

    Node(int val){
        this.val = val;
    }
}
public class TreeDriverClass {
    static int idx = -1;

    public static void main(String[] args) {
//        Node root = buildTreePre(new int[]{1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1});
        Node root = buildTreePre(new int[]{1,3,5,6,-1,-1,-1,-1,2,-1,9,7,-1,-1,-1});
//        idx = -1;
//        Node subtree = buildTreePre(new int[]{2,4,-1,-1,5,-1,-1});
//        System.out.println(isSubtree(root,subtree));

//        preOrder(root);
//        inOrder(root);
//        postOrder(root);
//        levelOrder(root);
//        inorderIt(root);
//        preorderIt(root);
//        postorderIt(root);
//        System.out.println(count(root));
//        System.out.println(diameterOfTree(root).diamter);
//        System.out.println(levelOrderWIthList(root));
//        System.out.println(buildTree(new int[]{1,2,4,5,3,6},new int[]{4,2,5,1,3,6}));
//        Node invert = invertBinaryTree(root);
//        leftViewOfTree(root);
//        System.out.println();
//        rightViewOfTree(root);
//        topViewOfTree(root,0);
//        verticalViewOfTree(root);
//        verticalViewOfTreeLettcode(root);
        widthOfBinaryTree(root);
//        System.out.println(maxDepth(root));
//        System.out.println(isBalanced(root));
//        System.out.println(lowestCommonAncestor(root,new Node(4),new Node(4)).val);
//        findPathToNode(root,5);
//        maxPathSum(root);
//        flatten(root);
    }




    public static Node buildTreePre(int nodes[]){
        idx++;
        if(nodes[idx] == -1){
            return null;
        }else{
            Node temp = new Node(nodes[idx]);
            temp.left = buildTreePre(nodes);
            temp.right = buildTreePre(nodes);
            return temp;
        }
    }

    public static void preOrder(Node root){

        if(root == null){
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void inOrder(Node root){

        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    public static void postOrder(Node root){

        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    public static void inorderIt(Node curr){

        Stack<Node> stack = new Stack<>();
        stack.push(curr);
        curr=curr.left;
        while (!stack.isEmpty() || curr!=null){

            if(curr!=null){
                stack.push(curr);
                curr=curr.left;
            }else {
                Node temp = stack.pop();
                System.out.println(temp.val);
                curr = temp.right;
            }
        }
    }
    public static void preorderIt(Node curr){

        Stack<Node> stack = new Stack<>();
        stack.push(curr);
        while (!stack.isEmpty() ){
            curr = stack.pop();
            System.out.println(curr.val);
            if(curr.right!=null){
                stack.push(curr.right);
            }

            if(curr.left!=null){
                stack.push(curr.left);
            }
        }
    }
    public static void postorderIt(Node curr){

        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || curr !=null ){

            if(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }else {
                Node temp = stack.peek().right;
                if(temp == null){
                    temp = stack.pop();
                    System.out.println(temp.val);
                    while (!stack.isEmpty() && stack.peek().right == temp){
                        temp = stack.pop();
                        System.out.println(temp.val);
                    }
                }else {
                    curr = temp;
                }
            }

        }
    }
    public static void levelOrder(Node root){

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            if(temp.left != null){
                queue.offer(temp.left);
            }
            if(temp.right != null){
                queue.offer(temp.right);
            }
            System.out.println(temp.val);
        }

    }

    public static List<List<Integer>> levelOrderWIthList(Node root){

        Queue<Node> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        queue.offer(root);
        while(!queue.isEmpty()){

            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if(queue.peek().left != null){
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right != null){
                    queue.offer(queue.peek().right);
                }
                levelList.add(queue.poll().val);
            }
            result.add(levelList);
        }
        return result;
    }

    public static List<List<Integer>> zigzagLevelOrder(Node root){

        Deque<Node> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()){

            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {

                if((level % 2) ==0){
                    Node temp = queue.poll();
                    if(temp.left != null){
                        queue.offer(temp.left);
                    }
                    if(temp.right != null){
                        queue.offer(temp.right);
                    }
                    levelList.add(temp.val);
                }else{

                    Node temp = queue.removeLast();
                    if(temp.right != null){
                        queue.offerFirst(temp.right);
                    }
                    if(temp.left != null){
                        queue.offerFirst(temp.left);
                    }
                    levelList.add(temp.val);
                }

            }
            level++;
            result.add(levelList);
        }
        return result;
    }

    public static int count(Node root){
        if(root ==null){
            return 0;
        }
        return count(root.left)+count(root.right)+1;
    }

    static class TreeInfo{
        int diamter;
        int height;

        TreeInfo(int diamter,int height){
            this.diamter = diamter;
            this.height = height;
        }
    }

    public static  TreeInfo diameterOfTree(Node root){

        if(root==null){
            return new TreeInfo(0,0);
        }
        TreeInfo info1 = diameterOfTree(root.left);
        TreeInfo info2 = diameterOfTree(root.right);
        int dia1 = info1.diamter;
        int dia2 = info2.diamter;
        int dia3 = info1.height +info2.height +1;
        int height = Math.max(info1.height,info2.height)+1;
        int diameter = Math.max(Math.max(dia1,dia2),dia3);
        return new TreeInfo(diameter,height);

    }

    public static boolean isSubtree(Node root,Node subtree){
        if(subtree == null){
            return true;
        }
        if(root == null){
            return false;
        }
        if(root.val == subtree.val){
            return isIdentical(root,subtree);
        }else{
            return isSubtree(root.left,subtree) || isSubtree(root.right,subtree);
        }

    }

    public static boolean isIdentical(Node root,Node subtree){
        if(root == null && subtree == null){
            return true;
        }
        if(root == null || subtree == null){
            return false;
        }
        if(root.val == subtree.val){
            return isIdentical(root.left,subtree.left) && isIdentical(root.right,subtree.right);
        }
        return false;
    }

    public  static Node buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }

        Node root = constructTree(preorder,0, preorder.length-1,inorder,0, inorder.length-1,map );

    return root;
    }

    public static Node constructTree(int[] preorder, int preStart,int preEnd,int[] inorder, int inStrat, int inEnd, Map<Integer,Integer> map) {

        if(preStart > preEnd || inStrat > inEnd) {
            return null;
        }

        Node temp = new Node(preorder[preStart]);
        int inRoot = map.get(preorder[preStart]);
        int inleft = inRoot-inStrat;

        temp.left = constructTree(preorder, preStart+1,preStart+inleft,inorder,inStrat,inRoot-1,map);
        temp.right = constructTree(preorder, preStart+1+inleft,preEnd,inorder,inRoot+1,inEnd,map);




        return temp;


    }

    public static Node invertBinaryTree(Node root){
        if(root == null){
            return null;
        }
        System.out.println(root.val);
        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    public static boolean isSymmetric(Node root) {
        if(root == null){
            return true;
        }
        return isSymmetricCheck(root.left,root.right);


    }
    public static boolean isSymmetricCheck(Node p, Node q){
        if(p ==null && q == null){return true;}
        if (p==null || q == null){return false;}
        if(p.val == q.val){
            return  isSymmetricCheck(p.left,q.right) && isSymmetricCheck(p.right,q.left);
        }
        return false;
    }

    public static void leftViewOfTree(Node root){
        if(root == null){
            return;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node temp = queue.poll();
                if(i==0){
                    System.out.println(temp.val);
                }
                if(temp.left != null){
                    queue.offer(temp.left);
                }
                if(temp.right != null){
                    queue.offer(temp.right);
                }
            }
        }
    }

    public static void rightViewOfTree(Node root){
        if(root == null){
            return;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node temp = queue.poll();
                if(i==0){
                    System.out.println(temp.val);
                }
                if(temp.right != null){
                    queue.offer(temp.right);
                }
                if(temp.left != null){
                    queue.offer(temp.left);
                }
            }
        }
    }
    static int rightIndex = 0;
    static int leftIndex = -1;
    public static void topViewOfTree(Node root,int index){
        if(root == null){
            return;
        }
        if(index > leftIndex){
            leftIndex = index;
            System.out.println(root.val);
        } else if (index < rightIndex) {
            rightIndex = index;
            System.out.println(root.val);
        }
        topViewOfTree(root.left,index+1);
        topViewOfTree(root.right,index-1);
    }

//    public ArrayList <Integer> bottomView(Node root)
//    {
//
//        Map<Integer,Integer> map = new TreeMap<>();
//        ArrayList<Integer> result = new ArrayList<>();
//        if(root == null){
//            return null;
//        }
//        Queue<Node> queue = new ArrayDeque<>();
//        root.hd = 0;
//        queue.add(root);
//        while(!queue.isEmpty()){
//            int len = queue.size();
//            for (int i = 0; i < len; i++) {
//                Node temp = queue.poll();
//                map.put(temp.hd,temp.data);
//                if(temp.left != null){
//                    temp.left.hd = temp.hd-1;
//                    queue.offer(temp.left);
//                }
//                if(temp.right != null){
//                    temp.right.hd=temp.hd+1;
//                    queue.offer(temp.right);
//                }
//
//            }
//        }
//
//        for (Map.Entry<Integer,Integer> m: map.entrySet()){
//            result.add(m.getValue());
//        }
//
//        //traversing the map elements and storing nodes in the list.
//
//        return result;
//        // Code here
//    }

    public static void verticalViewOfTree(Node root){
        Map<Integer,Queue<Integer>> result = new TreeMap<>();
        calculateVerticalView(root,0,result);
        System.out.println(result);
        List<List<Integer>> da = new ArrayList<>();
        for (Queue<Integer> queue : result.values()){
            List<Integer> l = new ArrayList<>();
            while (!queue.isEmpty()){
                l.add(queue.poll());
            }

            da.add(l);
        }
        System.out.println(da);

    }

    public static void calculateVerticalView(Node root, int index, Map<Integer,Queue<Integer>> result){

        if(root == null){
            return;
        }
        calculateVerticalView(root.left,index-1,result);
        if(result.containsKey(index)){
            Queue numbers = result.get(index);
            numbers.offer(root.val);
        }else {
            Queue<Integer> numbers = new PriorityQueue<>();
            numbers.offer(root.val);
            result.put(index,numbers);
        }
        calculateVerticalView(root.right,index+1,result);
    }

    public static void verticalViewOfTreeLettcode(Node root){
        Map<Integer,Map<Integer,Queue<Integer>>> map = new TreeMap<>();
        calculateVerticalViewLeetcode(root,0,0,map);
        System.out.println(map);
        List<List<Integer>> result = new ArrayList<>();
        for(Map<Integer,Queue<Integer>> levelMap: map.values()){
            List<Integer> list = new ArrayList<>();
            for (Queue<Integer> queue:levelMap.values()){
                while (!queue.isEmpty()){
                    list.add(queue.poll());
                }

            }
            result.add(list);
        }
        System.out.println(result);

    }


    public static void calculateVerticalViewLeetcode(Node root, int index,int level, Map<Integer,Map<Integer,Queue<Integer>>> map){

        if(root == null){
            return;
        }
        if(map.containsKey(index)){

            Map<Integer,Queue<Integer>> levelMap = map.get(index);
            if(levelMap.containsKey(level)){
                Queue<Integer> queue = levelMap.get(level);
                queue.offer(root.val);
            }else{
                Queue<Integer> queue = new PriorityQueue<>();
                queue.offer(root.val);
                levelMap.put(level,queue);
            }
        }else {
            Map<Integer,Queue<Integer>> levelMap = new TreeMap<>();
            Queue<Integer> queue = new PriorityQueue<>();
            queue.offer(root.val);
            levelMap.put(level,queue);
            map.put(index,levelMap);
        }
        calculateVerticalViewLeetcode(root.left,index-1,level+1,map);

        calculateVerticalViewLeetcode(root.right,index+1,level+1,map);
    }

    static int maxWidth = 0;
    public static int widthOfBinaryTree(Node root){
        Map<Integer,Long> map = new HashMap<>();
        calculateMaxWidthUsingRecursion(root,0l,0,map);
        System.out.println(maxWidth);
        return maxWidth;
//        return calculateMaxWidthUsinglevelOrder(root);
    }

    public static void calculateMaxWidthUsingRecursion(Node root,Long index, int level,Map<Integer,Long> map){
        if(root == null){
            return;
        }

        if(!map.containsKey(level) ){
            map.put(level,index);
        }

        int diff = (int)(index-map.get(level));
        maxWidth = Math.max(maxWidth,diff+1);
        calculateMaxWidthUsingRecursion(root.left,(2*index),level+1,map);
        calculateMaxWidthUsingRecursion(root.right,(2*index)+1,level+1,map);
    }

    static class MyWidthInfo{

        Node node;
        int idx;

        public MyWidthInfo(Node node, int idx) {
            this.node = node;
            this.idx = idx;
        }
    }

    public static int calculateMaxWidthUsinglevelOrder(Node root){
        int maxWidth = 0;
        if(root == null){
            return 0;
        }

        Queue<MyWidthInfo> queue = new ArrayDeque<>();
        queue.offer(new MyWidthInfo(root,0));
        while(!queue.isEmpty()){
            int size = queue.size();

            int first =0; int last = 0;
            for (int i = 0; i < size; i++) {
                MyWidthInfo widthInfo = queue.poll();
                if(i ==0){
                    first = widthInfo.idx;
                }
                if(i == size-1){
                    last = widthInfo.idx;
                }
                if(widthInfo.node.left != null){
                    queue.offer(new MyWidthInfo(widthInfo.node.left,2*widthInfo.idx));
                }
                if(widthInfo.node.right != null){
                    queue.offer(new MyWidthInfo(widthInfo.node.right,(2*widthInfo.idx)+1));
                }
            }
            maxWidth = Math.max(maxWidth,(last-first)+1);
        }
        System.out.println(maxWidth);
        return maxWidth;

    }

    public static int maxDepth(Node root){
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left > right ? left+1 : right+1;
    }

    public static boolean isBalanced(Node root) {

        if(checkIfBalanced(root) == -1){
            return false;
        }
        return true;
    }

    public static int checkIfBalanced(Node root){
        if(root == null){
            return 0;
        }
        int left = checkIfBalanced(root.left);
        if(left == -1){
            return -1;
        }
        int right = checkIfBalanced(root.right);
        if(right == -1){
            return -1;
        }
        if(Math.abs(left-right) > 1){
            return  -1;
        }else {
            return (left > right ? left : right)+1;
        }
    }

    static class LCATreeInfo{
        boolean pFound;
        boolean qFound;
        Node node;

        public LCATreeInfo() {
        }

        public LCATreeInfo(boolean pFound, boolean qFound, Node node) {
            this.pFound = pFound;
            this.qFound = qFound;
            this.node = node;
        }
    }
    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
       return findLowestCommonAncestor(root,p,q).node;
    }

    public static LCATreeInfo findLowestCommonAncestor(Node root, Node p, Node q) {

        if(root == null){
            return new LCATreeInfo();
        }

        LCATreeInfo left = findLowestCommonAncestor(root.left,p,q);
        LCATreeInfo right = findLowestCommonAncestor(root.right,p,q);
        if(left.node != null || right.node != null){
            return new LCATreeInfo(true,true,left.node != null ? left.node : right.node);
        }
        LCATreeInfo newInfo = new LCATreeInfo();
        newInfo.pFound = left.pFound || right.pFound || root.val == p.val;
        newInfo.qFound = left.qFound || right.qFound || root.val == q.val;
        if(newInfo.pFound && newInfo.qFound){
            newInfo.node = root;
            return newInfo;
        }
        return newInfo;
    }

    public static Node findLowestCommonAncestorStriver(Node root, Node p, Node q) {

        if(root == null || root == p || root==q){
            return root;
        }

        Node left = findLowestCommonAncestorStriver(root.left,p,q);
        Node right = findLowestCommonAncestorStriver(root.right,p,q);

        if(left == null){
            return right;
        } else if (right == null) {
            return left;
        }else{
            return root;
        }
    }

    public static void findPathToNode(Node root, int val){
        List<Integer> list = new ArrayList<>();
        hasPath(root,5,list);
        System.out.println(list);
    }

    public static boolean hasPath(Node root, int val,List<Integer> result){

        if(root == null){
            return false;
        }

        result.add(root.val);
        if(root.val == val){
            return true;
        }

        if(hasPath(root.left,val,result)|| hasPath((root.right),val,result)){
            return true;
        }

        result.remove(result.size()-1);
        return false;

    }

    static  int  maxSum  = Integer.MIN_VALUE;
    public static int maxPathSum(Node root) {
        findMaxSum(root);
        System.out.println(maxSum);
        return maxSum;
    }

    public static int findMaxSum(Node root){
        if(root == null){
            return 0;
        }

        int leftSum = findMaxSum(root.left);
        int rightSum = findMaxSum(root.right);
        int greaterSide = leftSum > rightSum ? leftSum+root.val: rightSum+ root.val;
        int total = leftSum+rightSum+root.val;
        if(total > maxSum){
            maxSum = total;
        }
        if(greaterSide > 0 ){
            return greaterSide;
        }
        return 0;
    }

    public static void flatten(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        getNodes(root, queue);
        Node current = new Node(-1);
        Node initial = current;
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            current.right = temp;
            temp.left = null;
            current = temp;
        }
        initial .right = null;

    }
    public static void getNodes(Node root, Queue<Node> queue){

        if(root == null){
            return;
        }
        queue.offer(root);
        getNodes(root.left,queue);
        getNodes(root.right,queue);
    }

    Node prv = null;
    public void convertToLinkedList(Node root){
        if(root == null){
            return;
        }
        convertToLinkedList(root.right);
        convertToLinkedList(root.left);
        root.right = prv;
        root.left = null;
        prv = root;

    }

    public void convertToLinkedListStriver(Node root){
        if(root == null){
            return;
        }
        convertToLinkedList(root.right);
        convertToLinkedList(root.left);
        root.right = prv;
        root.left = null;
        prv = root;

    }

    public static void convertToLL(Node root){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
            Node linkNode = stack.peek();
            node.right = linkNode;
            node.left = null;
        }
    }


}
