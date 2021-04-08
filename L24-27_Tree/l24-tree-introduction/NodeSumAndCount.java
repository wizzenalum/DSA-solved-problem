/*############################################################################
		calcualte the number of nodes and sum of the data
					

					STATUS  -- completed		
#############################################################################*/	
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
class BTree<T>{
	T data;   // data is generic type;
	BTree<T> left;  // adreess of left/ first  child node 
	BTree<T> right;  // adreess will be stored in arrary

	// contructor will decide the memory of array and data
	BTree(T data){
		this.data = data;
		this.left = null;
		this.right = null;
		

	}
}

public class NodeSumAndCount{


	public static void print(BTree<Integer> root){
		// System.out.println(root);
		if(root==null) return;
		System.out.print(root.data+" : ");
		if(root.left!=null) System.out.print("L "+root.left.data);
		if(root.right!=null) System.out.print("   R "+root.right.data);
		System.out.println();
		// System.out.print("left  ");
		print(root.left);
		// System.out.print("   right   ");
		print(root.right);

	}
	static Scanner scan = new Scanner(System.in);

	public static BTree<Integer> BTreeInputLevelWise(BTree<Integer> root, Queue<BTree<Integer>> queue,int[] arr, int index){
		BTree<Integer> leftChild, rightChild;
		// System.out.println(index);
		if(root==null){
			int rootData = arr[index];
			index++;
			if(rootData == -1) return null;
			root = new BTree<>(rootData);
		}
		int left = arr[index];
		int right = arr[index+1];

		if(left==-1) root.left = null;
		else {
			leftChild = new BTree<>(left);
			root.left = leftChild;
			queue.add(leftChild);
		}
		if(right==-1) root.right = null;
		else {
			rightChild = new BTree<>(right);
			root.right = rightChild;
			queue.add(rightChild);
		}
		if(!queue.isEmpty()) BTreeInputLevelWise(queue.poll(),queue, arr, index+2);
		return root;
	}

// *************** count the node of three by post order traversal**************
	public static int countNode(BTree<Integer> root){
		// time O(n) space O(n)

		if(root==null) return 0;
		int countLeft = countNode(root.left);
		int countRight = countNode(root.right);
		return 1+countLeft+countRight;
	}
// *************** calculate the  sum of all node data by post order traversal**************
	public static int sumNodeData(BTree<Integer> root){
		// time O(n) space O(n)
		
		if(root==null) return 0;
		int leftSum = sumNodeData(root.left);
		int rightSum = sumNodeData(root.right);
		return root.data.intValue()+leftSum+rightSum;
	}
	

	public static void main(String[] args) {
		//creting tree by level wise input
		// 1 2 3 4 5 -1 7 -1 -1 -1 -1 -1 -1
		int[] arr = {1,2,3,4,5,-1,7,-1,-1,-1,-1,-1,-1};
		Queue<BTree<Integer>> queueForNextNode = new LinkedList<>();
		BTree<Integer> root = BTreeInputLevelWise(null, queueForNextNode, arr, 0);
		print(root);
		System.out.println("\n"+countNode(root));
		System.out.println(sumNodeData(root));
	}
}