/*############################################################################
		For a given Binary Tree of type integer and a number K, print out 
		all root-to-leaf paths where the sum of all the node data along the 
		path is equal to K.


					COMPLETED=False;
#############################################################################*/

import java.util.Stack;
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

public class PathSumRootToLeaf{


	public static int rootToLeafHelper(BinaryTreeNode<Integer> root, int value, Stack<BinaryTreeNode<Integer>> stack){

		if(root==null) return value;
		int newValue = value-root.data.intValue();
		if(newValue<0) return 5+value;
		stack.add(root);
		// System.out.println(root.data+" "+value+" this"+newValue);
		int left = rootToLeafHelper(root.left, newValue,stack);
		int right = rootToLeafHelper(root.right, newValue,stack);
		Stack<BinaryTreeNode<Integer>> q2;
		if(left+right==0){
			q2 = new Stack<>();
			while(!stack.isEmpty()){
				q2.add(stack.pop());
			}
			while(!q2.isEmpty()){ 
				stack.add(q2.pop());
				System.out.print(stack.peek().data+" ");
			}
			System.out.println();
		}
		// System.out.println(stack.pop().data);
		stack.pop();
		return value;
	}
	
	public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
		Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
		rootToLeafHelper(root,k,stack);
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
		// tree.print();
		// System.out.println();
		rootToLeafPathsSumToK(tree.root,8);	
	}
	
}