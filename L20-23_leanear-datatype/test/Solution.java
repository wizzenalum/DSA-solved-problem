// public class Solution {
// 	public static LinkedListNode<Integer> nextLarge(LinkedListNode<Integer> head){
//       if(head==null) return head;
//         int currentdata = head.data.intValue();
//         if(head.next ==null){
//             head.data = currentdata+1;
//             return head;
//         }
//         LinkedListNode<Integer> node = nextLarge(head.next);
//         int number = node.data.intValue();
//         if(number>9){
//             node.data = number%10;
//             head.data = currentdata+1;
//         }return head;  
//     }

// 	public static LinkedListNode<Integer> nextLargeNumber(LinkedListNode<Integer> head) {
//         if(head==null) return head;
//         head = nextLarge(head);
//         LinkedListNode<Integer> node = LinkedListNode<>(1);
//         int number = head.data.intValue();
//         if(number>9){
//             head.data = number%10;
//             node.next = head;
//             head = node;
//         }      
//         return head;
// 	}


// }
public class Solution {

    public static void changeLL(LinkedListNode<Integer> head) {
        if(head==null||head.next==null) return;
        LinkedListNode<Integer> outerTemp = head;
        LinkedListNode<Integer> innerTemp = head;
        boolean check = true;
        int length=0, index, count, outercount;
        // find max element.
        int max = head.data.intValue();
        int temp = head.data.intValue(),temp2;
        while(outerTemp.next!=null){
            temp = outerTemp.data.intValue();
            if(temp>max){
                max = temp;
            }
            outerTemp = outerTemp.next;
        }
        //search and replace during increamet
        max++;
        outerTemp = head;
        while(outerTemp!=null){
            innerTemp = outerTemp.next;
            while(innerTemp!=null){
                temp = outerTemp.data.intValue();
                temp2 = innerTemp.data.intValue();
                if(temp==temp2){
                    innerTemp.data = max;
                    max++;
                }
                innerTemp = innerTemp.next; 
            }outerTemp = outerTemp.next;

        }


    }
}