public class maxSubarray {

    public static void main(String args[]){
        int input[] = new int[]{-1};


        int MAX_SO_FAR= Integer.MIN_VALUE;
        int SUM = 0;
        for(int i=0;i<input.length;i++){

            SUM = SUM+input[i];
            if(SUM > MAX_SO_FAR){
                MAX_SO_FAR = SUM;
            }
            if(SUM<0){
                SUM =0;
            }

        }
        System.out.print(MAX_SO_FAR);

    }
}
