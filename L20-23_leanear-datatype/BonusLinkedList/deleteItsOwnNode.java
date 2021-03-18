import java.util.Scanner;
class LinkedListNode<T>{
    T data;
    LinkedListNode<T> next;
    LinkedListNode(T data){
        this.data = data;
    }
}


public class deleteItsOwnNode{

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
        You are given a pointer to a node and you have to delete that node 
        from the singly linked list using only the given pointer.
        Note: Head pointer is not given to you. And the node to be deleted 
        can never be the last node.

    #############################################################################*/
    public static void deleteNode(LinkedListNode<Integer> node) {
         node.data=node.next.data;
        node.next=node.next.next;
    }

    public static void main(String[] args){
        int[] arr = {10,20,4};
        LinkedListNode<Integer> node = createLLFromArr(arr,arr.length);
        deleteNode(node.next);
        print(node);

    }
}