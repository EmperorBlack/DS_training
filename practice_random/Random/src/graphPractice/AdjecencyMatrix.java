package graphPractice;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Edge{
    int src;
    int dst;

    public Edge(int src, int dst) {
        this.src = src;
        this.dst = dst;
    }

    @Override
    public String toString() {
        return this.src+"-"+this.dst;
    }
}

public class AdjecencyMatrix {

    public static void main(String[] args) {
        buildEdges();
    }

    public static void buildEdges(){
        ArrayList<Edge> list[] = new ArrayList[4];
        for (int i = 0; i < 4; i++) {
            list[i] = new ArrayList<>();
        }

        list[0].add(new Edge(0,2));
        list[1].add(new Edge(1,2));
        list[1].add(new Edge(1,3));
        list[2].add(new Edge(2,0));
        list[2].add(new Edge(2,1));
        list[2].add(new Edge(2,3));
        list[3].add(new Edge(3,1));
        list[3].add(new Edge(3,2));

        System.out.println(Arrays.toString(list));
    }

}
