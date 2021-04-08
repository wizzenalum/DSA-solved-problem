/*############################################################################
		we will going to implement following functions.
			1. remove all leaf nodes of the tree;
			2. check tree is balanced or not;

					COMPLETED = False
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

public class TutorialProblems{

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
		// time O(n) space O(n)

		if(root==null) return;
		if(root.left!=null) queue.add(root.left);
		if(root.right!=null) queue.add(root.right);
		System.out.print(root.data+" ");
		if(!queue.isEmpty()) print(queue.poll(),queue);

	}
	public static void printDetail(BinaryTreeNode<Integer> root, Queue<BinaryTreeNode<Integer>> queue){
		// time O(n) space O(n)

		if(root==null) return;
		if(root.left!=null) queue.add(root.left);
		if(root.right!=null) queue.add(root.right);
		System.out.print(root.data+" :");
		if(root.left!=null) System.out.print(" L "+root.left.data);
		if(root.right!=null) System.out.print(" R "+root.right.data);
		System.out.println();
		if(!queue.isEmpty()) printDetail(queue.poll(),queue);

	}

//**** remove all nodes of child nodes time O(n) space O(1) *********************************************************************

	public static BinaryTreeNode<Integer> removeAllLeafNodes(BinaryTreeNode<Integer> root){
		if(root == null || (root.left==null && root.right==null)) return null;
		if(root.left!=null && root.left.left==null && root.left.right==null){
			root.left = null;
			if(root.right!=null && root.right.left==null && root.right.right==null){
				root.right = null;
			}
			return root;
		}
		if(root.right!=null && root.right.left==null && root.right.right==null){
				root.right = null;
			if(root.left!=null && root.left.left==null && root.left.right==null){
				root.left = null;	
			}
				return root;
			}
			return root;
		}
//**** remove all nodes of child nodes time O(n) space O(1) *********************************************************************

	public static BinaryTreeNode<Integer> removeAllLeafNodes1(BinaryTreeNode<Integer> root){
		if(root == null || (root.left==null && root.right==null)) return null;
		root.left = removeAllLeafNodes1(root.left);
		root.right = removeAllLeafNodes1(root.right);
		return root;
	}
//****  check tree is balanced time O(n) space O(n) *********************************************************************
	public static int TreeBalanced(BinaryTreeNode<Integer> root){
		// if return -1 then it is not balance else it is balanced. here i am counting the height and comparing it.

		if(root==null) return 0;
		int left = TreeBalanced(root.left);
		int right = TreeBalanced(root.right);
		if(left==-1 || right==-1) return -1;
		if(left-right>1 || right-left>1) return -1;
		return (right>left?right:left)+1;
	}
	public static boolean isTreeBalanced(BinaryTreeNode<Integer> root){
		if(TreeBalanced(root) == -1) return false;
		return true;
	}


	public static void main(String[] args) {
		//creting tree by level wise input
		/* following is te tree which will be printed by deferent ways

				      1
				   2  	 3
				 4   5	   7

		*/
		// 1 2 3 4 5 -1 7 -1 -1 -1 -1 -1 -1
		int[] arr = {1,2,3,4,5,-1,7,-1,-1,-1,-1,-1,8,-1,7,-1,-1};
		Queue<BinaryTreeNode<Integer>> queueForNextNode = new LinkedList<>();
		BinaryTreeNode<Integer> root = BinaryTreeNodeInputLevelWise(null, queueForNextNode, arr, 0);
		// print(root,queueForNextNode);
		removeAllLeafNodes1(root);
		System.out.println(isTreeBalanced(root));
		printDetail(root,queueForNextNode);
	}
}