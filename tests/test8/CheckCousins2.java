import java.util.ArrayList;


class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}
public class CheckCousins2 {
		// Binary Tree Node class
	public static int parent(BinaryTreeNode<Integer> root, int p,int parentLevel) {
        if(root==null) return -1;
        if(root.data == p) return parentLevel;
        int leftPer = parent(root.left,p,parentLevel+1);
        if(leftPer!=-1) return leftPer;
        return parent(root.right,p,parentLevel+1);
    }

	public static boolean isCousin(BinaryTreeNode<Integer> root, int p, int q) {
        int parentP = parent(root,p,-1);
        int parentQ = parent(root,q,-1);
        if(parentP==-1||parentQ==-1) return false;
		if(parentP==parentQ) return true;
        return false;
	}
    public static void main(String[] args) {
        BinaryTreeNode<Integer> n1 = new BinaryTreeNode(5);
        BinaryTreeNode<Integer> n2 = new BinaryTreeNode(6);
        BinaryTreeNode<Integer> n3 = new BinaryTreeNode(10);
        BinaryTreeNode<Integer> n4 = new BinaryTreeNode(2);
        BinaryTreeNode<Integer> n5 = new BinaryTreeNode(3);
        BinaryTreeNode<Integer> n6 = new BinaryTreeNode(4);
        BinaryTreeNode<Integer> n7 = new BinaryTreeNode(9);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n5.right = n7;
        n3.left = n6;
        System.out.println(isCousin(n1, 3, 4));
    }
}
