/*############################################################################
						  Inorder Sucessor
	Given an arbitrary binary tree and a node of this tree, you need to find 
	the inorder successor of this node in the tree.
	The inorder successor of a node in a binary tree is that node which will 
	be visited immediately after the given node in inorder traversal of the tree. 
	If the given node is visited last in the inorder traversal, then its inorder 
	successor is NULL.
	The inorder traversal of a binary tree is the traversal method in which for 
	any node its left subtree is visited first, then the node itself and then 
	the right subtree.
	
	Note
	 1. Each node is associated with a unique integer value. 
	 2. The node for which the successor is to be found is guaranteed to be the
	 	part of the tree.

	
					completed false
#############################################################################*/
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
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

public class InorderSucessor{
	public static int k=0;
	public static BinaryTreeNode<Integer> inorderSuccesor(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> Node) {
        if(root==null) return root;
        // if(k==1){
        // 	k = 0;
        // 	return root;
        // }
        BinaryTreeNode<Integer> temp = inorderSuccesor(root.left,Node);
        if(temp!=null&&k==0) return temp;
        if(k==1){
        	k = 0;
        	return root;
        }
        if(Node==root) k =1;
        return inorderSuccesor(root.right,Node);

    }
 //    public static int kthSmallestNode(BinaryTreeNode<Integer> root){
 //    	if(root==null) return Integer.MIN_VALUE;
 //    	if(k = 1) return root;
 //    	int smallest = kthSmallestNode(root.left);
 //    	if(smallest!=Integer.MIN_VALUE) return smallest;
 //   		if(root.data==data)
 //    	if(k==0) return root.data;
 //    	int smallest2 = kthSmallestNode(root.right);

	// 	return smallest2;
		
	// }
	public static void main(String[] args) {
		//creting tree by level wise input
		/* following is te tree which will be printed by deferent ways

				      4
				   2  	 5
				 1   3	   7

		*/
		// 1 2 3 4 5 -1 7 -1 -1 -1 -1 -1 -1
		// int[] arr = {4,2,5,1,3,-1,7,-1,-1,-1,-1,-1,-1};
		// int[] arr = {1,2,3,4,5,-1,-1,-1,-1,-1,-1};  // node = 2 and ans = 5;
		int[] arr = {180,-1,486,809,-1,121,-1,379,-1,157,-1,-1,749,-1,-1};  // node = 121, ans = 809
		BinaryTree tree = new BinaryTree(arr); // accessed from an another class call ed BinaryTre
		tree.printDetail();
        System.out.println(inorderSuccesor(tree.root, tree.root.right.left.left).data);
		

	}	
}
