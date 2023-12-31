package graphbasics.wordLadder1;

import java.util.*;

public class WordLadderDriver {

    public static void main(String[] args) {
        System.out.println(new Solution().ladderLength("hit","cog",Arrays.asList("hot","dot","dog","lot","log","cog")));
    }
}

class Pair{
    String word;
    int transformations;

    public Pair(String word, int transformations) {
        this.word = word;
        this.transformations = transformations;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>();
        for (String word: wordList
             ) {
            set.add(word);
        }

        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(beginWord,0));

        while (!queue.isEmpty()){
            Pair pair = queue.poll();
            StringBuffer pollWord = new StringBuffer(pair.word);

            for (int i = 0; i < beginWord.length(); i++) {

                StringBuffer word = new StringBuffer(pollWord);
                for (char c = 'a'; c <= 'z'; c++) {
                    word.setCharAt(i,c);
                    String transfWord = word.toString();
                    if(set.contains(transfWord)){
                        queue.offer(new Pair(transfWord,pair.transformations+1));
                        set.remove(transfWord);
                        if(transfWord.equals(endWord)){
                            return pair.transformations+2;
                        }
                    }

                }
            }
        }
        return 0;
    }
}
