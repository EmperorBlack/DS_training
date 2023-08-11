package hashset;

class Node{
    Node next;
    int val;

    Node(int val){
        this.val = val;
    }
}

class MyHashSet {

    Node store[];
    int capacity = 10;
    int size = 0;

    public MyHashSet() {
        store = new Node[10];
    }

    public void add(int key) {
        if(contains(key)){
            return;
        }
        if(this.size > (capacity * 0.75)){
            this.capacity = capacity*2;
            Node[] newStore = new Node[capacity];
            for (int i = 0; i < size; i++) {
                if(store[i] != null){
                    Node temp = store[i];
                    while (temp!=null){
                        addNode(temp.val,newStore);
                    }
                }
            }
            this.store = newStore;
        }
        addNode(key,store);

    }

    public void remove(int key) {
        int size = store.length;
        int hash = key%size;
        Node node = store[hash];
        if(node == null){
            return;
        }else{
            Node head = new Node(-1);
            head.next = node;
            Node prv = head;
            Node temp = node;
            while (temp!=null){
                if (temp.val == key){
                    break;
                }
                prv = temp;
                temp = temp.next;
            }
            if(temp!=null){
                prv.next = temp.next;
                size--;
            }
            store[hash] = head.next;
        }
    }

    public boolean contains(int key) {
        int size = store.length;
        int hash = key%size;
        Node node = store[hash];
        if(node == null){
            return false;
        }else{
            Node temp = node;
            while (temp!=null){
                if (temp.val == key){
                    return true;
                }
                temp = temp.next;
            }
            return false;
        }
    }

    public void addNode(int key, Node[] store){
        int size = store.length;
        int index = key%size;
        Node nodeInPlace = store[index];
        Node newNode = new Node(key);
        if(nodeInPlace == null){
            store[index] = newNode;
        }else {
            store[index] = newNode;
            newNode.next = nodeInPlace;
        }
        this.size++;
    }
}

public class HashSetDriver {
    public static void main(String[] args) {


        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.contains(1);
        hashSet.contains(3);
        hashSet.add(2);
        hashSet.contains(2);
        hashSet.remove(2);
        hashSet.contains(2);

    }
}
