/*############################################################################
						   implementing trie data structure
	it is used to store the words in tree, where every level store next
	letter of the word and last letter has word terminating property.

	i already implemented but here i will using recursion way of iterative first method.


				completed = true


#############################################################################*/

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


	public static boolean search(String word, TrieNode root){
		if(word.length()==0){
			if(root.isTerminating){
				// System.out.println("terminata");
				return true;
			}
			else return false;
		}
		int charIndex = word.charAt(0)-'a';
		TrieNode child = root.children[charIndex];
		if(child==null) return false;
		return search(word.substring(1), child);

	}
	
	public boolean search(String word){
		return search(word,this.root);
	}

	// remove fucntion 
	public static boolean remove(String word, TrieNode root){
		// if(root==null) return false;
		if(word.length()==0){
			if(root.isTerminating){
				// System.out.println(root.data+" "+root.isTerminating);
				root.isTerminating=false;
				return true;
			}else return false;
		}
		int charIndex = word.charAt(0)-'a';
		TrieNode child = root.children[charIndex];
		if(child==null) return false;
		return remove(word.substring(1), child);
	}
	

	public String remove(String word){
		if(remove(word,this.root)) return word;
		return null;
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
}
public class TrieClassAsCoddingNinjas{
	public static void main(String[] args) {
		Trie t = new Trie();
		t.add("add");
		t.add("a");
		t.add("ad");
		t.add("love");
		t.add("cuddle");
		System.out.println(t.search("add"));
		System.out.println(t.remove("add"));
		System.out.println(t.search("add"));
	}
}