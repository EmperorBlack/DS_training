import java.util.Arrays;

public class TwoSumSorted {

    public static void main(String args[]){
        int []a = new int[]{5,25,75};
        System.out.println(Arrays.toString(getSortedTwoSumOptimal(a,100)));
    }

    public static int[] getSortedTwoSumOptimal(int array[],int target){
        int i =0,j=array.length-1;
        while(i<j){
            if(array[i]+array[j] == target){
                return new int[]{i+1,j+1};
            } else if (array[i]+array[j] > target) {
                j--;
            }else {
                i++;
            }
        }
        return null;
    }
    public static int[] getSortedTwoSumIndex(int array[],int target){
        for(int i =0;i<array.length-1;i++){
            int j = i+1;
            while( (j < array.length) && (array[j] < target-array[i]) ){
                ++j;
            }
            if(j < array.length && target-array[i] == array[j]){
                return new int[]{i+1,j+1};
            }
        }
        return null;
    }

    public static int[] getTwoSumIndex(int arr[],int target){
        for(int i=0;i<arr.length-1;i++){
            int num = binarySearch(arr,i+1,arr.length-1,target-arr[i]);
            if( num!= -1){
                return new int[]{i,num};
            }
        }
        return null;
    }

    public static int binarySearch(int array[], int i, int j,int target){

        if(i<=j){
            int mid = (i+j)/2;
            if(array[mid] == target){
                return mid;
            } else if (array[mid] > target) {
                return binarySearch(array,i,mid-1,target);
            }else {
                return binarySearch(array,mid+1,j,target);
            }
        }
        return -1;
    }
}
