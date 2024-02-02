package LeetCode75.guessNumber;

public class GuessNumberDriver {
}

class GuessNumber{

    int guess(int num){
        return 1;
    }

}


class Solution extends GuessNumber{
    public int guessNumber(int n) {

        int start = 0;
        int end = n;
        while(start <= end){
            int gNum = start + (end-start)/2;
            int compareValue = guess(gNum);
            if(compareValue == -1){
                end = gNum-1;
            } else if (compareValue == 1) {
                start = gNum+1;
            }else{
                return gNum;
            }

        }
        return -1;

    }
}