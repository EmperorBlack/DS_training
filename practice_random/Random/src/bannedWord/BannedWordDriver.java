package bannedWord;

import java.util.*;

public class BannedWordDriver {

    public static void main(String[] args) {

//                ["hit"]
//        System.out.println(new Solution().mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",new String[]{"hit"}));
        System.out.println(new Solution().mostCommonWord("Bob! marry",new String[]{"hit"}));
    }


}

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {


        Set<String> banWord = new HashSet<>();
        for (String bWord: banned
             ) {
            banWord.add(bWord);
        }

        Map<String,Integer> map = new HashMap<>();

        String result = "";
        int max = Integer.MIN_VALUE;

        for ( String word: paragraph.split("[!?',;. ]")
             ) {
            word = word.toLowerCase().trim();

            if(!word.isEmpty() && !banWord.contains(word)){
                map.put(word, map.getOrDefault(word,0)+1);
                if(map.get(word) > max){
                    max = map.get(word);
                    result = word;
                }
            }

        }
        return result;




    }


}
