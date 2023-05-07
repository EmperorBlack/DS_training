import java.util.Arrays;

public class BubbleSort {

    public static void main(String args[]){

        int[] input = new int[]{2,9,4,3,6,5,1};

        for(int i=0;i<input.length-1;i++){
            for(int j =0;j<input.length-(1+i);j++){
                if(input[j]>input[j+1]){
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(input));

    }
}
