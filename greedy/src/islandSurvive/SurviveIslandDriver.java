package islandSurvive;

public class SurviveIslandDriver {
    public static void main(String[] args) {

        System.out.println(Solution.minimumDays(8, 34 ,1));
    }
}

class Solution{
    static int minimumDays(int S, int N, int M){

        int totalFoodUnit = S*M;
        int sundaysCount = S/7;
        int daysNeedToBuyFood = totalFoodUnit%N ==0 ? (totalFoodUnit / N) : (totalFoodUnit/N)+1;
        int totalDaysSheCanBuy = S-sundaysCount;
        if(totalDaysSheCanBuy >= daysNeedToBuyFood){
            return daysNeedToBuyFood;
        }else{
            return -1;
        }
        // code here
    }
}