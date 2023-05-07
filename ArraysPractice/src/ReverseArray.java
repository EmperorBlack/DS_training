import java.util.Arrays;

public class ReverseArray {

    public static void main(String args[]){

        System.out.println("printing main content");

        int []input = new int[]{2,3,5,7,8, 9};
        int reverse = input.length-1;
        for(int i=0;i<reverse;i++){
            int temp = input[i];
            input[i] = input[reverse];
            input[reverse] = temp;
            reverse--;
        }
        System.out.println(Arrays.toString(input));
    }
}
