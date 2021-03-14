import java.lang.Integer;
import java.util.Scanner;
class LinkedListNode<T>{
    T data;
    LinkedListNode<T> next;
    LinkedListNode(T data){
        this.data = data;
    }
}



public class EvenAfterOddLL{

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
        For a given singly linked list of integers, arrange the elements 
        such that all the even numbers are placed after the odd numbers. 
        The relative order of the odd and even terms should remain unchanged.
    #############################################################################*/
    public static LinkedListNode<Integer> evenAfterOdd(LinkedListNode<Integer> head) {
        
        if(head==null||head.next==null) return head;  // for [],[a]
        LinkedListNode<Integer> index=head, evenHead=null, evenLast=null, oddLast=null;
        boolean firstEven=true, firstOdd=true;
        int indexValue=0;
        while(index.next!=null){  // for 2 to length-1 element of linked list.
            indexValue = index.data.intValue();
            if(indexValue%2==1){
                // System.out.println("while");
                if(firstOdd) {
                    head = index;
                    firstOdd = false;
                }
                oddLast = index;
            }else{
                if(firstEven){
                    firstEven =false;
                    evenHead  = index;
                    evenLast = index;
                }else{
                    if(oddLast!=null) oddLast.next = index.next;
                    evenLast.next = index;
                    evenLast = index;
                }
            }
            index = index.next;
        }
        indexValue = index.data.intValue();
        if(indexValue%2==1){       // last element is odd   
            if(oddLast==null){     // [2,2,3] 
                oddLast = index;
                head = oddLast;
            }
            else oddLast = index;  // [2,3,4,4,5]
        }
        else {                      // last element is even
            if(evenLast==null){     // [3,5,3,2]
                evenLast = index;    
                evenHead = index;
            }else{                    // [3,2,3,43,4]
                evenLast.next = index;
                evenLast = index;

            }
        }
        if(oddLast!=null&&evenHead!=null){   //when odd cam in only at last
            oddLast.next = evenHead;
            evenLast.next = null;
        }
        return head;
    }

        public static void main(String[] args){
            int[] arr = {5,3,1};
            LinkedListNode<Integer> node = createLLFromArr(arr,arr.length);
            print(evenAfterOdd(node));
            // int b = 55;
            // String bb = "45";
     
            // // Construct two Integer objects
            // Integer x = Integer.valueOf(b);
            // Integer y = Integer.valueOf(bb);
            // System.out.println(x.intValue());
            // System.out.println(x+" "+y);
            // System.out.println(x+y);

        }
}