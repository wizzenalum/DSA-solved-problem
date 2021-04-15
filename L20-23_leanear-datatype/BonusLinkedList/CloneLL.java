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
		if(head.arb!=null) System.out.print("->"+head.arb.data);
		else System.out.print("->"+head.arb);
		// if(head.arb!=null) System.out.print("->"+head.arb.data);
		System.out.print(" -->>-- ");
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

			function    				completed
	clone(bruet force method)              true
	clone1(time O(n) space O(n))           true
	clone2(time O(n) space O(1))           true
		there is one issue of creation of the problem.
#############################################################################*/

// method 1 bruite force solution 
	public static Node<Integer> cloneLL(Node<Integer> head) {
		// it is burite force solution to the problem which has recurance T(n) = T(n-1) +cn. so time O(n^2);
		// only works when it have arbitory link is in forward way not in previous one.
		if(head==null) return head;
		Node<Integer> tempNode = new Node<Integer>(head.data);
		Node<Integer> newHead = clone(head.next);
		tempNode.next = newHead;
		newHead  = tempNode;
		if(head.arb!=null){
		// System.out.println("in");
		Node<Integer> temp=head;
			while(head.arb!=temp && temp!=null){
				tempNode = tempNode.next;
				temp=temp.next;
			}
			newHead.arb = tempNode;
		}return newHead; 	
	}
	// think nodes can be linked in reverese order...
	public static void addBackwardLinks(	Node<Integer> head, Node<Integer> cloneHead,
													Node<Integer> startHead, Node<Integer> startClone ){
		// as forward links are connected by clone so we here connect backward links.
		if(head==null) return;
		addBackwardLinks(head.next,cloneHead.next, startHead, startClone);	
		if(head.arb!=null && cloneHead.arb==null){
			while(head.arb!=startHead && startHead!=null){
				startHead=startHead.next;
				startClone = startClone.next;
			}
			cloneHead.arb = startClone;
		}

	}
	public static Node<Integer> clone(Node<Integer> head) {
		// it is burite force solution to the problem which has recurance T(n) = T(n-1) +cn. so time O(n^2);
		// it will solve the problm and can link previous link to by arbitorily.	
		if(head==null) return head;
		Node<Integer> newHead = cloneLL(head);
		addBackwardLinks(head,newHead,head,newHead);
		return newHead; 			
	}

	public static Node<Integer> clone1(Node<Integer> head){
		// it only have time of O(n) and space also O(n)/O(1)(if given list is lost) that is new created link list.
		// problem is it just break the original linked list and we cant restore it.
		if(head==null) return head;
		Node<Integer> temp = head, cloneTemp=null, index = head, 
				cloneIndex = null, newHead = null;
		// creating exact copy of the head ll.
		int length = 0;
		while(temp!=null){
			if(temp == head){
				cloneTemp = new Node<>(temp.data);
				newHead = cloneTemp;	
			}else{
				cloneTemp.next = new Node<>(temp.data);
				cloneTemp = cloneTemp.next;
			}
			length++;
			temp = temp.next;
		}
		// create back and forth relations in b/w new and old linked list.
		index = head;
		cloneIndex = newHead;
		while(index!=null){
			temp = index.next;
			cloneIndex.arb  =index;
			index.next = cloneIndex;
			cloneIndex = cloneIndex.next;
			index = temp;
		}
		index = head;
		cloneIndex = newHead;
	// creting arbitary relations for the new linklist with regaining the old one only work when arbitary links are in forward way..
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
	// creting arbitary relations for the new linklist but can't regain old one but create arbitories perfectly but time O(n) space O(1).
	// but here we are restoring actual root list by storiing it in array so space O(n);
		// Node[] arr = new Node[length]; 
		// int i =0;
		// while(cloneIndex!=null){
		// 	// System.out.print(cloneIndex.data);
		// 	arr[i] = index;
		// 	i++;
		// 	if(cloneIndex.next!=null) temp = cloneIndex.next.arb;
		// 	if(index.arb!=null) cloneIndex.arb = index.arb.next;
		// 	else cloneIndex.arb = null;
		// 	index = temp;
		// 	cloneIndex = cloneIndex.next;
		// }
		// // restoring root list
		// for(i=1;i<length;i++){
		// 	arr[i-1].next = arr[i]; 
		// }
		// arr[i-1].next = null;
		return newHead;
	}
	

	public static Node<Integer> clone2(Node<Integer> head){
		// it only have time of O(n) and space also O(n) that is new created link list.
		// recrete both without using extra space.
		if(head==null) return head;
		Node<Integer> index = head, cloneIndex =null;
// step 1  creating exact copy of the head ll.

	// //**********following code is giving some problem.****
		Node<Integer> newHead = new Node<>(head.data.intValue()),
								cloneTemp = newHead, temp = head.next;
		while(temp!=null){
			cloneTemp.next = new Node<Integer>(temp.data);
			temp = temp.next;
			cloneTemp = cloneTemp.next;
		}


        // alternate way of creting the list work fine 
		Node<Integer> temp = head, cloneTemp=null, newHead=null;
		while(temp!=null){
			if(temp == head){
				cloneTemp = new Node<>(temp.data);
				newHead = cloneTemp;	
			}else{
				cloneTemp.next = new Node<>(temp.data);
				cloneTemp = cloneTemp.next;
			}
			temp = temp.next;
		}



// step 2  create back and forth relations in b/w index, indexcloned, index.next.
        index = head;
        cloneIndex = newHead;
		while(index!=null){
			temp = index.next;
			cloneTemp = cloneIndex.next;
			index.next = cloneIndex;
			cloneIndex.next = temp;
			index = temp;
			cloneIndex = cloneTemp;
		}
// // //step1+step2 = crete and place b/t given list.
// // 		Node<Integer> temp = head, cloneTemp=null, newHead=null;
// // 		index = head;
// // 		while(index!=null){
// // 			cloneTemp = new Node<>(index.data);
// // 			if(index == head) newHead = cloneTemp;
// // 			cloneTemp.next = index.next;
// // 			index.next = cloneTemp;
// // 			index = cloneTemp.next;
// // 		}
// creting arbitary relations.
		index = head;
		while(index!=null){
			if(index.arb!=null) index.next.arb = index.arb.next;
			index = index.next.next;
		}
// restore both the lists
		index = head;
        // temp = head.next;
		while(index!=null){
			temp = index.next.next;
			if(index.next.next!=null){
				index.next.next = temp.next;
				index.next = temp;
                
			}else{
				index.next = null;
			}
			index = temp;
		}
		return head;
	}
	public static void main(String...args){
		// int[] arr = {0,1,2,3};
		// int[] arr1 = {0,1,2,3};
		int[] arr = {0,1,2,3,4,5,6,7,8,9};
		int[] arr1 = {0,9,1,3,2,5,3,9,4,8,5,9,6,9,8,9};
		Node<Integer> head = createLLfrom2Array(arr,arr1,0,0);
		head.next.next.next.arb = head.next;
		print(head);
		System.out.println();
		// System.out.println(head.next.next);
		head = clone2(head);
		print(head);
	}
}