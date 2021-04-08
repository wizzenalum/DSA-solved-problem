/*############################################################################
		here we will wrote following functions
			1. replace data of each node with its respective height or depth.
			2. node with data x is present or not
			3. print all the nodes without sibling.

					COMPLETED = true
#############################################################################*/	
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
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

public class ReplaceNodeWithDepth{
	static Scanner scan = new Scanner(System.in);
	public static BinaryTreeNode<Integer> BinaryTreeNodeInputLevelWise(BinaryTreeNode<Integer> root, Queue<BinaryTreeNode<Integer>> queue,int[] arr, int index){
		BinaryTreeNode<Integer> leftChild, rightChild;
		// System.out.println(index);
		if(root==null){
			int rootData = arr[index];
			index++;
			if(rootData == -1) return null;
			root = new BinaryTreeNode<>(rootData);
		}
		int left = arr[index];
		int right = arr[index+1];
		if(left==-1) root.left = null;
		else {
			leftChild = new BinaryTreeNode<>(left);
			root.left = leftChild;
			queue.add(leftChild);
		}
		if(right==-1) root.right = null;
		else {
			rightChild = new BinaryTreeNode<>(right);
			root.right = rightChild;
			queue.add(rightChild);
		}
		if(!queue.isEmpty()) BinaryTreeNodeInputLevelWise(queue.poll(),queue, arr, index+2);
		return root;
	}	
	public static void print(BinaryTreeNode<Integer> root, Queue<BinaryTreeNode<Integer>> queue){
		if(root==null) return;
		if(root.left!=null) queue.add(root.left);
		if(root.right!=null) queue.add(root.right);
		System.out.print(root.data+" ");
		if(!queue.isEmpty()) print(queue.poll(),queue);

	}

//****  replace node's data with depth *********************************************************************
	public static void changeToDepth(BinaryTreeNode<Integer> root,int depth) {

		if(root==null) return;
		root.data = depth;
		changeToDepth(root.left, depth+1);
		changeToDepth(root.right, depth+1);
	    
	}

	public static void changeToDepthTree(BinaryTreeNode<Integer> root) {
		// time O(n) space O(n)

		changeToDepth(root,0);
	    
	}
//**** node with data x in the tree *********************************************************************
	public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
		// time O(n) space O(n)

	    if(root == null) return false;
	    if(root.data.intValue()==x) return true;
	    return isNodePresent(root.left,x)||isNodePresent(root.right,x);
	}
//**** print nodes those dont have sibling *********************************************************************
	public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
		// time O(n) space O(n)
		
		if(root==null) return;
		if(root.left!=null && root.right==null){
			System.out.print(root.left.data.intValue()+" ");
		}
		if(root.left==null && root.right!=null){
			System.out.print(root.right.data.intValue()+" ");
		}
		printNodesWithoutSibling(root.left);
		printNodesWithoutSibling(root.right);
	}

	public static void main(String[] args) {
		/* following is te tree which will be printed by deferent ways

				      1
				   2  	 3
				 4   5	   7

		*/
		int[] arr = {1,2,3,4,5,-1,7,-1,-1,-1,-1,-1,-1};
		Queue<BinaryTreeNode<Integer>> queueForNextNode = new LinkedList<>();
		BinaryTreeNode<Integer> root = BinaryTreeNodeInputLevelWise(null, queueForNextNode, arr, 0);
		// changeToDepthTree(root);
		// print(root, queueForNextNode);
		System.out.print(isNodePresent(root,7));
		System.out.println();
		printNodesWithoutSibling(root);
	}

}