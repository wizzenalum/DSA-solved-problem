class LinkedListNode<T>{
	T data;
	LinkedListNode<T> next;
	LinkedListNode(T data){
		this.data = data;
	}

}

public class ReverseLL{
	public static LinkedListNode<Integer> createLL(int[] arr){
		int len = arr.length;
		LinkedListNode<Integer> head=null;
		for(int i = len-1; i>=0;i--){
			LinkedListNode<Integer> node = new LinkedListNode<>(arr[i]);
			node.next = head;
			head = node;
		}return head;
	}
	public static void print(LinkedListNode<Integer> node){
		while(node!=null){
			System.out.println(node.data);
			node = node.next;
		}
	}
	
/*############################################################################
		delete ith term and return head indexing from 0;
	#############################################################################*/	

	public static LinkedListNode<Integer> reverseLinkedListRec1(LinkedListNode<Integer> head){
	// *********sequantial method time O(n) space O(1) *****************
		if(head==null||head.next==null) return head;
		LinkedListNode<Integer> previous = head;
		LinkedListNode<Integer> current = previous.next;
		LinkedListNode<Integer> forward = current.next;
		previous.next = null;
		while(forward!=null){
			current.next = previous;
			previous = current;
			current = forward;
			forward = forward.next;
		}
		current.next = previous;
		return current;
	}
	public static LinkedListNode<Integer> reverseRecurse(LinkedListNode<Integer> head,LinkedListNode<Integer> previous){
	// *********recursive method time O(n) space O(n) *****************
		if(head.next == null) return previous;
		LinkedListNode<Integer> node = head.next;
		head.next = head.next.next;
		node.next = previous;
		return reverseRecurse(head,node);
	}
	public static LinkedListNode<Integer> reverseLinkedListRec2(LinkedListNode<Integer> head){
		if(head == null||head.next==null) return head;
		if(head.next.next==null){
			LinkedListNode<Integer> forward = head.next;
			forward.next = head;
			head.next = null;
			return forward;
		}
		LinkedListNode<Integer> previous = head.next;
		head.next  = head.next.next;
		previous.next = head;
		return reverseRecurse(head,previous);
	}
	public static LinkedListNode<Integer> reverseLinkedListRec(LinkedListNode<Integer> head){
		if(head==null||head.next==null) return head;
		LinkedListNode<Integer> node = reverseLinkedListRec(head.next);
		head.next.next = head;
		head.next = null;
		return node;
	}


	public static void main(String[] args) {
		int[] arr = {1,2,3,4,6};
		LinkedListNode<Integer> node = createLL(arr);
		node = reverseLinkedListRec(node);
		print(node);
	}

}