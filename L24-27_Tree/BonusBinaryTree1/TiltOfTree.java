/*############################################################################
				  Tilt of a Binary tree

	You are given a binary tree and you have to return the tilt of the whole tree.

	Tilt of the whole tree is the sum of all nodes' tilt and the tilt of a node 
	is the absolute difference between the sum of all left subtree node values 
	and the sum of all right subtree node values. The tilt of null nodes is 0.

				completed:- true
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

class TiltData{
	static int tiltSum = 0;
	int tilt;
	int sum;
	TiltData(int tilt,int sum){
		this.tilt = tilt;
		this.sum = sum;
	}
}

public class TiltOfTree{
	public static TiltData getTiltHelper(BinaryTreeNode<Integer> root){
		if(root == null) return new TiltData(0,0);
		TiltData leftSet = getTiltHelper(root.left);
		TiltData rightSet = getTiltHelper(root.right);
		int sum = leftSet.sum+rightSet.sum+root.data.intValue();
		int tilt = Math.abs(leftSet.sum-rightSet.sum);
		TiltData.tiltSum += tilt;
		return new TiltData(tilt,sum);
	}

	
	public static int getTilt(BinaryTreeNode<Integer> root) {
		TiltData set = getTiltHelper(root);
		return set.tiltSum;
            
    }

	public static void main(String[] args) {
		//creting tree by level wise input
		/* following is te tree which will be printed by deferent ways

				      1
				   2  	 3
				 4   5	   7

		*/
		// 1 2 3 4 5 -1 7 -1 -1 -1 -1 -1 -1
		// int[] arr = {1,2,3,4,5,-1,7,-1,-1,-1,-1,-1,-1};
		int[] arr = {1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1};

		BinaryTree tree = new BinaryTree(arr); // accessed from an another class call ed BinaryTree
		System.out.println(getTilt(tree.root));
		tree.printDetail();
	}
	
}
