/*############################################################################
		 Level wise linkedlist

	Given a binary tree, write code to create a separate linked list for each level. 
	You need to return the array which contains head of each level linked list.
			completed true
#############################################################################*/
import java.util.ArrayList;
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

public class LevelWiseLinkList{
// working good but showing stackover flow problem. to me.
	public static void Helper(	BinaryTreeNode<Integer> root,ArrayList<LinkedListNode<Integer>> list,
								Queue<BinaryTreeNode<Integer>> nodeQueue, Queue<Integer> levelQueue,
								LinkedListNode<Integer>last, int level, int preLevel){
		if(root==null) return;
		LinkedListNode<Integer> node = new LinkedListNode<>(root.data);

		if(root.left!=null){
			nodeQueue.add(root.left);
			levelQueue.add(level+1);
		} 
		if(root.right!=null){
			nodeQueue.add(root.right);
			levelQueue.add(level+1);
		} 

		if(preLevel<level){
			list.add(node);
		}else last.next = node;

		if(nodeQueue.isEmpty()) return;
		Helper(nodeQueue.poll(),list,nodeQueue,levelQueue,node,levelQueue.poll(),level);
	}

	public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root){
		Queue<BinaryTreeNode<Integer>> nodeQueue = new LinkedList<>();
		Queue<Integer> levelQueue = new LinkedList<>();
		ArrayList<LinkedListNode<Integer>> arrlist = new ArrayList<>();
		Helper(root,arrlist,nodeQueue,levelQueue,null,0,-1);
		return arrlist;
	}

// method is same just removing the stackoverflow problem.
	public static LinkedListNode<Integer>  Helper1(	BinaryTreeNode<Integer> root,ArrayList<LinkedListNode<Integer>> list,
								Queue<BinaryTreeNode<Integer>> nodeQueue, Queue<Integer> levelQueue,
								LinkedListNode<Integer>last, int level, int preLevel){
		if(root==null) return null;
		LinkedListNode<Integer> node = new LinkedListNode<>(root.data);

		if(root.left!=null){
			nodeQueue.add(root.left);
			levelQueue.add(level+1);
		} 
		if(root.right!=null){
			nodeQueue.add(root.right);
			levelQueue.add(level+1);
		} 

		if(preLevel<level){
			list.add(node);
		}else last.next = node;
		return node;
	}

	public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel1(BinaryTreeNode<Integer> root){
		if(root==null) return null;
		Queue<BinaryTreeNode<Integer>> nodeQueue = new LinkedList<>();
		Queue<Integer> levelQueue = new LinkedList<>();
		ArrayList<LinkedListNode<Integer>> arrlist = new ArrayList<>();
		int preLevel = -1, level = 0;
		LinkedListNode<Integer> last = null;
		nodeQueue.add(root);
		levelQueue.add(level);
		while(!nodeQueue.isEmpty()){
			level = levelQueue.poll();
			last = Helper1(nodeQueue.poll(),arrlist,nodeQueue,levelQueue,last,level,preLevel);
			preLevel = level;
		}
		return arrlist;
	}

	// best aprtoach is itteratvie and is following
	public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel2(BinaryTreeNode<Integer> root){
		if(root==null) return null;
		Queue<BinaryTreeNode<Integer>> nodeQueue = new LinkedList<>();
		Queue<Integer> levelQueue = new LinkedList<>();
		ArrayList<LinkedListNode<Integer>> arrlist = new ArrayList<>();
		int preLevel = -1, level = 0;
		LinkedListNode<Integer> last = null;
		nodeQueue.add(root);
		levelQueue.add(level);
		while(!nodeQueue.isEmpty()){
			LinkedListNode<Integer> node = new LinkedListNode<>(root.data);

			if(root.left!=null){
				nodeQueue.add(root.left);
				levelQueue.add(level+1);
			} 
			if(root.right!=null){
				nodeQueue.add(root.right);
				levelQueue.add(level+1);
			} 

			if(preLevel<level){
				arrlist.add(node);
			}else last.next = node;
			last = node;
			preLevel = level;
			level = levelQueue.poll();
			root = nodeQueue.poll();
		}
		return arrlist;
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

		BinaryTree tree = new BinaryTree(arr); // accessed from an another class call ed BinaryTree
		tree.printDetail();
		System.out.println();
		ArrayList<LinkedListNode<Integer>> list = constructLinkedListForEachLevel2(tree.root);
		System.out.println(list.size());

	}	
}
