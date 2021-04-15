/*############################################################################
				 Construct BST from level order

	You are given level order traversal of a Binary Search Tree in N-sized array, 
	you have to construct a BST from this level order traversal.
		
					completed false
#############################################################################*/
import java.util.Queue;
import java.util.LinkedList;
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

public class ConstructBSTFromLevelOrder{
	public static BinaryTreeNode<Integer> constructBST(int[] levelorder, int n) {
		if(n<=0) return null;
		int i = 2, len = levelorder.length;
        Queue<BinaryTreeNode<Integer>> rootQueue = new LinkedList<>();
        Queue<BinaryTreeNode<Integer>> superQueue = new LinkedList<>();
        BinaryTreeNode<Integer> treeRoot, root, superRoot=null, node;
        treeRoot = new BinaryTreeNode<>(levelorder[0]);
        root = treeRoot;
        // condition untill tree move to third hight their may be 2 or 3 node creted.
        if(n>1){
	        node = new BinaryTreeNode<>(levelorder[1]);
        	if(root.data<node.data){
        		root.right = node;
        		superRoot = root;
        		root = node;
        	}
        	else{
        		root.left = node;
        		if(n>2 && levelorder[2]>node.data){
			        if(levelorder[2]>root.data){
			        	root.right = new BinaryTreeNode<>(levelorder[2]);
			        	rootQueue.add(root.right);
			        	superRoot = root;
			        	root = node;
			        	i++;
			        }else{
			        	superRoot = root;
			        	root = node;
			        }
        		}
        	}

        }

		// BinaryTree tree = new BinaryTree(); 
		// tree.root = treeRoot;
		// tree.printDetail();
		// System.out.println(i+" "+root.data+" "+superRoot.data);
        // upto now height of tree is 2 and nodes or i can be 2 or three. and further nodes will br added
        // as following for four conditions which depends upon root and super root. and super root will select by root.

        while(i<len){
        	// adding left child to root.
        	if(root.data<=superRoot.data){
        		if(levelorder[i]<=root.data){
        			root.left = new BinaryTreeNode<Integer>(levelorder[i]);
        			rootQueue.add(root.left);
        			i++;
        		}
			// System.out.println(i+" "+root.data+" "+superRoot.data);
        		if(i==len) break;
        		if(levelorder[i]>root.data && levelorder[i]<=superRoot.data){
        			root.right = new BinaryTreeNode<Integer>(levelorder[i]);
        			rootQueue.add(root.right);
        			i++;
        		}
        		superQueue.add(root);
        		root=rootQueue.poll();

   			// right node activities.
        	}else if(root.data>superRoot.data){
        		if(levelorder[i]<=root.data){
        			root.left = new BinaryTreeNode<Integer>(levelorder[i]);
        			rootQueue.add(root.left);
        			i++;
        		}
        		if(i==len) break;

        		if(levelorder[i]>root.data){
        			root.right = new BinaryTreeNode<Integer>(levelorder[i]);
        			rootQueue.add(root.right);
        			i++;
        		}
        		superQueue.add(root);
        		root = rootQueue.poll();
        		superRoot = superQueue.poll();
        	}
        }
        // System.out.println(superRoot.data+" "+root.data+" "+i+" "+rootQueue.isEmpty());
        return treeRoot;

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
		int[] arr = {4,1,7,0,2,5,8,3,6,9};

		BinaryTree tree = new BinaryTree(); // accessed from an another class call ed BinaryTree
		tree.root = constructBST(arr,arr.length);
		tree.printDetail();
	
		

	}	
}
