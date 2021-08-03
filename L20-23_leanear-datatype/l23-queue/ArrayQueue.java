class QueueIsEmptyException extends Exception {

}

class ArrayQueue{
	private int[] arr;
	private int front;
	private int capacity;
	private int rear;

	ArrayQueue(){
		this(1);
	}
	ArrayQueue(int capacity){
		this.arr = new int[capacity];
		this.front = -1;
		this.rear = -1;
		this.capacity = capacity;
	}
	void add(int a){
		// enqueue operation at the rear place with time O(1);
		ensureCapacity();
		// System.out.println(this.rear);
		this.arr[this.rear+1] = a;
		this.rear++;
		if(this.front==-1) this.front++;
	}
	int remove() throws QueueIsEmptyException{
		// dequeue the element from front place with time O(1);

		if(this.front==-1|| this.front>this.rear) throw new QueueIsEmptyException();
		int value = this.arr[this.front];
		if(this.front==this.capacity-1){
			this.front = -1;
			this.rear = -1;
		}else this.front++;
		return value;
	}
	int peek() throws QueueIsEmptyException{
		// time O(1)  return the front value;
		if(this.front==-1|| this.front>this.rear) throw new QueueIsEmptyException();
		return arr[this.front];
	}
	boolean isEmpty(){
		// time O(1) return true or false as it is empty or not
		if(this.front==-1|| this.front>this.rear) return true;
		return false;
	}
	int size(){
		// time O(1) return size of queue
		if(this.front==-1|| this.front>this.rear) return 0;
		return this.rear-this.front+1;
	}
	private void ensureCapacity(){
		// this fuction will return same arr by shifting element to start(0) if elements are less. and also create new if elements are more.
		// time O(n);
		if(this.front==-1) return;
		int size= (this.rear - this.front+1);
		int[] arr2;
		// System.out.println("ensure "+this.capacity);
		if(this.capacity>size*2){// this part shift the element if the capacity>2*size so capcity esure work less time.
			for(int i=0;i<size;i++){
				this.arr[i] = this.arr[i+this.front];
			}
		}
		else{
			arr2 = new int[this.capacity*2];  // 
			for(int i=0;i<size;i++){
				arr2[i] = this.arr[i+this.front];
			}
			this.arr = arr2;
			this.capacity = this.capacity*2;
			// System.out.println("ensure "+ capacity+" "+arr2.length);
		}
		this.front = 0;
		this.rear = size-1;
	}
}