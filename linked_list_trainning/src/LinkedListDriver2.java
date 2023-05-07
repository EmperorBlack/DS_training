import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ListNode {
    public int val;
    public ListNode prev;
    public ListNode next;
    public ListNode child;

    ListNode(int val){
        this.val = val;
    }
};



public class LinkedListDriver2 {

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);

        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.prev = listNode1;

        listNode2.next = listNode3;
        listNode3.prev = listNode2;

        listNode4.next = listNode5;
        listNode5.prev = listNode4;

        listNode2.child = listNode4;

        ListNode head = listNode1;
        flatLinkedList(head);
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }

        Map<String,String> map = new HashMap<>();
        System.out.println(map.get(null));



    }

    public static ListNode flatLinkedList(ListNode head){

        ListNode begin = head;
        ListNode pre = head;

        while (begin!= null){
            if(begin.child!=null){

                ListNode newNodes = flatLinkedList(begin.child);
                ListNode nextNode = begin.next ;

                begin.next = begin.child;
                begin.child.prev = begin;
                begin.child = null;
                newNodes.next = nextNode;

                if(nextNode!=null){
                    nextNode.prev = newNodes;
                }
                begin = newNodes;
                pre = newNodes;
            }else {
                pre = begin;
                begin = begin.next;
            }
        }

        return pre;

    }


}
