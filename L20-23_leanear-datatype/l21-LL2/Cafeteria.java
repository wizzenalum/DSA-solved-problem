import java.util.Scanner;
class LinkedListNode<T>{
    T data;
    LinkedListNode<T> next;
    LinkedListNode(T data){
        this.data = data;
    }
}


public class Cafeteria{

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
    public static void changeLL(LinkedListNode<Integer> head) {
        if(head==null||head.next==null) return;
        LinkedListNode<Integer> outerTemp = head;
        LinkedListNode<Integer> innerTemp = head;
        boolean check = true;
        int length=1, index, count, countOuter;
        // find max element.
        int max = head.data.intValue();
        int temp = head.data.intValue(),temp2;
        while(outerTemp.next!=null){
            temp = outerTemp.data.intValue();
            if(temp>max){
                max = temp;
            }
            outerTemp = outerTemp.next;
            length++;
        }
        System.out.println(length);
        //search and replace during increamet
        max++;
        while(check){
            check = false;
            index = length;
            outerTemp = head;
            countOuter = 0;
            while(outerTemp!=null){
                innerTemp = outerTemp.next;
                count = countOuter;
                while(innerTemp!=null){
                    count++;
                    temp = outerTemp.data.intValue();
                    temp2 = innerTemp.data.intValue();
                    if(temp==temp2){
                        check = true;
                        break;
                    }
                    innerTemp = innerTemp.next; 
                }
                countOuter++;
                if(index>count) index = count;
                outerTemp = outerTemp.next;

            }
            if(check){
                outerTemp = head;
                for(int i = 0; i<index;i++){
                    outerTemp = outerTemp.next;
                }
                outerTemp.data = max;
                max++;
            }
        }
    }

        public static void main(String[] args){
            int[] arr = {1,3,1,4,4,2,1};
            LinkedListNode<Integer> node = createLLFromArr(arr,arr.length);
            changeLL(node);
            print(node);

        }
}