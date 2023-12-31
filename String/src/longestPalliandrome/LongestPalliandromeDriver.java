package longestPalliandrome;

public class LongestPalliandromeDriver {
    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("cbaabd"));
    }

}

class Solution {
    static String maxString = "";
    public String longestPalindrome(String s) {

        for (int k = 0; k < s.length(); k++) {
            checkLongest(k,k,s);
            checkLongest(k-1,k,s);
        }
        return maxString;
    }

    public void checkLongest(int i, int j, String s){

        while(i >=0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            if(maxString.length() < (j-i)+1){
                maxString = s.substring(i,j+1);
            }
            i--;
            j++;
        }

    }
}
