class Node<T>{
	T data;
	Node<T> next;
	Node<T> arb;
	Node(T data){
		this.data = data;
		this.next = null;
		this.arb = null;
	}
}
public class CloneLL{
	public static Node<Integer> createLLfrom2Array(	int[] arr, int[] linkarray,
											int arrayIndex, int linkIndex){

		if(arrayIndex==arr.length) return null;
		int temp = 0;
		Node<Integer> tempNode = new Node<>(arr[arrayIndex]);
		if(linkIndex<linkarray.length && linkarray[linkIndex]==arrayIndex) temp = linkIndex+2;
		Node<Integer> head = createLLfrom2Array(arr,linkarray,arrayIndex+1,temp);
		tempNode.next = head;
		head = tempNode;
		if(linkIndex<linkarray.length && arrayIndex==linkarray[linkIndex]){
			tempNode = head;
			for(int i=linkarray[linkIndex];i<linkarray[linkIndex+1];i++){
				tempNode = tempNode.next;
			}
			head.arb = tempNode;
		} 
		return head;

	}
	public static void print(Node<Integer> head){
		if(head==null) return;
		System.out.print(head.data);
		System.out.print("->"+head.arb);
		// if(head.arb!=null) System.out.print("->"+head.arb.data);
		System.out.print(" | ");
		print(head.next);
	}
	/*############################################################################
		A singly linked list is given to you with N nodes where each node is 
		pointing to its next node and some of its nodes are pointing to the arbitrary nodes. 
		You are given with M arbitrary pointers, where you have M pairs denoting 
		that two nodes a and b are connected i.e. a's arbitrary pointer is pointing 
		towards b (a->arb=b). You have to write a function to clone the original 
		linked list given to you and return its head. We will validate whether the 
		linked list is a copy of the original linked list or not.
#############################################################################*/
	public static Node<Integer> clone(Node<Integer> head) {
		// it is burite force solution to the problem which has recurance T(n) = T(n-1) +cn. so time O(n^2);
		if(head==null) return head;
		Node<Integer> tempNode = new Node<Integer>(head.data);
		Node<Integer> newHead = clone(head.next);
		tempNode.next = newHead;
		newHead  = tempNode;
		if(head.arb!=null){
		// System.out.println("in");
		Node<Integer> temp=head;
			while(head.arb!=temp){
				tempNode = tempNode.next;
				temp=temp.next;
			}
			newHead.arb = tempNode;
		}return newHead; 	
	}
	// think nodes can be linked in reverese order...
public static Node<Integer> clone1(Node<Integer> head, Node<Integer> startHead, Node<Integer> startclone, boolean check) {
		// it is burite force solution to the problem which has recurance T(n) = T(n-1) +cn. so time O(n^2);
		if(head==null) return head;
		Node<Integer> newHead, tempNode;
		if(check){
			tempNode = new Node<Integer>(head.data);
			newHead = clone1(head.next,startHead,tempNode,false);
			startclone = tempNode;
		}else{
			tempNode = new Node<Integer>(head.data);
			newHead = clone1(head.next,startHead,startclone,check);
		}
		tempNode.next = newHead;
		newHead  = tempNode;
		if(head.arb!=null){
		// System.out.println("in");
		Node<Integer> temp=startHead;
		tempNode = startclone;
			while(head.arb!=temp){
				temp=temp.next;
				tempNode = tempNode.next;
			}
			newHead.arb = tempNode;
		}return newHead; 	

	}
	public static Node<Integer> clone(Node<Integer> head) {
		// it is burite force solution to the problem which has recurance T(n) = T(n-1) +cn. so time O(n^2);
		if(head==null) return head;
		Node<Integer> newHead = clone1(head, head, head, true);
		return newHead; 	
	}

	public static Node<Integer> clone2(Node<Integer> head){
		if(head==null) return head;
		Node<Integer> newHead = new Node<>(head.data.intValue());
		Node<Integer> temp = head.next, cloneTemp=newHead, index = head, cloneIndex = newHead;
		// creating exact copy of the head ll.
		while(temp!=null){
			cloneTemp.next = new Node<Integer>(temp.data.intValue());
			temp = temp.next;
			cloneTemp = cloneTemp.next;
		}
		// create back and forth relations in b/w new and old linked list.
		while(index!=null){
			temp = index.next;
			cloneIndex.arb  =index;
			index.next = cloneIndex;
			cloneIndex = cloneIndex.next;
			index = temp;
		}
		// creting arbitary relations for the new linklist with regaining the old one.
		index = head;
		cloneIndex = newHead;
		while(cloneIndex!=null){
			if(cloneIndex.next==null){
				index.next = null;
				cloneIndex.arb = null;
				break;
			}else if(cloneIndex.arb.arb!=null){
				cloneTemp = cloneIndex.arb.arb.next;
				temp = cloneIndex.next.arb;
				cloneIndex.arb = cloneTemp;
				index.next = temp;
				cloneIndex = cloneIndex.next;
				index = temp;
			}else{
				index.next = cloneIndex.next.arb;
				cloneIndex.arb = null;
				index = index.next;
				cloneIndex = cloneIndex.next;
			}
		}
		return newHead;
	}
	public static void main(String...args){
		int[] arr = {0,1,2,3};
		int[] arr1 = {0,1,2,3};
		// int[] arr = {0,1,2,3,4,5,6,7,8,9};
		// int[] arr1 = {0,9,1,3,2,5,3,9,4,8,5,9,6,9,8,9};
		Node<Integer> head = createLLfrom2Array(arr,arr1,0,0);
		print(head);
		System.out.println();
		// System.out.println(head.next.next);
		head = clone(head);
		print(head);

	}
}