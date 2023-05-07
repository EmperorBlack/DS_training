package stackTrainning;

public class SortStack {

    public static void main(String[] args) {

        MyStack stack = new MyStack();
        stack.push(2);
        stack.push(5);
        stack.push(1);
        stack.push(3);
        stack.push(4);
        Node head = stack.getHead();
        Node tm  = head;
        Node last = null;
        while(tm.next != null){
            tm = tm.next;
        }
        last = tm;

        Node newHead = sortStack(head,last);

        while (newHead!=null){
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
    public static Node findMiddle(Node first, Node last){
        Node firstPointer = first;
        Node slowPointer = first;

        while(firstPointer!=last && firstPointer.next!=last){
            firstPointer=firstPointer.next.next;
            slowPointer = slowPointer.next;
        }
        return slowPointer;
    }

    public static Node sortStack(Node first, Node last){
        if (first != last) {

            Node middle = findMiddle(first,last);
            Node second = middle.next;
            middle.next = null;

            first = sortStack(first,middle);
            second = sortStack(second,last);
            return merge(first,second);
        }
       return first;
    }

    public static Node merge(Node first,Node second){
        Node node = new Node(-1);
        Node current = node;

        while(first!=null && second!=null){
            if(first.val <= second.val){
                current.next = first;
                first = first.next;
            }else {
                current.next = second;
                second = second.next;
            }
            current = current.next;
        }
        if(first!=null){
            current.next = first;
        }
        if(second!=null){
            current.next = second;
        }
        while(current.next!=null){
            current = current.next;
        }
        return node.next;

    }
}
