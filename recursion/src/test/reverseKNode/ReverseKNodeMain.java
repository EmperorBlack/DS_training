package test.reverseKNode;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class ReverseKNodeMain {
    public static void main(String[] args) {

        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);


        ListNode test = reverseKGroup(node1,1);
    }



    public static ListNode reverseKGroup(ListNode head, int k) {

          ListNode first = head;
          ListNode curr = head;
          int count = 1;
          while(count<k && curr!= null && curr.next!=null){
              curr = curr.next;
              count++;
          }

          if(curr !=null && count == k){
              ListNode kGrpHead = reverseKGroup(curr.next,k);

              ListNode prv = head;
              curr = prv.next;
              while(count>1){
                  ListNode temp = curr.next;
                  curr.next = prv;
                  prv = curr;
                  curr = temp;
                  count--;
              }
              head.next = kGrpHead;
              return prv;
          }else{
              return head;
          }


    }
}
