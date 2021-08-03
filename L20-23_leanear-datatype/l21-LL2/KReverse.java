import java.util.Scanner;
class LinkedListNode<T>{
    T data;
    LinkedListNode<T> next;
    LinkedListNode(T data){
        this.data = data;
    }
}


public class KReverse{

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
	    Given a singly linked list of integers, reverse the nodes 
		of the linked list 'k' at a time and return its modified list.
		 'k' is a positive integer and is less than or equal to the 
		 length of the linked list. If the number of nodes is not a multiple 
		 of 'k,' then left-out nodes, in the end, should be reversed as well.
		Example :
			Given this linked list: 1 -> 2 -> 3 -> 4 -> 5
			For k = 2, you should return: 2 -> 1 -> 4 -> 3 -> 5
			For k = 3, you should return: 3 -> 2 -> 1 -> 5 -> 4
    #############################################################################*/
    
    public static LinkedListNode<Integer> kReverse(LinkedListNode<Integer> head, int k) {
		if(k<2||head==null||head.next==null) return head;
		int tempK = 1;
		boolean firstReverse = true;
		LinkedListNode<Integer> index=head, tail = null, temp = null,
								reverseHead = null, reverseTail = null;
		// breakLabel:
		while(index!=null){
			// System.out.println("in");
			// temp = index; //here i want index to fix and temp will move next only next loop
			// for(tempK=1;tempK<k;tempK++){  // checking the space for reverse.
			// 	if(temp==null||temp.next==null) return head;
			// 	temp = temp.next;
			// }
			reverseHead = null; 
			boolean firstNodeOfReverse = true; 
			for(tempK=0;index!=null&&tempK<k;tempK++){ // reverse the part of linked list.
				temp = index.next;			// temp is just temprarily storing index.next and index is moving ahead.
				index.next = reverseHead;
				if(firstNodeOfReverse){
					reverseTail = index;
					firstNodeOfReverse = false;
				}
				reverseHead = index;
				index=temp;
			}
			if(firstReverse){
				head = reverseHead;
				tail = reverseTail;
				tail.next = index;
				firstReverse=false;
			}else{
				tail.next = reverseHead;
				tail = reverseTail;
				tail.next  =index;
			}
		}
		return head;
	}
	public static LinkedListNode<Integer> kReverse1(LinkedListNode<Integer> head, int k) {
		if(head==null||head.next==null||k==1) return head;
		int count;
		LinkedListNode<Integer> tailReverse =head, index = head.next,
								 forward=null;
		for(count = 1; index!=null && count<k;count++){
			forward = index.next;
			index.next = head;
			head = index;
			index = forward;
		}
		forward = null;
		if(count>=k){
			forward = kReverse1(index,k);
		}
		tailReverse.next = forward;
		return head;
	}

        public static void main(String[] args){
            int[] arr = {10,34,2,3};
            LinkedListNode<Integer> node = createLLFromArr(arr,arr.length);
            LinkedListNode<Integer> head = (kReverse1(node,3));
            print(head);

        }
}