import java.util.Scanner;
class LinkedListNode<T>{
	T data;
	LinkedListNode<T> next;
	LinkedListNode(T data){
		this.data = data;
	}
}
public class PalindromeTest{
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
		check the linked list is palindrome or not. and return true or false accordingly.
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

	public static LinkedListNode<Integer> revrseHalfofIt(LinkedListNode<Integer> head, int x){
	// it will reverse the ll from the xth node to last node and return head of updated LL
		// indexing start from 0;
		if(x<0) return head;
		LinkedListNode<Integer> firstHalfEnd = head;
		int firstHalfEndIndex = 0;
		while(firstHalfEnd!=null&&x!=0){
			if(firstHalfEndIndex==x-1){
				break;
			} 
			firstHalfEndIndex++;
			firstHalfEnd = firstHalfEnd.next;
		}
		if(x<firstHalfEndIndex||firstHalfEnd == null|| firstHalfEnd.next==null||firstHalfEnd.next.next==null){
			return head;
		}
		// System.out.println(firstHalfEnd.data+"  "+firstHalfEndIndex);
		LinkedListNode<Integer> previous  = firstHalfEnd.next;
		if(x==0) {
			firstHalfEnd = null;
			previous = head;
		}
		LinkedListNode<Integer> current = previous.next;
		LinkedListNode<Integer> forward = current.next;
		previous.next = null;
		while(forward!=null){
			current.next = previous;
			previous = current;
			current = forward;
			forward = forward.next;
		}
		if(forward==null){
			current.next = previous;
		}
		if(firstHalfEnd==null) head = current;
		else firstHalfEnd.next = current;
		return head;
	}
// ************* bruit force solution time O(n^2) O(1)************
	public static boolean isPalindrome(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> temp = head;
		int length = 0;
		while(temp!=null){
			length++;
			temp=temp.next;
		}
		// System.out.print(length);
		if(head==null||head.next==null) return true;
		temp = head;
		LinkedListNode<Integer> temp1 = head;
		for(int start=1;start<=length;start++){
			// System.out.println("get in for");
			temp1 = temp;
			for(int end = start; end<length;end++){
				temp1 = temp1.next;
			}length--;
			if(!temp.data.equals(temp1.data)) return false;
			temp = temp.next;
		}return true;
	}
//********* by creating new linklist by revrse time O(n) spac O(n)***************
	public static boolean isPalindrome1(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> current  = reverseLL(head);
		while(head!=null){
			if(!head.data.equals(current.data)) return false;
			head = head.next;
			current = current.next;
		}return true;
	}
// ********** by reversing half of itself time O(n) space O(1)***********
	public static boolean isPalindrome2(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> temp = head;
		int length = 0;
		while(temp!=null){
			length++;
			temp=temp.next;
		}
		if(length<=1) return true;
		int secondHalfStart = (length+1)/2;  // indexing from zero.
		head = revrseHalfofIt(head,secondHalfStart);
		LinkedListNode<Integer> secondHalfhead = head;
		for(int i =0; i<secondHalfStart;i++) secondHalfhead = secondHalfhead.next;
		while(secondHalfhead!=null){
			// System.out.println("count");
			if(!secondHalfhead.data.equals(head.data)) return false;
			head = head.next;	
			secondHalfhead = secondHalfhead.next; 
		}

		return true;
	}

	public static void main(String[] args) {
		int[] arr = {0,0,2,0,0};
		LinkedListNode<Integer> node = createLLFromArr(arr,arr.length);
		// // print(node);
		System.out.println("bruit force function     "+isPalindrome(node));
		System.out.println("createing new reverse LL     "+isPalindrome1(node));
		System.out.println("reverseing it's self half     "+isPalindrome2(node));
		// System.out.println(" -ve");
		// print(revrseHalfofIt(node,-1));
		// System.out.println(" zero");
		// print(revrseHalfofIt(node,0));
		// System.out.println(" three");
		// print(revrseHalfofIt(node,3));
		// System.out.println(" two");
		// print(revrseHalfofIt(node,2));
	}
}