/*############################################################################
			 Kth smallest node in BST

	Given a BST and an integer K, you need to find the Kth smallest element 
	present in the BST. Return INT_MIN if that is not present in the BST.
	
					completed true
#############################################################################*/
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
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

public class KthSmallestNodeInBST{
	public static int k;
    public static int kthSmallestNode(BinaryTreeNode<Integer> root){
    	if(root==null) return Integer.MIN_VALUE;
    	int smallest = kthSmallestNode(root.left);
    	if(smallest!=Integer.MIN_VALUE) return smallest;
    	k--;
    	if(k==0) return root.data;
    	int smallest2 = kthSmallestNode(root.right);

		return smallest2;
		
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
		BinaryTree tree = new BinaryTree(arr); // accessed from an another class call ed BinaryTre
		k = 8;
        System.out.println(kthSmallestNode(tree.root));
		

	}	
}
