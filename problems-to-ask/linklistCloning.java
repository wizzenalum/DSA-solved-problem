// what is the difference in following two ways of cloning the link lists.
// look into L20-23_lenear-datastructure>BonusLinkedList>cloneLL.java>clone2 method.
// solution
	// i was using intValue() method that is creating problem
// public static Node<Integer> clone(Node<Integer> head){
// 		if(head==null) return head;
// 		Node<Integer> index = head, cloneIndex =null;
// // way 1 to create the new link list.
// 		Node<Integer> newHead = new Node<>(head.data.intValue()),
// 								cloneTemp = newHead, temp = head.next;
// 		cloneIndex = newHead;
// 		while(temp!=null){
// 			cloneTemp.next = new Node<Integer>(temp.data);
// 			temp = temp.next;
// 			cloneTemp = cloneTemp.next;
// 		}
// // way 2 to create the new link list.
// 		Node<Integer> temp = head, cloneTemp=null, newHead=null;
// 		while(temp!=null){
// 			if(temp == head){
// 				cloneTemp = new Node<>(temp.data);
// 				newHead = cloneTemp;	
// 			}else{
// 				cloneTemp.next = new Node<>(temp.data);
// 				cloneTemp = cloneTemp.next;
// 			}
// 			temp = temp.next;
// 		}
// 		return newHead;
// }
import java.util.Integer;
class linklistCloning{
	public static void main(String[] args) {
		Integer a = new Integer("1234323434");
		int b = a;
		System.out.println(a+" "+b);
	}
	// i don't know what is the issue but thier is something
}