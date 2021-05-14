/*############################################################################
					  Palindrome Pair

	Given 'n' number of words, you need to find if there exist any two words 
	which can be joined to make a palindrome or any word, which itself is 
	a palindrome.
	
	The function should return either true or false. You don't have to 
	print anything.
		
		Constraints:
			0 <= n <= 10^5
			Time Limit: 1 sec

		Sample Input 1 :
			4
			abc def ghi cba

		Sample Output 1 :
			true

		Explanation of Sample Input 1:
			"abc" and "cba" forms a palindrome

		Sample Input 2 :
			2
			abc def

		Sample Output 2 :
			false

			completed  true;
#############################################################################*/
import java.util.ArrayList;

class TrieNode {
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

		if(child == null) {
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}

		add(child, word.substring(1));
	}

	public void add(String word){
		add(root, word);
	}

	private boolean search(TrieNode root, String word) {
		if(word.length() == 0) {
			return root.isTerminating;
		}

		int childIndex=word.charAt(0) - 'a';
		TrieNode child=root.children[childIndex];

		if(child == null) {
			return false;
		}

		return search(child,word.substring(1));

	}

	public boolean search(String word) {
		return search(root,word);
	}

	private void print(TrieNode root, String word) {
		if (root == null) {
			return;
		}
		
		if (root.isTerminating) {
			System.out.println(word);
		}
		
		for (TrieNode child : root.children) {
			if (child == null) {
				continue;
			}
			String fwd = word + child.data;
			print(child, fwd);
		}
	}
	
	public void print() {
		print(this.root, "");
	}





	/*..................... Palindrome Pair................... */

	private boolean isPalindrome(String str){
		for(int i = 0, j = str.length()-1; j>=i;i++,j--){
			if(str.charAt(i)!=str.charAt(j)) return false;
		}
		return true;
	}
	public boolean isPalindromePair(ArrayList<String> words) {
		for(int i = 0; i<words.size();i++){
        	this.add(words.get(i));
        }
        for(int i = 0; i<words.size();i++){
        	String str = "";
        	for(int j = words.get(i).length()-1; j>=0;j--){
        		str = str + words.get(i).charAt(j);
        	}
        	if(this.search(str)) return true; // identify self palindrom and two word sum(even length) to palindrom
        	for(int j = 1; j<=words.get(i).length();j++){
        		if(isPalindrome(words.get(i).substring(0,j))){
        			if(this.search(str.substring(0,str.length()-j))) return true;
        		}
        	}
        	for(int j = 1; j<=words.get(i).length();j++){
        		if(isPalindrome(words.get(i).substring(str.length()-j,str.length()))){
        			if(this.search(str.substring(j,str.length()))) return true;
        		}
        	}


        	if(this.search(str.substring(1))) return true;// odd length two word but extra letter is in first word.
        }
        
		return false;
	}


	
} 
public class PalindromePair{
	public static void main(String[] args) {
		ArrayList<String> vect = new ArrayList<>();
		// String[] str = "this not the ht array list but now it is lets use it for pattern matching".split(" ");
		String[] str = "abcmam cba".split(" ");
		for(String s : str) vect.add(s);
		Trie t = new Trie();
		System.out.println(t.isPalindromePair(vect));
		// t.print();

	}
}