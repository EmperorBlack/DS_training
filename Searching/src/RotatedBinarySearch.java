public class RotatedBinarySearch {

    public static void main(String a[]){
        int[] nums = new int[]{100,110,50,60,70,80,100};
        int target = 0;
       System.out.println(bSearch(nums,target,0,nums.length-1));
    }




    public static int bSearch(int[] nums, int target,int l ,int h){

        while(l<=h){
            int mid = (l+h)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > nums[l] ){

                if((target>=nums[l] && target<nums[mid])) {
                    h= mid-1;
                }else{
                    l=mid+1;
                }
            }else {
                if((target>nums[mid] && target<=nums[h])) {
                    l= mid+1;
                }else{
                    h=mid-1;
                }
            }

        }
        return  -1;


    }

}
