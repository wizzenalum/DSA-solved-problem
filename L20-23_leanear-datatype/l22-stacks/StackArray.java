class StackEmptyException extends Exception{
	private static final long serialVersionUID= 1L;
}
class StackArray{

	private int[] dataStack;
	private int size;
	private int capacity;


	StackArray(){
		dataStack = new int[2];
		this.size = 0;
		this.capacity = 2;
	}

	void pop() throws StackEmptyException{
		if(this.size<=0){
			throw new StackEmptyException();
		}
		this.size--;
	}
	void push(int data){
		ensuresize(this.size);
		this.dataStack[this.size] = data;
		this.size++;
	}
	int top() throws StackEmptyException{
		if(size<=0) throw new StackEmptyException();
		return this.dataStack[this.size-1];
	}
	boolean isEmpty(){
		if(this.size==0) return true;
		return false;
	}
	int size(){
		return this.size;
	}
	void ensuresize(int n){
		if(this.capacity<=n){
			int[] arr = new int[this.capacity*2];
			for(int i = 0; i<this.size;i++){
				arr[i] = this.dataStack[i];
			}
			this.dataStack=arr;
			this.capacity = this.capacity*2;
			System.out.println("capasity   "+ this.capacity);
		}
	}
}