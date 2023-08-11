public class findDuplicateDriver {
    public static void main(String[] args) {
        System.out.println(new findDuplicateDriver().findDuplicate(new int[]{1,3,4,2,2}));
    }

    public int findDuplicate(int[] nums) {
      int first = 0;
      int slow = 0;

      do{
          first = nums[nums[first]];
          slow = nums[slow];
      }while ((first!=slow));

      first = 0;
      while (first!=slow){
          first=nums[first];
          slow=nums[slow];
      }
      return first;
    }
}
