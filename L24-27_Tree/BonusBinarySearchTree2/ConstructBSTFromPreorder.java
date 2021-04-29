/*############################################################################
			 Construct a BST from preorder

	You are given preorder traversal of a Binary Search Tree, you have to 
	construct a BST from this preorder traversal.	
		
			completed true
#############################################################################*/
import java.util.Stack;
class LinkedListNode<T>{
	T data;
	LinkedListNode<T> next;
	LinkedListNode(T data){
		this.data = data;
		this.next = null;
	}
}
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
public class ConstructBSTFromPreorder{
	 public static BinaryTreeNode<Integer> constructBST(int[] preorder) {
	 	int len = preorder.length, i = 1;
	 	if(len<=0) return null;
	 	Stack<BinaryTreeNode<Integer>> st = new Stack<>();
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(preorder[0]), temp = root;
        while(i<len){
	        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(preorder[i]);
	        if(node.data<=temp.data){
	        	// System.out.println(temp.data+" "+node.data+" L ");
	        	temp.left = node;
	        	st.add(temp);
	        	temp = node;
	        	i++;
	        }else if(node.data>temp.data && (!st.isEmpty())){
	        	if(st.peek().data>node.data){
		        	// System.out.println(temp.data+" "+node.data+" 1R");
	        		temp.right = node;
	        		temp = node;
	        		i++;
	        	}else temp = st.pop();
	        }else{
	        	// System.out.println(temp.data+" "+node.data+" 2R");
	        	temp.right = node;
	        	temp = node;
	        	i++;
	        }
        }
        return root;
    }
	public static void main(String[] args) {
		//creting tree by level wise input
		/* following is te tree which will be printed by deferent ways

				      4
				   2  	 5
				 1   3	   7

		*/
		// 1 2 3 4 5 -1 7 -1 -1 -1 -1 -1 -1
		int[] arr = {20, 10, 2, 14, 80, 100};

		BinaryTree tree = new BinaryTree(); // accessed from an another class call ed BinaryTree
		tree.root = constructBST(arr);
		tree.printDetail();
		
		

	}	
}
