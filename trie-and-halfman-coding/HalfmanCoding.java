/*############################################################################
		try to implements the halfman compression and decompression
	here i will do all the things like compression and decompression of any string
	
	this will be from scratch because i will going to write each data staructure my self
	and then implements it.
						completed  true;
						leve up false;
#############################################################################*/	
import java.util.HashMap;// one day i will wrote no import version of this.
import java.util.PriorityQueue;

class TreeNode{
	Character leaf;
	Integer head;
	TreeNode left;
	TreeNode right;

	TreeNode(Character leaf){
		this.leaf = leaf;
		this.head = null;
		this.left = null;
		this.right = null;
	}

	TreeNode(Integer head){
		this.leaf = null;
		this.head = head;
		this.left = null;
		this.right = null;
	}
}

class PqNode{
	int frequancy;
	Character data;
	TreeNode root;
	PqNode(int frequancy, Character data){
		this.frequancy = frequancy;
		this. data = data;
		this.root = null;
	}
	PqNode(int frequancy, TreeNode root){
		this.frequancy = frequancy;
		this. data = null;
		this.root = root;
	}
}


class Halfman{
	// every object will contain compression and decompression map and other functions will be static.
	// step1 create frequancy hash map.
	// step2 create priority queue.
	// step3 create half man tree.
	// step4 create compression map.
	// step5 create decompression map.
	// and now this processs is completed.
	HashMap<String,Character> decompressionMap;
	HashMap<Character,String> compressionMap;


	Halfman(){
		this.compressionMap = new HashMap<>();
		this. decompressionMap = new HashMap<>();
	}
	// compress 1.  when String is passed as parameter.
	// compress 2.  when document is passed as parameter.
	public String compress(String str){
		HashMap<Character,Integer> freqMap = new HashMap<>();
	// step1 create frequancy hash map.
		freqMapGenerator(str, freqMap);
		System.out.println(freqMap.entrySet());
	// step2 create priority queue.
		PriorityQueue<PqNode> pq = pqCreate(freqMap);
		// while(!pq.isEmpty()){
		// 	System.out.println(pq.poll().data);
		// }
		System.out.println(pq.size());
	// step3 create half man tree.
		TreeNode root = halfmanTree(pq);
		checkPrint(root);
	// step4 create compression map.
		// createHafmanCodeMap(root,"");
		createHafmanCodeMap(root,this.compressionMap,this.decompressionMap,"");
		// System.out.println(this.compressionMap.entrySet());
		// System.out.println(this.decompressionMap.entrySet());
	// lets compress and return the data.
		return stringToHafmanCode(str,this.compressionMap);	
	}

	public String decompress(String str){
		return HafmanCodeToString(str, this.decompressionMap);
	}

	static private String stringToHafmanCode(String str, HashMap<Character,String> compressionMap){
		String output = "";
		for(int i = 0; i<str.length();i++){
			output += compressionMap.get(str.charAt(i));
		}
		return output;
	}
	static private String HafmanCodeToString(String str, HashMap<String,Character> decompressionMap){
		String output = "";
		int temp = 0;
		for(int i = 1; i<=str.length();i++){
			if(decompressionMap.containsKey(str.substring(temp,i))){
				output += decompressionMap.get(str.substring(temp,i));
				temp = i;
			}
		}
		return output;
	}
	void checkPrint(TreeNode root){
		if(root.head==null){
			System.out.println(root.leaf);
			return;
		}
		System.out.println(root.head);
		checkPrint(root.left);
		checkPrint(root.right);
	}
	static private void freqMapGenerator(String str, HashMap<Character,Integer> freqMap){
		for(int i = 0; i<str.length();i++){
			if(!freqMap.containsKey(str.charAt(i))){
				freqMap.put(str.charAt(i),1);
			}else{
				freqMap.put(str.charAt(i),freqMap.get(str.charAt(i))+1);
			}
		}
	}
	private static PriorityQueue<PqNode> pqCreate(HashMap<Character,Integer> freqMap){
		PriorityQueue<PqNode> pq = new PriorityQueue<>((a, b) -> 
        a.frequancy - b.frequancy);
        for(Character c:freqMap.keySet()){
        	pq.add(new PqNode(freqMap.get(c),c));
        }
        return pq;

	}

	private static TreeNode halfmanTree(PriorityQueue<PqNode> pq){
		TreeNode treeRoot = null;
		while(pq.size()>1){
			PqNode min1 = pq.poll(), min2 = pq.poll();
			int freqSum = min1.frequancy+min2.frequancy;
			treeRoot = new TreeNode(freqSum);
			if(min1.root==null && min2.root==null){
				treeRoot.left = new TreeNode(min1.data);
				treeRoot.right = new TreeNode(min2.data);
			}else if(min1.root!=null && min2.root!=null){
				treeRoot.left = min1.root;
				treeRoot.right = min2.root;
			}else if(min1.root==null){
				treeRoot.left = new TreeNode(min1.data);
				treeRoot.right = min2.root;
			}else{
				treeRoot.left = min1.root;
				treeRoot.right = new TreeNode(min2.data);
			}
			pq.remove(min1);
			pq.remove(min2);
			pq.add(new PqNode(freqSum,treeRoot));
		}
		if(pq.peek().data!=null){
			treeRoot = new TreeNode(pq.peek().frequancy);
			treeRoot.left = new TreeNode(pq.peek().data);
		}
		return treeRoot;
	}

	// this is long code and replace with createHafmanCodeMap function
	static private void createHafmanCodeMap(	TreeNode root, HashMap<Character,String> compressionMap,
								HashMap<String, Character> decompressionMap, String hafmanCode){
		// this function will map each Character of the input to the hafman code.
		if(root.leaf!=null){
			System.out.println(root.leaf+" ha "+hafmanCode);
			compressionMap.put(root.leaf,hafmanCode);
			decompressionMap.put(hafmanCode,root.leaf);
			return;
		}
		createHafmanCodeMap(root.left,compressionMap,decompressionMap,hafmanCode+0);
		createHafmanCodeMap(root.right,compressionMap,decompressionMap,hafmanCode+1);
	}
	// this function will use space to each object but not need to pass the both maps.
	void createHafmanCodeMap(TreeNode root, String hafmanCode){
		// this function will map each Character of the input to the hafman code.
		if(root.leaf!=null){
			// System.out.println(root.leaf+" ha "+hafmanCode);
			this.compressionMap.put(root.leaf,hafmanCode);
			this.decompressionMap.put(hafmanCode,root.leaf);
			return;
		}
		createHafmanCodeMap(root.left,hafmanCode+0);
		createHafmanCodeMap(root.right,hafmanCode+1);
	}
}

public class HalfmanCoding{
	public static void main(String[] args) {
		String str = "abcka";
		Halfman hf = new Halfman();
		String compressed = hf.compress(str);
		String decompressed = hf.decompress(compressed);
		System.out.println("compresed string \n"+compressed+"\ndecompressed string\n"+decompressed);

	}
}
