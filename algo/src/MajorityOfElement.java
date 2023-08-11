import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MajorityOfElement {
    public static void main(String[] args) {

        System.out.println(new MajorityOfElement().majorityElement(new int[]{3,2,3}));
        System.out.println(new MajorityOfElement().majorityElementOpt(new int[]{3,2,3}));
        System.out.println(new MajorityOfElement().majorityElementNBy3(new int[]{2,2,1,3}));
    }

    public int majorityElement(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int n :nums
             ) {

                if(map.containsKey(n)){
                    int count = map.get(n) + 1;
                    if(count > nums.length/2){
                        return n;
                    }
                    map.put(n,count);
                }else {
                    map.put(n,1);
                }
        }
        return -1;
    }

    public int majorityElementOpt(int[] nums) {

        int count=0;
        int ele = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {

            if(count<=0){
                ele= nums[i];
                count++;
            }else {
                if(nums[i] == ele){
                    count++;
                }else {
                    count--;
                }
            }
        }
        return ele;
    }

    public List<Integer> majorityElementNBy3(int[] nums) {

        int count1=0;
        int count2=0;

        int ele1 = Integer.MAX_VALUE;
        int ele2 = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {

            if(count1==0 && ele2 != nums[i]){
                ele1= nums[i];
                count1++;
            }else if (count2 == 0 && ele1 != nums[i]){
                ele2 = nums[i];
                count2++;
            } else if (nums[i] == ele1) {
                count1++;
            } else if (nums[i] == ele2) {
                count2++;
            }else {
                count1--;
                count2--;
            }
        }
        count1 =0;
        count2 = 0;
        for (int n :nums
             ) {
            if(n == ele1){
                count1++;
            } else if (n == ele2) {
                count2++;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        if(count1 > (nums.length/3)){
            ans.add(ele1);
        }
        if(count2 > (nums.length)/3){
            ans.add(ele2);
        }
        return ans;
    }
}


