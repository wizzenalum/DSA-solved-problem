/*############################################################################
			function impelimented here are 
		1. BST(Binary search Tree) to LL(Linked List).
		2. print elements b/w k1 an k2;
		3. construct BST.
			completed  --  false
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

class LinkedListNode<T>{
	T data;
	LinkedListNode<T> next;
	LinkedListNode(T data){
		this.data = data;
		this.next = null;
	}
}

public class AssignmentProblem{
	public static void printll(LinkedListNode<Integer> node){
		if(node==null) {
			System.out.println("null");
			return;
		}
		System.out.print(node.data+" -> ");
		printll(node.next);
	}
/*************   Given a BST, convert it into a sorted linked list. You have to return the head of LL.   ********/
	public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
		if(root==null) return null;
		// System.out.println("root "+ root.data);
		LinkedListNode<Integer> llNode = new LinkedListNode<>(root.data);
		LinkedListNode<Integer> right = constructLinkedList(root.right);
		llNode.next = right;

		LinkedListNode<Integer> left = constructLinkedList(root.left);
		if(left==null) return llNode;

		right = left;
		if(left!=null) while(left.next!=null) left = left.next;
		left.next =llNode;
		return right;
	}
	// method 2
	static class Pair{
		LinkedListNode<Integer> start, end;
		Pair(LinkedListNode<Integer> start, LinkedListNode<Integer> end){
			this.start = start;
			this.end = end;
		}
	}
	public static Pair constructHelper(BinaryTreeNode<Integer> root) {
		if(root == null) return new Pair(null,null);
		LinkedListNode<Integer> node = new LinkedListNode<>(root.data);
		Pair rootPair = new Pair(node,node);
		Pair leftPair = constructHelper(root.left);
		Pair rightPair = constructHelper(root.right);
		if(leftPair.end != null){
			leftPair.end.next = node;
			rootPair.start = leftPair.start;
		}
		node.next = rightPair.start;
		if(rightPair.end!=null) rootPair.end = rightPair.end;
		
		return rootPair;
	}
	public static LinkedListNode<Integer> constructLinkedList1(BinaryTreeNode<Integer> root) {
		return constructHelper(root).start;
	}


//****  Given a BST and data of two nodes, find 'LCA' (Lowest Common Ancestor) of the given two nodes in the BST. ************
	public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
		if(root==null) return -1;
		int current = root.data.intValue(), left =-1, right = -1;
		if(a<=current || b<=current) left = getLCA(root.left,a,b);
		if(current<=a || current<=b) right = getLCA(root.right,a,b);
		// first if statemnets
		if(left==a && right==b || left==b && right==a) return current;
		if(left!=-1 && left!=a && left!=b) return left;
		if(right!=-1 && right!=a && right!=b) return right;
		if(current==a || current==b) return current;
		if(((left==a)||(left==b))) return left;
		if(((right==a)||(right==b))) return right;
		// another if statemnets
		// if(left==a){
		// 	if(right==b || current == b) return current;
		// 	if(right!=-1) return right;
		// }if(left==b){
		// 	if(right == a || current == a) return current;
		// 	if(right!=-1) return right;
		// }if(left!=-1) return left;
		// if(right==a){
		// 	if(current == b) return current;
		// 	if(left!=-1) return left;
		// }if(right==b){
		// 	if(current == a) return current;
		// 	if(left!=-1) return left;
		// }if(right!=-1) return right;
		// if(current == a || current == b) return current; 
		return -1;
	}
/* 		Given a binary search tree, you have to replace each node's 
		data with the sum of all nodes which are greater or equal than it. 
		You need to include the current node's data also.   */
	public static int replaceHelper(BinaryTreeNode<Integer> root, int parentSum) {
		if(root == null) return 0;
		int current = root.data;
		int right = replaceHelper(root.right,parentSum);
		root.data = right+current+parentSum;
		int left = replaceHelper(root.left, root.data);
		return right+current+left;
	}
	// another replaceHelper 
	public static int replaceHelper1(BinaryTreeNode<Integer> root, int parentSum) {
		if(root == null) return parentSum;
		parentSum = replaceHelper(root.right,parentSum);
		parentSum += root.data;
		parentSum = replaceHelper(root.left, parentSum);
		return parentSum;
	}
		public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
			replaceHelper1(root,0);
	}

	public static void main(String[] args) {
		//creting tree by level wise input
		/* following is te tree which will be printed by deferent ways

				      4
				   2  	 5
				 1   3	   7

		*/
		// 1 2 3 4 5 -1 7 -1 -1 -1 -1 -1 -1
		int[] arr = {4,2,5,1,3,-1,7,-1,-1,-1,-1,-1,-1};

		BinaryTree tree = new BinaryTree(arr); // accessed from an another class call ed BinaryTree
		tree.printDetail();
	// first problem. 
		// printll(constructLinkedList(tree.root));
		// printll(constructLinkedList1(tree.root));
	// second problem.
		// System.out.println(getLCA(tree.root,2,5));
	// third problem
		replaceWithLargerNodesSum(tree.root);
		tree.printDetail();
		

	}	
}
