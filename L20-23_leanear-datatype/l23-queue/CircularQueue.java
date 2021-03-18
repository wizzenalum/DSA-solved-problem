class QueueIsEmptyException extends Exception {

}
// in normal queue we need to shift the elements as we reached the end of the array or need to increase the size.
// but here we can enqueue the element at the start as rear reach end so no need to shift elements but 
// we need to increse the size as the array get filled;

// here i will use size = (rear-front+capacity)%capacity + 1;
// i need to use size variable because there is problem with empty and full arr those showing same conditions.
class CircularQueue{
	private int[] arr;
	private int front;
	private int capacity;
	private int rear;
	private int size;

	CircularQueue(){
		this(2);
	}
	CircularQueue(int capacity){
		this.arr = new int[capacity];
		this.front = -1;
		this.rear = -1;
		this.size = 0;
		this.capacity = capacity;
	}
	void add(int a){
		// enqueue operation at the rear place with time O(1);
		ensureCapacity();
		// System.out.println(this.rear);
		this.arr[(++this.rear)%capacity] = a;
		this.size++;
		if(this.front == -1) this.front++;
	}
	int remove() throws QueueIsEmptyException{
		// dequeue the element from front place with time O(1);
		// System.out.println(size+" "+front);
		if(this.size==0) throw new QueueIsEmptyException();
		int value = this.arr[this.front];
		this.front = (this.front+1)%this.capacity;
		this.size--;
		return value;
	}
	int peek() throws QueueIsEmptyException{
		// time O(1)  return the front value;
		if(this.size==0) throw new QueueIsEmptyException();
		return arr[this.front];
	}
	boolean isEmpty(){
		// time O(1) return true or false as it is empty or not
		if(this.size==0) return true;
		return false;
	}
	int size(){
		// time O(1) return size of queue
		return this.size;
	}
	private void ensureCapacity(){
		// this fuction will return same arr by shifting element to start(0) if elements are less. and also create new if elements are more.
		// time O(n);
		if(this.size<this.capacity) return;
		int[] arr2 = new int[this.capacity*2]; 
		for(int i=0;i<size;i++){
			arr2[i] = this.arr[i];
		}
		this.arr = arr2;
		this.capacity = this.capacity*2;
	}
}