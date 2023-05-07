public class BinarySearch {
    public static void main(String a[]){

       int input[] = new int[]{2,5,7,8,11,40,80,100,234,345,500,551,562};

       int search = 10;

       int l=0,h=input.length-1;

       while(l<h){
           int middle = (l+h)/2;
           if(input[middle] == search){
               System.out.println(middle);
               break;
           } else if (input[middle]<search) {
               l=middle+1;
           }else {
               h = middle-1;
           }

       }


    }
}
