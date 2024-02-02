package LeetCode75.stringCompress;

public class StringCompressDriver {
    public static void main(String[] args) {

        System.out.println(new Solution().compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
    }
}

class Solution {
    public int compress(char[] chars) {


        char current = chars[0];
        int count = 1;
        int ind = 0;
        for (int i = 1; i < chars.length; i++) {

            if(current != chars[i]){

                chars[ind] = current;
                ind++;
                if(count > 1){
                    String countStr = String.valueOf(count);
                    for (int j = 0; j < countStr.length(); j++) {
                        chars[ind] = countStr.charAt(j);
                        ind++;
                    }
                }
                current = chars[i];
                count=1;
            }else{
                count++;
            }

        }
        chars[ind] = current;
        ind++;
        if(count > 1){
            String countStr = String.valueOf(count);
            for (int j = 0; j < countStr.length(); j++) {
                chars[ind] = countStr.charAt(j);
                ind++;
            }
        }


        return ind;

    }
}

