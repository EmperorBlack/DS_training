package trie2CodingNinja;


class TrieNode{
    TrieNode[] children;
    boolean isEndOfWord;

    int endCount;

    int repeatCount;

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

    public int getEndCount() {
        return endCount;
    }

    public void setEndCount(int endCount) {
        this.endCount = endCount;
    }

    public int getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(int repeatCount) {
        this.repeatCount = repeatCount;
    }
}

class Trie{
    TrieNode root = new TrieNode();
    public void insert(String key){
        TrieNode current = root;
        for (int i = 0; i < key.length() ; i++) {
            if(current.getNode(key.charAt(i)) == null) {
                current.setNode(key.charAt(i));
            }
            current = current.getNode(key.charAt(i));
            current.setRepeatCount(current.getRepeatCount()+1);

            if(i == key.length()-1){
                current.setEndOfWord();
                current.setEndCount(current.getEndCount()+1);
            }

        }
    }
    public int countWordsEqualTo(String key){
        TrieNode current = root;
        for (int i = 0; i < key.length(); i++) {
            if(current.getNode(key.charAt(i)) == null){
                return 0;
            }
            current = current.getNode(key.charAt(i));
        }
        return current.getEndCount();
    }

    public int countWordsStartingWith(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {

            if(current.getNode(prefix.charAt(i)) == null){
                return 0;
            }
            current = current.getNode(prefix.charAt(i));
        }
        return current.getRepeatCount();
    }

    public void erase(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            current = current.getNode(word.charAt(i));
            current.setEndCount(current.getEndCount()-1);
            current.setRepeatCount(current.getRepeatCount()-1);
        }
    }
}

public class TrieDriverClass {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("mango");
        trie.insert("banana");
        trie.insert("apple");
        System.out.println(trie.countWordsEqualTo("banana"));
        System.out.println(trie.countWordsStartingWith("app"));
        trie.erase("banana");
        trie.insert("abc");
        trie.insert("abc");
        trie.insert("aef");
        System.out.println(trie.countWordsEqualTo("abc"));
        System.out.println(trie.countWordsStartingWith("a"));


    }
}
