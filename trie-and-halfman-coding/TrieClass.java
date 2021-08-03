/*############################################################################
						       implementing trie
	it is used to store the words in tree, where every level store next
	letter of the word and last letter has word terminating property.


				completed = false


#############################################################################*/
class TrieNode{ 
	TrieNode[] next;
	// char letter;
	boolean isWordEnd;
	TrieNode(boolean isWordEnd){
		// this.letter = letter;
		this.isWordEnd = isWordEnd;
		this.next = new TrieNode[26];
	}
}
// implementation mine.
// this class uses extra space but it highly fast and take O(word length) time to every process. 
//but for long term it can be space exaustive.
class Trie{
	TrieNode[] start;
	int size;

	Trie(){
		this.start = new TrieNode[26];
		this.size = 0;
	}
// here i am adding the word.
	public void add(String word){
		TrieNode[] root = this.start;
		int index = 0;
		for(int i = 0; i<word.length();i++){
			index = word.charAt(i)-'a';
			if(root[index]!=null){
				if(i==word.length()-1) root[index].isWordEnd = true;
				root = root[index].next;
			}
			else if(root[index]==null){
				TrieNode node = new TrieNode(false);
				if(i==word.length()-1) node.isWordEnd = true;
				root[index] = node;
				root = root[index].next;
			}
		}
	}
// here i searching the word

	public boolean search(String word){
		TrieNode[] root = this.start;
		int index = 0;
		for(int i = 0; i<word.length();i++){
			// System.out.println(i);
			index = word.charAt(i)-'a';
			if(root[index]==null){
				// System.out.println("fie");
				return false;
			}
			if(root[index]!=null && i ==word.length()-1){
				if(!root[index].isWordEnd) return false;
			} 
			root = root[index].next;
		}
		return true;
	}
	
// here i removing the word
	public String remove(String word){
		TrieNode[] root = this.start;
		int index = 0;
		for(int i = 0; i<word.length();i++){
			// System.out.println(i);
			index = word.charAt(i)-'a';
			if(root[index]==null){
				System.out.println("word not present");
			}
			if(root[index]!=null && i ==word.length()-1){
				if(!root[index].isWordEnd) System.out.println("word not present");
				else{
					root[index].isWordEnd  = false;
					if(root[index].next==null){
						root[index] = null;
						boolean check = true;
						for(int j = 0; j<26;j++){
							if(root[j]!=null){
								check = true;
								break;
							}
						}
						if(check) root = null;
					}
				}
			} 
			root = root[index].next;
		}
		return word;
	}


	public static void print(TrieNode[] start,String str){
		if(start == null) return;
		for(int i =0; i<26;i++){
			if(start[i]!=null){
				if(start[i].isWordEnd) System.out.println(str+((char)(i+'a')));
				print(start[i].next,str+((char)(i+'a')));
			}
		}
	}
}

// method 2 increase the time complexity but the space complexity will be reduced.
class TrieNode{ 
	TrieNode next;
	TrieNode right;
	char letter;
	boolean isWordEnd;
	TrieNode(char letter, boolean isWordEnd){
		this.letter = letter;
		this.isWordEnd = isWordEnd;
		this.next = null;
	}
}
class Trie{
	TrieNode start;
	int size;

	Trie(){
		// i makiing this to start of all the word but this letter not included anywhere.
		this.start = new TrieNode(' ',false);
		this.size = 0;
	}
// here i am adding the word.
	public static TrieNode addHelper(TrieNode start, String word, int index){
		// System.out.print("calling ");
		// if(start==null) System.out.println(start);
		// else System.out.println(start.letter);
		if(word.length()<=index){
			// System.out.print("R0   ");
			// if(start==null) System.out.println(start);
			// else System.out.println(start.letter);
			return start;
		}
		TrieNode node = null;
		boolean isWordEnd = false;
		if(index == word.length()-1) isWordEnd = true;

		TrieNode startPrev = start, root = start;
		while(start!=null && start.letter<word.charAt(index)){
			startPrev = start;
			start = start.right;
		}
		if(start == null){
			// System.out.println("R1  in  ");
			node = new TrieNode(word.charAt(index),isWordEnd);
			node.next = addHelper(null,word,index+1);
			// System.out.println("R1   "+node.letter);
			if(startPrev!=null){
				startPrev.right = node;
				return root;
			}
			return node;
		}
		if(start.letter == word.charAt(index)){
			// System.out.println("R2  in ");
			start.isWordEnd = isWordEnd;
			start.next = addHelper(start.next, word,index+1);
			// System.out.println("R2   " +start.letter);
			return root;
		}
		if(start.letter>word.charAt(index)){
			// System.out.println("R3 in" );
			node = new TrieNode(word.charAt(index),isWordEnd);
			node.next = addHelper(null,word,index+1);
			if(startPrev.letter>word.charAt(index)){

				node.right = startPrev;
			}
			else{

				startPrev.right = node;
				node.right = start;
			}
			// System.out.println("R3   " +node.letter);
		}
		return root;
	}
	public void add(String word){
		if(word.length()<1) return;

		this.start.next = Trie.addHelper(this.start.next, word, 0);	
	}
// here i searching the word

	public static boolean searchHelper(TrieNode start, String word, int index){
		// System.out.println("in");
		if(word.length()<=index) return false;
		if(start==null) return false;
		if(word.length()-1==index){
			if(start.letter!=word.charAt(index)|| !start.isWordEnd) return false;
			else return true;
		}
		while(start!=null){
			if(start.letter==word.charAt(index)){
				return searchHelper(start.next,word,index+1);
			}
			start = start.right;
		}
		return false;
	}
	
	public boolean search(String word){
		return searchHelper(this.start.next,word,0);
	}
	
// here i removing the word
	public static String removeHelper(TrieNode start, String word, int index){
		// System.out.println("in");
		if(word.length()<=index) return null;
		if(start==null) return null;
		if(word.length()-1==index){
			if(start.letter!=word.charAt(index)|| !start.isWordEnd) return null;
			else{
				start.isWordEnd = false;
				return start.letter+"";
			}
		}
		while(start!=null){
			if(start.letter==word.charAt(index)){
				String retWord = removeHelper(start.next,word,index+1);
				
				return start.letter + retWord;
			}
			start = start.right;
		}
		return null;
	}
	
	public String remove(String word){
		return removeHelper(this.start.next,word,0);
	}

	
	public static void print(TrieNode start,String str){
		if(start == null) return;
		if(start.isWordEnd) System.out.println(str+start.letter);
		while(start!=null){
			print(start.next,str+start.letter);
			start = start.right;
		}
	}
}

public class TrieClass{

	
	public static void main(String[] args) {
	// // testing first class.
	// 	Trie t = new Trie();
	// 	t.add("add");
	// 	t.add("ad");
	// 	t.add("a");
	// 	t.add("love");
	// 	t.add("cuddle");
		// System.out.println(t.remove("ad"));
	// 	System.out.println(t.search("add"));
	// 	Trie.print(t.start,"");
	// testing second class.
		Trie t = new Trie();
		t.add("add");
		t.add("ad");
		t.add("a");

		t.add("love");
		t.add("cuddle");
		// System.out.println(t.start.letter);
		System.out.println(t.remove("ad"));
		Trie.print(t.start,"");
		// System.out.println(t.start.next.next.next.letter);
		System.out.println(t.search("love"));
	}
}