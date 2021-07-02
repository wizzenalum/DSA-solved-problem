package group3;
/*  War on NinjaLand
Send Feedback
Pandora has declared war against NinjaLand. The brave soldiers of NinjaLand have been defending their country against attacks for a long time. There is a shortage of food amongst the citizens. The governor of NinjaLand has ordered the army to drop food crates via helicopters.
Each helipad in NinjaLand is located at the nodes of a Generic Tree. Due to constant attacks from Pandora, the dispatched helicopter cannot stay over civilian sky for long or it will be shot down by the enemy. The pilot has decided to cover the entire Helipad Tree with the least number of landings. Each Helipad node can cover the node connected to it by one edge.
If the number of landings exceed a certain number, the helicopter will be shot down by Pandora.
Since it is a high pressure situation, you have to help the pilot figure out the minimum number of times he needs to land his helicopter in order to cover the entire Helipad Tree without being shot and complete its mission (if possible).
Input Format:

We need to input two things- Tree nodes and maximum allowed landings.
The first line of input contains data of the nodes of the tree in level order form. The order is: data for root node, number of children to root node, data of each of child nodes and so on and so forth for each node. The data of the nodes of the tree is separated by space.  
Since data of each node is irrelevant, it will be taken as 1, representing that the node exists.
Second line of each test case will contain an integer K representing the maximum allowed landings.

Constraints:

Time Limit: 1 sec

Output Format:

All you have to do is find the minimum number of landings required, and return it. The printAns function has already been written for you. It's logi is as follows:
If it is possible to complete the mission with <= K landings, print the minimum number of landings required to completely cover the Helipad Tree and the phrase “Mission Successful” , otherwise print the minimum number of landings required to completely cover the Helipad Tree and the phrase “Mission Unsuccessful”.

Sample Input 1:

1 3 1 1 1 2 1 1 0 0 0 0
3

Sample Output 1:

2 Mission Successful

Explanation:

For the given input the tree formed is given below, which can be covered with minimum 2 landings, which is less than the maximum allowed landings.

Alt Text
Sample Input 2:

1 3 1 1 1 2 1 1 1 1 3 1 1 1 0 0 2 1 1 0 0 0 0 0
2

Sample Output 2:

3 Mission Unsuccessful

Explanation:

For the given input the tree formed is given below, which can be covered with minimum 3 landings, which is more than the maximum allowed landings.

 */
public class WarOnNIijaLand {
    
}
public class Solution
{

    static int minLandingCover(TreeNode<Integer> root) {
        //Write your code here
    }

    static void printAns(int allowed, int ans)
    {
        if (ans <= allowed)
        {
            System.out.println(ans + " Mission Successful");
        }
        else{
            System.out.println(ans + " Mission Unsuccessful");
        }
    }

}


import java.util.ArrayList;
import java.util.Scanner;

 class QueueEmptyException extends Exception {
}

 class QueueUsingLL<T> {

	class Node<T> {
		T data;
		Node<T> next;
		Node(T data){
			this.data = data;
		}
	}

	private Node<T> head;
	private Node<T> tail;
	private int size = 0;

	public int size(){
		return size;
	}

	public boolean isEmpty(){
		if(size == 0){
			return true;
		}
		return false;
	}

	public T front() throws QueueEmptyException{
		if(size == 0){
			QueueEmptyException e = new QueueEmptyException();
			throw e;
		}

		return head.data;
	}


	public void enqueue(T element){
		Node<T> newNode = new Node<T>(element);

		if(head == null){
			head = newNode;
			tail = newNode;
		}
		else{
			tail.next = newNode;
			tail = newNode;
		}

		size++;
	}

	public T dequeue() throws QueueEmptyException{
		if(head == null){
			QueueEmptyException e = new QueueEmptyException();
			throw e;
		}
		if(head == tail){
			tail = null;
		}
		T temp = head.data;
		head = head.next;
		size--;
		return temp;
	}
}

   class TreeNode<T> {
		T data;
		ArrayList<TreeNode<T>> children;

		TreeNode(T data){
			this.data = data;
			children = new ArrayList<TreeNode<T>>();
		}
	}

public class Runner {



	static Scanner s = new Scanner(System.in);

	public static TreeNode<Integer> takeInputLevelWise(){
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<TreeNode<Integer>>();  // Queue of nodes that are entered themselves but their children aren't added yet
		int rootData = s.nextInt();
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);
		while(!pendingNodes.isEmpty()){
			TreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
				int numChild = s.nextInt();
				for(int i = 0 ; i < numChild; i++){
					int currentChild = s.nextInt();
					TreeNode<Integer> childNode = new TreeNode<Integer>(currentChild);
					pendingNodes.enqueue(childNode);
					currentNode.children.add(childNode);
				}
			} catch (QueueEmptyException e) {
			}
		}
		return root;
	}


	public static void main(String[] args) {

        TreeNode<Integer> root =  takeInputLevelWise();
        int allowed;
        allowed = s.nextInt();
        int final_ans = Solution.minLandingCover(root);
		Solution.printAns(allowed, final_ans);

	}

}