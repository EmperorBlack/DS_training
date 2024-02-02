package LeetCode75.dota2Senate;

import java.util.ArrayDeque;
import java.util.Queue;

public class Dota2SenateDriver {
    public static void main(String[] args) {

        System.out.println(new Solution().predictPartyVictory("RDD"));
    }
}

class Solution {
    public String predictPartyVictory(String senate) {

        Queue<Integer> rad = new ArrayDeque<>();
        Queue<Integer> dire = new ArrayDeque<>();

        for (int i = 0; i < senate.length(); i++) {

            if(senate.charAt(i) == 'R'){
                rad.offer(i);
            }else{
                dire.offer(i);
            }
        }

        while(!rad.isEmpty() && !dire.isEmpty()){
            int radPeek = rad.peek();
            int direPeek = dire.peek();

            if(radPeek < direPeek){
                dire.poll();
                rad.poll();
                rad.offer(radPeek+senate.length());
            }else{
                dire.poll();
                rad.poll();
                dire.offer(direPeek+senate.length());
            }
        }

        if(rad.isEmpty()){
            return "Dire";
        }else{
            return "Radiant";
        }


    }
}
