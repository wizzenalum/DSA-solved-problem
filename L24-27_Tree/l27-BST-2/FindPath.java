/*############################################################################
		Given a BST and an integer k. Find and return the path from the node 
		with data k and root (if a node with data k is present in given BST) 
		in a list. Return empty list otherwise.
		Note: Assume that BST contains all unique elements.

				completed true
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
public class FindPath{
	public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int data){
		if(root==null) return null;
		ArrayList<Integer> left = null, right = null,current;
		if(data<=root.data) left = getPath(root.left,data);
		if(data>=root.data) right = getPath(root.right,data);
		current = left!=null?left:right;
		if(current == null && root.data == data){
			current = new ArrayList<Integer>();
			current.add(data);		} 
		else if(current!=null) current.add(root.data);
		return current;
	}
	public static void main(String[] args) {
		//creting tree by level wise input
		/* following is te tree which will be printed by deferent ways

				      4
				   2  	 5
				 1   3	   7

		*/
		// 1 2 3 4 5 -1 7 -1 -1 -1 -1 -1 -1
		int[] arr = {4,2,5,1,3,-1,7,-1,-1,-1,-1,-1,-1};

		BinaryTree tree = new BinaryTree(arr); // accessed from an another class call ed BinaryTree
		tree.printDetail();
	// first problem. 
		ArrayList<Integer> arrl = getPath(tree.root,3);
		System.out.println(arrl.subList(0,arrl.size()));
	// second problem.
	// third problem
		
		

	}	
}
