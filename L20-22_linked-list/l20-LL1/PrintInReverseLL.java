import java.util.Scanner;
class LinkedListNode<T>{
	T data;
	LinkedListNode<T> next;
	LinkedListNode(T data){
		this.data = data;
	}
}
public class PrintInReverseLL{
	public static LinkedListNode<Integer> createLLFromArr(int[] arr, int size){
		// create a linked list from given array and return head of linked list.
		if(size==0) return null;
		LinkedListNode<Integer> head = new LinkedListNode<>(arr[0]);
		LinkedListNode<Integer> temp = head;
		for(int i = 1;i<size;i++){
			LinkedListNode<Integer> node = new  LinkedListNode<Integer>(arr[i]);
			temp.next = node;
			temp = node;
		}
		return head;
	}


	public static void print(LinkedListNode<Integer> head){
		//print the all elements of the ll
		while(head!=null){
			System.out.println(head.data);
			head = head.next;
		}
	}
/*############################################################################
		this will print linked list in reverse order.
#############################################################################*/
	
	public static LinkedListNode<Integer> reverseLL(LinkedListNode<Integer> head){
		// return a head of new reversed linked list
		if(head==null) return head;
		LinkedListNode<Integer> current = head;
		LinkedListNode<Integer> headReverse = new LinkedListNode<>(current.data);
		while(current.next!=null){
			LinkedListNode<Integer> node = new LinkedListNode<>(current.next.data);
			node.next = headReverse;
			current = current.next;
			headReverse = node;
		} 
		// print(headReverse);
		return headReverse;
	}

	public static void printReverse(LinkedListNode<Integer> root) {
		// // *******bruit force method  time O(n^2) space O(1) *******
		// LinkedListNode<Integer> temp  =root;
		// int length = 0;
		// while(temp!=null){
		// 	length++;
		// 	temp = temp.next;
		// }
		// // System.out.print(length);

		// for(int i = length;i>0;i--){
		// 	temp = root;
		// 	for(int j = 1;j<i;j++){
		// 		temp = temp.next;

		// 	}System.out.print(temp.data+" ");
		// }

		// // ****** recursivly  time O(n) space O(n) *************

		// if(root==null) return;
		// else{
		// 	printReverse(root.next);
		// 	System.out.print(root.data+" ");
		// }
		// ********** using reverese linked list Time O(n) space O(n) ***************
		LinkedListNode<Integer> head = reverseLL(root);
		while(head!=null) {
			System.out.print(head.data+" ");
			head = head.next;
		}
	}
	public static void main(String[] args) {
		int[] arr = {1,3};
		LinkedListNode<Integer> node = createLLFromArr(arr,arr.length);
		// print(node);
		printReverse(node);
		// print(reverseLL(node));
	}
}