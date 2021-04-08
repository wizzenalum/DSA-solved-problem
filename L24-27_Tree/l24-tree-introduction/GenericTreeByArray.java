/*############################################################################
		implimetation of the generic tree node by creating array of child nodes.
					

					STATUS  --  NOT IMPLEMENTED
		


#############################################################################*/	

class GenericTree<T,E>{
	T data;   // data is generic type;
	GenericTree[] child;  // adreess will be stored in arrary

	// contructor will decide the memory of array and data
	GenericTree(T data){
		this.data = data;
		child = new GenericTree[E];
		for(int i = 0;i<E;i++){
			child[i] = null;

		}
	}
}

public class BinaryTreeByArray{
	public static void main(String[] args) {
		GenericTree<Integer,2> root = new GenericTree<>(30);
		System.out.println(root.data);
		GenericTree<Integer,0> child1 = new GenericTree<>(15);
		GenericTree<Integer,3> child2 = new GenericTree<>(20);
		root.child[0] = child1;
		root.child[1] = child2;
		GenericTree<Integer,0> node1 = new GenericTree<>(1);
		GenericTree<Integer,0> node2 = new GenericTree<>(2);
		GenericTree<Integer,0> node3 = new GenericTree<>(3);
		child2.child[0] = node1;
		child2.child[1] = node2;
		child2.child[2] = node3;

		System.out.println(root.child[0].data);


	}
}