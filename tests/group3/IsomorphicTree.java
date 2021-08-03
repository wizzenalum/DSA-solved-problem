package group3;
import java.util.Scanner;
/*  Isomorphic Trees
Send Feedback
Given two binary trees. Check whether these two trees are isomorphic or not.
Isomorphic trees are the ones which can be made identical by series of flips i.e. by swapping left and right children of a number of nodes.
Example

Input

Output

 True

Input format :

Line 1 :  Elements in level order form (separated by space)
(If any node does not have left or right child, take -1 in its place)

Output Format :

True or False

Sample Input 1:

     5 35 10 2 3 5 2 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
     9 11 12 2 5 3 2 -1 -1  -1 -1 -1 -1 -1 -1

Sample Output 1:

     False

Sample Input 1:

     2 35 10 2 3  -1 -1 -1 -1 -1 -1
     9 10 35 -1 -1 3 2 -1 -1  -1 -1 

Sample Output 1:

     True

 */
class BinaryTreeNode<T> {
	public T data;
	public BinaryTreeNode<T> left;
	public BinaryTreeNode<T> right;
	public BinaryTreeNode<T> next;

	public BinaryTreeNode(T data) {
		this.data = data;
		left = null;
		right = null;
		next = null;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	public BinaryTreeNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}

}

class Node<T> {
	T data;
	Node<T> next;

	Node(T data) {
		this.data = data;
	}

}

class QueueUnderFlowException extends Exception {

}

class QueueUsingLinkedList<T> {
	Node<T> front;
	Node<T> rear;
	int size;

	public QueueUsingLinkedList() {
		front = null;
		rear = null;
		size = 0;
	}

	public void enqueue(T data) {
		Node<T> nyaNode = new Node<>(data);
		if (front == null) {
			front = nyaNode;
			rear = nyaNode;
		} else {
			rear.next = nyaNode;
			rear = rear.next;
		}
		size++;
	}

	public T dequeue() throws QueueUnderFlowException {
		if (front == null) {
			throw new QueueUnderFlowException();
		}
		Node<T> temp = front;
		front = front.next;
		size--;
		return temp.data;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0 ? true : false;
	}

	public void printQueue() {
		Node<T> temp = front;
		while (temp != null) {
			System.out.print(temp.data + "-->");
			temp = temp.next;
		}
	}
}
public class IsomorphicTree {
    static boolean isIsomorphic(BinaryTreeNode<Integer> n1, BinaryTreeNode<Integer> n2) {
		if(n1==null && n2 == null) return true;
        if(n1==null||n2==null) return false;
        if(n1.data!=n2.data) return false;
        BinaryTreeNode<Integer> swap;
        swap = n1.left;
        n1.left = n1.right;
        n1.right = swap;
        if(!isIsomorphic(n1.left, n2.left)) return false;
        if(!isIsomorphic(n1.right, n2.right)) return false;
		return true;
	}
    static Scanner s = new Scanner(System.in);

	static BinaryTreeNode<Integer> prepareTree() throws QueueUnderFlowException {

		int data = s.nextInt();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);
		QueueUsingLinkedList<BinaryTreeNode<Integer>> queue = new QueueUsingLinkedList();
		queue.enqueue(root);

		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> currentNode = queue.dequeue();

			int leftData = s.nextInt();
			if (leftData != -1) {
				BinaryTreeNode<Integer> leftNode = new BinaryTreeNode<>(
						leftData);
				currentNode.setLeft(leftNode);
				queue.enqueue(currentNode.getLeft());

			}

			int rightData = s.nextInt();
			if (rightData != -1) {
				currentNode.setRight(new BinaryTreeNode<>(rightData));
				queue.enqueue(currentNode.getRight());
			}
		}
		return root;
	}

	public static void main(String[] args) throws QueueUnderFlowException {
		// TODO Auto-generated method stub
		BinaryTreeNode<Integer> root1 = prepareTree();
		BinaryTreeNode<Integer> root2 = prepareTree();

		System.out.println(isIsomorphic(root1, root2));

	}

}
