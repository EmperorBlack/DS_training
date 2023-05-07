public class MaxProductSubArray {
    public static void main(String args[]){
        System.out.println(findMaxSubArray(new int[]{-2,0}));
    }

    public static long findMaxSubArray(int nums[]){

        long minValue = nums[0];
        long maxValue = nums[0];
        long maxSoFar = nums[0];

        for(int i=1;i<nums.length;i++){

            if(nums[i] > 0){
                 minValue= Math.min(nums[i],minValue*nums[i] );
                maxValue = Math.max(nums[i],maxValue*nums[i] );
            } else if (nums[i] < 0) {
                long tmp = minValue;
                minValue = maxValue;
                maxValue = tmp;

                minValue = Math.min(nums[i],minValue*nums[i] );
                maxValue = Math.max(nums[i],maxValue*nums[i] );
            }else{
                minValue = nums[i];
                maxValue = nums[i];
            }
            maxSoFar = maxSoFar > maxValue ? maxSoFar : maxValue;

        }
        return maxSoFar;
    }
}
