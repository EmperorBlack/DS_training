package BookLibraryInterview;


import java.util.*;

public class BookLibraryDriver {
    public static void main(String[] args) {

       new Solution().getCount(new int[]{6,6,2,-6,-2,-6});

////        TreeSet<Value> set = new TreeSet<>((v,v1)->Integer.compare(v.val,v1.val));
//        Queue<Value> queue = new PriorityQueue<>((v1,v2)->Integer.compare(v1.val,v2.val));
//
//        Value val1 = new Value(1);
//
//       Value val2 = new Value(2);
//        System.out.println(queue);
    }

}
class Value{
    int val;

    public Value(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Value{" +
                "val=" + val +
                '}';
    }
}

class Solution{


    public void getCount(int[] bookId){

        Queue<Value> queue = new PriorityQueue<>((v1,v2)->Integer.compare(v2.val,v1.val));
        Map<Integer,Value> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < bookId.length; i++) {

            boolean isNegative = bookId[i] < 0 ? true: false;
            int key = Math.abs(bookId[i]);

            if(map.containsKey(key)){
                Value value = map.get(key);
                queue.remove(value);
                if(isNegative){
                    value.val = value.val-1;
                }else{
                    value.val = value.val+1;
                }
                if(value.val <= 0){
                    map.remove(key);
                }else{
                    queue.offer(value);
                }

            }else{
                Value v = new Value(1);
                map.put(key,v);
                queue.offer(v);
            }

            if(queue.size() == 0){
                result.add(0);
            }else{
                result.add(queue.peek().val);
            }

        }


        System.out.println(result);
    }
}
