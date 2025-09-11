public class ImplementTrie_I {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple"); // return True
        trie.search("app"); // return False
        trie.startsWith("app"); // return True
        trie.insert("app");
       System.out.println(trie.search("app"));
    }
}
class Trie {
    Node root;
    public Trie() {
        this.root = new Node();
    }
    
    public void insert(String word) {
        Node curr = this.root;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(curr.child[c-'a'] == null) {
                curr.child[c-'a'] = new Node();
            }
            curr = curr.child[c-'a'];
        }
        curr.isLeaf = true;
    }
    
    public boolean search(String word) {
        Node curr = this.root;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(curr.child[c-'a'] != null) {
                curr = curr.child[c-'a'];
            } else {
                return false;
            }
        }
        return curr.isLeaf;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = this.root;
        for(int i=0; i<prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(curr.child[c-'a'] != null) {
                curr = curr.child[c-'a'];
            } else {
                return false;
            }
        }
        return true;
    }
}

class Node{
    Node[] child;
    boolean isLeaf;
    Node () {
        this.child = new Node[26];
        this.isLeaf = false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
