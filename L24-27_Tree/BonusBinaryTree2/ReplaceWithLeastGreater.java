/*############################################################################
				  Replace with least greater

    You are given an N-sized array of integers, replace every element of this 
    array with the least greater element on its right side in the array. 
    If there is no greater element on the right side, replace it with -1.

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

public class ReplaceWithLeastGreater{
	// iknow this problem is hare not to be bruit force like this but i am doing to get one solution.
    public static void replace(int[] arr, int n) {
        int leastGreater = 0, forward = 0;
        for(int index = 0; index<n;index++){
            leastGreater = index;
            for(forward = index+1;forward<n-1;forward++){
                if(arr[forward]>arr[index]){
                    if(arr[leastGreater]==arr[index]) leastGreater = forward;
                    else if(arr[leastGreater]>arr[forward]) leastGreater = forward;
                }
            }
            if(arr[leastGreater]==arr[index]) arr[index] = -1;
            else arr[index] = arr[leastGreater];
        }
    }
    // here i am using tree to store data and create as look for nextgreate value and reduce arr from backward.

    public static BinaryTreeNode<Integer> replaceWith(BinaryTreeNode<Integer> root, int data, int[] least){
        if(root==null) return new BinaryTreeNode<Integer>(data);
        if(data>=root.data) root.right = replaceWith(root.right,data,least);
        if(data<root.data){
            least[0] = root.data;
            root.left = replaceWith(root.left,data,least);
        }return root;
    }
    
    public static void replaceHelper(int[] arr, int n, BinaryTreeNode<Integer> root){
        int[] least = {-1};
        for(int i = n-1;i>=0;i--){
            least[0] = -1;
            root = replaceWith(root, arr[i], least);
            arr[i] = least[0];
        }
    }
    
    public static void replace1(int[] arr, int n) {
        replaceHelper(arr,n,null);
    }
	public static void main(String[] args) {
		//creting tree by level wise input
		/* following is te tree which will be printed by deferent ways

				      4
				   2  	 5
				 1   3	   7

		*/
		// 1 2 3 4 5 -1 7 -1 -1 -1 -1 -1 -1
		// int[] arr = {4,2,5,1,3,7};
		// int[] arr = {4,1,7,0,2,5,8,3,6,9};
        int[] arr = {8, 58, 71, 18, 31, 32, 63, 92, 43, 3, 91, 93, 25, 80, 28, 2, 1};
        replace1(arr,arr.length);
        System.out.println(Arrays.toString(arr));
		BinaryTree tree = new BinaryTree(); // accessed from an another class call ed BinaryTree
	
		

	}	
}
