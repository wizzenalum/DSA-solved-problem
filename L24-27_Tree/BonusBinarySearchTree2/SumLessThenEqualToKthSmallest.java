/*############################################################################
			Sum of elements less than or equal to Kth smallest element

    You are given an integer K and elements of a binary search tree in level 
    order form. You have to return the sum of elements which are smaller than 
    or equal to Kth smallest element of the tree.

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

public class SumLessThenEqualToKthSmallest{
    // method1 
        // step1 look for inorder succssor in tree.
        // step2 add this element to the tree.
        // step3 according to the lookup set the values
        // it cause time complexity O(n).
    // method 2
        // here this fuction do both works at same time. and return directly sum.
	// public static int solve(BinaryTreeNode<Integer> node, int[] k){
 //        if(node == null) return 0;
 //        int sum = solve(node.left,k);
 //        if(k[0]==0) return sum;
 //        sum+=node.data;
 //        // System.out.println(node.data);
 //        k[0]--;
 //        sum+= solve(node.right,k);
 //        return sum;
 //    }
    public static int solve(BinaryTreeNode<Integer> node, int k){
        int count=0;
        int sum=0;
        while(node!=null ){
            if(node.left==null){
                sum=sum+node.data;
                count=count+1;
                if(count==k){
                    break;
                }
                node=node.right;
            }
            else{
                BinaryTreeNode<Integer> predecessor=node.left;
                while(predecessor.right!=null && predecessor.right!=node){
                    
                    predecessor=predecessor.right;
                }
                if(predecessor.right==null){
                    
                    predecessor.right=node;
                    node=node.left;
                }
                else{
                    predecessor.right=null;
                    sum=sum+node.data;
                    count=count+1;
                    if(count==k){
                        break;
                    }
                    node=node.right;
                }
            }
        }
        return sum;
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
        int[] k = {3};
        System.out.println(solve(tree.root, 3));
		

	}	
}