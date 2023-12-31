package HeapBasics;

class MinHeap{
    private int[] heapArray;
    private int capacity;
    private int currentSize;

    MinHeap(int capacity){
        this.capacity = capacity;
        currentSize = 0;
        heapArray = new int[capacity];
    }

   public  int getParent(int key){
        return (key-1)/2;
   }

   public int getLeft(int key){
        return (key*2)+1;
   }

   public int getRight(int key){
        return (key*2)+2;
   }

   public void swap(int i,int j){
        int temp = heapArray[i];
        heapArray[i] = heapArray[j];
        heapArray[j] = temp;
   }

   public boolean insertKey(int key){
        if(currentSize == capacity){
            return false;
        }
        int i = currentSize;
        heapArray[currentSize++] = key;

        while(i!=0 && heapArray[i] < heapArray[getParent(i)]){
            swap(i,getParent(i));
            i = getParent(i);
        }
        return true;
   }

   public void decreaseKey(int key , int newVal){
        heapArray[key] = newVal;

        while(key != 0 && heapArray[key] < heapArray[getParent(key)] ){
            swap(key,getParent(key));
            key = getParent(key);
        }
   }

   public int getMin(){
        return heapArray[0];
   }

   public int extractMin(){

        if(currentSize <=0){
            return Integer.MAX_VALUE;
        }

        if(currentSize == 1){
            return heapArray[--currentSize];
        }
        int root =heapArray[0];

        heapArray[0] = heapArray[--currentSize];
        minHeapify(0);
        return root;
   }

   public void minHeapify(int key){
        int l = getLeft(key);
        int r = getRight(key);
        int small = key;
        if(l< currentSize && heapArray[l] < heapArray[small]){
            small = l;
        }

       if(r< currentSize && heapArray[r] < heapArray[small]){
           small = r;
       }
       if(key != small){
           swap(key,small);
           minHeapify(small);
       }
   }

   public void increaseKey(int key, int newVal){
        heapArray[key] = newVal;
        minHeapify(key);
   }

   public void deleteKey(int key){
        heapArray[key] = heapArray[--currentSize];
        minHeapify(key);
   }

}

public class MinHeapDriver {

    public static void main(String[] args) {
        MinHeap h = new MinHeap(11);
        h.insertKey(3);
        h.insertKey(2);
        h.deleteKey(1);
        h.insertKey(15);
        h.insertKey(5);
        h.insertKey(4);
        h.insertKey(45);
        System.out.print(h.extractMin() + " ");
        System.out.print(h.getMin() + " ");

        h.decreaseKey(2, 1);
        System.out.print(h.getMin());
    }
}
