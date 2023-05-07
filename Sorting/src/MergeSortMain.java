import java.util.Arrays;

public class MergeSortMain {


    public static void main(String a[]){
        int[] input = new int[]{2,9,4,3,6,5,1};
        sort(input,0,input.length-1);
        System.out.println(Arrays.toString(input));
    }

    public static void sort(int arr[],int l,int h){

        if(l<h){
            int middle=(l+h)/2;
            sort(arr,l,middle);
            sort(arr,middle+1,h);
            merge(arr,l,middle,h);
        }
    }

    public static void merge(int arr[],int l, int m,int h){
        int n1=m-l+1,n2=h-m;
        int la[] = new int[n1];
        int ra[] = new int[n2];

        for(int i=0;i<n1;i++){
            la[i] = arr[l+i];
        }
        for(int i=0;i<n2;i++){
            ra[i] = arr[m+i+1];
        }

        int i=0,j=0,k=l;

        while(i<n1 && j<n2){
            if(la[i]<ra[j]){
                arr[k]=la[i];
                i++;
            }else{
                arr[k]=ra[j];
                j++;
            }
            k++;
        }

        while(i<n1){
            arr[k]=la[i];
            i++;
            k++;

        }
        while(j<n2){
            arr[k]=ra[j];
            j++;
            k++;
        }


    }
}
