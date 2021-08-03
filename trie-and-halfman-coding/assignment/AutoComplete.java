/*############################################################################
                                 Auto complete

        Given n number of words and an incomplete word w. You need to 
        auto-complete that word w.
        
        That means, find and print all the possible words which can be formed 
        using the incomplete word w.
        
        Note : Order of words does not matter.

                        completed  true;
#############################################################################*/
import java.util.ArrayList;
class TrieNode{
        char data;
        boolean isTerminating;
        TrieNode children[];
        int childCount;

        public TrieNode(char data) {
                this.data = data;
                isTerminating = false;
                children = new TrieNode[26];
                childCount = 0;
        }
}

class Trie {
        private TrieNode root;
        public int count;
        public Trie() {
                root = new TrieNode('\0');
        }

        private void add(TrieNode root, String word){
                if(word.length() == 0){
                        root.isTerminating = true;
                        return;
                }               
                int childIndex = word.charAt(0) - 'a';
                TrieNode child = root.children[childIndex];
                if(child == null){
                        child = new TrieNode(word.charAt(0));
                        root.children[childIndex] = child;
                        root.childCount++;
                }
                add(child, word.substring(1));
        }

        public void add(String word){
                add(root, word);
        }
        
        
        public static void printAutoComplete(TrieNode root, String word){
                if(root==null) return;
                if(root.isTerminating) System.out.println(word);
                for(int i = 0; i<26;i++){
                        if(root.children[i]!=null){
                                printAutoComplete(root.children[i], word+root.children[i].data);
                        }
                }

        }
        
        public void autoComplete(ArrayList<String> input, String word) {
                for(int i = 0; i<input.size();i++){
                        this.add(input.get(i));
                }
                TrieNode temp = this.root;
                for(int i =0; i<word.length();i++){
                        int index = word.charAt(i)-'a';
                        if(temp.children[index]==null) return;
                        temp = temp.children[index];
                }
                // System.out.println(temp.data);
                // System.out.println("in");
                printAutoComplete(temp, word);
        
    }

} 
public class AutoComplete{
        public static void main(String[] args) {
                ArrayList<String> vect = new ArrayList<>();
                String[] str = "this not the ht array list but now lit lite it is lets use it for pattern matching".split(" ");
                // String[] str = "abcmam cba".split(" ");
                for(String s : str) vect.add(s);
                Trie t = new Trie();
                t.autoComplete(vect, "li");
                // t.print();

        }
}