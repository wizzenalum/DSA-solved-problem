/*############################################################################
		For a given a Binary Tree of type integer, print it in a level order 
		fashion where each level will be printed on a new line. Elements on 
		every level will be printed in a linear fashion and a single space 
		will separate them.

					COMPLETED=False;
#############################################################################*/

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

public class LevelOrderTraversal{

	public static void printHelper(BinaryTreeNode<Integer> root, int depth, Queue<BinaryTreeNode<Integer>> queue, Queue<Integer> queue2){
		// it have stack overflow problem
		if(root==null) return;
		System.out.print((root.data+" "));
		if(root.left!=null){
			queue2.add(depth+1);
			queue.add(root.left);	
		}
		if(root.right!=null){
			queue2.add(depth+1);
			queue.add(root.right);

		}
	}

	
	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		Queue<Integer> queue2 = new LinkedList<>();
		int depth = 0, prevDepth=0;
		printHelper(root,depth,queue,queue2);
		while(!queue.isEmpty()){
			depth = queue2.poll();
			if(depth>prevDepth) System.out.println();
			prevDepth = depth;
			printHelper(queue.poll(),prevDepth,queue, queue2);
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
		tree.print();
		System.out.println();
		printLevelWise(tree.root);		
	}
	
}