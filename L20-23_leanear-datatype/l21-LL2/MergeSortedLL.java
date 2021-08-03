class LinkedListNode<T>{
	T data;
	LinkedListNode<T> next;
	LinkedListNode(T data){
		this.data = data;
	}
}
public class MergeSortedLL{
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
	Write a function to merge them in such a way that the resulting singly
	linked list is also sorted(in ascending order) and return the new head to the list.
#############################################################################*/
	public static LinkedListNode<Integer> mergeTwoSortedLinkedLists(
													LinkedListNode<Integer> head1,
													LinkedListNode<Integer> head2
														) {
// ********** time O(n) and space O(1) ***********
	 	if(head1==null) return head2;
	 	if(head2==null) return head1;
        LinkedListNode<Integer> head = head1.data.compareTo(head2.data)==-1?head1:head2;
        LinkedListNode<Integer> temp;
        LinkedListNode<Integer> endNode = head;
        while(head1!=null&&head2!=null){

        	if(head1.data.compareTo(head2.data)==-1){
        		// System.out.println("if  "+head1.data+" "+ head2.data);
    			temp = head1.next;
    			endNode.next = head1;
    			endNode = endNode.next;
    			head1 = temp;
        	}else{
        		// System.out.println("else  "+head1.data+" "+ head2.data);
        		temp = head2.next;
        		endNode.next = head2;
        		endNode = endNode.next;
        		head2 = temp;
        	}
        }
        if(head1!=null){
        	endNode.next = head1;
        }
        if(head2!=null){
        	endNode.next = head2;
        }
        return head;
    }
	public static void main(String[] args) {
		int[] arr = {22};
		int[] arr1 = {2,2,36};
        LinkedListNode<Integer> head1 = createLL(arr,0);
        LinkedListNode<Integer> head2 = createLL(arr1,0);
        print(mergeTwoSortedLinkedLists(head1,head2));
	}
}