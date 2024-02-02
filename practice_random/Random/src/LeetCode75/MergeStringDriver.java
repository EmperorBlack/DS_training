package LeetCode75;

public class MergeStringDriver {
    public static void main(String[] args) {

        System.out.println(new Solution().mergeAlternately("abc","pqr"));
    }
}

class Solution {
    public String mergeAlternately(String word1, String word2) {


        int ind = 0;

        StringBuilder result = new StringBuilder();
        while (ind < word1.length() && ind < word2.length()){

            result.append(word1.charAt(ind)).append(word2.charAt(ind));
            ind++;

        }

        if(ind < word1.length()){
            result.append(word1.substring(ind,word1.length()));
        }
        if(ind < word2.length()){
            result.append(word2.substring(ind,word2.length()));
        }

        return result.toString();
    }
}