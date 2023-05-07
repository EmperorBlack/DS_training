import java.util.Arrays;

public class Test {

    public static void main(String args[]){

        int nums1[] = new int[]{1, 2, 3, 0, 0, 0};
        int nums2[] = new int[]{2, 5, 6};
        int n = 3;
        int m = 3;



        int sortedIndex = nums1.length-1;
        int firstArray = m-1;
        int secondArray = n-1;
        while(sortedIndex >= 0) {

            if( firstArray >= 0 && (secondArray < 0 || nums1[firstArray] > nums2[secondArray])){
                nums1[sortedIndex] = nums1[firstArray];
                firstArray--;
                sortedIndex--;
            }else{
                nums1[sortedIndex] = nums2[secondArray];
                secondArray--;
                sortedIndex--;
            }

        }


        System.out.print(Arrays.toString(nums1));
    }

}
