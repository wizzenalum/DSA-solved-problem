import java.util.Scanner;
public class ExercisesBeetweenLectures{
	static class LinkedListNode<T>{
		T data;
		LinkedListNode<T> next;
		LinkedListNode(T data){
			this.data = data;
		}
	}
/*############################################################################
	create a linked list from given array of integer and return head of linked list.
#############################################################################*/
	public static LinkedListNode<Integer> createLLFromArr(int[] arr, int size){
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

/*############################################################################
		print the all elements of the ll
#############################################################################*/
public static void print(LinkedListNode<Integer> head){
	while(head!=null){
		System.out.println(head.data);
		head = head.next;
	}
}


/*############################################################################
		count the of nodes for given head of a linked list.
#############################################################################*/
public static int length(LinkedListNode<Integer> head){
		int length = 0;
		while(head!=null){
			length++;
			head = head.next;
		}
		return length;
	}



/*############################################################################
		print the ith node for given head of a linked list.
#############################################################################*/
	public static void printIthNode(LinkedListNode<Integer> head, int i){
		int index = 1;
		while(head!=null){
			if(index==i) {
				System.out.println(head.data);
				return;
			}
			else {
				index++;
				head = head.next;
			}
		}

	}
/*############################################################################
		insert a data into a linked list at position pos when head of of 
		linklist is given and return new head.
#############################################################################*/
	public static LinkedListNode<Integer> insert(LinkedListNode<Integer> head, int pos, int data){
		LinkedListNode<Integer> node = new LinkedListNode<>(data);
		LinkedListNode<Integer> temp = head;
		int index = 0;
		while(temp!=null){
			if(pos==0){
				node.next=temp;
				head = node;
				break;
			}
			if(index == pos-1){
				node.next = temp.next;
				temp.next = node;
				break;
			}else{
				index++;
				temp = temp.next;
			}
		}
		return head;
	}

/*############################################################################
		delete a node from the position pos and return new head of linked list.
#############################################################################*/
	
	public static LinkedListNode<Integer> deleteNode(LinkedListNode<Integer> head, int pos) {
		int index = 0;
		LinkedListNode<Integer> temp = head;
		while(temp.next!=null){
			if(pos ==0){
				head = head.next;
				break;
			}
			if(index == pos-1){
				if(temp.next.next==null){
					temp.next = null;
				}else{
					temp.next = temp.next.next;
				}
				break;
			}
			index++;
			temp = temp.next;
		} return head;
	}

	public static void main(String[] args) {
		// ************hard coded linked list**************************
		// LinkedListNode<Integer> node = new LinkedListNode<>(10);
		// LinkedListNode<Integer> node2 = new LinkedListNode<>(20);
		// LinkedListNode<Integer> node3 = new LinkedListNode<>(30);
		// LinkedListNode<Integer> node4 = new LinkedListNode<>(40);
		// node.next = node2;
		// node2.next = node3;
		// node3.next = node4;
		// ************linked list for marray by function******************
		int[] arr = {10,20,30,40};
		LinkedListNode<Integer> node = createLLFromArr(arr,arr.length);

		// ************input from console**************************
		// Scanner scan = new Scanner(System.in);
		// String inputStr = scan.nextLine();
		// String[] inputArr = inputStr.trim().split(" ");
		// int n = inputArr.length;
		// int[] arr = new int[n];
		// for(int i =0;i<n;i++) arr[i] = Integer.parseInt(inputArr[i]);
		// LinkedListNode<Integer> node = createLLFromArr(arr,arr.length);


		System.out.println("leangth function  "+length(node)+"\n");
		System.out.println("PrintIthNode function");
		printIthNode(node,3);
		System.out.println("insert function"+insert(node,1,15).data);
		System.out.println("\nprint function");
		print(insert(node,1,15));
		System.out.println("delete function");
		print(deleteNode(node,5));
	}
}