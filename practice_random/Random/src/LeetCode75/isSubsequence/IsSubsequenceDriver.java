package LeetCode75.isSubsequence;

public class IsSubsequenceDriver
{
    public static void main(String[] args) {

        System.out.println(new Solution().isSubsequence("abc","ahbgdc"));
    }
}

class Solution {
    public boolean isSubsequence(String s, String t) {

        int i =0;
        for (int j = 0; j < t.length(); j++) {

            if(t.charAt(j) == s.charAt(i)){
                i++;
                if(i == s.length()){
                    return true;
                }
            }
        }
        if(i == s.length()){
            return true;
        }else{
            return false;
        }
    }
}