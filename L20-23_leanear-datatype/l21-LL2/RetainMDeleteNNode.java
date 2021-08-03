import java.util.Scanner;
class LinkedListNode<T>{
    T data;
    LinkedListNode<T> next;
    LinkedListNode(T data){
        this.data = data;
    }
}


public class RetainMDeleteNNode{

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
         for given linked list and integer M,N. you need to delete N nodes after every M nodes.
    #############################################################################*/
    public static LinkedListNode<Integer> skipMdeleteN(LinkedListNode<Integer> head, int M, int N) {
        if(M==0) return null;
        if(head==null||N==0) return head;
        int mTemp = 1, nTemp = 1;
        boolean retain = true;
        LinkedListNode<Integer> index = head, tail=null, 
                                retainHead = head, deleteHead =null;
        while(index!=null){
            if(mTemp<M && retain){
                mTemp++;
            }else if(mTemp==M && retain){
                if(tail==null) tail = index;
                else {
                    tail.next = retainHead;
                    tail = index;
                }
                deleteHead = index.next;
                retain = false;
                mTemp=1;
            }else if(nTemp<N){
                nTemp++;
            }else if(nTemp==N){
                tail.next = index.next;
                retainHead = index.next;
                nTemp=1;
                retain = true;
            }
        // System.out.println(head+" "+head.next);
            index = index.next;
        }
        if(tail!=null){
            if(mTemp<=M&&retain){
                tail.next = retainHead;

            }else if(nTemp<=N) {
                tail.next =null;
            }

        }
        return head;
    }

        public static void main(String[] args){
            int[] arr = {10};
            LinkedListNode<Integer> node = createLLFromArr(arr,arr.length);
            LinkedListNode<Integer> head = (skipMdeleteN(node,3,1));
            print(head);

        }
}