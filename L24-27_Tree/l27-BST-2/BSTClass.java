/*############################################################################
							 BST Class

		Implement the BST class which includes following functions -
	1. search
		Given an element, find if that is present in BST or not. Return true or false.

	2. insert -
		Given an element, insert that element in the BST at the correct position. 
		If element is equal to the data of the node, insert it in the left subtree.
		
	3. delete -
		Given an element, remove that element from the BST. If the element which is 
		to be deleted has both children, replace that with the minimum element from 
		right sub-tree.
		
	4. printTree (recursive) -
		Print the BST in ithe following format -
		For printing a node with data N, you need to follow the exact format -
		N:L:x,R:y

		where, N is data of any node present in the binary tree. x and y are the 
		values of left and right child of node N. Print the children only if it 
		is not null.
		There is no space in between.
		You need to print all nodes in the recursive format in different lines.
				
				completed false
#############################################################################*/
import java.util.Stack;
class BinaryTreeNode<T>{
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;
	BinaryTreeNode(T data){
		this.data 	= data;
		this.left 	= null;
		this.right 	= null;
	}
}	


class BinarySearchTree {
	BinaryTreeNode<Integer> root;

	// constructor
	BinarySearchTree(BinaryTreeNode<Integer> root){
		this.root = root;
	}
	BinarySearchTree(){
		this.root = null;
	}
	

	// Implements insert function to add new item in the BST
	private static void insertHelper(BinaryTreeNode<Integer> root, int data){
		if(root==null) return;
		BinaryTreeNode<Integer> node = new BinaryTreeNode<>(data);
		if(data<=root.data){
			if(root.left!=null) insertHelper(root.left,data);
			else root.left=node;
		}else{
			if(root.right!=null) insertHelper(root.right, data);
			else root.right = node;
		}

	}

	public void insert(int data) {
		if(this.root==null){
			this.root = new BinaryTreeNode<>(data);
		}else insertHelper(this.root,data);
	}


	private static BinaryTreeNode<Integer> removeHelper(	BinaryTreeNode<Integer> root,
														 	BinaryTreeNode<Integer> preRoot, int data){
		// here i am replacing the data node with inorder successor from inorder successor and inorder predecessor.
		if(root==null) return null;
		if(root.data<data) root = removeHelper(root.right,root,data);
		else if(root.data>data) root = removeHelper(root.left,root,data);
		else{
			if(root.right==null) root = root.left;
			else if(root.right.left==null){
				root.right.left = root.left;
				root = root.right;
			}else{
				BinaryTreeNode<Integer> temp=null, tempRoot=null;
				temp = root.right;
				tempRoot = temp.left;
				while(tempRoot.left!=null){
					temp = tempRoot;
					tempRoot = tempRoot.left;
				}
				temp.left = tempRoot.right;
				tempRoot.left = root.left;
				tempRoot.right = root.right;
				root = tempRoot;
			}
		}
		if(preRoot==null) return root;
		else if(root==null);
		else if(preRoot.data>=root.data) preRoot.left = root;
		else preRoot.right = root;
		return preRoot; 
	}
	public void remove(int data) {
		this.root = removeHelper(this.root,null, data);
	}
	

	private static void printHelper(BinaryTreeNode<Integer> root){
		if(root==null) return;
		System.out.print(root.data+":");
		if(root.left!=null) System.out.print("L:"+root.left.data+",");
		if(root.right!=null) System.out.print("R:"+root.right.data);
		System.out.println();
		printHelper(root.left);
		printHelper(root.right);
	}


	private static void printHelper1(BinaryTreeNode<Integer> root){
		// no stack overflow probllem
		if(root==null) return;
		Stack<BinaryTreeNode<Integer>> st = new Stack<>();
		out:
		while(root!=null){
			System.out.print(root.data+":");
			if(root.left!=null) System.out.print("L:"+root.left.data+",");
			if(root.right!=null) System.out.print("R:"+root.right.data);
			System.out.println();
			if(root.left==null && root.right==null){
				if(st.isEmpty()) break;
				BinaryTreeNode<Integer> temp = st.pop();
				while(temp.right==null){
					if(st.isEmpty()) break out;
					temp = st.pop();
				}
				root = temp.right;
			}
			else if(root.left!=null){
				st.add(root);
				root = root.left;
			}else if(root.right!=null){
				root = root.right;
			}
		}

	}
	public void printTree() {
		printHelper1(this.root);
		// System.out.println();
		// printHelper(this.root);
	}
	

	private static boolean searchHelper(BinaryTreeNode<Integer> root, int data){
		if(root==null) return false;
		boolean check = false;
		if(data<root.data) check = searchHelper(root.left,data);
		else if(data>root.data) check = searchHelper(root.right,data);
		else check = true;
		return check;
	}
	public boolean search(int data) {
		return searchHelper(this.root,data);

	}
}
public class BSTClass{
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		int[] arr = {4,5,6,3,8};
		for(int i =0; i< arr.length;i++){
			bst.insert(arr[i]);
		}
		bst.printTree();
		for(int i =0; i< arr.length;i++){
			bst.remove(arr[arr.length-1-i]);
			System.out.println();
			bst.printTree(); 
		}
		// bst.remove(8);
		// System.out.println();
		// bst.printTree(); 
	}
}