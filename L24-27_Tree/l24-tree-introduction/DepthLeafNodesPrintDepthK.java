/*############################################################################
		here we will wrote following functions
			1. calculate the height of the tree;
			2. count the leaf nodes of the tree.
			3. print each node that is present at the k depth.

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

public class DepthLeafNodesPrintDepthK{
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


//****  height of the  tree where null head has 0 height  ***************************************

	public static int height(BinaryTreeNode<Integer> root) {
		// time O(n) space O(n)
		if(root==null) return 0;
		int left = height(root.left);
		int right = height(root.right);
		return 1+ (left>right?left:right);
	}

//****  count the leaf nodes of the treee *****************************************************
		// time O(n) space O(n)

	public static int leafNodes(BinaryTreeNode<Integer> root) {
		if(root==null) return 0;
		if(root.left==null && root.right==null) return 1;
		int left = leafNodes(root.left);
		int right = leafNodes(root.right);
		return left+right;
	}
//****  print nodes at depth k  *****************************************************
		// time O(n) space O(n)
	
	public static void printAtDepthk(BinaryTreeNode<Integer> root, int k) {
		// here depth 0 means root and height 1;
		if(root==null||k<0) return;
		if(k==0){
			System.out.print(root.data.intValue()+" ");
			return;
		}
		printAtDepthk(root.left,k-1);
		printAtDepthk(root.right,k-1);
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
		print(root, queueForNextNode);
		System.out.println();
		System.out.println(height(root));
		System.out.println(leafNodes(root));
		System.out.println();
		printAtDepthk(root,2);
	}

}