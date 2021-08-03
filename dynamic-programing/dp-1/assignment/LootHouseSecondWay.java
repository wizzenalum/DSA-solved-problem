/*############################################################################
						    Loot Houses

	A thief wants to loot houses. He knows the amount of money in each house. 
	He cannot loot two consecutive houses. Find the maximum amount of money 
	he can loot.

	Sample Input 2 :
		6
		10 2 30 20 3 50

	Sample Output 2 :
		90

	Explanation of Sample Output 2 :
		Looting first, third, and the last houses([10 + 30 + 50]) will result 
		in the maximum loot, and all the other possible combinations would 
		result in less than 90.

this time i am not going to cheack every possible cases. 
 

				completed 1,2,3 
			
#############################################################################*/
import java.util.Scanner;
import java.util.Arrays;
public class LootHouseSecondWay{
// step 1  recursion
	public static int maxMoneyLooted(int[] houses, int index){
		int len = houses.length;
		if(index<0) return 0;
		if(index<1) return houses[0];
		if(index<2) return houses[0]>houses[1]?houses[0]:houses[1];
		int maxpre = maxMoneyLooted(houses, index-2);
		int maxprepre = maxMoneyLooted(houses,  index-3);
		if(maxpre+houses[index]>maxprepre+houses[index-1]) return maxpre+houses[index];
		return maxprepre+houses[index-1];
	}
// step 2 using memoization technique
	public static int maxMoneyLootedMemo(int[] houses, int[] storage, int index){
		int len = houses.length;
		if(index<0) return 0;
		if(index<1) return houses[0];
		if(index<2) return houses[0]>houses[1]?houses[0]:houses[1];
		if(storage[index] !=0) return storage[index];

		int maxpre = maxMoneyLootedMemo(houses,storage,index-2);
		int maxprepre = maxMoneyLootedMemo(houses,storage, index-3);
		if(maxpre+houses[index]>maxprepre+houses[index-1]) storage[index] = maxpre+houses[index];
		else storage[index] = maxprepre+houses[index-1];

		return storage[index];
	}
// step 3 iterative dp
	public static int maxMoneyLootedIterDP(int[] houses) {
		int len = houses.length;
		if(len<1) return 0;
		if(len==1) return houses[0];
		int maxpre = 0, i = 1, maxprepre = 0;
		int[] storage = new int[len];
		storage[0] = houses[0];

		while(i<len){
			if(maxpre+houses[i]>maxprepre+houses[i-1]) storage[i] = maxpre+houses[i];
			else storage[i] = maxprepre+houses[i-1];
			maxprepre = maxpre;
			maxpre = storage[i-1];
			i++;
		}
		System.out.println(Arrays.toString(storage));
		return storage[len-1];
	}

	public static void main(String[] args){
		int[] houses = {10, 2, 30, 20, 3, 50};
		// int[] houses = {5, 5, 10, 100, 10, 5};
		// int[] houses = {10, 2,4};
	// recursive approach
		System.out.println(maxMoneyLooted(houses, houses.length-1));
	// memoization approach.
		int[] storage = new int[houses.length];
		System.out.println(maxMoneyLootedMemo(houses,storage,houses.length-1));
	// // // // // iterative dp appraoch
		System.out.println(maxMoneyLootedIterDP(houses));
	
	}


}