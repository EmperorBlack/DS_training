package LeetCode75.reverseSentence;

public class ReverseSentenceDriver {

    public static void main(String[] args) {

        System.out.println(new Solution().reverseWords("the sky is blue"));
    }
}

class Solution {
    public String reverseWords(String s) {

        StringBuffer result = new StringBuffer();
        String[] splitArr = s.split(" ");
        for (int i = splitArr.length-1 ; i >=0 ; i--) {
            String word = splitArr[i].trim();
            if(!word.isEmpty()){
                result.append(word+" ");
            }
        }
        return result.toString().trim();
    }
}