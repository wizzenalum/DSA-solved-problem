import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.text.html.HTMLEditorKit.HTMLTextAction;

public class VerticalOrder {
    
    private static void createMap(BinaryTreeNode<Integer> root, HashMap<Integer, ArrayList<Integer>> map, int verOrder) {
        if(root==null) return;
        if(!map.containsKey(verOrder)) map.put(verOrder,new ArrayList<>());
        map.get(verOrder).add(root.data);
        createMap(root.left, map, verOrder-1);
        createMap(root.right, map, verOrder+1);
    }
    public static void printBinaryTreeVerticalOrder(BinaryTreeNode<Integer> root){
		HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        createMap(root,map,0);
        for(int key:map.keySet()){
            ArrayList<Integer> list = map.get(key);
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i)+" ");
            }System.out.println();
        }
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
        printBinaryTreeVerticalOrder(n1);
    }
}
