import java.util.ArrayList;


class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}
public class CheckCousins {
    // Binary Tree Node class
    static class Pair{
        int parent;
        int level;
        Pair(int a,int b){
            parent = a;
            level = b;
        }
    }
    public static Pair parent(BinaryTreeNode<Integer> root, int p,int per,int level) {
        if(root==null) return null;
        if(root.data == p) return new Pair(per,level);
        Pair leftPer = parent(root.left,p,root.data,level+1);
        if(leftPer!=null) return leftPer;
        return parent(root.right,p,root.data,level+1);
    }

    public static boolean isCousin(BinaryTreeNode<Integer> root, int p, int q) {
        Pair parentP = parent(root,p,-1,0);
        Pair parentQ = parent(root,q,-1,0);
        if(parentP==null||parentQ==null) return false;
        if(parentP.level==parentQ.level &&parentP.parent !=parentQ.parent) return true;
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
        System.out.println(isCousin(n1, 3, 9));
    }
}
