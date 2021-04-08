// this class used to create and print the trees.
import java.util.Queue;
import java.util.LinkedList;
class BinaryTree{
	BinaryTreeNode<Integer> root;
	Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();

	BinaryTree(int[] arr){
		this.root = this.createTree(this.root,this.queue,arr,0);
		queue=null;

	}
	BinaryTreeNode<Integer> createTree(BinaryTreeNode<Integer> root, Queue<BinaryTreeNode<Integer>> queue,int[] arr, int index){
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
		if(!queue.isEmpty()) createTree(queue.poll(),queue, arr, index+2);
		return root;
	}
	void print(){
		this.queue = new LinkedList<>();
		print(this.root,this.queue);
	}
	void print(BinaryTreeNode<Integer> root, Queue<BinaryTreeNode<Integer>> queue){
		// time O(n) space O(n)
		if(root==null) return;
		if(root.left!=null) queue.add(root.left);
		if(root.right!=null) queue.add(root.right);
		System.out.print(root.data+" ");
		if(!queue.isEmpty()) print(queue.poll(),queue);
	}
	void printDetail(){
		this.queue = new LinkedList<>();
		printDetail(this.root,this.queue);
	}
	void printDetail(BinaryTreeNode<Integer> root, Queue<BinaryTreeNode<Integer>> queue){
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
}