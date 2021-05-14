/*############################################################################
					 Pattern Matching

	Given a list of n words and a pattern p that we want to search. Check 
	if the pattern p is present the given words or not. Return true if the 
	pattern is present and false otherwise.

			completed  false;
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
	private void add(TrieNode root, String word,int index){
		if(word.length()==index){
			root.isTerminating=true;
			return;
		}
		int charIndex = word.charAt(index) - 'a';
		TrieNode child = root.children[charIndex];
		if(child==null){
			root.children[charIndex] = new TrieNode(word.charAt(index));
			root.childCount++;
		}
		add(root.children[charIndex],word,index+1); 		
	}

	public void add(String word){
		add(root, word,0);
	}
	public boolean search(String word){
		return search(root, word);
	}

	private boolean search(TrieNode root, String word) {
		if(word.length() == 0){
			return true;
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			return false;
		}
		return search(child, word.substring(1));
	}


	public boolean patternMatching(ArrayList<String> vect, String pattern) {
        for(int i = 0; i<vect.size();i++){
        	String str = vect.get(i);
        	while(!str.equals("")){
        		this.add(str);
        		str = str.substring(1);
        	}
        }
        return search(pattern);
	}

}
public class PatternMatching{
	public static void main(String[] args) {
		ArrayList<String> vect = new ArrayList<>();
		String[] str = "this not the the array list but now it is lets use it for pattern matching".split(" ");
		for(String s : str) vect.add(s);
		Trie t = new Trie();
		System.out.println(t.patternMatching(vect, "lkist"));

	}
}