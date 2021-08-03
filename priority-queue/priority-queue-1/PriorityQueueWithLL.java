class PriorityNode{
	int priority;
	String value;
	PriorityNode next;
	PriorityNode prev;

	PriorityNode(int priority, String value){
		this.priority = priority;
		this.value = value;
		this.next = null;
		this.prev = null;
	}
}

class PriorityQueue{
	private PriorityNode max;
	private PriorityNode min;
	private int size;

	PriorityQueue(){
		this.min=null;
		this.max = null;
		this.size = 0;
	}

	void insert(int priority, String value){
		PriorityNode node = new PriorityNode(priority,value);
		if(min==null){
			min = node;
			max = node;
		}
		else{
			if(min.priority>=priority){
				node.next = min;
				min.prev = node;
				min = node;
			} else if(priority>=max.priority){
				max.next = node;
				node.prev = max;
				max = node;
			}else{
				PriorityNode temp = this.min;
				while(temp.priority<priority) temp = temp.next;
				node.next = temp;
				node.prev = temp.prev;
				temp.prev.next = node;
				temp.prev = node;

			}
		}
		size++;
	}

	// getting values from Priority queue;
	String getMin(){
		return this.min.value;
	}
	String getMax(){
		return this.max.value;
	}
	// remove elements from the queue;

	boolean removeMax(){
		if(this.max==null) return false;
		if(this.max == this.min){
			this.max =  null;
			this.min = null;
		}
		else{
			this.max = this.max.prev;
			this.max.next = null;
		}
		size--;
		return true;
	}
	boolean removeMin(){
		if(this.min==null) return false;
		if(this.min == this.max){
			this.min =  null;
			this.max = null;
		}
		else{
			this.min = this.min.next;
			this.min.prev = null;
		}
		size--;
		return true;
	}

	int size(){
		return size;
	}
	void print(){
		PriorityNode temp = this.min;
		while(temp!=null){
			System.out.print("["+temp.priority+" -> "+temp.value+"]");
			if(temp.next!=null) System.out.print(" -->> ");
			temp = temp.next;
		}
	}
}
public class PriorityQueueWithLL{
	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue();
		pq.insert(20,"rt");
		pq.insert(1,"on");
		System.out.println(pq.removeMin());
		System.out.println(pq.removeMax());
		pq.insert(15,"both");
		pq.insert(15,"bo");
		pq.insert(254,"rt");
		pq.insert(453,"ongf");
		pq.insert(13,"bothg");
		pq.insert(4,"bogaf");
		System.out.println(pq.getMin());
		System.out.println(pq.getMax());
		pq.print();
	}
}