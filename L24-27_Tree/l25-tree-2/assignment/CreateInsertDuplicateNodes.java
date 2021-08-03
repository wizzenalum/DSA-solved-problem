/*##########################################################################
	1. 	For a given a Binary Tree of type integer, duplicate every node
	  	of the tree and attach it to the left of itself.
		The root will remain the same. So you just need to insert nodes in 
		the given Binary Tree.

					COMPLETED = True
#############################################################################*/	
class BinaryTreeNode<T>{
	T data;   // data is generic type;
	BinaryTreeNode<T> left;  // adreess of left/ first  child node 
	BinaryTreeNode<T> right;  // adreess will be stored in arrary

	// contructor will decide the memory of array and data
	BinaryTreeNode(T data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
public class CreateInsertDuplicateNodes{

// create and insert cduplicate tree.
	public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
		if(root==null) return;
		BinaryTreeNode<Integer> node = new BinaryTreeNode<>(root.data.intValue());
		node.left = root.left;
		root.left = node;
		insertDuplicateNode(node.left);
		insertDuplicateNode(root.right);

	}
	public static void main(String[] args) {
		//creting tree by level wise input
		/* following is te tree which will be printed by deferent ways

				      1
				   2  	 3
				 4   5	   7

		*/
		// 1 2 3 4 5 -1 7 -1 -1 -1 -1 -1 -1
		int[] arr = {1,2,3,4,5,-1,7,-1,-1,-1,-1,-1,-1};
		BinaryTree tree = new BinaryTree(arr); // accessed from an another class call ed BinaryTree
		tree.printDetail();
		System.out.println();
		insertDuplicateNode(tree.root);
		tree.printDetail();
	}
}
