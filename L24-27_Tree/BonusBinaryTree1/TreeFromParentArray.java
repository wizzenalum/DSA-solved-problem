/*############################################################################
				 Construct binary tree from parent array

		You are given an N-sized array that represents a binary tree such that 
		array indexes are values in tree nodes and array values give the parent 
		node of that particular index (or node). The value of the root index is 
		-1 as there is no parent of the root node. You have to construct a binary 
		tree from the given parent array.
		
		Note:
		You have to return the root of the constructed tree. The Output will be 
		the sorted level order traversal of the tree.

		Input Format:
		The first line of input contains the size of the parent array(N). 
		The next line input contains the space-separated elements of the input parent array.

		Output Format:
		The Output will be the sorted level order traversal of the tree. Each level 
		of the tree is printed in a new line and in a sorted manner.

		Sample Input:

		7
		6 0 6 2 2 3 -1

		Sample Output:

		6 
		0 2 
		1 3 4 
		5

		Explanation

		                        6
		                       / \
		                      0   2
		                     /   / \
		                    1   3   4
		                       /
		                      5
#############################################################################*/
import java.util.Stack;
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

public class TreeFromParentArray{

	public static void constructBTHelper(int[] parent, int n, BinaryTreeNode<Integer> root) {
     	if(root==null) return;
        boolean left = true, right = false;
     	for(int i =0;i<n;i++){
     		if(parent[i] == root.data.intValue() && left) {
     			root.left = new BinaryTreeNode<>(i);
     			constructBTHelper(parent,n,root.left);
     			left = false;
     			right = true;
     		}else if(parent[i] == root.data.intValue() && right){
     			root.right = new BinaryTreeNode<>(i);
     			constructBTHelper(parent,n,root.right);
     		}else if((!left)&&(!right)) break;
        }
    }	
     public static BinaryTreeNode<Integer> constructBT(int[] parent, int n) {
     	if(n==0) return null;
        BinaryTreeNode<Integer> root = null;
     	for(int i =0;i<n;i++){
     		if(parent[i] == -1) {
     			root = new BinaryTreeNode<>(i);
     			break;
     		}
        }
        constructBTHelper(parent,n,root);
        return root;
    }

	public static void main(String[] args) {
		//creting tree by level wise input
		/* following is te tree which will be printed by deferent ways

				      1
				   2  	 3
				 4   5	   7

		*/
		int[] arr = {6, 0, 6, 2, 2, 3, -1};

		BinaryTree tree = new BinaryTree();
		tree.root = constructBT(arr,arr.length);
		tree.printDetail();
		// postOrder(tree.root);
	}
	
}
