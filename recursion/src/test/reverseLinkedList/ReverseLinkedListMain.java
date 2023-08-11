package test.reverseLinkedList;

import java.awt.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class ReverseLinkedListMain {

    public static void main(String[] args) {


        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node = new ListNode(1,node2);

        ListNode newHead = reverseList(node);









    }


    public static ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode first = head;
        ListNode second = head.next;
        ListNode newHead = reverseTwoNode(first,second);
        head.next = null;
        return newHead;
    }
    public static ListNode reverseTwoNode(ListNode first, ListNode second) {

        ListNode next = second.next;
        second.next = first;


        if(next == null){
            return second;
        }else {
            return reverseTwoNode(second,next);
        }

    }

}
