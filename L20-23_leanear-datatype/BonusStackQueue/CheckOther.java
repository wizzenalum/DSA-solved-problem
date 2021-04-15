class Node {
            int data;
            Node next;
            Node prev;
            Node(int data) {
                this.data = data;
                this.next = null;
                this.prev = null;
            }
        }
class Stack {

    Node front;
    Node middle;
    int count;
    
	Stack() {
		// front=new Node(-1);
  //       middle=new Node(-1);
        count=0;
    }

	public void push(int element) {
	Node newNode=new Node(element);
        if(front==null){
            System.out.println("in");
    		front=newNode;
            middle=newNode;
            count++;
        }
        else{
            front.prev=newNode;
            newNode.next=front;
            front=front.prev;
            count++;
            if(count%2!=0){
                middle = middle.prev;
            }
        }
	}

	public int pop() {
        int a=0;
		if(front==null){
		return 0;       }
       
        else if(front.next==null){
            a=front.data;
            front = null;
            middle = null;
            count--;
        }
        
        else{
            a=front.data;
            front=front.next;
            front.prev=null;
            count--;
            if(count%2==0){
                middle=middle.next;
            }
        }
		return a;
    }
	
	public int getmiddle() {
		if(front==null){
            return 0;
        }
        return middle.data;
	}
		
	public int removeMiddle() {
         int a=0;
		if(front==null){
		return 0;    }
       
        else{
            if(middle.next==null){
                a=middle.data;
                middle=middle.prev;
                middle.next=null;
                count--;
            }

            else{
                a=middle.data;
                middle.prev.next=middle.next;
                middle.next.prev=middle.prev;
                count--;
            }}

            if(count%2==0){
                middle=middle.next;
            }
            else{
                middle=middle.prev;
            }
        
        return a;
	}
	
	public void print() {
			Node temp=front;
        while(temp!=null){
        System.out.print(temp.data+" ");
        temp=temp.next;
        }
	} 
}
public class CheckOther{
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(30);
        System.out.println(s.removeMiddle());
        // s.push(20);
        // s.push(10);
        // s.push(1);
        s.print();
        // System.out.println();
        // System.out.println(s.getmiddle());

        // s.push(0);
        // s.removeMiddle();
        // s.removeMiddle();
        // s.removeMiddle();
        // s.push(30);
        // s.push(20);
        // s.push(10);
        // s.push(30);
        // s.push(20);
        // s.push(10);
        // s.print();
        // System.out.println(s.getmiddle());
    }
}