package huffMan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Node{
    Node left;
    Node right;
    int val;

    char c;

    public Node(int val,char c) {
        this.val = val;
        this.c = c;

    }
}

public class HuffManDriver {
    public static void main(String[] args) {
        System.out.println(new Solution().huffmanCodes("qwertyuiopasdfghjklzxcvbn",new int[]{8,9,14,19,20,21,21,25,33,45,50,50,66,68,70,73,74,75,76,82,85,90,94,97,100},25));
    }
}

class Solution {
    public ArrayList<String> huffmanCodes(String S, int f[], int N)
    {
        ArrayList<String> result = new ArrayList<>();
        Queue<Node> queue = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.val, o2.val)));
        for (int i = 0; i < N; i++) {
            queue.offer(new Node(f[i],S.charAt(i)));
        }
        Node root = null;
        while (queue.size() > 1){
            Node left = queue.poll();
            Node right = queue.poll();
            Node newNode = new Node(left.val+right.val,'_');
            newNode.left = left;
            newNode.right = right;
            queue.offer(newNode);
        }
        root = queue.poll();
        preOrder(root,"",result);
        return result;

    }

    public void preOrder(Node root,String s,ArrayList<String> result){
        if(root.left == null && root.right ==null && Character.isLetter(root.c)){
            result.add(s);
            return;
        }
        preOrder(root.left,s+"0",result);
        preOrder(root.right,s+"1",result);
    }
}
