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

 

				completed 1,2,3 false  4 false
			
#############################################################################*/
import java.util.Scanner;
public class LootHousesByThief{ 
// // step 1  recursion*********************************************

// way 1 recursion backword  can't solve this problem.
	public static int lootHouseRecBack(int[] houses, int index, boolean isTheftLastHouse) {
		// here i return the sum for all individual cases.
		// return value is the sum of all the forward(in arr) house theft. index shows current house in which we are.
		// isTheftLastHouse tells last house theft or not;

	// why dont it worked	
		// this  can't move backward because one fuction cant return two values, 
		// here branching is growing. 
		// once look at when isTheftLastHouse=false then try to study this code. will you able to solve it.
		if(houses.length<=index) return 0;
		int maxsum = lootHouseRecBack(houses,index+1,false), temp =0;
		if(!isTheftLastHouse){
			temp = lootHouseRecBack(houses,index+1,true);
			return (temp>maxsum?temp:maxsum)+houses[index];
		}
		return maxsum;
	}
// way 2 forward only recursion can't solve this problem
	public static void lootHouseRecFor(int[] houses,int sum, int index, boolean isTheftLastHouse) {
		//here i calculating sum by moving forward in indexes.
		// sum is the sum of all the previous house theft. index shows current house in which we are.
		// isTheftLastHouse tells last house theft or not;

	// why this solution not worked
		// this  solution took all the values to the very end.
		// but we dont have any method to retrive them from there.
		// even all end up in seprate branches so we can not compare them.
		if(houses.length<=index) return;
		lootHouseRecFor(houses,sum,index+1,false);
		if(!isTheftLastHouse){
			lootHouseRecFor(houses, sum+houses[index],index+1,true);
		}
	}

// way 3 recursion Backward and forward currect solution.
	public static int lootHouseRecForBack(int[] houses, int sum, int index, boolean isTheftLastHouse) {
		//here i pass sum by calculating.
		// sum is the sum of all the previous house theft for specific case. index shows current house in which we are.
		// isTheftLastHouse tells current house should be theft or not;
		// return values shows max possible for until that perticular index.

		// this problem cant solve array that has length more then approx 10,000 give stack overflow issue.  
		if(houses.length<=index) return sum;
		int maxsum = lootHouseRecForBack(houses,sum,index+1,false), temp =0;
		if(!isTheftLastHouse){
			temp = lootHouseRecForBack(houses,sum+houses[index],index+1,true);
			maxsum = temp>maxsum?temp:maxsum;
		}
		return maxsum;
	}

// // step 2 using memoization technique ****************************

	// way 1 can improve the second recursion by passing a address of maxposibleSum which share to all  the functions.
	// so use that to get the maxSum.

	public static void lootHouseRecForMemo(int[] houses,int sum, int[] maxSum, int index, boolean isTheftLastHouse) {
		// all the parameter are same as in step 1 way 1 but one new maxSum parameter will tell the current max. 
		// to retrive and compare the all possible sums.
		// System.out.println(sum+" "+index+" "+isTheftLastHouse);

		// this problem cant solve array that has length more then approx 10,000 give stack overflow issue.  
		if(houses.length<=index){
			if(sum>maxSum[0]) maxSum[0] = sum;
			return;
		} 
		lootHouseRecForMemo(houses,sum, maxSum,index+1,false);
		if(!isTheftLastHouse){
			lootHouseRecForMemo(houses,sum+houses[index],maxSum,index+1,true);
		}
	}

	// way 2 using dp with memoization means removing repeatin calls.
	 // i can use step1.2 or step1.3 but i am choosing step1.3 because number of parameter will be reduced littel;

	public static int lootHouseMemoDp(int[] houses, int[][] storage, int sum, int index, boolean isTheftLastHouse) {
		System.out.println(index+" "+isTheftLastHouse);
		//every thing same as step1.3 but storage is new where is will store all possible unique calls.
		// as i know fuction calls are distict due to index  and isTheftLastHouse parameters.
		// so i will use n*2 matrix where first colomn store for true and second of false. 

		// i was wrong this piece of code not call repeted calls so cant be sue dp.	
			int maxsum = 0, temp = 0; 
		// using storage
		if(index>0){
			if(isTheftLastHouse && storage[index-1][0]!=-1){
				System.out.print("used from storage");
				return storage[index-1][0];	
			} 
			if(!isTheftLastHouse && storage[index-1][1]!=-1 && storage[index-1][0]!=-1){
				return storage[index-1][1];	
			}}// not present in storage then calculating
		if(houses.length<=index){
		} return sum;
		maxsum = lootHouseMemoDp(houses, storage, sum,index+1,false);
		if(!isTheftLastHouse){
			temp = lootHouseMemoDp(houses, storage, sum+houses[index],index+1,true);
			maxsum = temp>maxsum?temp:maxsum;
			storage[index][0] = maxsum;
			return maxsum;
		}
		storage[index][1] = maxsum; 
		return maxsum;
	}
// solution to this problem by any method
	// i think convert the step1.3 into iterative function.
	public static int lootHouseRecForBack(int[] houses) {
		//every similar to step1.3.
		int sum=0, index=0, returnSum=0; 
		boolean isTheftLastHouse;
		// this problem cant solve array that has length more then approx 10,000 give stack overflow issue.  
		if(houses.length<=index) return sum;
		int maxsum = lootHouseRecForBack(houses,sum,index+1,false), temp =0;
		if(!isTheftLastHouse){
			temp = lootHouseRecForBack(houses,sum+houses[index],index+1,true);
			maxsum = temp>maxsum?temp:maxsum;
		}
		return maxsum;
	}
// // step 3 iterative dp
// 	public static int lootHouseIterDP(int n){
// 	}

	public static void main(String[] args){
		// int[] houses = {10, 2, 30, 20, 3, 50};
		int[] houses = {10, 2,4};
		// int[] houses = new int[20]; // check stack overflow limit.
// step 1 recursion
	// 1 recursive backword wrong
		// System.out.println(lootHouseRecBack(houses, 0,false));
	// 2 recursive forward wrong
		// lootHouseRecFor(houses,0, 0,false);
// 	// 3 recursive backword and forward.
		// System.out.println(lootHouseRecForBack(houses, 0,0,false));
// // step 2 memoization
// 	// way 1 imporove step1.2;
		int[] arr = new int[1];
		// lootHouseRecForMemo(houses,0,arr,0,false);
		// System.out.println(arr[0]);
	// way 1 imporove step1.2;
		int[][] storage = new int[houses.length+1][2];
		for(int i = 0; i<storage.length;i++){
			storage[i][0] = -1;
			storage[i][1] = -1;
		}
		System.out.println(lootHouseMemoDp(houses, storage, 0,0,false));
	// 	System.out.println(lootHouseMemo(n,arr));
	// // // // iterative dp appraoch
	// 	System.out.println(lootHouseIterDP(n));
	
	}


}