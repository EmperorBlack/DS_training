import java.util.Arrays;

public class SelectionSort {

    public static void main(String args[]){
        int input[] = new int[]{2,3,1,5,4};

        for(int i=0;i<input.length;i++){
            int smallPos = i;
            for(int j=i+1;j<input.length;j++){
                if(input[smallPos]>input[j]){
                    smallPos = j;
                }
            }
            if(smallPos != i){
                int temp = input[smallPos];
                input[smallPos] = input[i];
                input[i] = temp;
            }
        }
        System.out.println("sorted array after selection sorting ==> "+ Arrays.toString(input));
    }
}
