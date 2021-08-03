import java.util.ArrayList;
import java.util.HashMap;
import java.lang.NullPointerException;

// generic class for which i thought
// class PriorityQueueMin<P,V>{  // here P for priority and V for related value to this.
// 	private ArrayList<P> heap;  // this array will store the heap for priority queue.
// 	private int capacity;
// 	private HashMap<P,V> map;

// 	PriorityQueueMin(){
// 		this(16); // default capacity assumed to be 16;
// 	}

// 	PriorityQueueMin(int capacity){
// 		this.heap = new ArrayList<>(capacity);
// 		this.capacity = capacity;
// 		this.map = new HashMap<>();
// 	}

// 	void insert(P priority, V value){
// 		this.heap.add(priority);
// 		this.map.put(priority,value);
// 		if(this.heap.size()==1) return;
// 		int index = this.heap.size()-1, parentIndex = 0;
// 		while(index>=0){
// 			parentIndex = (index-1)/2;  // leftnode = 2p+1  and rightnode = 2p+2;
// 			int child = this.heap.get(index), parent = this.heap.get(parentIndex);
// 			if(child<parent){
// 				int swap = this.heap.get(parentIndex);
// 				this.heap.set(parentIndex,this.heap.get(index));
// 				this.heap.set(index,swap);
// 			}
// 		}	
// 	}

	// // getting values from Priority queue;
	// String getMin(){
	// 	return this.min.value;
	// }
	// String getMax(){
	// 	return this.max.value;
	// }
	// // remove elements from the queue;

	// boolean removeMax(){
	// 	if(this.max==null) return false;
	// 	if(this.max == this.min){
	// 		this.max =  null;
	// 		this.min = null;
	// 	}
	// 	else{
	// 		this.max = this.max.prev;
	// 		this.max.next = null;
	// 	}
	// 	size--;
	// 	return true;
	// }
	// boolean removeMin(){
	// 	if(this.min==null) return false;
	// 	if(this.min == this.max){
	// 		this.min =  null;
	// 		this.max = null;
	// 	}
	// 	else{
	// 		this.min = this.min.next;
	// 		this.min.prev = null;
	// 	}
	// 	size--;
	// 	return true;
	// }

// 	int size(){
// 		return heap.size();
// 	}
// 	void print(){
// 		for(int i = 0; i<heap.size();i++){
// 			System.out.print("["+heap.get(i)+" -> "+map.get(heap.get(i))+"]");
// 		}
// 	}
// }


// class PriorityQueueMin<V>{  // here P for priority and V for related value to this.
// 	private ArrayList<Integer> heap;  // this array will store the heap for priority queue.
// 	private int capacity;
// 	private HashMap<Integer,V> map;

// 	PriorityQueueMin(){
// 		this(16); // default capacity assumed to be 16;
// 	}

// 	PriorityQueueMin(int capacity){
// 		this.heap = new ArrayList<>(capacity);
// 		this.capacity = capacity;
// 		this.map = new HashMap<>();
// 	}

// 	void insert(int priority, V value){
// 		this.heap.add(priority);
// 		this.map.put(priority,value);
// 		if(this.heap.size()==1) return;
// 		int index = this.heap.size()-1, parentIndex = 0;
// 		while(index>0){
// 			parentIndex = (index-1)/2;  // leftnode = 2p+1  and rightnode = 2p+2;
// 			int child = this.heap.get(index);
// 			int parent = this.heap.get(parentIndex);
// 			if(child<parent){
// 				int swap = this.heap.get(parentIndex);
// 				this.heap.set(parentIndex,this.heap.get(index));
// 				this.heap.set(index,swap);
// 			}
// 			index = parentIndex;
// 		}	
// 	}

// 	// getting values from Priority queue;
// 	V getMin(){return this.map.get(this.heap.get(0));}
	

// 	// remove elements from the priority queue;

// 	boolean removeMin(){
// 		if(this.heap.size()==0) return false;
// 		map.remove(this.heap.get(0)); // rmeoving item from map.
// 		 // replacing first item to last item in the heap and removing last
// 		int last = this.heap.remove(this.heap.size()-1);
// 		if(this.heap.size()==0) return true;

// 		this.heap.set(0,last);
// 		// fixing the heap order property.
// 		int index = 0, leftChild = 0, rightChild = 0;
// 		while(index<this.heap.size()){
// 			leftChild = index*2+1;  // leftnode = 2p+1  and rightnode = 2p+2;
// 			rightChild = index*2+2;
// 			if(	leftChild>=this.heap.size() || 
// 				(rightChild>=this.heap.size() &&  this.heap.get(index)<this.heap.get(leftChild)) ||
// 				(this.heap.get(index)<this.heap.get(leftChild) && this.heap.get(index)<this.heap.get(rightChild))) return true;

// 				int swap = 0;
// 			if(rightChild>=this.heap.size()){
// 				swap = this.heap.get(leftChild);
// 				this.heap.set(leftChild,this.heap.get(index));
// 				this.heap.set(index,swap);
// 				return true;
// 			}
// 			leftChild = this.heap.get(leftChild)>this.heap.get(rightChild)?rightChild:leftChild;
// 			swap = this.heap.get(leftChild);
// 			this.heap.set(leftChild,this.heap.get(index));
// 			this.heap.set(index,swap);
// 			index = leftChild;
// 		}
// 		return true;
// 	}

// 	int size(){
// 		return heap.size();
// 	}
// 	void print(){
// 		for(int i = 0; i<heap.size();i++){
// 			System.out.print("["+heap.get(i));
// 			// System.out.print(" -> "+map.get(heap.get(i))+"]");
// 		}
// 	}
// }

// class PriorityQueueMax<V>{  // integer type is priority and V for related value type to this.
// 	private ArrayList<Integer> heap;  // this array will store the heap for priority queue.
// 	private int capacity;
// 	private HashMap<Integer,V> map;

// 	PriorityQueueMax(){
// 		this(16); // default capacity assumed to be 16;
// 	}

// 	PriorityQueueMax(int capacity){
// 		this.heap = new ArrayList<>(capacity);
// 		this.capacity = capacity;
// 		this.map = new HashMap<>();
// 	}

// 	void insert(int priority, V value){
// 		this.heap.add(priority);
// 		this.map.put(priority,value);
// 		if(this.heap.size()==1) return;
// 		int index = this.heap.size()-1, parentIndex = 0;
// 		while(index>0){
// 			parentIndex = (index-1)/2;  // leftnode = 2p+1  and rightnode = 2p+2;
// 			int child = this.heap.get(index);
// 			int parent = this.heap.get(parentIndex);
// 			if(child>parent){
// 				int swap = this.heap.get(parentIndex);
// 				this.heap.set(parentIndex,this.heap.get(index));
// 				this.heap.set(index,swap);
// 			}
// 			index = parentIndex;
// 		}	
// 	}

// 	// getting values from Priority queue;
// 	V getMax(){
// 		return this.map.get(this.heap.get(0));
// 	}


// 	// // remove elements from the priority queue;

// 	boolean removeMax(){
// 		if(this.heap.size()==0) return false;
// 		map.remove(this.heap.get(0)); // rmeoving item from map.
// 		 // replacing first item to last item in the heap and removing last
// 		int last = this.heap.remove(this.heap.size()-1);
// 		if(this.heap.size()==0) return true;

// 		this.heap.set(0,last);
// 		// fixing the heap order property.
// 		int index = 0, leftChild = 0, rightChild = 0;
// 		while(index<this.heap.size()){
// 			leftChild = index*2+1;  // leftnode = 2p+1  and rightnode = 2p+2;
// 			rightChild = index*2+2;
// 			if(	leftChild>=this.heap.size() || 
// 				(rightChild>=this.heap.size() &&  this.heap.get(index)>this.heap.get(leftChild)) ||
// 				(this.heap.get(index)>this.heap.get(leftChild) && this.heap.get(index)>this.heap.get(rightChild))){
// 					return true;
// 			}

// 				int swap = 0;
// 			if(rightChild>=this.heap.size()){
// 				swap = this.heap.get(leftChild);
// 				this.heap.set(leftChild,this.heap.get(index));
// 				this.heap.set(index,swap);
// 				return true;
// 			}
// 			leftChild = this.heap.get(leftChild)<this.heap.get(rightChild)?rightChild:leftChild;
// 			swap = this.heap.get(leftChild);
// 			this.heap.set(leftChild,this.heap.get(index));
// 			this.heap.set(index,swap);
// 			index = leftChild;
// 		}
// 		return true;
// 	}

// 	int size(){
// 		return heap.size();
// 	}
// 	void print(){
// 		for(int i = 0; i<heap.size();i++){
// 			System.out.print("["+heap.get(i));
// 			// System.out.print(" -> "+map.get(heap.get(i))+"]");
// 		}
// 	}
// }
// using an element class to store the priority and value in arraylist which work as heap.
class Element<V>{
	V value;
	int priority;

	Element(int priority, V value){
		this.priority = priority;
		this.value = value;
	}
}
// class NoElementPresent extends Exception{
// 	int serialVersionUID = 1;
// }
class PriorityQueueMin<V> {  // here P for priority and V for related value to this.
	private ArrayList<Element<V>> heap;  // this array will store the heap for priority queue.
	private int capacity;

	PriorityQueueMin(){
		this(16); // default capacity assumed to be 16;
	}

	PriorityQueueMin(int capacity){
		this.heap = new ArrayList<>(capacity);
		this.capacity = capacity;
	}

	void insert(int priority, V value){
		Element<V> ele = new Element<>(priority, value);

		this.heap.add(ele);
		if(this.heap.size()==1) return;
		// now we will do up hipfy process.
		int index = this.heap.size()-1, parentIndex = 0;
		while(index>0){
			parentIndex = (index-1)/2;  // leftnode = 2p+1  and rightnode = 2p+2;
			int child = this.heap.get(index).priority;
			int parent = this.heap.get(parentIndex).priority;
			if(child<parent){
				Element<V> swap = this.heap.get(parentIndex);
				this.heap.set(parentIndex,this.heap.get(index));
				this.heap.set(index,swap);
			}
			index = parentIndex;
		}	
	}

	// getting values from Priority queue;
	V getMin() throws NullPointerException{
		if(this.isEmpty()) throw new NullPointerException();
		return this.heap.get(0).value;
	}
	boolean isEmpty(){
		return this.heap.isEmpty();
	}

	// remove elements from the priority queue;

	boolean removeMin() throws NullPointerException{
		if(this.heap.size()==0) throw new NullPointerException("Priority Queue has no item");
		 // replacing first item to last item in the heap and removing last
		Element<V> last = this.heap.remove(this.heap.size()-1);
		if(this.heap.size()==0) return true;

		this.heap.set(0,last);
		// fixing the heap order property. by forward hipify.
		int index = 0, leftChild = 0, rightChild = 0;
		while(index<this.heap.size()){
			leftChild = index*2+1;  // leftnode = 2p+1  and rightnode = 2p+2;
			rightChild = index*2+2;
			if(	leftChild>=this.heap.size() || 
				(rightChild>=this.heap.size() &&  this.heap.get(index).priority<this.heap.get(leftChild).priority) ||
				(this.heap.get(index).priority<this.heap.get(leftChild).priority && this.heap.get(index).priority<this.heap.get(rightChild).priority)){
				return true;
			}

				Element<V> swap = null;
			if(rightChild>=this.heap.size()){
				swap = this.heap.get(leftChild);
				this.heap.set(leftChild,this.heap.get(index));
				this.heap.set(index,swap);
				return true;
			}
			leftChild = this.heap.get(leftChild).priority>this.heap.get(rightChild).priority?rightChild:leftChild;
			swap = this.heap.get(leftChild);
			this.heap.set(leftChild,this.heap.get(index));
			this.heap.set(index,swap);
			index = leftChild;
		}
		return true;
	}

	int size(){
		return heap.size();
	}
	void print(){
		for(int i = 0; i<this.size();i++){
			System.out.print("["+this.heap.get(i).priority);
			System.out.print(" -> "+this.heap.get(i).value+"]");
		}
	}
}

class PriorityQueueMax<V>{  // here P for priority and V for related value to this.
	private ArrayList<Element<V>> heap;  // this array will store the heap for priority queue.
	private int capacity;

	PriorityQueueMax(){
		this(16); // default capacity assumed to be 16;
	}

	PriorityQueueMax(int capacity){
		this.heap = new ArrayList<>(capacity);
		this.capacity = capacity;
	}

	void insert(int priority, V value){
		Element<V> ele = new Element<>(priority, value);

		this.heap.add(ele);
		if(this.heap.size()==1) return;
		// now we will do up hipfy process.
		int index = this.heap.size()-1, parentIndex = 0;
		while(index>0){
			parentIndex = (index-1)/2;  // leftnode = 2p+1  and rightnode = 2p+2;
			int child = this.heap.get(index).priority;
			int parent = this.heap.get(parentIndex).priority;
			if(child>parent){
				Element<V> swap = this.heap.get(parentIndex);
				this.heap.set(parentIndex,this.heap.get(index));
				this.heap.set(index,swap);
			}
			index = parentIndex;
		}	
	}

	// getting values from Priority queue;
	V getMax() throws NullPointerException{
		if(this.isEmpty()) throw new NullPointerException();
		return this.heap.get(0).value;
	}
	boolean isEmpty(){
		return this.heap.isEmpty();
	}

	// remove elements from the priority queue;

	boolean removeMax(){
		if(this.heap.size()==0) throw new NullPointerException();
		 // replacing first item to last item in the heap and removing last
		Element<V> last = this.heap.remove(this.heap.size()-1);
		if(this.heap.size()==0) return true;

		this.heap.set(0,last);
		// fixing the heap order property. by forward hipify.
		int index = 0, leftChild = 0, rightChild = 0;
		while(index<this.heap.size()){
			leftChild = index*2+1;  // leftnode = 2p+1  and rightnode = 2p+2;
			rightChild = index*2+2;
			if(	leftChild>=this.heap.size() || 
				(rightChild>=this.heap.size() &&  this.heap.get(index).priority>this.heap.get(leftChild).priority) ||
				(this.heap.get(index).priority>=this.heap.get(leftChild).priority && this.heap.get(index).priority>=this.heap.get(rightChild).priority)) {
				return true;
			}

				Element<V> swap = null;
			if(rightChild>=this.heap.size()){
				swap = this.heap.get(leftChild);
				this.heap.set(leftChild,this.heap.get(index));
				this.heap.set(index,swap);
				return true;
			}
			leftChild = this.heap.get(leftChild).priority>this.heap.get(rightChild).priority?rightChild:leftChild;
			swap = this.heap.get(leftChild);
			this.heap.set(leftChild,this.heap.get(index));
			this.heap.set(index,swap);
			index = leftChild;
		}
		return true;
	}

	int size(){
		return heap.size();
	}
	void print(){
		for(int i = 0; i<this.size();i++){
			System.out.print("["+this.heap.get(i).priority);
			System.out.print(" -> "+this.heap.get(i).value+"]");
		}
	}  
}
public class PriorityQueueWithHeap{
	public static void main(String[] args) {
		// test min priority queue;
		PriorityQueueMin<String> pq = new PriorityQueueMin<>();
		pq.insert(20,"run");
		System.out.println(pq.getMin());
		pq.insert(1,"on");
		pq.insert(15,"both");
		System.out.println(pq.removeMin());
		pq.insert(15,"bo");
		pq.insert(254,"rt");
		pq.insert(453,"ongf");
		pq.print();
		System.out.println(pq.size());
		pq.insert(13,"bothg");
		pq.insert(4,"bogaf");
		System.out.println(pq.getMin());

		// testing max priority queue;
		PriorityQueueMax<String> pqMax = new PriorityQueueMax<>();
		pqMax.insert(20,"run");
		pqMax.insert(1,"on");
		pqMax.insert(15,"both");
		pqMax.insert(15,"bo");
		pqMax.insert(254,"rt");
		pqMax.insert(453,"ongf");
		System.out.println(pqMax.removeMax());
		pqMax.print();
		System.out.println(pqMax.getMax());
		System.out.println(pqMax.size());
		pqMax.insert(13,"bothg");
		pqMax.insert(4,"bogaf");
		System.out.println(pqMax.getMax());




	}
}