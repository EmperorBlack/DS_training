import java.util.Arrays;

public class NmeetingInOneRoomDriver {

    public static void main(String[] args) {
        System.out.println();
    }
}

class Pair{
    int start;
    int end;

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }


}

class Solution
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {

        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(start[i],end[i]);
        }
        Arrays.sort(pairs,(o1,o2)-> o1.end - o2.end);
        Pair current = pairs[0];
        int count = 1;
        for (int i = 1; i < n; i++) {
            if(pairs[i].start > current.end){
                count++;
                current = pairs[i];
            }
        }
        return count;
    }
}