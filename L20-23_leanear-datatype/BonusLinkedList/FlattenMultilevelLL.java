class Node{
	int data;
	Node next;
	Node down;
	Node(int data){
		this. data= data;
		this.next = null;
		this.down = null;
	}
}
public class FlattenMultilevelLL{
	public static Node createLLfromArray(int[] arr){
		int len1 = arr.length;
		if(len1<=0) return null;
		Node head=new Node(arr[0]), temp=head;
		for(int i =1; i<len1;i++){
			Node node = new Node(arr[i]);
			temp.next = node;
			temp= node;
		} return head;
	}
	public static Node addArrayTodowns(int[] arr){
		int len1 = arr.length;
		if(len1<=0) return null;
		Node head=new Node(arr[0]), temp=head;
		for(int i =1; i<len1;i++){
			Node node = new Node(arr[i]);
			temp.down = node;
			temp= node;
		} return head;
	}
	public static void print(Node head){
		if(head==null) return;
		System.out.print(head.data+" ");
		if(head.next!=null) print(head.next);
		if(head.down!=null) print(head.down);
	}
	/*############################################################################
		You are given a linked list in which each node has two pointers: next 
		and down. Each down pointer will have its own next and down pointer. 
		This results in a multilevel data structure.
		You have to flatten this multilevel linked list and form a singly linked
		list such that all the nodes in the first level should come first, then 
		nodes of second level and so on.
#############################################################################*/
	public static Node flatNext(Node head){
		if(head==null) return head;
		Node last = head;
		while(last.next!=null){
			last = last.next;
		}return last;
	}
	public static void flattenListCorrect(Node hp) {
		if(hp==null) return;
		Node last = flatNext(hp);
		Node index = hp;
		while(index!=null){
		// System.out.println("flast 1 ");
			if(index.down!=null){
				Node down = index.down;
				last.next = down;
				last = flatNext(down);
				index.down=null;
			}
			index = index.next;
		}
    }

	



	public static void main(String...args){
		int[] arr = {1,2,3,4,5,6};
		int[] arr1 = {7,8,9,12};
		int[] arr2 = {13,14,15};
		int[] arr3 = {16};
		Node head = createLLfromArray(arr);
		Node head1 = addArrayTodowns(arr1);
		Node head2 = createLLfromArray(arr2);
		Node head3 = createLLfromArray(arr3);
		head.down = head1;
		head.next.next.down = head2;
		head.next.next.next.down = head3;
		// System.out.println(head.next.next.data);
		// System.out.println(head3.down);
		flattenListCorrect(head);
		print(head);

	}
}