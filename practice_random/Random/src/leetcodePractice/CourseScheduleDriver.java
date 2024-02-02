package leetcodePractice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class CourseScheduleDriver {
    public static void main(String[] args) {

        System.out.println(new Solution().canFinish(2, new int[][]{{1,0}}));
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
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<Edge> graph[] = new ArrayList[numCourses];
        int []inDegree = new int[numCourses];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edges: prerequisites
             ) {
          inDegree[edges[0]]++;
          graph[edges[1]].add(new Edge(edges[1],edges[0]));
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < inDegree.length; i++) {
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()){
            int curr = queue.poll();
            count++;
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                inDegree[e.dst]--;
                if(inDegree[e.dst] ==0){
                    queue.offer(e.dst);
                }
            }
        }

        return count == numCourses ? true : false;

    }
}
