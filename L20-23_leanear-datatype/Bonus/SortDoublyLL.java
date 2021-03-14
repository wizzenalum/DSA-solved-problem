class DoublyLinkedListNode<T>{
	T data;
	DoublyLinkedListNode<T> next;
	DoublyLinkedListNode<T> prev;
	DoublyLinkedListNode(T data){
		this.data = data;
		this.next = null;
		this.prev = null;
	}

}
public class SortDoublyLL{
	public static DoublyLinkedListNode<Integer> createDoublyLLFromArray(int[] arr){
		int len = arr.length;
		if(len<=0) return null;
		DoublyLinkedListNode<Integer> head =new DoublyLinkedListNode<>(arr[0]);
		DoublyLinkedListNode<Integer> last= head;
		for(int i=1;i<len;i++){
			DoublyLinkedListNode<Integer> node =new DoublyLinkedListNode<>(arr[i]);
			last.next = node;
			node.prev = last;
			last = node;
		}
		return head;
	}
	public static void print(DoublyLinkedListNode<Integer> node){
		while(node!=null){
			System.out.println(node.prev+"<---"+node.data+"--->"+node.next+" || ");
			node = node.next;
		}
	}
	public static DoublyLinkedListNode<Integer> sorting(DoublyLinkedListNode<Integer> head) {
        if(head==null||head.next==null) return head;
        DoublyLinkedListNode<Integer> 	firstHalfIndex=head, secondHalfIndex=null, 
        								tempForFirst = null, tempForSecond = null;
        while(firstHalfIndex.next!=null){  // to reach the biggest element.
        	if(firstHalfIndex.next.data.intValue()<firstHalfIndex.data.intValue()) break;
        	firstHalfIndex = firstHalfIndex.next;
        }
        secondHalfIndex = firstHalfIndex.next; // this is the start of second part of list that is decreasing.
        firstHalfIndex.next = null;  // because this will be the last element of the linklist.
        while(secondHalfIndex!=null){
        	tempForSecond = secondHalfIndex.next;
        	tempForFirst = firstHalfIndex.next;
        	if(firstHalfIndex==null) tempForFirst = firstHalfIndex;
    		while(firstHalfIndex!=null && firstHalfIndex.data.intValue()>=secondHalfIndex.data.intValue()){ // here i start moiving back 
    			tempForFirst = firstHalfIndex;  // to track the next of the firsthalf index.
    			firstHalfIndex = firstHalfIndex.prev;
    		}
        	if(firstHalfIndex!=null){
        		firstHalfIndex.next = secondHalfIndex;
        		secondHalfIndex.prev = firstHalfIndex;
        		secondHalfIndex.next = tempForFirst;
        		tempForFirst = secondHalfIndex;

        		secondHalfIndex = tempForSecond;// increament.
        	}else if(secondHalfIndex==null) break;
        	else{
        		// program if fist half become null but shi have some thing;
        		firstHalfIndex  = tempForFirst;
        		while(secondHalfIndex!=null){
        			tempForSecond = secondHalfIndex.next;
        			firstHalfIndex.prev = secondHalfIndex;
        			secondHalfIndex.next  =firstHalfIndex;
        			firstHalfIndex = secondHalfIndex;
        			secondHalfIndex = tempForSecond;
        		}
        		firstHalfIndex.prev = secondHalfIndex;
        		return firstHalfIndex;
        	}
        }return head;
    }
	public static void main(String...args){
		int[] arr = {1,2,3,4,5,8,9,12,12,10,8,4,2};
		// int[] arr = {10,0};
		DoublyLinkedListNode<Integer> head = createDoublyLLFromArray(arr);
		print(sorting(head));

		// print(head);
	}	
}