package longestCommonPrefix;

import java.util.Arrays;

public class LongestCommonPrefixDriver {

    public static void main(String[] args) {

        String s[] = new String[]{"abdc","abe","abf"};
        System.out.println(new Solution().longestCommonPrefix(s));


    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
       String s1 = strs[0];
       String s2 = strs[strs.length-1];
       int ind =0;
       while (ind < s1.length() && ind < s2.length()){
           if(s1.charAt(ind) != s2.charAt(ind)){
               break;
           }else{
               ind++;
           }
       }
       return s1.substring(0,ind);
    }
}

