package fulltest1;



import java.util.*;

class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
	}
	public void setRight(BinaryTreeNode<T> root)
	{
		right=root;
		
	}
	public void setLeft(BinaryTreeNode<T> root)
	{
		left=root;
		
	}
}

public class MergeTwoBST {
    static Scanner s = new Scanner(System.in);
	public static BinaryTreeNode<Integer> takeInput() {
		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<BinaryTreeNode<Integer>>(); 
		
		int rootData = s.nextInt();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.add(root);

		while (!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> currentNode;
			if(pendingNodes.isEmpty()) return null;
            currentNode = pendingNodes.poll();
			
			int leftChildData = s.nextInt();
			if (leftChildData != -1) {
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(
						leftChildData);
				currentNode.left = leftChild;
				pendingNodes.add(leftChild);
			}
			int rightChildData = s.nextInt();
			if (rightChildData != -1) {
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(
						rightChildData);
				currentNode.right = rightChild;
				pendingNodes.add(rightChild);
			}
		}
	
		return root;
	}


    public static void print(BinaryTreeNode<Integer> node) {
        if(node==null) return;
        print(node.left);
        System.out.println(node.data);
        print(node.right);
    }
    public static void createQueue(Queue<BinaryTreeNode<Integer>> que, BinaryTreeNode<Integer> node ) {
        if(node==null) return;
        BinaryTreeNode<Integer> right = node.right;
        createQueue(que, node.left);
        node.left = null;
        node.right = null;
        que.add(node);
        createQueue(que,right);
    }
    // method 1 not working.
    public static void merger(Queue<BinaryTreeNode<Integer>> que, BinaryTreeNode<Integer> node, int min, int max) {
        System.out.println("hoe");
        if(node==null) return;
        BinaryTreeNode<Integer> left = node.left, right = node.right;
        if(left!=null && right!=null){
            if(que.peek().data>node.data) merger(que, right, node.data+1, max);
            else merger(que, left, min, node.data);
        }
        else if(right!=null){
            if(que.peek().data<=node.data && que.peek().data>=min){
                if(que.isEmpty()) return;
                BinaryTreeNode<Integer> temp = que.poll();
                node.left = temp;
                while(que.peek().data<=node.data && que.peek().data>=min){
                    if(que.isEmpty()) return;
                    temp.right = que.poll();
                }
                return;
            }else merger(que, right, node.data+1, max);
        }
        else if(left!=null){
            if(que.peek().data>node.data && que.peek().data<=max){
                if(que.isEmpty()) return;
                BinaryTreeNode<Integer> temp = que.poll();
                node.right = temp;
                while(que.peek().data<=node.data && que.peek().data>=min){
                    if(que.isEmpty()) return;
                    temp.left = que.poll();
                }
                return;
            }else merger(que, left, min, node.data);
        } 
        else{
            System.out.println("yse");

            if(que.peek().data<=node.data && que.peek().data>=min){
                if(que.isEmpty()) return;
                System.out.println("hey");
                BinaryTreeNode<Integer> temp = que.poll();
                node.left = temp;
                if(que.isEmpty()) return;
                System.out.println(que.size());
                while(que.peek().data<=node.data && que.peek().data>=min){
                    temp.right = que.poll();
                    temp  = temp.right;
                }
            }
            if(que.peek().data>node.data && que.peek().data<=max){
                if(que.isEmpty()) return;
                BinaryTreeNode<Integer> temp = que.poll();
                node.right = temp;
                if(que.isEmpty()) return;
                while(que.peek().data<=node.data && que.peek().data>=min){
                    temp.left = que.poll();
                    temp = temp.left;
                }
            }
        }   
    }

    
    static void printMergeTrees(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2) {
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        createQueue(queue,root2);
        // for (int i = 0; i < queue.size(); i++) {
        //     System.out.println(queue.peek().data);
        //     queue.add(queue.poll());
        // }
        System.out.println("merger is started"+queue.size());
        merger(queue,root1,Integer.MIN_VALUE,Integer.MAX_VALUE);
        // print(root1);   
	}

// method 2 working dear
    public static void mergeArr(ArrayList<BinaryTreeNode<Integer>> arr,
                                Queue<BinaryTreeNode<Integer>> arr1,
                                Queue<BinaryTreeNode<Integer>> arr2) {
        while(!(arr1.isEmpty()&& arr2.isEmpty())){
            if(!arr1.isEmpty()&& !arr2.isEmpty()){
                if(arr1.peek().data>arr2.peek().data) arr.add(arr2.poll());
                else if(arr1.peek().data<arr2.peek().data) arr.add(arr1.poll());
                else{
                    arr.add(arr1.poll());
                    arr.add(arr2.poll());
                }
            }else if(arr1.isEmpty()&& arr2.isEmpty()) return;
            else{
                if(arr1.isEmpty()) arr.add(arr2.poll());
                if(arr2.isEmpty()) arr.add(arr1.poll());
            }
        }
    }
    public static void printMergeTrees2(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2) {
        Queue<BinaryTreeNode<Integer>> arr1 = new LinkedList<>();
        Queue<BinaryTreeNode<Integer>> arr2 = new LinkedList<>();
        createQueue(arr1, root1);
        createQueue(arr2, root2);
        ArrayList<BinaryTreeNode<Integer>> arr = new ArrayList<>();
        mergeArr(arr,arr1,arr2);
        arr.forEach(a -> System.out.print(a.data+" "));
    }
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root1 = takeInput();
		BinaryTreeNode<Integer> root2 = takeInput();
		// printMergeTrees(root1,root2);
		printMergeTrees2(root1,root2);

    }
}
