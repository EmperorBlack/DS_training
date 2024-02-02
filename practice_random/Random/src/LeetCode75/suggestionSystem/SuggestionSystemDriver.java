package LeetCode75.suggestionSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SuggestionSystemDriver {
    public static void main(String[] args) {

    }
}

class TrieNode{
    TrieNode[] children;

    List<String> words;

    public TrieNode() {
        children = new TrieNode[26];
        words = new ArrayList<>();
    }

    public TrieNode getNode(char c){
        return children[c-'a'];
    }

    public void setNode(char c){
        children[c-'a'] = new TrieNode();
    }

}

class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {

            if(curr.getNode(word.charAt(i)) == null){
                curr.setNode(word.charAt(i));
            }
            curr = curr.getNode(word.charAt(i));
            if(curr.words.size() < 3){
                curr.words.add(word);
            }
        }
    }




}


class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        Arrays.sort(products);

        Trie trie = new Trie();
        for (String product : products
             ) {
            trie.insert(product);
        }

        List<List<String>> result = new ArrayList<>();
        TrieNode curr = trie.root;
        for (int i = 0; i < searchWord.length(); i++) {

            char c = searchWord.charAt(i);
            TrieNode node = curr.getNode(c);

            if(node!=null){
                result.add(node.words);
                curr = node;
            }else{

                for (int j = i; j < searchWord.length(); j++) {
                    result.add(new ArrayList<>());
                }
                return result;
            }

        }
        return result;
    }
}
