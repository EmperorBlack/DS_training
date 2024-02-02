package LeetCode75.highestAltitude;

public class HighestAltitudeDriver {
    public static void main(String[] args) {

        System.out.println(new Solution().largestAltitude(new int[]{
                -4,-3,-2,-1,4,3,2
        }));
    }
}

  class Solution{
      public int largestAltitude(int[] gain) {

          int maxAlti =0;
          int altiAt = 0;

          for (int i = 0; i < gain.length; i++) {
              altiAt += gain[i];
              if(altiAt > maxAlti){
                  maxAlti = altiAt;
              }
          }
          return maxAlti;

      }
  }
