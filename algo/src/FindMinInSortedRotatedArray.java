public class FindMinInSortedRotatedArray {

    public static void main(String args[]){
        System.out.println("akjdbkajsdb");
        System.out.println("x = "+getMinimumNum(new int[]{15}));
    }

    public static int getMinimumNum(int nums[]){

        int start = 0;
        int end = nums.length-1;

        while(start<end){
            int mid = ( start + end )/2;
            if(mid ==0){
                start = 1;
                continue;
            }
            if(nums[mid] < nums[mid-1]){
                return  nums[mid];
            }else if(nums[mid] < nums[end]){
                end = mid-1;
            }else {
                start = mid+1;
            }

        }
        return start;

    }
}
