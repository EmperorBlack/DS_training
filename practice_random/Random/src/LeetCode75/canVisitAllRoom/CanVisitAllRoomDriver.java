package LeetCode75.canVisitAllRoom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CanVisitAllRoomDriver {
    public static void main(String[] args) {

        System.out.println(new Solution().canVisitAllRooms(Arrays.asList(Arrays.asList(1),Arrays.asList(2),Arrays.asList(3),new ArrayList<>())));
    }
}

class Edge{
    int src;
    int dst;

    public Edge(int src, int dst) {
        this.src = src;
        this.dst = dst;
    }
}

class Solution {
    int count = 0;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean visited[] = new boolean[rooms.size()];
        dfs(rooms,visited,0);
        if(count == visited.length){
            return true;
        }
        return false;


    }

    public void dfs(List<List<Integer>> rooms,boolean visited[],int curr ){

        visited[curr] = true;
        count++;

        List<Integer> adjRooms = rooms.get(curr);
        for (int i = 0; i < adjRooms.size(); i++) {
            int adjKey = adjRooms.get(i);
            if(!visited[adjKey]){
                dfs(rooms,visited,adjKey);
            }
        }
    }
}
