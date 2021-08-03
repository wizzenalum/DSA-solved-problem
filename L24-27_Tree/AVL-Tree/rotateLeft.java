/*############################################################################
				  rotate left BSt
	AVL TREE = balnced BST. 
	if tree is heavy at right side than we rotate it left to make it balanced.
		
					completed false
					
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

public class BSTDeadEnd{

	 public static boolean deadEnd(BinaryTreeNode<Integer> root) {
	 	// it showing good results when i am checking it but this not looking at two cases.

        if(root==null || (root.left==null && root.right==null)) return false;
        boolean left, right;
        BinaryTreeNode<Integer> superRoot = root,temp= null;
        if(superRoot.left!=null){
        	root = superRoot.left;
        	if(root.right!=null && (superRoot.data-2 <= root.data)){
        		if(root.data+1 == root.right.data) return true;
        	}
        }if(superRoot.right!=null){
        	root = superRoot.right;
        	if(root.left!=null && (superRoot.data+2 <= root.data)){
        		if(root.data-1 == root.left.data) return true;
        	}
        } 
        left = deadEnd(superRoot.left);
        right = deadEnd(superRoot.right);
        if(left||right) return true;
		return false;

    }
 	public static boolean deadEndHelper(BinaryTreeNode<Integer> root, int min, int max) {
   		if(root== null) return false;
   		if(min==max) return true;
   		boolean left = deadEndHelper(root.left, min, root.data-1);
   		boolean right = deadEndHelper(root.right, root.data+1, max);
   		return left||right;
    }
    public static boolean deadEnd1(BinaryTreeNode<Integer> root) {
	 	//  here i will find posible min max of every node if one node have same min max that will be dead end.
	 	return deadEndHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

	public static void main(String[] args) {
		//creting tree by level wise input
		/* following is te tree which will be printed by deferent ways

				      4
				   2  	 5
				 1   3	   7

		*/
		// 1 2 3 4 5 -1 7 -1 -1 -1 -1 -1 -1
		// int[] arr = {4,2,5,1,3,-1,7,-1,-1,-1,-1,-1,-1};
				 int[] arr = {8, 7, 10, 2, -1, 9, 13,-1,-1,-1,-1,-1,-1};
		BinaryTree tree = new BinaryTree(arr); // accessed from an another class call ed BinaryTree
		tree.printDetail();
		System.out.println(deadEnd1(tree.root));
		System.out.println(tree.height());
		BinaryTreeNode<Integer>[] j = {tree.root};
		

	}	
}
