/*############################################################################
		You are given a Binary Tree of type integer, a target node, 
		and an integer value K.
		Print the data of all nodes that have a distance K from the target node. 
		The order in which they would be printed will not matter.
#############################################################################*/

/*############################################################################
		For a given Binary Tree of type integer and a number K, print out 
		all root-to-leaf paths where the sum of all the node data along the 
		path is equal to K.


					COMPLETED=False;
#############################################################################*/

import java.util.ArrayList;
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

public class PrintNodeAtKDistance{


	public static boolean createPathToNode(BinaryTreeNode<Integer> root, int node, ArrayList<Character> arrList){
		if(root==null) return false;
		if(root.data.intValue()==node) return true;
		if(createPathToNode(root.left,node,arrList)){
			arrList.add('L');
			return true;
		}
		if(createPathToNode(root.right,node,arrList)){
			arrList.add('R');
			return true;
		}
		return false;
	}

	public static void printNodesAtDistanceK(	BinaryTreeNode<Integer> root, int depth, 
												ArrayList<Character> arrList, 
												boolean isNodePresent, int distance){
		if(root==null) return;
		int size = arrList.size();
		if(Math.abs(size-depth)==distance){
			System.out.println(root.data);
		}
		if(isNodePresent){
			if((size-depth)>0&&arrList.get(size-depth-1)=='L'){
				printNodesAtDistanceK(root.left,depth+1,arrList,true,distance);
				printNodesAtDistanceK(root.right,depth-1,arrList,false,distance);
			}else if((size-depth)>0&&arrList.get(size-depth-1)=='L'){
				printNodesAtDistanceK(root.left,depth-1,arrList,false,distance);
				printNodesAtDistanceK(root.right,depth+1, arrList, true, distance);
			}else{
				printNodesAtDistanceK(root.left,depth+1,arrList,true,distance);
				printNodesAtDistanceK(root.right,depth+1, arrList, true, distance);

			}
		}else{
				printNodesAtDistanceK(root.left,depth-1,arrList,false,distance);
				printNodesAtDistanceK(root.right,depth-1,arrList,false,distance);
		}
	}
	
	

	public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
		ArrayList<Character> arrList = new ArrayList<>();
		boolean isNodePresent = createPathToNode(root,node,arrList); 
		for(int i=arrList.size()-1;i>=0;i--){
			System.out.println(arrList.get(i));
		}
		printNodesAtDistanceK(root,0,arrList,isNodePresent,k);   
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
		BinaryTree tree = new BinaryTree(arr); // accessed from an another class call ed BinaryTree
		nodesAtDistanceK(tree.root,4,2);
		// System.out.println(Math.abs(5-4));
		// tree.print();
	}
	
}