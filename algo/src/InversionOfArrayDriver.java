import java.util.Arrays;

public class InversionOfArrayDriver {

    static int inversionCount = 0;
    public static void main(String[] args) {

        int arr[] = new int[]{3,2,1};
        InversionOfArrayDriver d = new InversionOfArrayDriver();
        d.mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        System.out.println(inversionCount);


    }

    public void mergeSort(int nums[],int start, int end){
        if(start < end ){
            int mid = (start+end)/2;
            mergeSort(nums,start,mid);
            mergeSort(nums,mid+1,end);
            merge(nums,start,mid,end);
        }
    }

    public void merge(int nums[],int start, int mid , int end){
        int left[] = new int[(mid-start)+1];
        int right[] = new int[end-mid];

        for (int i = 0; i < left.length; i++) {
            left[i] = nums[start+i];
        }

        for (int j = 0; j < right.length; j++) {
            right[j] = nums[mid+1+j];
        }

        int k = start;
        int i =0;
        int j =0;
        while(i<left.length && j < right.length){
            if(left[i] <= right[j]){
                nums[k] = left[i];
                i++;
            }else {
                nums[k] = right[j];
                inversionCount = inversionCount+(left.length-i);
                j++;
            }
            k++;
        }
        while (i < left.length){
            nums[k] = left[i];
            k++;
            i++;
        }
        while (j < right.length){
            nums[k] = right[j];
            k++;
            j++;
        }

    }
}


