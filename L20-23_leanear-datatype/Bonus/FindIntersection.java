class ListNode<T>{
	T data;
	ListNode<T> next;
	ListNode(T data){
		this.data = data;
	}
}
public class FindIntersection{
	public static ListNode<Integer> createLL(int[] arr, int index){
		if(index == arr.length) return null;
		ListNode<Integer> node = createLL(arr,index+1);
		ListNode<Integer> head = new ListNode<>(arr[index]);
		head.next = node;
		return head;
	}
	public static void print(ListNode<Integer> head){
		if(head==null) return;
		System.out.println(head.data);
		print(head.next);
	}
	/*############################################################################
			Write a function to get the intersection point of two Linked 
			Lists in no extra space and O(n) time complexity (head of both linked 
			lists must be different).
	#############################################################################*/
	public static ListNode<Integer> reverse(ListNode<Integer> head){
        if(head==null||head.next==null) return head;
        ListNode<Integer> index = head.next, forward = null;
        head.next = null;
        while(index!=null){
            forward = index.next;
            index.next = head;
            head = index;
            index = forward;
        }
        return head;
    }
        
    public static int changelist1(ListNode<Integer> h1,ListNode<Integer> h2) {
        if(h1==h2) return h1.data.intValue();
        if(h1==null||h2==null) return -1;
        // assume h1 is 10->20->30->40->50->60  and h2 is 1->30->40->50->60.
        int firstListLength =0, secondListLength = 0, length = 0;
        ListNode<Integer> temp = h1;
        while(temp!=null){   // it make firstListLength = 6;
            firstListLength++;
            temp = temp.next;
        }
        temp = h2;
        while(temp!=null){    // it make secondListLength = 5;
            secondListLength++;
            temp = temp.next;
        }
        h1 = reverse(h1);// reverse the first list and it become 60->50->40->30->20->10
        // as we know the address of the 30 is same in both list so second list h2 also changed.
        // h2 will become 1->30->20->10
        temp = h2;
        while(temp!=null){    // it count updated list count length = 4;
            length++;
            temp = temp.next;
        }
        // now we can calculate the comman second list length untill comman address came
        // (secondListLength + length-firstListLength-1)/2 = (5+4-6-1)/2 = 1;
        // as i can see in updsated h2 list comman address is present after just 1 node.
        int count  = (secondListLength + length-firstListLength-1)/2;
        temp = h2;
        for(int i =0;i<count;i++){
            temp = temp.next;
        }

        return temp.data.intValue();
    }

    // ********  why this thought does'nt came to my

	public static int changelist(ListNode<Integer> h1,ListNode<Integer> h2) {
        if(h1==h2) return h1.data.intValue();
        if(h1==null||h2==null) return -1;
        // assume h1 is 10->20->30->40->50->60  and h2 is 1->30->40->50->60.
        int firstListLength =0, secondListLength = 0, differance = 0;
        ListNode<Integer> temp = h1;
        while(temp!=null){   // it make firstListLength = 6;
            firstListLength++;
            temp = temp.next;
        }
        temp = h2;
        while(temp!=null){    // it make secondListLength = 5;
            secondListLength++;
            temp = temp.next;
        }
        // now move the head of begger length list so both list become equal 
        // here we h1 is bigger so move h1 by difference times.
        if(firstListLength>secondListLength){
            differance = firstListLength-secondListLength;
            for(int i=0;i<differance;i++){
                h1 = h1.next;
            }
        }else if(secondListLength>firstListLength){
            differance = secondListLength-firstListLength;
            for(int i=0;i<differance;i++){
                h2 = h2.next;
            }
        }
        while(h1!=null){    // it count updated list count length = 4;
            if(h1==h2){return h1.data.intValue();}
            h1 = h1.next;
            h2 = h2.next;
        }return -1;
    }
	public static void main(String...args){
		int[] arr = {10,20,30,40,50,60};
		ListNode<Integer> head = createLL(arr,0);
		int[] arr2 = {1};
		ListNode<Integer> head2 = createLL(arr2,0);
		head2.next = head.next.next;
		print(head2);

	}
}
