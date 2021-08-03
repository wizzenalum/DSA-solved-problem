/*############################################################################
						  Buy the ticket

	You want to buy a ticket for a well-known concert which is happening in 
	your city. But the number of tickets available is limited. Hence the 
	sponsors of the concert decided to sell tickets to customers based on 
	some priority.
	
	A queue is maintained for buying the tickets and every person is attached 
	with a priority (an integer, 1 being the lowest priority).
	
	The tickets are sold in the following manner -
		1. The first person (pi) in the queue requests for the ticket.
		2. If there is another person present in the queue who has higher 
			priority than pi, then ask pi to move at end of the queue without 
			giving him the ticket.
		3. Otherwise, give him the ticket (and don't make him stand in queue again).

	Giving a ticket to a person takes exactly 1 minute and it takes no time 
	for removing and adding a person to the queue. And you can assume that 
	no new person joins the queue.
	Given a list of priorities of N persons standing in the queue and the index 
	of your priority (indexing starts from 0). Find and return the time it will 
	take until you get the ticket.

				completed -- true
#############################################################################*/	
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
public class BuyTheTicket{


	// public static int buyTicket(int input[], int k) {
	// method is correct but giving time limit exced error.
	// 	PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
	// 	    @Override
	// 	    public int compare(Integer a, Integer b) {
	// 	        return b - a; 
	// 	    }
	// 	});

	// 	// creating the max heap so i can know the max value
	// 	for(int i =0; i<input.length;i++){
	// 		maxHeap.add(input[i]);
	// 	}

	// 	// lets find the time taken by the ticket collector
	// 	int time=0, start = 0;
	// 	while(true){
	// 		System.out.println("loop  ");
	// 		if(maxHeap.size()==0){
	// 			System.out.println("something wrong with you implementation");
	// 			return -1;
	// 		}
	// 		if(input[start]<maxHeap.peek()){
	// 			start = (start+1)%input.length;
	// 		}
	// 		else if(input[start]==maxHeap.peek()){
	// 			if(start == k) return time+1;
	// 			maxHeap.poll();
	// 			start = (start+1)%input.length;
	// 			time++;
	// 		}
	// 	}
	// }

// i will use a queue as discussed in the video
	public static int buyTicket1(int input[], int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
		    @Override
		    public int compare(Integer a, Integer b) {
		        return b - a; 
		    }
		});

		Queue<Integer> indexQueue = new LinkedList<Integer>();
		// creating the max heap so i can know the max value;
		// and index Queue to know the index;
		for(int i =0; i<input.length;i++){
			maxHeap.add(input[i]);
			indexQueue.add(i);
		}
		// lets find the time taken by the ticket collector
		int time=0, temp = 0;
		while(true){
			// System.out.println("loop  ");
			if(maxHeap.size()==0){
				System.out.println("something wrong with you implementation");
				return -1;
			}
			if(input[indexQueue.peek()]<maxHeap.peek()){
				indexQueue.add(indexQueue.poll());
			}
			else if(input[indexQueue.peek()]==maxHeap.peek()){
				if(indexQueue.peek() == k) return time+1;
				maxHeap.poll();
				indexQueue.poll();
				time++;
			}
		}
	} 
// now i will use hash map to jump to next person without itterating over whole array. it will save more time then given solution.
	public static int buyTicket2(int input[], int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
		    @Override
		    public int compare(Integer a, Integer b) {
		        return b - a; 
		    }
		});

		// creating the max heap so i can know the max value
		for(int i =0; i<input.length;i++){
			maxHeap.add(input[i]);
		}
		HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();// maping priority to index
		for(int i =0;i<input.length;i++){
			if(!map.containsKey(input[i])){
				map.put(input[i], new ArrayList<Integer>());
			}
			map.get(input[i]).add(i);
		}
		// System.out.println(map.entrySet());
		// lets find the time taken by the ticket collector
		int time=0, start = -1, startPrev = -1;
		while(true){
			// System.out.print("loop  ");
			if(maxHeap.size()==0){
				System.out.println("something wrong with you implementation");
				return -1;
			}
			ArrayList<Integer> listIndex = map.get(maxHeap.peek());

			// System.out.print(listIndex+" ");
			int index = 0;
			for(; index<listIndex.size();index++){
				if(startPrev<listIndex.get(index)){
					start = listIndex.get(index);
					break;
				}
			}
			if(start == startPrev){
				index = 0;
				start = listIndex.get(index);
			}
			// System.out.print(start+" "+ index+" ");
			for(int i = 0;i<listIndex.size();i++){
				if(start == k) return time+1;
				time++;
				maxHeap.poll();
				startPrev = start;
				index = (index+1)%listIndex.size();
				start = listIndex.get(index);
			}
			// System.out.println();
		}
	}

	public static void main(String[] args) {
		// int[] arr = {2,453,4,43,423,32,32,4676,76,8,67,6,5,243,23,5,1,78};
		// int[] arr = {5,4,3,8,7,6,2,1};
		int[] arr = {2,3,2,2,4};  // k = 3,  ans = 4;
		
		// System.out.println(buyTicket2(arr,3));		
		System.out.println(buyTicket1(arr,3));		
	}
}