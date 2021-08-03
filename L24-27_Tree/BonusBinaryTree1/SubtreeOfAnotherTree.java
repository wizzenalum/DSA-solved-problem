/*############################################################################
				     Subtree of Another Tree
	Given two binary trees T and S, check whether tree S has exactly the 
	same structure and node values with a subtree of T, i.e. check if tree 
	S is a subtree of the tree T.

	A subtree of a tree T is a tree S consisting of a node in T and all of 
	its descendants in T. The subtree corresponding to the root node is the 
	entire tree; the subtree corresponding to any other node is called a 
	proper subtree.
	

				completed:- true
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

public class SubtreeOfAnotherTree{
	public static boolean isSubtree(BinaryTreeNode<Integer> T, BinaryTreeNode<Integer> S) {
		if(T==null && S==null) return true;
		if(T==null||S==null) return false;
		// System.out.println(T.data+" "+S.data);
		boolean b = false, a = isSubtree(T.left,S);
		if(a) return a;
		a = a||isSubtree(T.right,S);
		if(a) return a;
		if(T.data==S.data){
			b = isSubtree(T.left,S.left);
			b = b && isSubtree(T.right, S.right);
		}
		// System.out.println(a||b);
		return b;
	}
	public static void main(String[] args) {
		//creting tree by level wise input
		/* following is te tree which will be printed by deferent ways

				      1
				   2  	 3
				 4   5	   7

		*/
		// 1 2 3 4 5 -1 7 -1 -1 -1 -1 -1 -1
		// int[] arr = {1,2,3,4,5,-1,7,-1,-1,-1,-1,-1,-1};
		int[] arr1 = {1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1};
		int[] arr2 = {2, 4, 5, -1, -1, -1, -1};

		BinaryTree tree1 = new BinaryTree(arr1); // accessed from an another class call ed BinaryTree
		BinaryTree tree2 = new BinaryTree(arr2); // accessed from an another class call ed BinaryTree
		// tree2.printDetail();
		System.out.println(isSubtree(tree1.root,tree2.root));
	}
	
}
