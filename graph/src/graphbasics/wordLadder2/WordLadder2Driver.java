package graphbasics.wordLadder2;

import java.util.*;

public class WordLadder2Driver {

    public static void main(String[] args) {

        System.out.println(new Solution().findLadders("hit","cog",Arrays.asList("hot","dot","dog","lot","log","cog")));
    }
}


class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>();
        for (String word: wordList
        ) {
            set.add(word);
        }

        Queue<ArrayList<String>> queue = new ArrayDeque<>();
        ArrayList<String> startList= new ArrayList<>();
        startList.add(beginWord);
        queue.offer(startList);
        List<List<String>> result = new ArrayList<>();

        while (!queue.isEmpty()){

            int size = queue.size();
            Set<String> levelCollection = new HashSet<>();
            for (int k = 0; k < size; k++) {

                ArrayList<String> list = queue.poll();
                String lastWord = list.get(list.size()-1);
                StringBuffer pollWord = new StringBuffer(lastWord);

                for (int i = 0; i < beginWord.length(); i++) {

                    StringBuffer word = new StringBuffer(pollWord);

                    for (char c = 'a'; c <= 'z'; c++) {
                        word.setCharAt(i,c);
                        String transfWord = word.toString();
                        if(set.contains(transfWord)){
                            ArrayList<String> newList = new ArrayList<>(list);
                            newList.add(transfWord);
                            queue.offer(newList);
                            levelCollection.add(transfWord);
                            if(transfWord.equals(endWord)){
                                result.add(newList);
                            }
                        }

                    }
                }

            }
            set.removeAll(levelCollection);
            if(!result.isEmpty()){
                return result;
            }

        }
        return result;
    }
}
