package LeetCode75.flowerBed;

public class FlowerBedDriver {
    public static void main(String[] args) {

    }
}


class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int count =0;
        if(flowerbed.length == 1 && flowerbed[0] ==0 ){
           count = 1;
        }


        for (int i = 0; flowerbed.length > 1 && i < flowerbed.length; i++) {

            if(flowerbed[i] ==0){
                if(i ==0){
                    if(flowerbed[i+1] != 1){
                        count++;
                        flowerbed[i] =1;
                    }
                } else if (i == flowerbed.length-1) {

                    if(flowerbed[i-1] != 1){
                        count++;
                        flowerbed[i] =1;
                    }
                }else {
                    if(flowerbed[i-1] !=1 && flowerbed[i+1] !=1){
                        count++;
                        flowerbed[i] =1;
                    }
                }
            }



        }
        if(count >= n){
            return true;
        }else{
            return false;
        }

    }
}