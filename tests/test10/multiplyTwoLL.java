/* *********        Multiply Two Linked Lists   ***************
	1. You are given two linked lists. Data of each node of these linked 
	lists contain a digit from the range: [0, 9].
	2. The linked lists represent two numbers.
	3. You have to print the product of these two numbers.
		
		Input Format:
			Input has already been managed for cpp and java submissions. 
			In cpp and java, you have to just write a function which receives 
			head nodes of two linked lists. The sizes of linked lists are N and M, 
			respectively.
			For other languages, the first line of input contains list of N space 
			separated integers, terminated by -1. The following line of input also 
			contains list of M space separated integers, terminated by -1. The 
			integers form the data of nodes of two linked list.   

		Constraints:
			N and M lies in the range: [1, 1000].
			0 <= |Node Data| <= 9

		Output format:
			Print the product of numbers, represented by two linked lists.

		Sample Input:
			1 2 3 4 5 -1
			1 2 3 -1

		Sample Output:
			1 5 1 8 4 3 5
 */





package  test10;

import java.util.Scanner;
 
class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;
    
    public LinkedListNode(T data) {
        this.data = data;
        this.next = null;
    }
}

public class multiplyTwoLL {

	public static LinkedListNode<Integer> takeInput(Scanner s) {
		LinkedListNode<Integer> head = null;
		LinkedListNode<Integer> tail = null;
		
		int data = s.nextInt();
		
		while(data != -1) {
			LinkedListNode<Integer> newNode = new LinkedListNode<>(data);
			
			if(head == null) {
				head = newNode;
				tail = newNode;
			} else {
				tail.next = newNode;
				tail = newNode;
			}
			data = s.nextInt();
		}
		return head;
	}
    public static void print(LinkedListNode<Integer> head) {
        while(head!=null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
	public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head) {
		// System.out.println(head.data);
		if(head == null) return null;
		if(head.next==null) return head;
		LinkedListNode<Integer> nHead = reverse(head.next);
		
		head.next.next = head;
		head.next = null;
		return nHead;
		
	}
	public static int count(LinkedListNode<Integer> head) {
        int c  = 0;
		while(head!=null){
			c++;
			head = head.next;
		}
		return c;
    }
	
    public static void multiply(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        // reverse the linked list
		head1 = reverse(head1);
		head2 = reverse(head2);
		LinkedListNode<Integer> temp1= head1, temp2 = head2, addPos = null;
		LinkedListNode<Integer> result = new LinkedListNode<>(0), add = result;
		int len1 = count(head1),len2 = count(head2);
		// System.out.println(len1+" "+len2);
		for (int i = 0; i <len1 ; i++) {
			temp2 = head2;
			print(result);
			
			add = result;
			for (int j = 0; j < i; j++) {
				if(add.next==null) add.next = new LinkedListNode<>(0);
				add = add.next;
			}
			int hasil = 0;
			for (int j = 0; j < len2; j++) {
				int num = temp2.data*temp1.data+hasil;
				int tempNum = num%10;
				addPos = add;
				while(tempNum!=0){
					tempNum += addPos.data;
					addPos.data=tempNum%10;
					tempNum/=10;
					if(addPos.next ==null && tempNum!=0){
						addPos.next = new LinkedListNode<>(0);
					}
					addPos = addPos.next;
				}
				hasil = num/10;
				if(add.next==null && (j<len2-1||hasil!=0)) add.next = new LinkedListNode<>(0);
				add = add.next;
				temp2 = temp2.next;
			}
			if(hasil!=0) add.data += hasil;
			temp1 = temp1.next;
		}
		print(reverse(result));
    }

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		LinkedListNode<Integer> head1 = takeInput(s);
		LinkedListNode<Integer> head2 = takeInput(s);
		
		multiply(head1, head2);
		
		s.close();
	}

}