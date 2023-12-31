package atoiFunction;

import java.util.HashMap;
import java.util.Map;

public class AtoiDriver {
    public static void main(String[] args) {

        System.out.println(new Solution().myAtoi("123"));
        System.out.println(Integer.MAX_VALUE);

    }
}
class Solution {
    public int myAtoi(String s) {


        Map<Character,Integer> map = new HashMap<>();

        int j =0;
        for (char i = '0'; i < '0'+10; i++) {
            map.put(i,j);
            j++;
        }
        String str = s.trim();
        if(str.length() == 0 ){
            return 0;
        }
        boolean isNegative = false;
        int ind = 0;
        if(str.charAt(0) == '-'){
            isNegative = true;
            ind = 1;
        } else if (str.charAt(0) == '+') {
            ind = 1;
        }
        int result = 0;
        while(ind < str.length() && map.containsKey(str.charAt(ind))){
            int multiplyer = 10;
            int digit = map.get(str.charAt(ind));
            if(Integer.MAX_VALUE/10 < result || Integer.MAX_VALUE/10 == result && Integer.MAX_VALUE %10 < digit){
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = (result * multiplyer) + digit;
            ind++;
        }
        if(isNegative){
            result = -(result);
        }

        return result;
    }
}
