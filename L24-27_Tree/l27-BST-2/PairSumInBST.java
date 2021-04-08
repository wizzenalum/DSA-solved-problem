/*############################################################################
			 Pair sum in a BST

	Given a binary search tree and an integer S, find pair of nodes in the 
	BST which sum to S. You can use extra space of the order of O(log n).	

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

class LinkedListNode<T>{
	T data;
	LinkedListNode<T> next;
	LinkedListNode(T data){
		this.data = data;
		this.next = null;
	}
}

public class PairSumInBST{
	public static BinaryTreeNode<Integer> search(BinaryTreeNode<Integer> root, int n){
		if(root==null) return null;
		if(root.data==n) return root;
		if(root.data<n) return search(root.right,n);
		if(root.data>n) return search(root.left,n);
		return null;
	}
	public static void print(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> localRoot, int s){
		if(localRoot==null) return;
		if(s<root.data){
			print(root.left,root.left,s);
			return;
		}

		int c = localRoot.data;
		int max = s-c;
		BinaryTreeNode<Integer> check = search(root,s-c);
		if(check!=null && (c>=s-c) && check!=localRoot){
			// System.out.print("in check  "+c+" "+(s-c)+" "+localRoot.data+"   ");
			System.out.println(c<s-c?c:s-c+" "+(c>s-c?c:s-c));
		}
		print(root,localRoot.left,s);
		print(root,localRoot.right,s);

	}
	public static void printNodesSumToS(BinaryTreeNode<Integer> root, int s) {
		if(root==null) return;
		print(root,root,s);
		
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
		printNodesSumToS(tree.root, 6);
	}	
}
