/*############################################################################
				  Find the closest element

    You are given a BST in the level order form and a target node K. You have 
    to find a node having the minimum absolute difference with target value K 
    and print the value of that minimum absolute difference.
    
        Sample Input:
            9 4 17 3 6 -1 22 -1 -1 5 7 20 -1 -1 -1 -1 -1 -1 -1
            18

        Sample Output:
            1

        Explanation:
            Here K=18, The node that has value nearest to K is 17 so it's 
            difference with k is 1 is the answer.

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

public class FindClosestElement{
     public static int minDiff(BinaryTreeNode<Integer> root, int k) {
        // return nearest available element to k
        if(root == null) return -1;
        int left = minDiff(root.left,k);
        int right = minDiff(root.right,k);
        int min = root.data, temp = 0;
        if(left!=-1){
            temp = Math.abs(left-k);
            if(temp<Math.abs(root.data-k)) min = left;
        } 
        if(right!=-1){
            temp = Math.abs(right-k);
            if(temp<Math.abs(root.data-k)) min = right;
        }
        return min;
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
        System.out.println(minDiff(tree.root, 3));
		

	}	
}
