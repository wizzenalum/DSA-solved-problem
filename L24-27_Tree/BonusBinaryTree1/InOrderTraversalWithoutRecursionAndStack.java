/*############################################################################
		For a given Binary Tree of type integer and a number K, print out 
		all root-to-leaf paths where the sum of all the node data along the 
		path is equal to K.


					COMPLETED=True;
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

// import java.util.math;
public class InOrderTraversalWithoutRecursionAndStack {
	
	 public static void inOrder(BinaryTreeNode<Integer> root) {
	 	BinaryTreeNode<Integer> temp=null;
	 	while(root!=null){
	 		// System.out.println("root is  "+root.data);
	 		if(root.left!=null){
	 			temp = root.left;
	 			while(temp.right!=null && temp.right!=root)	temp = temp.right;
	 			if(temp.right!=root){
	 				temp.right = root;
	 				root = root.left;
	 			}else{
	 				System.out.print(root.data+" ");
	 				temp.right=null;
		 			root = root.right;
	 			}
	 		}
	 		else{
	 			System.out.print(root.data+" ");
	 			root = root.right;
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
		// int[] arr = {1,2,3,4,7,-1,-1,-1,-1,-1,-1};

		BinaryTree tree = new BinaryTree(arr); // accessed from an another class call ed BinaryTree
		// tree.
		tree.printDetail();
		inOrder(tree.root);
	}
	
}