import java.util.Scanner;
class LinkedListNode<T>{
    T data;
    LinkedListNode<T> next;
    LinkedListNode(T data){
        this.data = data;
    }
}


public class SwapNodesLL{

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
    You have been given a singly linked list of integers along with two integers, 
    'i,' and 'j.' Swap the nodes that are present at the 'i-th' and 'j-th' positions.
    #############################################################################*/
    public static LinkedListNode<Integer> swapNodes(LinkedListNode<Integer> head, int i, int j) {
        if(head==null||head.next==null||i==j) return head;
        // here i am making i smaller than j for all cases.
        int count= i<j?i:j;
        j = j>i?j:i;
        i = count;
        count = 0;
        LinkedListNode<Integer> index =head, nodeBeforeI=null,nodeI=null,
                                nodeBeforeJ = null, nodeJ = null;
        while(index!=null){
            if(count<=i){
                nodeBeforeI = nodeI;
                nodeI = index;
            }if(count<=j){
                nodeBeforeJ = nodeJ;
                nodeJ = index;
            }
            index = index.next;
            count++;
        }
        if(j>=count) return head;
        System.out.println( nodeI.data+" "+nodeBeforeJ.data+" "+nodeJ.data);
        if(nodeBeforeI!=null){
            nodeBeforeI.next = nodeJ;
        }
        LinkedListNode<Integer> swap;
        nodeBeforeJ.next = nodeI;
        swap = nodeJ.next;
        nodeJ.next = nodeI.next;
        nodeI.next = swap;
        if(nodeBeforeI==null) head = nodeJ;
        return head;
    }

        public static void main(String[] args){
            int[] arr = {10,12,13};
            LinkedListNode<Integer> node = createLLFromArr(arr,arr.length);
            LinkedListNode<Integer> head = (swapNodes(node,1,0));
            print(head);

        }
}