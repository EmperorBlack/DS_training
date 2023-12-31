package anagramTest;

import java.util.Arrays;

public class ValidAnagramDriver {

    public static void main(String[] args) {
        System.out.println(new Solution().isAnagram("nagaram","anagram"));
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {

        char[] first = s.toCharArray();
        char[] second = t.toCharArray();
        Arrays.sort(first);
        Arrays.sort(second);
        return String.valueOf(first).equals(String.valueOf(second));
     }
}
