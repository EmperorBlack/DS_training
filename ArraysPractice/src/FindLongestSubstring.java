import java.util.Arrays;

public class FindLongestSubstring {

    public static void main(String args[]){
//        String subString = "kart";
//        System.out.println("kartik".substring(0,subString.length()).equals(subString));
        String a[] = new String[]{"flow","flower","flight"};
        System.out.println(findLongestPrefixedSubstring(a));
//        System.out.println(longestCommonPrefix(a));

    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        Arrays.sort(strs);
        System.out.println(Arrays.toString(strs));
        String first = strs[0];
        String last = strs[strs.length - 1];
        int c = 0;
        while(c < first.length())
        {
            if (first.charAt(c) == last.charAt(c))
                c++;
            else
                break;
        }
        return c == 0 ? "" : first.substring(0, c);

    }
    public static String findLongestPrefixedSubstring(String array[]){
//        Arrays.sort(array);
//        System.out.println(Arrays.toString(array));
//
//        Arrays.sort(array,(o1, o2) ->{
//                    if(o1.length() > o2.length()){
//                        return 1;
//                    }else if (o1.length() < o2.length()){
//                        return -1;
//                    }else
//                        return 0;
//                }
//                );

        String subString =array[0];
        int index = 1;
        while(index < array.length){
            if(subString.length()<=0){
                break;
            }
            while(!array[index].startsWith(subString)){
                if(subString.length()<=0){
                    break;
                }
                subString = subString.substring(0,subString.length()-1);
            }
            index++;

        }
//        System.out.println(Arrays.toString(array) );
        return subString;
    }
}
