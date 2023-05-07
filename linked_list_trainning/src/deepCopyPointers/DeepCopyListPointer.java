package deepCopyPointers;


import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}



public class DeepCopyListPointer  {

    public static void main(String[] args) {

        Node node1  = new Node(7);
        Node head = node1;
        Node node2  = new Node(13);
        Node node3  = new Node(11);
        Node node4  = new Node(10);
        Node node5  = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node2.random  = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;
        Node newNode = copyRandomListO1Space(head);
    }

    public static Node  copyRandomList(Node head) {

        Map<Node, Node> pointer = new HashMap<Node, Node>();
        Node temp = head;
        Node newHead = new Node(-1);
        Node newTemp = newHead;
        while(temp!=null){

            Node deep = new Node(temp.val);
            deep.random = temp.random;
            newTemp.next = deep;
            pointer.put(temp,deep);
            newTemp = newTemp.next;
            temp = temp.next;
        }

        Node newStart=newHead.next;


        while(newStart!=null){
            newStart.random = pointer.get(newStart.random);
            newStart= newStart.next;
        }

        return newHead.next;

    }

    public static Node copyRandomListO1Space(Node head) {

        Node old = head;
        while(old!=null){

            Node temp = old.next;
            Node copy = new Node(old.val);
            old.next = copy;
            copy.next = temp;
            old = temp;
        }

        old = head;
        Node newHead = old.next;
        while(newHead !=null){

            newHead.random = old.random != null ? old.random.next : null;
            newHead = newHead.next != null ? newHead.next.next : null;
            old = old.next != null ? old.next.next : null;

        }
        newHead = head.next;
        Node newHeadTemp = newHead;

        old = head;
        while (newHead != null){
            old.next = old.next.next;
            newHead.next = newHead.next != null ? newHead.next.next : null;
            newHead = newHead.next;
            old = old.next;

        }


        return newHeadTemp;

    }
}

