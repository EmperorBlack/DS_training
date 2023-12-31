package FindIndexOf;

public class IndexOfDriver {
    public static void main(String[] args) {

        System.out.println(new Solution().strStr("hello","ll"));
    }
}

class Solution {
    public int strStr(String haystack, String needle) {

        int pInd =0;
        int sInd=0;
        int lps[] = findLps(needle);

        while(pInd < needle.length()){

            if(sInd >= haystack.length()){
                return -1;
            }

            if(haystack.charAt(sInd) == needle.charAt(pInd)){
                pInd++;
                sInd++;

            }else{
                if(pInd==0){
                    sInd++;
                }else{
                    pInd = lps[pInd-1];
                }
            }
        }
        return sInd-pInd;

    }

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
