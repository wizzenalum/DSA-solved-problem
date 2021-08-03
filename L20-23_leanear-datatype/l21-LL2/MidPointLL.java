class LinkedListNode<T>{
	T data;
	LinkedListNode<T> next;
	LinkedListNode(T data){
		this.data = data;
	}
}
public class MidPointLL{
	public static LinkedListNode<Integer> createLL(int[] arr, int i){
		if(arr.length==i) return null;
		LinkedListNode<Integer> head = new LinkedListNode<>(arr[i]);
		head.next = createLL(arr, i+1);
		return head;
	}
	public static void print(LinkedListNode<Integer> head){
		if(head==null) return;
		System.out.print(head.data+" ");
		print(head.next);

	}
/*############################################################################
			return a middle node of the linked list.
#############################################################################*/
	public static int length(LinkedListNode<Integer> head){
		int length=0;
		while(head!=null){
			length++;
			head = head.next;
		}return length;
	}
	public static LinkedListNode<Integer> midPoint(LinkedListNode<Integer> head) {
		int index = (length(head)-1)/2;
		int count = 0;
		while(head!=null){
			if(index == count) return head;
			head = head.next;
			count++;
		}
		return head; 
    }
	public static void main(String[] args) {
		int[] arr = {};
        LinkedListNode<Integer> node = createLL(arr,0);
        System.out.println("\nmid point   "+midPoint(node).data);
        System.out.println(-1/2);
	}
}