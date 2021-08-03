import java.util.Scanner;
class LinkedListNode<T>{
    T data;
    LinkedListNode<T> next;
    LinkedListNode(T data){
        this.data = data;
    }
}


public class SumOfTwoNumbers{

    public static LinkedListNode<Integer> createLL(int[] arr, int index){
        if(index == arr.length) return null;
        LinkedListNode<Integer> node = createLL(arr,index+1);
        LinkedListNode<Integer> head = new LinkedListNode<>(arr[index]);
        head.next = node;
        return head;
    }


    public static void print(LinkedListNode<Integer> head){
        //print the all elements of the ll
        while(head!=null){
            System.out.print(head.data+" ");
            head = head.next;
        }
    }
    /*############################################################################
        You are given two numbers represented by two different linked list. 
        You have to write a function to return the sum of both the numbers in a linked list.
        Note: You are not allowed to use extra space. You don't have to modify the given linked lists.
    #############################################################################*/
    public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head){
        if(head==null||head.next == null) return head;
        LinkedListNode<Integer> newHead = reverse(head.next);
        head.next.next = head;
        head.next= null;
        return newHead;

    }
    public static LinkedListNode<Integer> addNumbers(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {  
    // this will return sum linked list by making change in the given liked list
        // bruitforce solution if i go to end and add last bit and then again go to last bit and do it again. i am not implemeting that.
    // ********  reverse the arrays and then add them sequancially ***************
        if(head1==null) return head2;
        if(head2==null) return head1;
        head1 = reverse(head1);
        head2 = reverse(head2);//we get reversed linked lists
        // variable that will we use in this program
        LinkedListNode<Integer> newHead  = head1,previous = null;
        int remainder = 0;
        int bitWiseSum = 0;

        while(head1!=null && head2!=null){ // add places untill one list will become empty.
            bitWiseSum =head1.data.intValue()+head2.data.intValue()+remainder ;
            if(bitWiseSum>9){
                // System.out.println("in");
                remainder = 1;
                head1.data = bitWiseSum%10;
                // print(newHead);
            }else {
                head1.data = bitWiseSum;
                remainder = 0;
            }
            previous = head1;
            head1 = head1.next;
            head2 = head2.next;
        }

        // now adding one remaining list to make sum.
        if(head2!=null){
            previous.next = head2;
            head1 = head2;
        }
        while (head1!=null){
            bitWiseSum = remainder+head1.data.intValue();
            if(bitWiseSum>9){
                remainder = 1;
                head1.data = 0;
            }else {
                head1.data = bitWiseSum;
            // System.out.println("in");
            // print(newHead);
                break;
            }
            previous = head1;
            head1 = head1.next;
        }

        if(head1==null&&remainder==1){
            LinkedListNode<Integer> node = new LinkedListNode<Integer>(1);
            previous.next = node;
        }return reverse(newHead);
    }

// *********** let's fullfill the exact requirement **************

    public static LinkedListNode<Integer> ADD(LinkedListNode<Integer> longList, LinkedListNode<Integer> shortList, int differece){
        if(longList==null && shortList==null) return null;
        int placeSum = 0;
        LinkedListNode<Integer> sum=null;
        if(differece>0){
            sum = ADD(longList.next,shortList,differece-1);
            placeSum = longList.data.intValue(); 
            
        }
        if(differece==0){
            sum = ADD(longList.next,shortList.next,differece);
            placeSum = longList.data.intValue()+shortList.data.intValue();
            
        }
        if(sum!=null && sum.data.intValue()>9){
            sum.data = sum.data.intValue()%10;
            placeSum++;
        }
        LinkedListNode<Integer> node = new LinkedListNode<>(placeSum);
        node.next = sum;
        return node;
}
    public static LinkedListNode<Integer> addNumbers1(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {  
        // add using recursion.
        if(head1==null) return head2;
        if(head2==null) return head1;
        int len1 = 0, len2 = 0;
        LinkedListNode<Integer> temp=head1;
        while(temp!=null){
            len1++;
            temp = temp.next;
        }
        temp = head2;
        while(temp!=null){
            len2++;
            temp = temp.next;
        }
        // it will make long list head1 and short head2;
        temp = len1>=len2?ADD(head1,head2,len1-len2):ADD(head2,head1,len2-len1);
        if(temp.data.intValue()>9){
            LinkedListNode<Integer> node = new LinkedListNode<>(1);
            node.next = temp;
            return node;
        }return temp;
    }


    public static void main(String[] args){
        int[] arr = {5};
        int[] arr2 = {1,2};
        LinkedListNode<Integer> head1 = createLL(arr,0);
        LinkedListNode<Integer> head2 = createLL(arr2,0);
        // print(reverse(head1));
        // print(head2);
        // print(addNumbers(head1,head2));

        print(addNumbers1(head1,head2));
        // print(ADD(head1,head2));

    }
}