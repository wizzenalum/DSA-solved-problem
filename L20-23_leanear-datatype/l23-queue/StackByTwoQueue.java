import java.util.Queue;
import java.util.LinkedList;

class Stack{
	private Queue<Integer> firstQueue;
	private Queue<Integer> secondQueue;
	// this is constroctor
	Stack(){
		this.firstQueue = new LinkedList<>();
		this.secondQueue  = new LinkedList<>();
	}


    /*----------------- Public Functions of Stack -----------------*/


    public int getSize() { 
        //Implement the getSize() function
        return this.firstQueue.size();
    }

    public boolean isEmpty() {
        //Implement the isEmpty() function
        return this.firstQueue.isEmpty();
    }

    public void push(int element) {
        //Implement the push(element) function
        this.firstQueue.add(element);
    }

    public int pop() {
        //Implement the pop() function
        if(this.firstQueue.size()==0) return -1;
        while(!(this.firstQueue.size()==1)){
        	this.secondQueue.add(this.firstQueue.remove());
        }
        int value = this.firstQueue.remove().intValue();

        while(!this.secondQueue.isEmpty()){
        	this.firstQueue.add(this.secondQueue.remove());
        }
        return value;
    }

    public int top() {
        //Implement the top() function
        if(this.firstQueue.size()==0) return -1;
        while(!(this.firstQueue.size()==1)){
        	this.secondQueue.add(this.firstQueue.remove());
        }
        int value = this.secondQueue.peek().intValue();
    	this.secondQueue.add(this.firstQueue.remove());

        while(!this.secondQueue.isEmpty()){
        	this.firstQueue.add(this.secondQueue.remove());
        }
        return value;
    }

}
public class StackByTwoQueue{
	public static void main(String[] args) {
		Stack s = new Stack();
		System.out.println(s.isEmpty());
		s.push(10);
		s.push(12);
		System.out.println(s.getSize());
		System.out.println(s.top()+" "+s.pop());
		System.out.println(s.getSize()+" "+s.pop());
		System.out.println(s.pop());
	}
}