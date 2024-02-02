package LeetCode75.noOfProvinience;

import java.util.List;

public class NumberOfProvinenceDriver {
    public static void main(String[] args) {

    }
}

class Solution {

    public int findCircleNum(int[][] isConnected) {

        int count = 0;
        boolean visited[] = new boolean[isConnected.length];
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]){
                count++;
                dfs(isConnected,visited,i);
            }

        }
        return count;


    }
    public void dfs(int[][] cities, boolean visited[], int curr ){

        visited[curr] = true;

        int[] adjCities = cities[curr];
        for (int i = 0; i < adjCities.length; i++) {
            if(cities[curr][i] == 1 && !visited[i]){
                dfs(cities,visited,i);
            }
        }
    }
}
