/*############################################################################
				   Serialize and Deserialize

	You are given a binary tree and you have to serialize and deserialize the 
	given binary tree. Serialization is to store the tree in an array so that 
	it can be restored later while deserialization reading tree back from that 
	array.
	The structure of the tree must be maintained while serializing or deserializing 
	the binary tree. You have to complete the function serialization and deserialization.

				completed:- true
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

public class SerializationAndDeserialization{
	public static void serialize(BinaryTreeNode<Integer> root, ArrayList<Integer> tree) {
            if(root == null) {
            	tree.add(-1);
            	return;
            }
            tree.add(root.data.intValue());
            serialize(root.left,tree);
            serialize(root.right,tree);
    }

    public static BinaryTreeNode<Integer> deSerialize(ArrayList<Integer> tree){
    	if(tree.isEmpty() || tree.get(0) == -1){
    		tree.remove(0);
    		return null;
    	}
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(tree.remove(0));
       	root.left = deSerialize(tree);
       	root.right = deSerialize(tree);
       	return root;
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
		int[] arr = {1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1};

		BinaryTree tree = new BinaryTree(arr); // accessed from an another class call ed BinaryTree
		ArrayList<Integer> arrList = new ArrayList<>(); 
		System.out.println();
		serialize(tree.root, arrList);
		System.out.println(arrList.subList(0, arrList.size()));
		tree.root = deSerialize(arrList);
		tree.printDetail();
	}
	
}
