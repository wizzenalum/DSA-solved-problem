import java.util.Scanner;
class LinkedListNode<T>{
    T data;
    LinkedListNode<T> next;
    LinkedListNode(T data){
        this.data = data;
    }
}

public class FindNodeRecursively{

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
    search the node in the linked list by given data n and head and return the index or -1
#############################################################################*/

    public static int findNode(LinkedListNode<Integer> head, int n) {
// *********time O(n)  space O(1)*********
        int index = 0;
        while(head!=null){
            if(head.data==n) return index;
            index++;
            head = head.next;
        }return -1;
    }
    public static int findNodeRec(LinkedListNode<Integer> head, int n) {
// *********time O(n)  space O(1)*********
        if(head==null) return -1;
        if(head.data.equals(n)) return 0;
        int index  = findNodeRec(head.next,n);
        if(index==-1) return -1;
        return index+1;
    }
    public static void main(String[] args){
        int[] arr = {10,20,30,40};
        LinkedListNode<Integer> node = createLLFromArr(arr,arr.length);
        System.out.print(findNodeRec(node,6789));
        // print(node);

    }
}