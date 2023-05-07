import java.util.Arrays;

public class QuickSortMain {
    public static void main(String args[]){

        int[] input = new int[]{2,9,4,3,6,5,1};
        quickstart(input,0,input.length-1);
        System.out.println(Arrays.toString(input));
    }

    public static void quickstart(int[] arr,int low, int high){

        if(low<high){
            int middle = partition(arr,low,high);
            quickstart(arr,low,middle-1);
            quickstart(arr,middle+1,high);
        }
    }

    public static int partition(int[] arr,int low,int high){

        int pivot = arr[high];
        int i = low-1;
        for(int j = low;j<high;j++){
            if(arr[j]<pivot){
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        int tmp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] =tmp;

        return i+1;


    }
}
