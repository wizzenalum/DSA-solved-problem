import java.util.Scanner;
class LinkedListNode<T>{
	T data;
	LinkedListNode<T> next;
	LinkedListNode(T data){
		this.data = data;
	}
}
public class EliminateDuplicateLL{
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
		this will remove consucative repeated data. and return head.
#############################################################################*/
	public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> temp = head;
		while(temp!=null&&temp.next!=null){
			if(temp.data.equals(temp.next.data)){
				temp.next = temp.next.next;
			}else temp = temp.next;
		}
		if(temp!=null) temp.next=null;
		return head;
		// if(temp.equals(null)||temp.next.equals(null)) return head;
		// LinkedListNode<Integer> temp1 = temp.next;
		// while(temp1!=null){
		// 	if(temp.data.equals(temp1.data)){
		// 		temp.next = temp1.next;
		// 		temp1 = temp1.next;
		// 	}else{
		// 		temp = temp1;
		// 		temp1 = temp1.next;
		// 	}
		// }return head;
	}
	public static void main(String[] args) {
		int[] arr = {1,1,2,3,3,3};
		LinkedListNode<Integer> node = createLLFromArr(arr,arr.length);
		print(removeDuplicates(node));
	}
}