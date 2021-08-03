import java.util.ArrayList;

// node class
class Node<T>{
	T data;
	Node<T> reference;
	Node(T ele){
		this.data = ele;
		this.reference = null;
	}
}
class LinkedList<T>{
	Node<T> head;
	Node<T> previous;
	Node<T> current;
	LinkedList(T data){
		this.head = new Node<T>(data);
		this.current = this.head;
	}
	void add(T data){
		this.previous = this.current;
		this.current = new Node<T>(data);
		// this.previous.reference(null);
		this.previous.reference = this.current;
	}
	

	void print(){
		Node<T> var = this.head;
		while(true){
			System.out.println(var.data);
			if(var.reference==null) break;
			var = var.reference;
		}
	}
}
public class TutorialProblems{
	// remove cosucativly occured integer from linkedarray.
	public static void removeConsicutiveOccurance(ArrayList<Integer> al){
		// for(int i =1;i<al.size();i++){
		// 	if(al.get(i)==al.get(i-1)) al.remove(i);
		// }
		System.out.print(al.subList(0,al.size()));
	}

	public static void main(String[] args) {
		ArrayList<Integer> arrList = new ArrayList<>(15);
		for(int i = 0;i<15;i++) arrList.add(i);
		arrList.add(1,1);
		System.out.print(arrList.subList(0,arrList.size()));
		removeConsicutiveOccurance(arrList);


		Node<String> a = new Node<>("hey");
		LinkedList<String> ll = new LinkedList<>("hey");
		ll.add("their");
		ll.add("their");
		ll.print();

	


	}
}