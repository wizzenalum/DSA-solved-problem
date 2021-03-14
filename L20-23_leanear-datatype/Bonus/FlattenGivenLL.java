class LinkedListNode<T>{
	T data;
	LinkedListNode<T> right;
	LinkedListNode<T> down;
	LinkedListNode(T data){
		this.data = data;
		this.right = null;
		this.down = null;
	}
}
public class FlattenGivenLL{
	public static LinkedListNode<Integer> createLLfromArray(int[] arr){
		int len1 = arr.length;
		if(len1<=0) return null;
		LinkedListNode<Integer> head=new LinkedListNode<>(arr[0]), temp=head;
		for(int i =1; i<len1;i++){
			LinkedListNode<Integer> node = new LinkedListNode<>(arr[i]);
			temp.down = node;
			temp= node;
		} return head;
	}
	public static LinkedListNode<Integer> createLLfrom2dArray(int[][] arr){
		int len1 = arr.length;
		if(len1<=0) return null;
		LinkedListNode<Integer> head= createLLfromArray(arr[0]),temp = head;
		for(int i=1;i<len1;i++){
			LinkedListNode<Integer> node = createLLfromArray(arr[i]);
			temp.right = node;
			temp = node;
		}
		return head;
	}
	public static void print(LinkedListNode<Integer> head){
		LinkedListNode<Integer> columnHead;
		while(head!=null){
			columnHead = head;
			while(columnHead!=null){
				System.out.print(columnHead.data+" ");
				columnHead = columnHead.down;
			}head = head.right;
			System.out.println();
		}
	}
	/*############################################################################
		You are given a linked list where each node of the 
		given linked list has two pointers of such that:
		1. The first pointer points to the next node of the main 
		linked list (known as "right" pointer).
		2. The second pointer points the linked list where this 
		node is head (known as "down" pointer).
		It is given that all the linked list are sorted. You have 
		to write a function to flatten this list into a single linked 
		list which should also be sorted.
#############################################################################*/
	public static LinkedListNode<Integer> mergeLL1( 	LinkedListNode<Integer> head1,
													LinkedListNode<Integer> head2){
		// this return merged linked list when two link list are given time O(n) space O(1)
		if(head1==null) return head2;
		if(head2==null) return head1;
		LinkedListNode<Integer> tail=null, head = null;
		int data1 = head1.data.intValue(), data2 = head2.data.intValue();
		if(data1>data2){
			tail = head2;
			head2 = head1;
			head1 = tail;
		}
		tail = head1;
		head = head1;
		head1 = head1.down;
		while(head1!=null && head2!=null){
			data1 = head1.data.intValue();
			data2 = head2.data.intValue();
			if(data1<data2){
				tail.down = head1;
				tail =head1;
				head1  =head1.down;
			}else if(data1>data2){
				tail.down = head2;
				tail =head2;
				head2  =head2.down;
			}else{
				tail.down = head1;
				tail =head1;
				head1  =head1.down;
				tail.down = head2;
				tail =head2;
				head2  =head2.down;
			}
		}
		if(head1!=null) tail.down = head1;
		if(head2!=null) tail.down = head2;
		return head;
	}
	public static LinkedListNode<Integer> mergeLL( 	LinkedListNode<Integer> head1,
													LinkedListNode<Integer> head2){
		// doing it recursivly....  
		if(head1==null) return head2;
		if(head2==null) return head1;
		LinkedListNode<Integer> head = null;
		int data1 = head1.data.intValue(), data2 = head2.data.intValue();
		if(data1<data2){
			head = mergeLL(head1.down,head2);
			head1.down = head;
			return head1;
		}
		if(data2<data1){
			head = mergeLL(head2.down,head1);
			head2.down = head;
			return head2;
		}
		head = mergeLL(head1.down,head2.down);
		head1.down = head;
		head2.down = head1;
		return head2;
	}

	public static LinkedListNode<Integer> flat(LinkedListNode<Integer> head) {
		if(head==null||head.right==null) return head;
		LinkedListNode<Integer> node = flat(head.right);
		head.right = null;
		return mergeLL(head,node); 
	}


	public static void main(String...args){
		int[][] mat = {
					{1,2,3,4},
					{1,2}
					};
		int[] arr = {2,3,15,16};
		int[] arr1 = {1,2,5,6};
		// LinkedListNode<Integer> head1 = createLLfromArray(arr);
		// LinkedListNode<Integer> head2 = createLLfromArray(arr1);
		// print(mergeLL(head1,head2));
		LinkedListNode<Integer> node = createLLfrom2dArray(mat);
		print(flat(node));

	}
}













