/*############################################################################
				 Largest BST

	Given a Binary tree, find the largest BST subtree. That is, you need 
	to find the BST with maximum height in the given binary tree. You 
	have to return the height of largest BST.

			complete = true	
#############################################################################*/
import java.util.ArrayList;
class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
class DataStore{
	int min, max, height;
	boolean isBST;
	// static int bstHeight = 0;
	DataStore(int min, int max, boolean isBST, int height){
		this.min 	= min;
		this.max 	= max;
		this.isBST 	= isBST;
		this.height =height;
	}
	void print(){
		System.out.println(min+" "+max+" "+isBST+" "+height);
	}

}
public class LargestBST{
	public static DataStore largestBSTHelper(BinaryTreeNode<Integer> root){
		if(root==null) return new DataStore(Integer.MAX_VALUE, Integer.MIN_VALUE, true, 0);
		DataStore left = largestBSTHelper(root.left);
		DataStore right = largestBSTHelper(root.right);

		// choose max height b/w left and right subtrees.
		int height = left.height>right.height?left.height:right.height;

		// when value return from null
		if(left.min==Integer.MAX_VALUE){
			left.min = root.data;
			left.max = root.data;
		}
		if(right.min==Integer.MAX_VALUE){
			right.min = root.data;
			right.max = root.data;
		}

		// data that will be return
		DataStore current = new DataStore(left.min,right.max,true,height);

		if(left.isBST&&right.isBST){
			if(left.max>root.data || right.min<root.data) current.isBST = false;
			if(current.isBST) current.height++;
		}else current.isBST = false;
		// current.print();
		return current; 

	}
	public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
		DataStore current = largestBSTHelper(root);
		return current.height; 
	}
	public static void main(String[] args) {
		//creting tree by level wise input
		/* following is te tree which will be printed by deferent ways

				      4
				   2  	 5
				 1   3	   7

		*/
		// 1 2 3 4 5 -1 7 -1 -1 -1 -1 -1 -1
		// int[] arr = {4,2,5,1,3,-1,7,-1,-1,-1,-1,-1,-1};
		int[] arr = {5, 6, 10, 2, 3, -1, -1, -1, -1, -1, 9, -1, -1};

		BinaryTree tree = new BinaryTree(arr); // accessed from an another class call ed BinaryTree
		tree.printDetail();
		System.out.println();
		System.out.print(largestBSTSubtree(tree.root));

		
		

	}	
}
