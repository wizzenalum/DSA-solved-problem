/*############################################################################
		here we will wrote following functions
			1. serch greatest node in the tree.
			2. count all nodes that are greater than x.
					COMPLETED = True;
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

public class GreatestAndMoreThanx{

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
	public static void printLevel(BinaryTreeNode<Integer> root, Queue<BinaryTreeNode<Integer>> queue){
		if(root==null) return;
		if(root.left!=null) queue.add(root.left);
		if(root.right!=null) queue.add(root.right);
		System.out.print(root.data+" ");
		if(!queue.isEmpty()) printLevel(queue.poll(),queue);

	}


//**** find node that has greteset data *********************************************************************
	public static int largestData(BinaryTreeNode<Integer> root) {
		// time O(n) space O(n)

		if(root==null) return -1;
		int left = largestData(root.left);
		int right = largestData(root.right);
		int x = left>right?left:right;
		x = x>root.data.intValue()?x:root.data.intValue();

		return x;
	}
//**** find number of nodes that are greater than x   ********************************************************

	public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x) {
		// time O(n) space O(n)
		
		if(root==null) return 0;
		int left = countNodesGreaterThanX(root.left,x);
		int right = countNodesGreaterThanX(root.right,x);
		if(root.data.intValue()>x){
			return 1+left+right;
		}
		return left+right;
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,-1,7,-1,-1,-1,-1,-1,-1};
		Queue<BinaryTreeNode<Integer>> queueForNextNode = new LinkedList<>();
		BinaryTreeNode<Integer> root = BinaryTreeNodeInputLevelWise(null, queueForNextNode, arr, 0);
		System.out.println(largestData(root));
		System.out.println(countNodesGreaterThanX(root,3));
		// printLevel(root,queueForNextNode);
	}
}