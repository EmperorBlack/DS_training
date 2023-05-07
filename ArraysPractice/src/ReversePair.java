import java.util.Arrays;

public class ReversePair {

    public static void main(String args[]){
      int  []nums =new int[]{2,4,3,5,1};
//      System.out.println(reversePairs(nums));
        reversePairs(nums);
    }
    public static void reversePairs(int[] nums) {

        System.out.println(mergeSort(nums,0,nums.length-1) +""+ Arrays.toString(nums));



    }

    public static int mergeSort(int nums[],int left, int right){
         if(left<right){
             int middle = (left+right)/2;
             int count = mergeSort(nums,left,middle);
             count += mergeSort(nums,middle+1,right);
             count += merge(nums,left,middle,right);
             return count;
         }
         return 0;
    }

    public static int merge(int nums[],int left,int mid, int right){
            int l = left;
            int r= mid+1;
            int count = 0;
           while(l<=mid && r <=right){
               if(nums[l] > nums[r] * 2){
                   count += (mid-l)+1;
                   r++;
               }else{
                   l++;
               }
           }
           l = left;
           r= mid+1;
           int k = 0;
           int []temp = new int[(right-left)+1];
           while(l<=mid && r<=right){
               if(nums[l]<=nums[r]){
                   temp[k] = nums[l];
                   l++;
               }else {
                   temp[k] = nums[r];
                   r++;
               }
               k++;
           }
           while(l<=mid){
               temp[k] = nums[l];
               l++;
               k++;
           }
            while(r<=right){
                temp[k] = nums[r];
                r++;
                k++;
            }
            for(int i = left,z=0;i<=right;i++,z++){
                nums[i] = temp[z];
            }
           return count;

    }


}


//        int count = 0;
//        for(int i=0;i<nums.length-1;i++){
//            for(int j =i+1;j< nums.length;j++){
////                long value = (long)nums[j] * 2;
//                if(nums[i] >= nums[j] && nums[i] > (long)nums[j] * 2){
//                    count ++;
//                }
//
//            }
//        }
//        return count;

//bruteforce