class StackEmptyException extends Exception{
	public static long serialVersionUID = 0L;
		StackEmptyException(){
			serialVersionUID++;
	}
}
class Node<T>{
	T data;
	Node previous;
	Node(T data){
		this.data = data;
	}

} 
class StackLL<T>{
	private Node<T> top;
	private int size;

	StackLL(){
		this.top = null;
		this.size = 0;
	}

	void push(T data) {
		Node<T> node = new Node<>(data);
		node.previous = this.top;
		this.top = node;
		this.size++;
	}
	void pop()throws StackEmptyException{
		raise();
		Node<T> node = this.top;
		this.top.previous = null;
		this.top = node;
		this.size--;
	}
	T top() throws StackEmptyException{
		raise();
		return this.top.data;
	}
	boolean isEmpty(){
		if(this.top==null) return true;
		return false;
	}
	int size()throws StackEmptyException{
		raise();
		return size;
	}

	void raise() throws StackEmptyException{
		if(this.top==null) throw new StackEmptyException();
	}
}