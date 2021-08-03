/*############################################################################
		Iterative postorder traversal of binary tree

	Given a binary tree, print the iterative postorder traversal of a given tree.
	Post-order traversal is: LeftChild RightChild Root

					completed:- true
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

public class InterativePostOrderTraversal{
	
	 public static void postOrder(BinaryTreeNode<Integer> root) {
	 	BinaryTreeNode<Integer> prev =null;
	 	Stack<BinaryTreeNode<Integer>> st = new Stack<>();
	 	int i=0;
            while(root!=null && i<30){
            	// System.out.println();
            	// System.out.print("while   "+root.data);
            	// i++;
            	if(root.left==null && root.right==null){
            		// System.out.print("   first ");
            		System.out.print(root.data+" ");
            		prev=root;
            		if(st.isEmpty()) break;
            		root = st.peek();
            	}else if(root.right!=null && root.right==prev){
            		// System.out.print("   second   ");
            		System.out.print(root.data+" ");
            		prev = root;
            		if(st.isEmpty()) break;
            		st.pop();
            		if(st.isEmpty()) break;
            		root = st.peek();
            	}else if(root.left!=null && root.left == prev){
            		// System.out.print("  third   ");
            		while(root.right==null){
            			System.out.print(root.data+" ");
	            		prev = root;
	            		if(st.isEmpty()) break;
	            		st.pop();
	            		if(st.isEmpty()) break;
	            		root = st.peek();
            		}
            		if(root.right!=prev) root=root.right;
            	}else if(root.left!=null){
            		// System.out.print("   forth   ");
        			st.add(root);
        			root = root.left;
        		}else if(root.left==null){
            		// System.out.print("   fifth  ");
        			st.add(root);
        			root = root.right;
        		}
            }
        }

	public static void main(String[] args) {
		//creting tree by level wise input
		/* following is te tree which will be printed by deferent ways

				      1
				   2  	 3
				 4   5	   7

		*/
		// 1 2 3 4 5 -1 7 -1 -1 -1 -1 -1 -1
		int[] arr = {1,2,3,4,5,-1,7,-1,-1,-1,-1,-1,-1};
		// int[] arr = {1,2,3,4,7,-1,-1,-1,-1,-1,-1};

		BinaryTree tree = new BinaryTree(arr); // accessed from an another class call ed BinaryTree
		// tree.
		tree.printDetail();
		postOrder(tree.root);
	}
	
}
