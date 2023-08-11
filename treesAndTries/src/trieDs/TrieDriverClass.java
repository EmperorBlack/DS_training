package trieDs;

import BSTBasics.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class TrieNode{
    TrieNode[] children;
    boolean isEndOfWord;

    TrieNode(){
        children = new TrieNode[26];
        isEndOfWord = false;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord() {
        isEndOfWord = true;
    }

    public TrieNode getNode(char c){
        return children[c-'a'];
    }

    public void setNode(char c){
        children[c -'a'] = new TrieNode();
    }
}

class Trie{
    TrieNode root = new TrieNode();

    public int nodeCount = 0;
    public void insert(String key){
        TrieNode current = root;
        for (int i = 0; i < key.length() ; i++) {
            if(current.getNode(key.charAt(i)) == null) {
                current.setNode(key.charAt(i));
                nodeCount++;
            }
            current = current.getNode(key.charAt(i));

            if(i == key.length()-1){
                current.setEndOfWord();
            }

        }
    }
    public boolean search(String key){
        TrieNode current = root;
        for (int i = 0; i < key.length(); i++) {
            if(current.getNode(key.charAt(i)) == null){
                return false;
            }
            current = current.getNode(key.charAt(i));
            if(i==key.length()-1 && current.isEndOfWord()){
                return true;
            }
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {

            if(current.getNode(prefix.charAt(i)) == null){
                return false;
            }
            current = current.getNode(prefix.charAt(i));
        }
        return true;
    }

    public boolean isExistsEveryPart(String key){

        if(key == null || key.isEmpty()){
            return true;
        }

        for (int i = 1; i <= key.length() ; i++) {

            String firstPart = key.substring(0,i);
            String secondPart = key.substring(i,key.length());
            if(search(firstPart) && isExistsEveryPart(secondPart)){
                return true;
            }
        }
        return false;
    }


    public boolean checkIfCompleteString(String word){
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            current = current.getNode(word.charAt(i));
            if(current == null || !current.isEndOfWord){
                return false;
            }
        }
        return true;
    }
}


public class TrieDriverClass {

   
    public static void main(String[] args) {
       String[] words = new String[]{"the","a","there","their","any"};
       Trie trie = new Trie();
        for (String word: words
             ) {
            trie.insert(word);
        }
//        System.out.println(Trie.root);
//
//        System.out.println(trie.search("ther"));
//
//        System.out.println(trie.isExistsEveryPart("athereany"));
//
//        System.out.println(trie.startsWith("ant"));
//
//        System.out.println(completeString(1,new String[]{"ab","bc"}));
//
//        System.out.println(countDistinctSubstrings("abab"));

        ArrayList<String> list = new ArrayList<>();
        list.add("water_is_cool");
        list.add("cold_ice_drink");
        list.add("cool_wifi_speed");



        new TrieDriverClass().solve("cool_ice_wifi",list );

    }

    public static String completeString(int n, String[] a) {
        Trie trie = new Trie();
        for (String s:a
             ) {
            trie.insert(s);
        }

        String big = "";
        for (String s:a
             ) {
            if(trie.checkIfCompleteString(s)){

                if(s.length() > big.length()){
                    big = s;
                } else if (s.length() == big.length() && s.compareTo(big) >0) {
                    big = s;
                }

            }
        }
        return big.isEmpty() ? "None" : big;
    }

    public static int countDistinctSubstrings(String s)
    {
        Trie trie = new Trie();
        for (int i = 0; i < s.length(); i++) {
            trie.insert(s.substring(i,s.length()));
        }

        return trie.nodeCount + 1;
        //	  Write your code here.
    }

    class ScoreIndexMap{
        public int score;
        public int index;

        ScoreIndexMap(int score,int index){
            this.score = score;
            this.index = index;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

    public ArrayList<Integer> solve(String A, ArrayList<String> B) {

        String[] goodWords = A.split("_");
        Trie trie = new Trie();
        for (String s:goodWords
        ) {
            trie.insert(s);
        }

        ArrayList<ScoreIndexMap> res = new ArrayList<>();

        for (int i = 0; i < B.size(); i++) {

            int count = 0;
            String[] reviews = B.get(i).split("_");
            for (String review : reviews) {
                if (trie.search(review)) {
                    count++;
                }
            }
            res.add(new ScoreIndexMap(count, i));
        }
        Collections.sort(res,(o1, o2) -> {
           if( o2.getScore()-o1.getScore() !=0){
               return  o2.getScore()-o1.getScore() ;
           }else {
               return o1.getIndex()-o2.getIndex() ;
           }
        });

        ArrayList<Integer> result = new ArrayList();
        for (ScoreIndexMap map :res
             ) {
            result.add(map.getIndex());
        }
        return result;
    }

    
}
