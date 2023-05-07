public class BinarySearchRecursion {

    public static void main(String a[]) {
        int[] nums = new int[]{5,1,3};
        int target = 3;
        System.out.println(bSearch(nums, target, 0, nums.length - 1));
    }


    public static int bSearch(int[] nums, int target, int l, int h) {


        if(l > h){
            return -1;
        }

        int mid = (l + h) / 2;
        if (nums[mid] == target) {
            return mid;
        }

        if (nums[mid] >= nums[l]) {

            if ((target >= nums[l] && target <= nums[mid])) {
               return  bSearch(nums, target, l, mid - 1);
            }
               return  bSearch(nums, target, mid + 1, h);

        }
        if ((target >= nums[mid] && target <= nums[h])) {
            return bSearch(nums, target, mid + 1, h);
        }
            return  bSearch(nums, target, l, mid - 1);


    }
}



