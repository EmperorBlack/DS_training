import java.util.Arrays;

public class InsertionSort {
    public static void main(String arg[]){

        int[] input = new int[]{2,9,4,3,6,5,1};
        for(int i=1;i<input.length;i++){
            int j = i-1;
            int pivot = input[i];
            while(j>=0 && pivot<input[j]){
                input[j+1] = input[j];
                j--;
            }
            input[j+1] = pivot;
        }
        System.out.println(Arrays.toString(input));
    }
}
