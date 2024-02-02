package LeetCode75.maxWater;

public class MaxWaterDriver {

}
class Solution {
    public int maxArea(int[] height) {

        int maxWater = Integer.MIN_VALUE;

        int i = 0;
        int j = height.length-1;

        while(i < j){
            int area = (j-i) * Math.min(height[i],height[j]);
            if(area > maxWater){
                maxWater = area;
            }
            if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }

return maxWater;
    }
}
