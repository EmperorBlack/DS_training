package AVLTree;


class Node {
    Node left;
    Node right;
    int key;
    int height;

    public Node(int key) {
        this.key = key;
        height = 1;
    }
}

class AVLTree{

    Node root;

    int height(Node n){
        if(n == null){
            return 0;
        }
        return n.height;
    }

    int max(int a, int b){
        return a>b ? a:b;
    }

    Node rightRotate(Node y){
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = max(height(y.left),height(y.right));
        x.height = max(height(x.left),height(x.right));
        return x;

    }

    Node leftRotate(Node x){
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(height(x.left),height(x.right));
        y.height = max(height(y.left),height(y.right));
        return y;

    }

    int getBalance(Node n){
        if(n==null){
            return 0;
        }

        return height(n.left) -height(n.right);
    }

    Node insert(Node node , int key){

        if(node == null){
            return new Node(key);
        }

        if(key < node.key){
            node.left = insert(node.left,key);
        } else if (key > node.key) {
            node.right = insert(node.right,key);
        }else {
            return  node;
        }

        node.height = 1+max(height(node.left),height(node.right));
        int balance = getBalance(node);

//        left left
        if(balance > 1 && key < node.left.key  ){
            return rightRotate(node);
        } else if (balance < -1 && key > node.right.key ) {
            return  leftRotate(node);
        } else if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }else if(balance < -1 && key <node.right.key){
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;


    }
}
public class AVLTreeDriver {

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        Node root = new Node(5);
        root = tree.insert(root,3);
        root = tree.insert(root,2);
        root =tree.insert(root,1);
        root =tree.insert(root,-3);
        root =tree.insert(root,9);
        root =tree.insert(root,12);
        root =tree.insert(root,15);
        root =tree.insert(root,20);
        root =tree.insert(root,10);tree.insert(root,6);
        root =tree.insert(root,7);




    }

}
