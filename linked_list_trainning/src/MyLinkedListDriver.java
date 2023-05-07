import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

class MyLinkedList {
    private Node head;
    private Node last;
    private int count = 0;

    public void traverseLinkedList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public Node getHead() {
        return head;
    }

    public void addAtFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        if (last == null) {
            last = newNode;
        }
        count++;
    }

    public void add(int value) {
        addAtLast(value);
    }

    public void addAtLast(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        }
        if (last != null) {
            last.next = newNode;
        }
        last = newNode;
        count++;
    }

    public void addAtNPos(int value, int n) {
        int nodeCount = n - 1;
        Node temp = head;
        while (nodeCount > 1) {
            temp = temp.next;
            nodeCount--;
        }
        Node newNode = new Node(value);
        Node next = temp.next;
        temp.next = newNode;
        newNode.next = next;
        count++;

    }

    public int size(int value) {
        return count;
    }

    public boolean search(int value) {
        return isThisNode(head, value);
    }

    private boolean isThisNode(Node node, int value) {
        if (node == null) {
            return false;
        }
        if (node.data == value) {
            return true;
        } else {
            return isThisNode(node.next, value);
        }
    }

    public int getCount() {
        Node tmp = head;
        return countNodes(tmp);
    }

    private int countNodes(Node n) {

        if (n == null) {
            return 0;
        }
        return 1 + countNodes(n.next);
    }

    public void reverseLinkedList() {

        Node current = head;
        Node next = current.next;

        while (next != null) {

            Node temp = next.next;
            next.next = current;
            current = next;
            next = temp;
        }
        head.next = null;
        head = current;
    }

    public void createLoopForTest() {
        Node tmp = head;
        tmp = tmp.next
                .next;
        last.next = tmp;
    }

    public void detectIfThereIsLoopANdRemove() {
        Node tmp = head;
        Node tmp2 = head;
        while (tmp != null && tmp2 != null) {
            tmp = tmp.next;
            tmp2 = tmp2.next;
            if (tmp2 != null) {
                tmp2 = tmp2.next;
            }
            if (tmp == tmp2) {
                break;
            }

        }
        if(tmp2 != null){
            tmp = head;
            Node prv = tmp2;
            while(tmp != tmp2){
                tmp= tmp.next;
                prv = tmp2;
                tmp2 = tmp2.next;

            }
            prv.next = null;
        }
    }
    public Node detectIntersectionOfLists(Node n1, Node n2){
//        Set<Node> content = new HashSet<>();
//        while (n1 != null){
//            content.add(n1);
//            n1 = n1.next;
//        }
//        while(n2 != null){
//            if(content.contains(n2)){
//                return n2;
//            }
//            n2 = n2.next;
//        }
//        return null;
        Node a1 = n1;
        Node a2 = n2;

        while (a1 != a2){
            a1 = a1==null ? n2:a1.next;
            a2 = a2==null ? n1:a2.next;
        }
        return a1;
    }

    public boolean isPalliandrom(Node n){
        StringBuilder sb = new StringBuilder();
        while (n!=null){
            sb.append(n.data);
            n = n.next;
        }
//        System.out.println(sb.reverse().);
        return sb.toString().equals(sb.reverse().toString());

    }
    public boolean isPalliandromByReverse(Node n){

        Node slow = n;
        Node fast = n;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        Node prev = slow;
        Node current = slow.next;
        prev.next = null;
        while (current!=null){

            Node temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        while(n!=null && prev!=null){
            if(n.data != prev.data){
                return false;
            }
            n=n.next;
            prev=prev.next;
        }
        return true;


    }


    public void findKNodeFromEnd(int k) {

        Node falsePointer = head;
        Node realPointer = head;
        for (int i = 0; i < k; i++) {
            falsePointer = falsePointer.next;
            if (i != k - 1 && falsePointer == null) {
                System.out.println("array have only " + (i + 1) + " elements");
                return;
            }
        }
        while (falsePointer != null) {
            falsePointer = falsePointer.next;
            realPointer = realPointer.next;
        }

        System.out.println("node value " + realPointer.data);

    }

    public Node mergeTwoLists(Node list1, Node list2) {

        Node mergedNodeHead = null;
        Node current = null;
        while (list1 != null && list2 != null) {
            Node smallNode = null;
            if (list1.data <= list2.data) {
                smallNode = list1;
                list1 = list1.next;
            } else {
                smallNode = list2;
                list2 = list2.next;
            }
            if (mergedNodeHead == null) {
                mergedNodeHead = smallNode;
                current = smallNode;
            } else {
                current.next = smallNode;
                current = smallNode;
            }

        }
        while (list1 != null) {
            if (mergedNodeHead == null) {
                mergedNodeHead = list1;
                current = list1;
            } else {
                current.next = list1;
                current = list1;
            }
            list1 = list1.next;
        }
        while (list2 != null) {
            if (mergedNodeHead == null) {
                mergedNodeHead = list2;
                current = list2;
            } else {
                current.next = list2;
                current = list2;
            }
            list2 = list2.next;
        }
        return mergedNodeHead;
    }

    public Node addTwoNumbers(Node l1, Node l2) {
        Node resultNodeHead = null;
        Node previousResult = null;
        int carry = 0;
        while (l1 != null || l2 != null) {

            Node newNode = null;
            int num = (l1 != null ? l1.data : 0) + (l2 != null ? l2.data : 0) + carry;
            if (num > 9) {
                carry = num / 10;
                num = num % 10;
            }else{
                carry  =0;
            }
            newNode = new Node(num);
            if (resultNodeHead == null) {
                resultNodeHead = newNode;
                previousResult = newNode;
            } else {
                previousResult.next = newNode;
                previousResult = newNode;
            }
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
        }
        if(carry > 0){
            previousResult.next = new Node(carry);
        }
        return resultNodeHead;
    }

    public List<Node> getMockIntersectionList(){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node5.next = node6;
        node6.next = node3;
        return Arrays.asList(node1,node5);

    }

//    public Node reverseKThGroup(int k){
//
//        Node n = head;
//        int i=1;
//        Node first = head;
//        Node newHead = null;
//        Node lastEnd = null;
//        while(n!= null){
//            if(i%k ==0){
//                Node end = n;
//                n=n.next;
//                Node lastHead = reverse(first,end);
//                if(newHead==null){
//                    newHead = lastHead;
//                }
//                if(lastEnd == null){
//                    lastEnd = first;
//                }else{
//                    lastEnd.next = lastHead;
//                    lastEnd = first;
//                }
//                first = n;
//            }else {
//                n=n.next;
//            }
//            i++;
//
//        }
//        return newHead;
//
//
//    }
//    public Node reverse(Node start, Node end){
//        Node curr = start.next;
//        Node prv = start;
//        while(prv!=end){
//            Node tmp = curr.next;
//            curr.next = prv;
//            prv =curr;
//            curr = tmp;
//        }
//        start.next = curr;
//        return prv;
//    }
public Node reverseKThGroup(int k){

    Node dumyHead = new Node(-1);
    dumyHead.next = head;
    int i=1;
    Node first = dumyHead;
    Node newHead = null;
    while(head!= null){
        if(i%k ==0){
            first = reverse(first,head);
            head = first.next;
        }else {
            head=head.next;
        }
        i++;

    }
    return dumyHead.next;


}
    public Node reverse(Node start, Node end){
        Node prv = start;
        Node begin = start.next;
        Node from = start.next;
        Node curr = from.next;
        while(from!=end){
            Node tmp = curr.next;
            curr.next = from;
            from =curr;
            curr = tmp;
        }
        begin.next = curr;
        prv.next = from;
        return begin;
    }
    public Node rotateList(int k ){
        Node start = head;
        int count = 1;
        while(start.next!=null){
            count++;
            start =start.next;
        }
        k = k%count;
        int moveTill = (count-k)-1;
        Node begin = head;
        while(moveTill-- >0){
            begin=begin.next;
        }
        start.next = head;
        head = begin.next;
        begin.next = null;

        return head;
    }

    public void flaternLinkedList(){

    }
}

    public class MyLinkedListDriver {

        public static void main(String[] args) {
            MyLinkedList linkedList = new MyLinkedList();
            linkedList.add(1);
            linkedList.add(2);
            linkedList.add(3);
            linkedList.add(4);
//        linkedList.addAtFirst(0);
//        linkedList.addAtLast(5);
//        linkedList.addAtNPos(6,5);

            linkedList.traverseLinkedList();

            System.out.println(linkedList.search(9));
            System.out.println(linkedList.getCount());
//        linkedList.reverseLinkedList();
//        linkedList.traverseLinkedList();
            linkedList.createLoopForTest();
            linkedList.detectIfThereIsLoopANdRemove();
            linkedList.traverseLinkedList();

            System.out.println("----------------------detecting intersection on a list------------------");

            List<Node> nodes = linkedList.getMockIntersectionList();
            System.out.println(linkedList.detectIntersectionOfLists(nodes.get(0),nodes.get(1)).data);
            System.out.println("----------------------detecting if list is palliandrom or not------------------");

            MyLinkedList linkedListPal = new MyLinkedList();
            linkedListPal.add(1);
            linkedListPal.add(2);
            linkedListPal.add(2);
            linkedListPal.add(1);

//            System.out.println(linkedListPal.isPalliandrom(linkedListPal.getHead()));
            System.out.println(linkedListPal.isPalliandromByReverse(linkedListPal.getHead()));


            System.out.println("----------------------reverse K group------------------");

            MyLinkedList linkedListrev = new MyLinkedList();
            linkedListrev.add(1);
            linkedListrev.add(2);
            linkedListrev.add(3);
            linkedListrev.add(4);
            linkedListrev.add(5);

            Node n = linkedListrev.reverseKThGroup(2);
            while (n!=null){
                System.out.println(n.data);
                n= n.next;
            }

            System.out.println("--------------------rotate k element------------->");
            MyLinkedList linkedListRot = new MyLinkedList();
            linkedListRot.add(1);
            linkedListRot.add(2);
            linkedListRot.add(3);
            linkedListRot.add(4);
            linkedListRot.add(5);

            Node r = linkedListRot.rotateList(10);
            while (r!=null){
                System.out.println(r.data);
                r= r.next;
            }


//            linkedList.findKNodeFromEnd(5);

//            System.out.println("_-------------__------------------trying to merge two sorted array----------------------------");
//            MyLinkedList linkedList1 = new MyLinkedList();
//            linkedList1.add(1);
//            linkedList1.add(2);
//            linkedList1.add(4);
//
//            MyLinkedList linkedList2 = new MyLinkedList();
//            linkedList2.add(1);
//            linkedList2.add(3);
//            linkedList2.add(4);
//
//            Node head = linkedList1.mergeTwoLists(linkedList1.getHead(), linkedList2.getHead());
//            while (head != null) {
//                System.out.println("merged Data===>" + head.data);
//                head = head.next;
//            }
//
//            System.out.println("_-------------__------------------trying to add two integer----------------------------");
//            MyLinkedList linkedList3 = new MyLinkedList();
//            linkedList3.add(2);
//            linkedList3.add(4);
//            linkedList3.add(3);
//
//            MyLinkedList linkedList4 = new MyLinkedList();
//            linkedList4.add(5);
//            linkedList4.add(6);
//            linkedList4.add(4);
//
//            Node resultHead = linkedList3.addTwoNumbers(linkedList3.getHead(), linkedList4.getHead());
//            System.out.print("resultant sum");
//            while (resultHead != null) {
//                System.out.print(resultHead.data);
//                resultHead = resultHead.next;
//            }



        }

    }
