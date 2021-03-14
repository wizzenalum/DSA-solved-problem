import java.util.Scanner;
class LinkedListNode<T>{
    T data;
    LinkedListNode<T> next;
    LinkedListNode(T data){
        this.data = data;
    }
}


public class BubbleSortLL{

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
        it will sort the link list itterativly.
    #############################################################################*/
    
   public static LinkedListNode<Integer> bubbleSort(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> newHead = null, index = head, 
                                min = head, previousMin = null,
                                previousIndex = null;
        while(index!=null){
            min = head;
            previousIndex = null;
            previousMin = null;
            while(index!=null){
                if(min.data.intValue()<index.data.intValue()){
                    // System.out.println("inBubbleSortLL");
                    previousMin = previousIndex;
                    min = index;
                    // System.out.println(previousMin.data+" "+min.data);
                }
                previousIndex = index;
                index = index.next;
            }
            if(previousMin==null) head=min.next;
            else previousMin.next = min.next;
            min.next = newHead;
            newHead = min;
            index = head;
            // System.out.println(newHead.data);
        }
        // System.out.println(newHead);
        return newHead;
    }

    public static void main(String[] args){
        int[] arr = {10,20,4};
        LinkedListNode<Integer> node = createLLFromArr(arr,arr.length);
        LinkedListNode<Integer> head = (bubbleSort(node));
        print(head);

    }
}