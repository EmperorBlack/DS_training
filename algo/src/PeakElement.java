public class PeakElement {
    public static void main(String args[]){
        System.out.println(PeekElement(new int[]{1,2,3},3));
    }

    public static int PeekElement(int[] arr,int n){
        if(arr.length == 0){
            return 0;
        }
        if(arr.length > 1 && arr[0]>arr[1]){
            return 0;
        }
        for(int i =1;i<arr.length-1;i++){
            if(arr[i] >= arr[i-1] && arr[i]>=arr[i+1]){
                return i;
            }
        }
        if(arr.length > 1 && arr[arr.length-1]>arr[arr.length-2]){
            return arr.length-1;
        }
        return 0;
    }
}
