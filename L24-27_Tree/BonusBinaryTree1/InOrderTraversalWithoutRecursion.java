/*############################################################################
		Given a binary tree, print the inorder traversal of a given tree 
		without using recursion and stack. 
		Inorder traversal is: LeftChild Root RightChild


					COMPLETED=true;
#############################################################################*/
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
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

// import java.util.math;
public class InOrderTraversalWithoutRecursion {
	
	 public static void inOrder(BinaryTreeNode<Integer> root) {
	 	// why i am usig so much while loop if it can be done 
	 	if(root==null) return;
	 	Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
	 	out:
	 	while(root!=null){
	 		if(root.left==null && root.right==null){
	 			System.out.print(root.data+" ");
	 			if(!stack.isEmpty()) root = stack.pop();
	 			else break;
	 			while(root.right==null){
		 			System.out.print(root.data+" ");
	 				if(!stack.isEmpty()) root = stack.pop();
	 			else break out;
	 			}
	 			System.out.print(root.data+" ");
	 			root = root.right;
	 		}
	 		while(root.left!=null){
	 			stack.add(root);
	 			root=root.left;
	 		}
	 		if(root.right!=null){
	 			System.out.print(root.data+" ");
	 			root= root.right;
	 		}  
        }
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
		// tree.
		inOrder(tree.root);
	}
	
}