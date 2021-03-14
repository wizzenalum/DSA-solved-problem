class LinkedListNode<T>{
	T data;
	LinkedListNode<T> next;
	LinkedListNode(T data){
		this.data = data;
	}

}

public class DeleteNode{
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
	

	public static LinkedListNode<Integer> deleteNodeRec(LinkedListNode<Integer> head, int pos) {
    // ********sequantail method  time O(n) space O(1)********************
    	if(head ==null) return head;
    	if(pos == 0) return head.next;
    	int index = 0;
    	LinkedListNode<Integer> beforeDeleteNode = head;
    	while(beforeDeleteNode.next!=null){
    		if(index == pos-1){
    			beforeDeleteNode.next = beforeDeleteNode.next.next;
    			break;
    		}
    		else {
    			index++;
    			beforeDeleteNode = beforeDeleteNode.next;
    		}
    	}return head;	
	}
	public static LinkedListNode<Integer> deleteNodeRec1(LinkedListNode<Integer> head, int pos) {
    // ********recursivly ********************
    	if(head==null) return head;
    	if(pos ==0) return head.next;
    	head.next = deleteNodeRec1(head.next,pos-1);
    	return head;
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		LinkedListNode<Integer> node = createLL(arr);
		node = deleteNodeRec1(node,1);
		print(node);
	}

}