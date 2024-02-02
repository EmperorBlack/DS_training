package LeetCode75.triePrefix;

public class TriePrefixDriver {
    public static void main(String[] args) {

    }
}
class TrieNode{
    TrieNode[] children;
    boolean endsWith;

    public TrieNode() {
        children = new TrieNode[26];
    }

    public TrieNode getNode(char c){
        return children[c-'a'];
    }

    public void setNode(char c){
        children[c-'a'] = new TrieNode();
    }

    public boolean isEndsWith() {
        return endsWith;
    }

    public void setEndsWith(boolean endsWith) {
        this.endsWith = endsWith;
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

            if(i == word.length()-1){
                curr.setEndsWith(true);
            }
        }
    }

    public boolean search(String word) {

        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(curr.getNode(c) == null){
                return false;
            }
            curr = curr.getNode(c);
        }

        return curr.isEndsWith();

    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(curr.getNode(c) == null){
                return false;
            }
            curr = curr.getNode(c);
        }

        return true;

    }
}
