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
class Pair<T, U> {
	T minimum;
	U maximum;

	public Pair(T minimum, U maximum) {
		this.minimum = minimum;
		this.maximum = maximum;
	}

}


// import java.util.math;
public class MinimumMaximumOfTree {

	public static Pair<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) {
		Pair<Integer,Integer> pair = new Pair<>(-1,-1), left,right;
		if(root==null) return pair;
		left = getMinAndMax(root.left);
		right = getMinAndMax(root.right);
		if(left.minimum!=-1&&right.minimum!=-1) pair.minimum = Math.min(root.data,Math.min(left.minimum,right.minimum));
		else if(left.minimum !=-1) pair.minimum = Math.min(root.data,left.minimum);
		else if(right.minimum !=-1) pair.minimum = Math.min(root.data,right.minimum);
		else pair.minimum = root.data;
		pair.maximum = Math.max(root.data,Math.max(left.maximum,right.maximum));
		return pair;	
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
		System.out.println(getMinAndMax(tree.root).minimum+"  "+getMinAndMax(tree.root).maximum);
		// System.out.print(a);
	}
	
}