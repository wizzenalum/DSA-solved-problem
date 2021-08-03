/*############################################################################
		we will use all traversals to print the tree;
			1. preorder traversals
			2. postordr traversals
			3. inorder traversals
			4. level order traversals

					COMPLETED = True
#############################################################################*/	
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
class BTree<T>{
	T data;   // data is generic type;
	BTree<T> left;  // adreess of left/ first  child node 
	BTree<T> right;  // adreess will be stored in arrary

	// contructor will decide the memory of array and data
	BTree(T data){
		this.data = data;
		this.left = null;
		this.right = null;
		

	}
}

public class PrintWithAllTraversals{

	static Scanner scan = new Scanner(System.in);

	public static BTree<Integer> BTreeInputLevelWise(BTree<Integer> root, Queue<BTree<Integer>> queue,int[] arr, int index){
		BTree<Integer> leftChild, rightChild;
		// System.out.println(index);
		if(root==null){
			int rootData = arr[index];
			index++;
			if(rootData == -1) return null;
			root = new BTree<>(rootData);
		}
		int left = arr[index];
		int right = arr[index+1];

		if(left==-1) root.left = null;
		else {
			leftChild = new BTree<>(left);
			root.left = leftChild;
			queue.add(leftChild);
		}
		if(right==-1) root.right = null;
		else {
			rightChild = new BTree<>(right);
			root.right = rightChild;
			queue.add(rightChild);
		}
		if(!queue.isEmpty()) BTreeInputLevelWise(queue.poll(),queue, arr, index+2);
		return root;
	}	

// *************** print the nodes of tree by pre order traversal**************
	public static void printPre(BTree<Integer> root){
		// time O(n) space O(1)

		if(root==null) return;
		System.out.print("R "+root.data);
		if(root.left!=null) System.out.print(" L "+root.left.data);
		if(root.right!=null) System.out.print(" R "+root.right.data);
		System.out.println();
		printPre(root.left);
		printPre(root.right);

	}
// *************** print the nodes of tree by in order traversal**************
	public static void printIn(BTree<Integer> root){
		// time O(n) space O(1)

		if(root==null) return;
		printIn(root.left);
		System.out.print("R "+root.data);
		if(root.left!=null) System.out.print(" L "+root.left.data);
		if(root.right!=null) System.out.print(" R "+root.right.data);
		System.out.println();
		printIn(root.right);

	}
	// *************** print the nodes of tree by post order traversal**************
	public static void printPost(BTree<Integer> root){
		// time O(n) space O(1)

		if(root==null) return;
		printIn(root.left);
		printIn(root.right);
		System.out.print("R "+root.data);
		if(root.left!=null) System.out.print(" L "+root.left.data);
		if(root.right!=null) System.out.print(" R "+root.right.data);
		System.out.println();

	}
	// *************** print the nodes of tree by level wise traversal**************
	public static void printLevel(BTree<Integer> root, Queue<BTree<Integer>> queue){
		// time O(n) space O(n)

		if(root==null) return;
		if(root.left!=null) queue.add(root.left);
		if(root.right!=null) queue.add(root.right);
		System.out.print(root.data+" ");
		if(!queue.isEmpty()) printLevel(queue.poll(),queue);

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
		Queue<BTree<Integer>> queueForNextNode = new LinkedList<>();
		BTree<Integer> root = BTreeInputLevelWise(null, queueForNextNode, arr, 0);
		// printPost(root);
		// System.out.println();
		// printPre(root);
		// System.out.println();
		// printIn(root);
		printLevel(root,queueForNextNode);
	}
}