package LeetCode75.deleteMiddleOfLL;

public class DeleteMiddleOfLLDriver {
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
    public ListNode deleteMiddle(ListNode head) {

        if(head.next == null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prv = new ListNode(-1);
        prv.next = slow;

        while (fast!= null && fast.next != null){
            fast= fast.next.next;
            slow = slow.next;
            prv = prv.next;
        }

        prv.next = slow.next;

        return head;
    }
}
