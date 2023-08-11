package stackTrainning;

import java.util.ArrayList;
import java.util.Stack;

class StockSpanner {

    ArrayList<Integer> values = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();
    ArrayList<Integer> indexes = new ArrayList<>();

    public StockSpanner() {
        stack.push(-1);
    }

    public int next(int price) {

        int index = values.size()-1;
        while (index >=0 && values.get(index).intValue() <= price){
            index = indexes.get(index);
        }
        int span = (values.size())-index;
        indexes.add(index);
        values.add(price);
        return span;
    }

    public int next2(int price) {

        values.add(price);
        while(stack.peek() >=0 && values.get(stack.peek()) <= price){
            stack.pop();
        }
        int span = (values.size()-1)-stack.peek();
        stack.push(values.size()-1);
        return span;


    }
}


public class StockSpanDriver {
    public static void main(String[] args) {
        StockSpanner spanner = new StockSpanner();
        System.out.println(spanner.next(100));
        System.out.println(spanner.next(80));
        System.out.println(spanner.next(60));
        System.out.println(spanner.next(70));
        System.out.println(spanner.next(60));
        System.out.println(spanner.next(75));
        System.out.println(spanner.next(85));

    }
}
