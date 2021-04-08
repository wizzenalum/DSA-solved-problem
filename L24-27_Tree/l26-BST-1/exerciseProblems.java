/*############################################################################
			function impelimented here are 
		1. search in BST(binary search tree)
		2. print elements b/w k1 an k2;
		3. construct BST.
			completed -- true.
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

public class exerciseProblems{
/*    Given a BST and an integer k. Find if the integer k is present in given BST or not. 
      You have to return true, if node with data k is present, return false otherwise.*/
	public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {
		if(root == null) return false;
		if(root.data.intValue() >k) return searchInBST(root.left,k);
		else if(root.data.intValue() <k) return searchInBST(root.right,k);
		else return true;
	}

//****  Given BST and integer k1 and k2, print the elements which are in range k1 and k2 (both inclusive). ************
	public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root,int k1,int k2){
		if(root==null) return;
		if(root.data<k1) elementsInRangeK1K2(root.right,k1,k2);
		else if(root.data>=k1 && root.data<=k2){
			elementsInRangeK1K2(root.left,k1,k2);
			System.out.print(root.data+" ");
			elementsInRangeK1K2(root.right,k1,k2);
		}
		else if(root.data>k2) elementsInRangeK1K2(root.left,k1,k2);

	}
/* 		Given a sorted integer array A of size n, which contains all unique elements. You need to 
		construct a balanced BST from this input array. Return the root of constructed BST.
		Note: If array size is even, take first mid as root.    */

	public static BinaryTreeNode<Integer> ArrayToBSTHelper(int[] arr, int start, int end){
		if(start>end) return null;
		int mid = (start+end)/2;
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(arr[mid]);
		root.left = ArrayToBSTHelper(arr, start, mid-1);
		root.right = ArrayToBSTHelper(arr, mid+1, end);
		return root;

	}

	public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n){
		if(arr.length<=0) return null;
		return ArrayToBSTHelper(arr,0,n-1);				
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
		// ArrayList<Integer> arrList = new ArrayList<>(); 
		// System.out.println(searchInBST(tree.root, 8));
	// second problme.
		// elementsInRangeK1K2(tree.root,2,5);
	// third problme.
		int[] arr2 = {1,2,3,4,5,7};
		tree.root = SortedArrayToBST(arr2,arr2.length);
		tree.printDetail();

	}	
}
