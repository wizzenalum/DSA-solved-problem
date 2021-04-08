/*############################################################################
		we will going to implement following functions.
			1. mirror binary tree
			2. The diameter of a tree can be defined as the maximum distance 
				between two leaf nodes. Here, the distance is measured in terms 
				of the total number of nodes present along the path of the two 
				leaf nodes, including both the leaves.
			3. print any tree level wise.

					COMPLETED = True
#############################################################################*/	
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
class BinaryTreeNode<T>{
	T data;   // data is generic type;
	BinaryTreeNode<T> left;  // adreess of left/ first  child node 
	BinaryTreeNode<T> right;  // adreess will be stored in arrary

	// contructor will decide the memory of array and data
	BinaryTreeNode(T data){
		this.data = data;
		this.left = null;
		this.right = null;
		

	}
}

public class practiceQuestions{

	static Scanner scan = new Scanner(System.in);

	public static BinaryTreeNode<Integer> BinaryTreeNodeInputLevelWise(BinaryTreeNode<Integer> root, Queue<BinaryTreeNode<Integer>> queue,int[] arr, int index){
		BinaryTreeNode<Integer> leftChild, rightChild;
		// System.out.println(index);
		if(root==null){
			int rootData = arr[index];
			index++;
			if(rootData == -1) return null;
			root = new BinaryTreeNode<>(rootData);
		}
		int left = arr[index];
		int right = arr[index+1];

		if(left==-1) root.left = null;
		else {
			leftChild = new BinaryTreeNode<>(left);
			root.left = leftChild;
			queue.add(leftChild);
		}
		if(right==-1) root.right = null;
		else {
			rightChild = new BinaryTreeNode<>(right);
			root.right = rightChild;
			queue.add(rightChild);
		}
		if(!queue.isEmpty()) BinaryTreeNodeInputLevelWise(queue.poll(),queue, arr, index+2);
		return root;
	}	
	public static void print(BinaryTreeNode<Integer> root, Queue<BinaryTreeNode<Integer>> queue){
		// time O(n) space O(n)

		if(root==null) return;
		if(root.left!=null) queue.add(root.left);
		if(root.right!=null) queue.add(root.right);
		System.out.print(root.data+" ");
		if(!queue.isEmpty()) print(queue.poll(),queue);

	}
	public static void printDetail(BinaryTreeNode<Integer> root, Queue<BinaryTreeNode<Integer>> queue){
		// time O(n) space O(n)

		if(root==null) return;
		if(root.left!=null) queue.add(root.left);
		if(root.right!=null) queue.add(root.right);
		System.out.print(root.data+" :");
		if(root.left!=null) System.out.print(" L "+root.left.data);
		if(root.right!=null) System.out.print(" R "+root.right.data);
		System.out.println();
		if(!queue.isEmpty()) printDetail(queue.poll(),queue);

	}

//**** mirror binary tree O(n) space O(1) *********************************************************************

	public static void mirrorBinaryTree(BinaryTreeNode<Integer> root){
		if(root==null) return;
		BinaryTreeNode<Integer> temp = root.left;
		root.left = root.right;
		root.right = temp;
		mirrorBinaryTree(root.left);
		mirrorBinaryTree(root.right);
	}




//****method1  diameter of the tree time worst--O(n^2) average--O(nlogn) *********************************************************************

	public static int height(BinaryTreeNode<Integer> root){
		if(root==null) return 0;
		int left = height(root.left);
		int right = height(root.right);
		return 1+(left>right?left:right);
	}
	public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root){
		if(root==null) return 0;
		int dia = height(root.left)+height(root.right)+1;  // leaf nodes present in each of left and right node.
		int dLeft = diameterOfBinaryTree(root.left);  // both nodes in left node.
		int dRigth = diameterOfBinaryTree(root.right); // both nodes present in right node
		if(dia<dLeft){
			dia  = dLeft;
			if(dLeft< dRigth) dia = dRigth;
		}else if(dia<dRigth) dia = dRigth;

		return dia;
	}
	//**** method 2 diameter of the tree time O(n) *********************************************************************
	static class DiaHight{
		// so return the multiple data with the function.
		int dia;
		int height;
		DiaHight(int dia, int height){
			this.dia = dia;
			this.height = height;
		}
	}
	public static DiaHight diameterOfBinaryTree1(BinaryTreeNode<Integer> root){
		DiaHight data;
		if(root==null){
			data = new DiaHight(0,0);
			return data;
		}
		DiaHight left = diameterOfBinaryTree1(root.left); 
		DiaHight right = diameterOfBinaryTree1(root.right);

		int dia = left.height+right.height+1;  // leaf nodes present in each of left and right node.
		int dLeft = left.dia;  // both nodes in left node.
		int dRigth = right.dia; // both nodes present in right node
		if(dia<dLeft){
			dia  = dLeft;
			if(dLeft< dRigth) dia = dRigth;
		}else if(dia<dRigth) dia = dRigth;  // dia is max dia for this root

		int height = 1+ (left.height>right.height?left.height:right.height);
		data = new DiaHight(dia, height);
		return data;
	}
	public static int diameterOfBinaryTree2(BinaryTreeNode<Integer> root){
		return diameterOfBinaryTree1(root).dia;
	}

//**** print tree level wise "showing problem of stack overflow"  *********************************************************************
	public static void printHelper(BinaryTreeNode<Integer> root, Queue<BinaryTreeNode<Integer>> queue){
		if(root==null) return;
		int left = -1, right=-1;

		if(root.left!=null){
			left = root.left.data.intValue();
			queue.add(root.left);
		}
		if(root.right!=null){
			right=root.right.data.intValue();
			queue.add(root.right);
		}

		System.out.println(root.data.intValue()+":L:"+left+",R:"+right);
		if(!queue.isEmpty()) printHelper(queue.poll(),queue);
	}
	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		printHelper(root,queue); 
	}

//**** print tree level wise   *********************************************************************

	public static void printHelper1(BinaryTreeNode<Integer> root, Queue<BinaryTreeNode<Integer>> queue){
		if(root==null) return;
		int left = -1, right=-1;

		if(root.left!=null){
			left = root.left.data.intValue();
			queue.add(root.left);
		}
		if(root.right!=null){
			right=root.right.data.intValue();
			queue.add(root.right);
		}
		System.out.println(root.data.intValue()+":L:"+left+",R:"+right);
	}
	public static void printLevelWise1(BinaryTreeNode<Integer> root) {
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		printHelper1(root,queue); 
		while(!queue.isEmpty()) printHelper1(queue.poll(),queue);

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
		int[] arr = {1,-1,2,-1,-1};
		Queue<BinaryTreeNode<Integer>> queueForNextNode = new LinkedList<>();
		BinaryTreeNode<Integer> root = BinaryTreeNodeInputLevelWise(null, queueForNextNode, arr, 0);
		// mirrorBinaryTree(root);
		// printDetail(root,queueForNextNode);
		// System.out.println(diameterOfBinaryTree(root));
		// System.out.println(diameterOfBinaryTree2(root));
		printLevelWise1(root);
	}
}