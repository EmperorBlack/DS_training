package stackTrainning;

class Solution8 {
//    public static int findCelebrity(int n) {
//        int in[] = new int[n];
//        int out[] = new int[n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//
//                if(Runner.knows(i,j)){
//                    in[j]++;
//                    out[i]++;
//                }
//            }
//
//        }
//        for (int i = 0; i < n; i++) {
//            if(in[i] == n-1 && out[i] == 0){
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    public static int findCelebrity(int n) {
//
//        int c =0;
//        for (int i = 1; i < n; i++) {
//            if(Runner.knows(c,i)){
//                c=i;
//            }
//        }
//
//        for (int i = 0; i < n; i++) {
//           if(i!=c &&( Runner.knows(c,i) || !Runner.knows(i,c)) ){
//               return -1;
//           }
//        }
//        return c;
//    }
}

public class CelebretyProblem {
    public static void main(String[] args) {

    }
}
