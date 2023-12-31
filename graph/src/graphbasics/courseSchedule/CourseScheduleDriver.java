package graphbasics.courseSchedule;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class CourseScheduleDriver {

    public static void main(String[] args) {

        System.out.println(new Solution().canFinish2(20 , new int[][]{{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}}));

    }

}

class Edge{
    int dst;
    int src;

    public Edge(int dst, int src) {
        this.dst = dst;
        this.src = src;
    }
}

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<Edge>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {

            int[] preReq = prerequisites[i];
            if(graph[preReq[1]] != null){
               ArrayList list = graph[preReq[1]];
               list.add(new Edge(prerequisites[i][0],prerequisites[i][1]));
            }else {
                ArrayList<Edge> list = new ArrayList<>();
                list.add(new Edge(prerequisites[i][0],prerequisites[i][1]));
                graph[preReq[1]] = list;
            }

        }

        int inDegrees[] = new int[numCourses];
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < graph.length; i++) {
            if(graph[i] != null){
                for (int j = 0; j < graph[i].size(); j++) {
                    inDegrees[graph[i].get(j).dst]++;
                }
            }

        }

        for (int i = 0; i < inDegrees.length; i++) {
            if(inDegrees[i] ==0){
                queue.offer(i);
            }
        }

        int count =0;
        while (!queue.isEmpty()){

            int e = queue.poll();
            count++;
            if (graph[e] != null){
                for (int i = 0; i < graph[e].size(); i++) {
                    Edge edge = graph[e].get(i);
                    inDegrees[edge.dst]--;
                    if(inDegrees[edge.dst] == 0){
                        queue.offer(edge.dst);
                    }

                }
            }
        }

        if(count != numCourses){
            return false;
        }
        return true;
    }

    public boolean canFinish2(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {

            int[] preReq = prerequisites[i];
                ArrayList list = graph.get(preReq[1]);
                list.add(prerequisites[i][0]);
        }

        int inDegrees[] = new int[numCourses];
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < graph.size(); i++) {
            if(graph.get(i) != null){
                for (int j = 0; j < graph.get(i).size(); j++) {
                    inDegrees[graph.get(i).get(j)]++;
                }
            }

        }

        for (int i = 0; i < inDegrees.length; i++) {
            if(inDegrees[i] ==0){
                queue.offer(i);
            }
        }

        int count =0;
        while (!queue.isEmpty()){

            int e = queue.poll();
            count++;

                for (int edge : graph.get(e)
                     ) {

                    inDegrees[edge]--;
                    if (inDegrees[edge] == 0) {
                        queue.offer(edge);
                    }
                }


        }

        if(count != numCourses){
            return false;
        }
        return true;
    }
}
