class LinkedListNode<T>{
	int data;
	LinkedListNode<T> next;
	LinkedListNode<T> down;
	LinkedListNode(int data){
		this. data= data;
		this.next = null;
		this.down = null;
	}
}
public class FlattenMultilevelLLDepthWise{
	public static LinkedListNode<Integer> createLLfromArray(int[] arr){
		int len1 = arr.length;
		if(len1<=0) return null;
		LinkedListNode<Integer> head=new LinkedListNode<Integer>(arr[0]), temp=head;
		for(int i =1; i<len1;i++){
			LinkedListNode<Integer> node = new LinkedListNode<>(arr[i]);
			temp.next = node;
			temp= node;
		} return head;
	}
	public static LinkedListNode<Integer> addArrayTodowns(int[] arr){
		int len1 = arr.length;
		if(len1<=0) return null;
		LinkedListNode<Integer> head=new LinkedListNode<Integer>(arr[0]), temp=head;
		for(int i =1; i<len1;i++){
			LinkedListNode<Integer> node = new LinkedListNode<Integer>(arr[i]);
			temp.down = node;
			temp= node;
		} return head;
	}
	public static void print(LinkedListNode<Integer> head){
		if(head==null) return;
		System.out.print(head.data+" ");
		if(head.next!=null) print(head.next);
		if(head.down!=null) print(head.down);
	}
	public static void print2(LinkedListNode<Integer> head) {
		if(head==null) return;
		System.out.print(head.data+" ");
		print2(head.next);
		
	}
	/*############################################################################
		You are given a linked list in which each node has two pointers: 
		next and child. Each child pointer will have its own next and child pointer. 
		This results in a multilevel data structure. You may refer to the figure for 
		better understanding.
		You have to flatten this multilevel linked list and form a singly linked list 
		such that the child node is printed before the next node for every node.
#############################################################################*/
	 public static LinkedListNode<Integer> flattenList(LinkedListNode<Integer> node) { 
	 	// retrun the linklist that faltten in down
        if(node==null) return node;
      	LinkedListNode<Integer> childNode = flattenList(node.down);
      	LinkedListNode<Integer> last, rightNode = node.next;
      	node.next = childNode;
      	last = node;
      	while(last.next!=null) last = last.next;
      	if(rightNode!=null) {
      		rightNode = flattenList(rightNode);
      	}
      	node.down = null;
      	last.next = rightNode;
      	return node;
    }
    // public static LinkedListNode<Integer> flattenList(LinkedListNode<Integer> node) { 
	 	// retrun the linklist that faltten in next

    //     if(node==null) return node;
    //   	LinkedListNode<Integer> childNode = flattenList(node.down);
    //   	LinkedListNode<Integer> last=node, rightNode = null;
    //   	while(last.down!=null) last = last.down;
    //   	if(node.next!=null) {
    //   		rightNode = flattenList(node.next);
    // node.next = null;
    //   	}
    //   	last.down = rightNode;
    //   	return node;
    // }
	public static void main(String...args){
		int[] arr = {1,2,3,4,5,6};
		int[] arr1 = {7,8,9,10};
		int[] arr2 = {13,14};
		int[] arr3 = {16};
		LinkedListNode<Integer> head = createLLfromArray(arr);
		LinkedListNode<Integer> head1 = addArrayTodowns(arr1);
		LinkedListNode<Integer> head2 = createLLfromArray(arr2);
		LinkedListNode<Integer> head3 = createLLfromArray(arr3);
		head.down = head2;
		head.next.next.down = head1;
		head.next.next.next.down = head3;
		// System.out.println(head.next.next.data);
		// System.out.println(head3.down);
		head = flattenList(head);
		print2(head);

	}
}