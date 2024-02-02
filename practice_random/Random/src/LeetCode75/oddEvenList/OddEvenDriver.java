package LeetCode75.oddEvenList;

public class OddEvenDriver {
    public static void main(String[] args) {

    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode evenMain = head.next;
        ListNode oddHead = head;
        ListNode evenHead = head.next;

        while (evenHead!=null && evenHead.next!=null && oddHead!= null){

            ListNode evenNext = evenHead.next.next;
            ListNode oddNext = oddHead.next.next;

            oddHead.next = oddNext;
            evenHead.next = evenNext;
            oddHead = oddHead.next;
            evenHead = evenHead.next;
        }

        oddHead.next = evenMain;

        return head;
    }
}
