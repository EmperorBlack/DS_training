package LeetCode75.reverseVowel;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowelDriver {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseVowels("hello"));
    }

}

class Solution {
    public String reverseVowels(String s) {

        Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));

        String vowel = "";
        for (int i = 0; i < s.length(); i++) {
            if(set.contains(s.charAt(i))){
                vowel = vowel+s.charAt(i);
            }
        }

        int ind = 0;
        String result = "";
        for (int i = s.length()-1; i >= 0 ; i--) {
            if(set.contains(s.charAt(i))){
               result = vowel.charAt(ind)+result;
               ind++;
            }else{
                result = s.charAt(i)+result;
            }
        }

        return result;
    }
}