/*############################################################################
		implimetation of the binary tree node by creating array of child nodes.
					

					STATUS  -- completed
		input data from user in left to right recursivly.
		printing that tree 
		input data from user level wise.		
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

public class BinaryTree{

//**** print the tree  time O(n) space O(n) *********************************************************************

	public static void print(BTree<Integer> root){
		if(root==null) return;
		System.out.print(root.data+" : ");
		if(root.left!=null) System.out.print("L "+root.left.data);
		if(root.right!=null) System.out.print("   R "+root.right.data);
		System.out.println();
		// System.out.print("left  ");
		print(root.left);
		// System.out.print("   right   ");
		print(root.right);

	}
	static Scanner scan = new Scanner(System.in);

	public static BTree<Integer> BTreeInput(){
		// time O(n) space O(n)

		int rootData = scan.nextInt();
		if(rootData == -1) return null;
		BTree<Integer> left = BTreeInput();
		BTree<Integer> right = BTreeInput();
		BTree<Integer> root = new BTree<>(rootData);
		root.left = left;
		root.right = right;
		return root;
	}
	public static BTree<Integer> BTreeInput1(BTree<Integer> root){
		// time O(n) space O(n)

		BTree<Integer> leftChild, rightChild;
		if(root==null){
			int rootData = scan.nextInt();
			if(rootData == -1) return null;
			root = new BTree<>(rootData);
		}
		int left = scan.nextInt();
		int right = scan.nextInt();

		if(left==-1) root.left = null;
		else {
			leftChild = new BTree<>(left);
			root.left = leftChild;
			BTreeInput1(leftChild);
		}
		if(right==-1) root.right = null;
		else {
			rightChild = new BTree<>(right);
			root.right = rightChild;
			BTreeInput1(rightChild);
		}
		return root;
	}

	public static BTree<Integer> BTreeInputLevelWise(BTree<Integer> root, Queue<BTree<Integer>> queue){
		// time O(n) space O(n)
		
		BTree<Integer> leftChild, rightChild;
		if(root==null){
			int rootData = scan.nextInt();
			if(rootData == -1) return null;
			root = new BTree<>(rootData);
		}
		int left = scan.nextInt();
		int right = scan.nextInt();

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
		if(!queue.isEmpty()) BTreeInputLevelWise(queue.poll(),queue);
		return root;
	}
	// 1 2 4 -1 -1 5 -1 -1 3 -1 7 -1 -1

	public static void main(String[] args) {
		// BTree<Integer> root = new BTree<>(1);
		// // System.out.println(root.data);
		// BTree<Integer> child1 = new BTree<>(2);
		// BTree<Integer> child2 = new BTree<>(3);
		// root.left = child1;
		// root.right = child2;
		// BTree<Integer> node1 = new BTree<>(4);
		// BTree<Integer> node2 = new BTree<>(5);
		// BTree<Integer> node3 = new BTree<>(6);
		// child1.left = node1;
		// child2.left = node2;
		// child1.right = node3;
		// creting input from terminal. in two formats as given.
		// 1 2 4 -1 -1 5 -1 -1 3 -1 7 -1 -1
		// BTree<Integer> root1 = BTreeInput();
		// //1 2 3 4 5 -1 -1 -1 -1 -1 7 -1 -1
		// BTree<Integer> root2 = BTreeInput1(null);
		// print(root1);
		// print(root2);

		//creting tree by level wise input
		// 1 2 3 4 5 -1 7 -1 -1 -1 -1 -1 -1
		Queue<BTree<Integer>> queueForNextNode = new LinkedList<>();
		BTree<Integer> root3 = BTreeInputLevelWise(null, queueForNextNode);
		print(root3);
	}
}