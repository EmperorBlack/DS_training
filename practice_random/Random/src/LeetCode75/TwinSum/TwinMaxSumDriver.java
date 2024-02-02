package LeetCode75.TwinSum;

public class TwinMaxSumDriver {
    public static void main(String[] args) {
        ListNode one = new ListNode(5,new ListNode(4,new ListNode(2,new ListNode(1))));

        System.out.println(new Solution().pairSum(one));
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
    public int pairSum(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast!=null && fast.next!= null){
            fast= fast.next.next;
            slow = slow.next;
        }
        ListNode middle = slow;
        ListNode lastHead = reverseLinkedList(slow,slow.next);
        middle.next = null;
        ListNode curr = head;
        int result = Integer.MIN_VALUE;
        while (lastHead!=null){
            int twinSum = curr.val+lastHead.val;
            if(twinSum > result){
                result = twinSum;
            }
            curr = curr.next;
            lastHead= lastHead.next;

        }


        return result;

    }

    public ListNode reverseLinkedList(ListNode first, ListNode second){

        if(second == null){
            return first;
        }
        ListNode temp = second.next;
        if(temp == null){
            second.next = first;
            return second;
        }else{
            second.next= first;
            return reverseLinkedList(second,temp);
        }

    }
}