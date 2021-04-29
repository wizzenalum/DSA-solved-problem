/*############################################################################
				 Find median of a BST
	You are given a BST, return the integral part of the median of the given BST.
	If the number of nodes are even, then median=((n/2)th node+(n/2+1)th node)/2
	If the number of nodes are odd, then median=(n/2)th node
	Note: The time complexity should be O(n) and space complexity should be O(1).

					completed true
#############################################################################*/
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class BinaryTreeNode<T>{
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;
	BinaryTreeNode(T data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class FindMedianOfBST{


	
	
	
	public static int median(BinaryTreeNode<Integer>  root,int[] count, int size, int[] meidanSent){
		if(root==null) return -1;
		System.out.println("func" +root.data+" "+meidanSent[0]);
		int median = median(root.left,count, size,meidanSent);
		count[0]++;
		if(size%2==1){
			if(count[0] == size/2+1){
				System.out.println("return 1 "+root.data);
				return root.data;

			} 
		}else{
			if(count[0] == size/2){
				meidanSent[0] = root.data;
			} 
		}
		if(median!=-1){
			System.out.println("return 2 "+median);
			return median;	
		} 
		median = median(root.right,count,size,meidanSent);
		if(meidanSent[0]!=-1){
			System.out.println("return 3 "+((root.data+meidanSent[0])/2));
			return (root.data+meidanSent[0])/2;	
		} 
		System.out.println("return 4 "+median);
		return median;
	}
	public static int countNode(BinaryTreeNode<Integer> root){
		if(root == null) return 0;
		int left = countNode(root.left);
		int right = countNode(root.right);
		return left+right+1;
	}
	public static BinaryTreeNode<Integer> findNthNode(BinaryTreeNode<Integer> root, int[] count,int position){
		if(root==null) return null;
		BinaryTreeNode<Integer> node = findNthNode(root.left,count,position);
		count[0]++;
		if(node!=null) return node;
		if(count[0] == position) return root;
		node = findNthNode(root.right,count,position);
		return node;
	}
  	public static int median(BinaryTreeNode<Integer> root) {
  		// method 1 count size call look for median element and calculate and retrun median
  		int size = countNode(root), median=0;
        int[] count = {0};

        BinaryTreeNode<Integer > node = findNthNode(root,count,size/2+1);
    	median = node.data;
        if(size%2==0){
        	count[0] = 0;
        	node = findNthNode(root,count,size/2);
        	median = (median+node.data)/2;
        }
        // int[] meidanSent = {-1};
        // int median = median(root,count,size,meidanSent);
        return median;
    }
	public static void main(String[] args) {
		//creting tree by level wise input
		/* following is te tree which will be printed by deferent ways

				      5
                   /    \
                 3        7
                /  \     /  \
               2    4   6    8

		*/
		// 1 2 3 4 5 -1 7 -1 -1 -1 -1 -1 -1
		// int[] arr = {50, 25, 75, 12, 37, 62, 87, -1, -1, 30, 40, -1, -1, -1, -1, -1, -1, -1, -1  };
		int[] arr = {5, 3, 7, 2, 4, 6, -1, -1, -1, -1, -1, -1, -1};
		BinaryTree tree = new BinaryTree(arr);
		tree.printDetail();
		System.out.println(median(tree.root));
	}	
}
