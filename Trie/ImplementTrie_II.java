public class ImplementTrie_II {
     public static void main(String[] args) {
        Trie1 trie = new Trie1();
        trie.insert("apple");
        System.out.println(trie.countWordsEqualTo("apple"));  // return 1
        trie.insert("app"); 
        System.out.println(trie.countWordsStartingWith("app")); // return 2
        trie.erase("apple");
        System.out.println(trie.countWordsStartingWith("app"));   // return 1
    }
}

class Trie1 {
    Node1 root;

    Trie1() {
        this.root = new Node1();
    }

    public void insert(String word) {
        Node1 curr = this.root;
        for(int i=0; i<word.length(); i++) {
            int index = word.charAt(i)-'a';
            if(curr.childs[index] == null) {
                curr.childs[index] = new Node1();
            }
            curr = curr.childs[index];
            curr.alphabetCount++;
        }
        curr.noOfWordEndsWith++;
    }

    public int countWordsEqualTo(String word) {
        Node1 curr = this.root;
        for(int i=0; i<word.length(); i++) {
            int index = word.charAt(i)-'a';
            if(curr.childs[index] == null) {
                return 0;
            }
            curr = curr.childs[index];
        }
        return curr.noOfWordEndsWith;
    }

    public int countWordsStartingWith(String prefix) {
        Node1 curr = this.root;
        for(int i=0; i<prefix.length(); i++) {
            int index = prefix.charAt(i)-'a';
            if(curr.childs[index] == null) {
                return 0;
            }
            curr = curr.childs[index];
        }
        return curr.alphabetCount;
    }
    
    public void erase(String word) {
        Node1 curr = this.root;
        for(int i=0; i<word.length(); i++) {
            int index = word.charAt(i)-'a';
            if(curr.childs[index] == null) {
                return;
            }
            curr = curr.childs[index];
            curr.alphabetCount--;
        }
        curr.noOfWordEndsWith--;
    }
}

class Node1 {
    Node1[] childs;
    int noOfWordEndsWith;
    int alphabetCount;

    Node1() {
        this.childs = new Node1[26];
        this.alphabetCount = 0;
        this.noOfWordEndsWith = 0;
    }
}
