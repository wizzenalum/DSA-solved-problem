/*############################################################################
		we will going to implement following functions.
			1. For a given preorder and inorder traversal of a Binary Tree of 
				type integer stored in an array, create the binary tree using 
				the given two arrays. You just need to construct the tree and 
				return the root.
			2. For a given postorder and inorder traversal of a Binary Tree of 
				type integer stored in an array, create the binary tree using 
				the given two arrays. You just need to construct the tree and 
				return the root.

					COMPLETED = True
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

public class CreateTreeFromPreorderInorderAndPostorder{
//****PREORDER TO TREE *********************************************************************

// buid tree from preorder and post order traversal array.
	public static BinaryTreeNode<Integer> buidTreeHelperPreIn(	int[] preOrder, int[] inOrder,
																int preStart, int preLast,
																int inStart, int inLast ){
		// in preOrder traversal first element is root always.
		// in InOrder traversal root node devide left and right child trees.
		if(preLast-preStart<1){
			return null;
		}
		// System.out.println(preStart+" "+preLast+" "+inStart+" "+inLast);
		int rootData = preOrder[preStart], leftNodes=0;
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
		if(preLast-preStart==1){
			return root;
		}
		for(int i = inStart;i<inLast;i++){
			// System.out.println(in);
			if(inOrder[i]==rootData) break;
			leftNodes++;
		}
		// System.out.println(rootData+" "+leftNodes);
		root.left = buidTreeHelperPreIn(preOrder,inOrder,preStart+1,leftNodes+preStart+1,inStart,inStart+leftNodes);
		root.right = buidTreeHelperPreIn(preOrder,inOrder,preStart+leftNodes+1,preLast,inStart+leftNodes+1,inLast);
		return root;
	}

	public static BinaryTreeNode<Integer> buildTreePre(int[] preOrder, int[] inOrder) {
		if(preOrder.length==0 || preOrder.length!=inOrder.length) return null;
		return buidTreeHelperPreIn(preOrder,inOrder,0,preOrder.length,0,inOrder.length);	
	}

//****POSTORDER TO TREE *********************************************************************

// buid tree from preorder and post order traversal array.
	public static BinaryTreeNode<Integer> buidTreeHelperPost(	int[] postOrder, int[] inOrder,
																int postStart, int postLast,
																int inStart, int inLast ){
		// System.out.println(postStart+" "+postLast+" "+inStart+" "+inLast);
		if(postStart>postLast) return null;
		int rootData = postOrder[postLast], leftNodes=0;
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
		if(postLast==postStart){
			return root;
		}
		// System.out.println("survive"+postStart+" "+postLast+" "+inStart+" "+inLast);

		for(int i=inStart;i<=inLast;i++){
			if(inOrder[i]==rootData) break;
			leftNodes++;
		}
		// System.out.println(rootData+" "+leftNodes);
		root.left = buidTreeHelperPost(postOrder,inOrder,postStart,postStart+leftNodes-1,inStart,inStart+leftNodes-1);
		root.right = buidTreeHelperPost(postOrder,inOrder,postStart+leftNodes,postLast-1,inStart+leftNodes+1,inLast);
		return root;
	}

	public static BinaryTreeNode<Integer> buildTreePost(int[] postOrder, int[] inOrder) {
		if(postOrder.length<=0 || postOrder.length!=inOrder.length) return null;
		return buidTreeHelperPost(postOrder,inOrder,0,postOrder.length-1,0,inOrder.length-1);	
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
		BinaryTree tree = new BinaryTree(arr);
		BinaryTreeNode<Integer> root = tree.root;
		// int[] preOrder = {1, 2, 4, 5, 3, 6, 7};
		// int[] inOrder = {4, 2, 5, 1, 6, 3, 7};
		// int[] postOrder = {4,5,2,6,7,3,1};
		// int[] preOrder = {1, 2, 3};
		// int[] inOrder = {2,1,3};
		// int[] postOrder = {2,3,1};
		int[] preOrder = {1,2,3,4,5,6,7,8,9};
		int[] inOrder = {1,2,6,5,4,8,7,9,3};
		int[] postOrder = {6,5,8,9,7,4,3,2,1};
		tree.root = buildTreePre(preOrder,inOrder);
		tree.printDetail();
		tree.root = buildTreePost(postOrder,inOrder);
		tree.printDetail();
	}
}
