public class FlowerBed {
    public static void main(String args[]){
        System.out.println(canPlaceFlower(new int[]{1,0,1,0,1,0,1},1));
    }
    public static boolean canPlaceFlower(int[] flowerBed,int n){
            if(flowerBed.length<2){
                if(flowerBed[0] == 0){
                    n--;
                }
            }else{
                if(flowerBed[0] == 0 && flowerBed[1] ==0){
                    flowerBed[0] = 1;
                    n--;
                }

                for(int i=1;i<flowerBed.length-1;i++)
                {
                    if(n <= 0){
                        return true;
                    }else if(flowerBed[i]==0 && (flowerBed[i-1]==0 && flowerBed[i+1]==0)) {
                        flowerBed[i] =1;
                        n--;
                    }
                }
                if(flowerBed[flowerBed.length-2] == 0 && flowerBed[flowerBed.length-1] ==0){
                    flowerBed[flowerBed.length-1] = 1;
                    n--;
                }
            }



        if(n<= 0)
            return true;
        else
            return false;

    }
}
