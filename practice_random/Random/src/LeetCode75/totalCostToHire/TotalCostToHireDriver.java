package LeetCode75.totalCostToHire;

import java.util.PriorityQueue;
import java.util.Queue;

public class TotalCostToHireDriver {

    public static void main(String[] args) {
        System.out.println(new Solution().totalCost(new int[]{17,12,10,2,7,2,11,20,8},3,4));
    }
}

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {

        Queue<Integer> front = new PriorityQueue<>();
        Queue<Integer> back = new PriorityQueue<>();


        int i =0;
        int count = candidates;
        while (count>0 && i < costs.length){
            front.offer(costs[i++]);
            count--;
        }

        int j = costs.length-1;
        count = candidates;
       while (j>=i && count > 0){
           back.offer(costs[j--]);
           count--;
       }

       Long result = 0l;
       while (k>0){

           int frontValue = !front.isEmpty() ? front.peek() : Integer.MAX_VALUE;
           int backValue = !back.isEmpty() ? back.peek() : Integer.MAX_VALUE;

           if(frontValue <= backValue){
               result = result+front.poll();
               if(i<=j){
                   front.offer(costs[i++]);
               }
           }else{
               result = result+back.poll();
               if(i<=j){
                   back.offer(costs[j--]);
               }
           }
           k--;
       }

    return result;
    }

    public long totalCost2(int[] costs, int k, int candidates) {

        Queue<Integer> front = new PriorityQueue<>();
        Queue<Integer> back = new PriorityQueue<>();



        int i =0;
        int j = costs.length-1;
        Long result = 0l;
        while (k>0){

            while(front.size() < candidates && i<=j){
                front.offer(costs[i++]);
            }

            while(back.size() < candidates && i<=j){
                back.offer(costs[j--]);
            }


            int frontValue = !front.isEmpty() ? front.peek() : Integer.MAX_VALUE;
            int backValue = !back.isEmpty() ? back.peek() : Integer.MAX_VALUE;

            if(frontValue <= backValue){
                result = result+front.poll();
            }else{
                result = result+back.poll();
            }
            k--;
        }

        return result;
    }
}

