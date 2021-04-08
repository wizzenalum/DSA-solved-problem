/*############################################################################
			 Ancestor matrix from given binary tree
	You are given a binary tree in level wise order where all the values are 
	from 0 to n-1. You have to construct an ancestor matrix of size n x n from 
	the given binary tree.
	Note: You have to write a function to print the ancestor matrix. The matrix 
	given to you as the function argument is initialised with 0.

	Ancestor matrix is defined as:

		matrix[i][j] = 1 if i is ancestor of j
		matrix[i][j] = 0, otherwise

			completed  true

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

public class AncestorMatrix{
	public static void printMatrix(int[][] mat){
		int rows = mat.length, columns = mat[0].length;
		for(int i = 0;i<rows;i++){
			for(int j = 0; j<columns;j++){
				System.out.print(mat[i][j]+" ");
			}System.out.println();
		}
	}
	public static void ancestorHelper(BinaryTreeNode<Integer> root, int[][] mat, ArrayList<Integer> arrList){
		if(root.left ==null && root.right == null) return;
		arrList.add(root.data);
		if(root.left!=null){
			ancestorHelper(root.left,mat,arrList);
			for(int i = arrList.size()-1;i>=0;i--){
				mat[arrList.get(i).intValue()][root.left.data.intValue()] = 1;
			}
		}if(root.right!=null){
			ancestorHelper(root.right,mat,arrList);
			for(int i = arrList.size()-1;i>=0;i--){
				mat[arrList.get(i).intValue()][root.right.data.intValue()] = 1;
			}
		}
		arrList.remove(arrList.size()-1);
	}
	public static void ancestor(BinaryTreeNode<Integer> root, int[][] matrix) {
		ArrayList<Integer> arrList = new ArrayList<>(matrix.length);
		ancestorHelper(root,matrix, arrList);
		printMatrix(matrix);
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
		// tree.
		// tree.printDetail();
		int[][] mat = new int[6][6];
		ancestor(tree.root, mat);
	}
	
}
