/*############################################################################
				set Parent pointer.
	for given level order arr i have to create a tree which have left right child
	with parent pointer too.

					completed true
#############################################################################*/
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class Node{
	int data;
	Node parent;
	Node left;
	Node right;
	Node(int data){
		this.data = data;
		this.parent = null;
		this.left = null;
		this.right = null;
	}
}
public class SetParentPointer{
    // 25 => 50[null] <= 75
    public static void print(Node root){				
    	// it will print tree in preorder.
    	if(root == null) return;
    	System.out.print(root.data+" => ");
    	if(root.left!=null){
    		System.out.print(root.left.data);
    	}if(root.parent!=null){
    		System.out.print("["+root.parent.data+"]");
    	}else System.out.print("["+root.parent+"]");
    	if(root.right!=null){
    		System.out.print(" <= "+root.right.data);
    	}
    	System.out.println();
    	print(root.left);
    	print(root.right);
    }
    public static Node createTreeWithParent(int[] arr, Node parent, int index){
    	if(arr.length<=index || arr[index]==-1) return null;
    	Node root = new Node(arr[index]);
    	root.parent = parent;
    	System.out.println(root.data+" "+index);
    	root.left = createTreeWithParent(arr, root,2*index+1);
    	root.right = createTreeWithParent(arr, root, 2*index+2);
    	return root;
	}
    public static Node solve(int[] arr){
    	return createTreeWithParent(arr,null,0);
	}
	public static void main(String[] args) {
		//creting tree by level wise input
		/* following is te tree which will be printed by deferent ways

				      4
				   2  	 5
				 1   3	   7

		*/
		// 1 2 3 4 5 -1 7 -1 -1 -1 -1 -1 -1
		int[] arr = {50, 25, 75, 12, 37, 62, 87, -1, -1, 30, 40, -1, -1, -1, -1, -1, -1, -1, -1  };
		print(solve(arr));	
	}	
}
