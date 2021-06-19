import java.util.HashMap;
class ListNode<T>{
    T data;
    ListNode<T> next;
    ListNode(T data){
        this.data = data;
        this.next = null;
    }
    
} 
public class NthNodeOfLoopedLL { 
     
    public static ListNode<Integer> LL(int[] arr) {
        if(arr.length == 0) return null;
        ListNode<Integer> head = new ListNode<Integer>(arr[0]), temp = head;
        for (int i = 1; i < arr.length; i++) {
            // System.out.println(temp.data);
            temp.next = new ListNode<Integer>(arr[i]);
            temp = temp.next; 
        }
        // adding last node to some arbitery node
        temp.next = head.next.next.next;// remember arr should long enough
        return head;

    }

    // method 1 by using the hashmap for question 1.
    public static ListNode<Integer> FindNode(ListNode<Integer> head, int N) {
        HashMap<ListNode<Integer>,ListNode<Integer>> map = new HashMap<>();//map current node to previos.
      ListNode<Integer> pre = null, current = head;
      while(true){
          map.put(current,pre);
          if(map.containsKey(current.next)) break;
          pre = current;
          current = current.next;
      }
      current = current.next;
      for(int i = 1;i<=N;i++){
          if(current==null) return null;
          current = map.get(current);
      }
      return current;
    } 
    // method 2 using two pointers
    public static ListNode<Integer> FindNode1(ListNode<Integer> head, int N) {
        ListNode<Integer> p1 = head, p2 = head;
        // getting inside the loop if it is there
        while(p1!=null&&p2!=null){
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1==p2) break;
        }
        if(p1==null || p2== null) return null; // terminating function if loop not present

        int nodesInLoop = 0, nodeBeforeNode = 0, i= 0;
        // counting nodes in side the loop 
        while(true){
            p1 = p1.next;
            nodesInLoop++;
            if(p1==p2) break;
        }

        p1 = head;
        p2 = head;
        //forwarding the p2 to nodesInloop steps
        for (int j = 0; j < nodesInLoop; j++) {
            p2 = p2.next;
        }
        // finding point where loop starts
        while(p1!=p2){
            p1 = p1.next;
            p2 = p2.next;
        }

        // counnting nodes before the loop
        p1 = head;
        while(p1!=p2){
            nodeBeforeNode++;
            p1 = p1.next;
        }

        // finallllllly
        if(nodeBeforeNode-N<0) return null;
        p1=head;
        for (int j = 0; j < nodeBeforeNode-N; j++) {
            p1 = p1.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5,6,7,8};
        ListNode<Integer> head = LL(arr);
        // for (int i = 0; i < arr.length+3; i++) {
        //     System.out.println(ll.data);
        //     ll = ll.next;
        // }
        System.out.println(FindNode(head, 2).data);
        System.out.println(FindNode1(head, 2).data);
    }  
}
