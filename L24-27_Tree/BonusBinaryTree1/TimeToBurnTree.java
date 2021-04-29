/*############################################################################
				      Time to Burn Tree

	You have been given a binary tree of N unique nodes and a Start node from 
	where the tree will start to burn. Given that the start node will always 
	exist in the tree, print the time(minutes) that it will take to burn 
	the whole tree.
	
	Note: It takes 1 minute for the fire to travel from burning node to its 
	adjacent node and burn down the adjacent node.

	For example:
		For the given binary tree: [1,2,3,-1,-1,4,5,-1,-1,-1,-1]
		Start Node: 3
		    1
		   / \
		  2   3
		     / \
		    4   5

		Explanation: 
		In the zeroth minute, Node 3 will start to burn.
		After one minute, Nodes (1, 4, 5) that are adjacent to 3 will burn 
		completely.

		After two minutes, the only remaining Node 2 will be burnt and there 
		will be no nodes remaining in the binary tree i.e the whole tree will 
		burn in 2 minutes.

	

				completed:- true
#############################################################################*/
import java.util.ArrayList;
class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public  BinaryTreeNode(T data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class TimeToBurnTree{
	// static class Pair{
	// 	BinaryTreeNode<Integer> node;
	// 	int upHeight;
	// 	Pair(BinaryTreeNode<Integer> node, int upHeight){
	// 		this.node = node;
	// 		this.upHeight = upHeight;
	// 	}
	// }
	// public static Pair nodePresent(BinaryTreeNode<Integer> root, int k){
	// 	if(root== null) return new Pair(null,0);
	// 	if(root.data == k) return new Pair(root,0);
	// 	Pair pair = nodePresent(root.left,k);

	// 	if(pair.node!=null){
	// 		pair.upHeight++;
	// 		return pair;

	// 	}
	// 	pair = nodePresent(root.right,k);
	// 	pair.upHeight++;
	// 	return pair;
	// }
	

	// public static int height(BinaryTreeNode<Integer> root){
	// 	if (root==null) return 0;
	// 	int height1= height(root.left);
	// 	int height2 = height(root.right);
	// 	height1 = height1>height2?height1:height2;
	// 	return height1+1;
	// }
	
	// public static int timeToBurnTree(BinaryTreeNode<Integer> root, int start) {
	// 	if(root==null) return 0;
	// 	int height = 0, temp = 0, heightRoot = 0;
	// 	if(start == root.data){
	// 		// System.out.println("centre");
	// 		heightRoot = height(root);
	// 		return heightRoot-1;
	// 	}
	// 	BinaryTreeNode<Integer> node = nodePresent(root.left,start);
	// 	if(node!=null){       // it means we are on left side.
	// 		// System.out.println("left");
	// 		temp = height(node);
	// 		// System.out.println(temp);
	// 		height = (height(root.left)+1 - temp)+height(root.right)+1;
	// 		// System.out.println(height);
	// 		height = height>temp?height:temp;
	// 		return height-1;
	// 	}

	// 	node = nodePresent(root.right,start);
	// 	// now start will in right side of the root.
	// 	// System.out.println("right");
	// 	if(node!=null){
 //            temp = height(node);
 //            // System.out.println(temp);
 //            height = (height(root.right)+1 - temp)+height(root.left)+1;
 //            // System.out.println(height);
 //            height = height>temp?height:temp;
 //            return height-1;
            
 //        }
 //        return -1;
	// }
	// public static boolean check = false;
	// public static int timeToBurnTree1(BinaryTreeNode<Integer> root, int start, int burnTime) {

	// 	if(root==null){
	// 		System.out.println("return 0");
	// 		return 0;
	// 	} 
	// 	System.out.print("call  "+ root.data+" "+burnTime+"  "+check);
	// 	int heightLeft  = 0, heightRight = 0, height = 0;
	// 	if(check == true){
	// 		System.out.println("one");
	// 		height = 1+ Math.max(timeToBurnTree1(root.left,start, 0), timeToBurnTree1(root.right,start, 0));
			
	// 	}
	// 	else if(check==false && root.data!=start){
	// 		System.out.println("two");

	// 		heightLeft = timeToBurnTree1(root.left, start, burnTime+1);

	// 		if(check = false){
	// 			burnTime = burnTime>heightLeft?burnTime:heightLeft;
	// 			heightRight = timeToBurnTree1(root.right,start, burnTime+1);
	// 			height = heightLeft>heightRight?heightLeft:heightRight + 1;
	// 		}else{
	// 			burnTime = heightLeft;
	// 			heightRight = timeToBurnTree1(root.right,start, burnTime+1);
	// 			if(heightRight>=burnTime) height = heightRight+1;
	// 			else height = burnTime;

	// 		}
	// 	}
	// 	else if(root.data==start){
	// 		System.out.println("three");

	// 		check = true;
	// 		heightLeft = timeToBurnTree1(root.left, start, 0);
	// 		heightRight = timeToBurnTree1(root.right,start, 0);
	// 		height = heightLeft>heightRight?heightLeft:heightRight;
	// 		System.out.println(" run onece " + check+ " "+height+" "+burnTime);
	// 		height = burnTime>height?burnTime:height;
	// 	}
	// 	System.out.println("return "+root.data+" "+height);
	// 	return height;
	// }

	// public static boolean check = false;
	public static int i = 0;
	public static int timeToBurnTree1(BinaryTreeNode<Integer> root, int start, int burnTime, boolean[] check) {

		if(root==null){
			System.out.println("return 0");
			return 0;
		} 
		System.out.print("call  "+ root.data+" "+burnTime+"  "+check[0]+" ");
		int heightLeft  = 0, heightRight = 0, height = 0;
		if(check[0] == true){
			System.out.println("one");
			height = 1+ Math.max(timeToBurnTree1(root.left,start, 0, check), timeToBurnTree1(root.right,start, 0,check));
			
		}
		else if(check[0]==false && root.data!=start){
			System.out.println("two");

			heightLeft = timeToBurnTree1(root.left, start, burnTime+1, check);

			if(check[0] == false){
				burnTime = burnTime>heightLeft?burnTime:heightLeft;
				heightRight = timeToBurnTree1(root.right,start, burnTime+1, check);
				height = heightLeft>heightRight?heightLeft:heightRight + 1;
				if(check[0]==true) height = heightRight;
			}else{
				burnTime = heightLeft;
				i++;
				System.out.println(" i is here  " +i);
				heightRight = timeToBurnTree1(root.right,start, burnTime+1, check);
				height = burnTime>(heightRight+i)?burnTime:(heightRight+i);

			}
		}
		else if(root.data==start){
			System.out.println("three");

			check[0] = true;
			heightLeft = timeToBurnTree1(root.left, start, 0, check);
			heightRight = timeToBurnTree1(root.right,start, 0, check);
			height = heightLeft>heightRight?heightLeft:heightRight;
			System.out.println(" run onece " + check[0]+ " "+height+" "+burnTime);
			height = burnTime>height?burnTime:height;
		}
		System.out.println("return "+root.data+" "+height);
		return height;

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
		// int[] arr1 = {1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1};
		// int[] arr1 = {1,2,3,-1,-1,4,-1,-1,5,-1,-1 };
		// int[] arr1 = {2,100,1,110,-1,10,3,-1,-1,11,-1,4,5,12,-1,-1,-1,-1,-1,13,-1,-1,-1};
		// int[] arr1 = {1,2,3,-1,-1,4,-1,-1,5,-1,-1 };
		// int[] arr1 = {1,2,-1,3,4,-1,-1,5,-1,-1,-1};  // start = 3, ans = 3
		// int[] arr1 = {1,2,-1,3,-1,-1,4,5,-1,-1,6,-1,-1}; // start = 6, ans = 5;
		int[] arr1 = {1,2,3,4,-1,-1,5,6,-1,-1,7,-1,-1,-1,-1};  // start = 4, ans = 5;
		BinaryTree tree1 = new BinaryTree(arr1); // accessed from an another class call ed BinaryTree
		tree1.printDetail();
		// System.out.println(timeToBurnTree(tree1.root,3));
		// System.out.println(nodePresent(tree1.root, 110).upHeight);
		// System.out.println(timeToBurnTree1(tree1.root,3, 0));
		boolean[] check = {false};
		System.out.println(timeToBurnTree1(tree1.root,4, 0,check));
	}
	
}
