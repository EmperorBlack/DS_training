package lpsArray;

import java.util.Arrays;

public class LpsArrayDriver {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(new LpsFinder().findLps("ABCABDABCABCABD")));
    }
}

class LpsFinder{

    public int[] findLps(String str){
        int []lps = new int[str.length()];
        int prefix = 0;
        int suffix = 1;

        lps[0] = 0;

        while(suffix < str.length()){

            if(str.charAt(prefix) == str.charAt(suffix)){
                lps[suffix] = prefix+1;
                prefix++;
                suffix++;
            }else{
                if(prefix == 0){
                    lps[suffix] =0;
                    suffix++;
                }else{
                    prefix = lps[prefix-1];
                }
            }


        }
        return lps;
    }







}
