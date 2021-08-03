/*############################################################################
				 Clone a binary tree

	You are given a binary tree with random pointers. A random pointer of a node 
	points to any random node of the binary tree and it can even point to NULL. 
	You have to clone this binary tree and return the root of the cloned binary tree.
#############################################################################*/
import java.util.Queue;
import java.util.LinkedList;
class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;
	BinaryTreeNode<T> random;

	public BinaryTreeNode(T data) {
		this.data = data;
		this.left = null;
		this.right = null;
		this.random = null;

	}
}

public class CloneBinarytree{
	public static void print(BinaryTreeNode<Integer> root, Queue<BinaryTreeNode<Integer>> queue){
		if(root==null) return;
		if(root.random!=null) System.out.print(root.data+"-> "+root.random.data+" : ");
		else System.out.print(root.data+"-> n : ");

		if(root.left!=null){
			System.out.print(" L "+root.left.data);
			queue.add(root.left);
		}
		// else System.out.print(" L null");

		if(root.right!=null){
			System.out.print(" R "+root.right.data);
			queue.add(root.right);
		}
		// else System.out.print(" R null");
		System.out.println();
		if(!queue.isEmpty()) print(queue.poll(), queue);
	}

	public static void createTreeBetweenRootTree(BinaryTreeNode<Integer> root) {
		// this will create links between root tree and cloned tree. 
		if(root==null) return;
		BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(root.data);
		node.right = root.right;
		root.right = node;
		createTreeBetweenRootTree(root.left);
		createTreeBetweenRootTree(node.right);
	}
	public static void arbitoryLinking(BinaryTreeNode<Integer> root) {
		// create arbitory linkage for new bnary tree 
		if(root==null) return;
		if(root.random!=null) root.right.random = root.random.right;
		arbitoryLinking(root.left);
		arbitoryLinking(root.right.right);
	}
	public static void restoreTree(BinaryTreeNode<Integer> root) {
		// time to restore both trees and create random links to the clone tree.
		if(root==null) return;
		BinaryTreeNode<Integer> temp = root.right;
		root.right = root.right.right;
		if(temp.right!=null) temp.right = temp.right.right;
		if(root.left!=null) temp.left = root.left.right;
		restoreTree(root.left);
		restoreTree(root.right);
	}

	public static BinaryTreeNode<Integer> clonedTree(BinaryTreeNode<Integer> root) {
		if(root == null) return root;
		// create tree inbetween given tree.
		createTreeBetweenRootTree(root);
		// crete arbitory linking.
		arbitoryLinking(root);
		// restore both the trees
		BinaryTreeNode<Integer> clone = root.right;
		restoreTree(root);
		return clone;
    }


	public static void main(String[] args) {
		//creting tree by level wise input
		/* following is te tree which will be printed by deferent ways

				      0
				   1  	 2
				 3   4	   5

		*/
		// 1 2 3 4 5 -1 7 -1 -1 -1 -1 -1 -1
		int[] arr = {0,1,2,3,4,-1,5,-1,-1,-1,-1,-1,-1};
		// int[] arr = {1,2,3,4,7,-1,-1,-1,-1,-1,-1};
		BinaryTree tree = new BinaryTree(arr); // accessed from an another class call ed BinaryTree
		BinaryTree clone = new BinaryTree();
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		tree.root.left.random = tree.root.right.right;
		tree.root.left.right.random = tree.root;
		print(tree.root, queue);
		System.out.println();

		clone.root = clonedTree(tree.root);
		System.out.println();
		print(clone.root,queue);	
	}
}
