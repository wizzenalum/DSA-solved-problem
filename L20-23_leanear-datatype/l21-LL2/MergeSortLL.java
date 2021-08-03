class LinkedListNode<T>{
	T data;
	LinkedListNode<T> next;
	LinkedListNode(T data){
		this.data = data;
	}
}
public class MergeSortLL{
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
	public static LinkedListNode<Integer> mergeTwoSortedLinkedLists(
													LinkedListNode<Integer> head1,
													LinkedListNode<Integer> head2
														) {
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
/*############################################################################
	it will return head of a sorted Link list for give link list using merge sort.
#############################################################################*/
    public static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head) {
        if(head==null||head.next==null) return head;
        LinkedListNode<Integer> temp = head;
        int tempNum=0, tempNumNext=0;
        while(temp.next!=null){
            tempNum = temp.data.intValue();
            tempNumNext = temp.next.data.intValue();
            if(tempNumNext<tempNum) break;
            temp = temp.next;
        }
        LinkedListNode<Integer> newHead = mergeSort(temp.next);
        temp.next = null;
        head = mergeTwoSortedLinkedLists(newHead,head);
        return head;
    }
    // public static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head) {
    //     if(head==null||head.next==null) return head;
    //     LinkedListNode<Integer> temp = head;
    //     int length = 0;
    //     while(temp!=null){
    //         length++;
    //         temp = temp.next;
    //     }
    //     // System.out.println(length);
    //     int mid = (length-1)/2;
    //     temp = head;
    //     for(int i=0; i<mid;i++) temp = temp.next;
    //     LinkedListNode<Integer> head1 =temp.next;
    //     temp.next = null;
    //     head = mergeTwoSortedLinkedLists(mergeSort(head),mergeSort(head1));
    //     return head;
    // }
	public static void main(String[] args) {
		int[] arr = {5,2};
		int[] arr1 = {10, 40, 53, 30, 67, 12, 89};
        LinkedListNode<Integer> head1 = createLL(arr,0);
        LinkedListNode<Integer> head2 = createLL(arr1,0);
        print(mergeSort(head2));
	}
}