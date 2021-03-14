import java.util.Scanner;
class LinkedListNode<T>{
	T data;
	LinkedListNode<T> next;
	LinkedListNode(T data){
		this.data = data;
	}
}

public class AppendLastNToFirst{

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
	for singly linked list of integers along with an integer 'N'. 
	it will append the last 'N' nodes towards the front of the singly linked list 
	and returns the new head to the list.
#############################################################################*/
	public static int length(LinkedListNode<Integer> head){
		//count he length of the linkedlist;
			int length = 0;
			while(head!=null){
				length++;
				head = head.next;
			}
			return length;
		}
	public static LinkedListNode<Integer> appendLastNToFirst(LinkedListNode<Integer> head, int n) {
		LinkedListNode<Integer> temp = head;
		LinkedListNode<Integer> newHead = head;
		int length = length(head);
		int index =1;
		if(n==0 || n>=length)return newHead;
		while(temp!=null){
			// System.out.println("get in the while");
			if(index == length-n) {
				newHead = temp.next;
				temp.next = null;
				temp = newHead;
				index++;
			}if(temp.next == null){
				temp.next = head;
				break;
			}if(index!=length-n){
				index++;
				temp = temp.next;
			}
		}
		return newHead;
	}
	
	public static void main(String[] args){
		int[] arr = {10,20,30,40};
		LinkedListNode<Integer> node = createLLFromArr(arr,arr.length);
	
		print(appendLastNToFirst(node,2));

	}
}