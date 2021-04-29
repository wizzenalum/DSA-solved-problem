
// getvalue(key)

class BST{
	String key;
	int value;
	BST left;
	BST right;
	BST(String key, int value){
		this.key = key;
		this.value = value;
		this.left = null;
		this.right = null;
	}
}

public class TreeMap{
	private BST root;
	private int size = 0;

	TreeMap(){
		this.root = null;
	}
	public void insert(String key, int value){
		BST node = new BST(key,value);
		if(this.root == null) this.root = node;
		else{
			BST head = this.root;
			boolean check = true;
			while(check){
				if(head.key.compareTo(key)==-1){
					if(head.right==null){
						head.right = node;
						check = false;
					}else head = head.right;
				}else if(head.key.compareTo(key)==0){
					head.value = value;
					check = false;
					this.size--;
				}
				else{
					if(head.left==null){
						head.left = node;
						check = false;
					}else head = head.left;
				}
			}
			
		}
		this.size++;
	}
// here i am tring to make BST aprox balanced.
	// private 
	// private static rotateLeft(BST root){

	// }
	// private static rotateLeft(BST root){
		
	// }
	private static class Pair{
		boolean verification;
		BST node;
		Pair(boolean verification, BST node){
			this.verification = verification;
			this.node = node;
		}

	}
	public int size(){ return this.size;}

	public boolean delete(String key){
		Pair temp = delete(this.root,key);
		this.root = temp.node;
		return temp.verification;	
	}
	static private Pair delete(BST root, String key){
		if(root==null) return new Pair(false,null);
		BST temp = null, prev = null, node = null;
		Pair pair = null;
		boolean verification = false;

		if(root.key.compareTo(key)==0){
			if(root.right == null) node = root.left;
			else if(root.right.left == null) node = root.right;
			else{
				prev = root.right;
				temp = root.right.left; 
				while(temp.left!=null){
					prev = temp;
					temp = temp.left;
				}
				prev.left = temp.right;
				temp.left = root.left;
				temp.right = root.right;
				node = temp;
				verification = true;
			}
		}
		else{
			pair = delete(root.left,key);
			root.left = pair.node;
			verification = pair.verification;
			pair = delete(root.right,key);
			root.right = pair.node;
			verification = verification||pair.verification;
			node = root;
		} 
		return new Pair(verification,node);
	}
	public Integer getValue(String key){
		BST head = this.root;
		boolean check = true;
		int value = 0;
		while(check && head!=null){
			if(head.key.compareTo(key)==0){
				value = head.value;
				check = false;
			}else if(head.key.compareTo(key)==-1) head = head.right;
			else head = head.left;
		}
		if(head==null) return null;
		return value;

	}
}