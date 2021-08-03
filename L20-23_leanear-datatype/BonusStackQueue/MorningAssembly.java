/*############################################################################
		In a local school, N students have assembled for the morning assembly. 
		All the students are standing in a straight line. Due to some technical 
		issues, the mike is not working. The technician is trying to solve the 
		issue. Students have to stand in the line, all this while. After a while, 
		students start looking at each other. But, since they are not standing in 
		any particular order of heights, not one cannot see everyone else.

		Two students X and Y can see each other if they are standing next to each 
		other or if no student standing between them has height greater than height 
		of either X or Y.
		You will be given height of students standing in the assembly line. You have 
		to print the number of pairs of students that can see each other.

		Input format:
			The first line of input contains an integer N (1 <= N <= 500000), 
			that denotes the number of students standing in the line.
			Each of following N line contains an integer, that denote height of a 
			particular person. The heights provided cannot be greater than 1000000000. 
			The heights are provided in nanometers. 

		Constraints

			Time Limit: 1 second

		Output format:

			Print the number of pairs of students that can see each other.

		Sample Input 1:

			7
			2
			4
			1
			2
			2
			5
			1

		Sample Output 1:

			10

			completed false;
#############################################################################*/

import java.util.Scanner;
import java.util.Stack;
public class MorningAssembly{

// method 1 but crash due stack overflow.
	public static int countpair(int[] arr, int index){
		// i think working fine.
		if(arr.length-index<2) return 0;
		if(arr.length-index==2) return 1;

		int count =0, mid = index+1;
		for(int i = index+1;i<arr.length;i++){
			if(arr[mid]<=arr[i]){
				count++;
			}
			if(arr[i]>arr[index]) break;
			if(arr[mid]<arr[i]) mid=i;
		}
		return count + countpair(arr,index+1);
	}

// method 1 now time limit is excidingg that means time complexity is high.
	public static int countpairforindex(int[] arr, int index){
	
		if(arr.length-index<2) return 0;
		if(arr.length-index==2) return 1;

		int count =0, mid = index+1;
		for(int i = index+1;i<arr.length;i++){
			if(arr[mid]<=arr[i]){
				count++;
			}
			if(arr[i]>arr[index]) break;
			if(arr[mid]<arr[i]) mid=i;
		}
		return count;
	}

	public static int countpair1(int[] arr){
		int pairCount = 0;
		for(int i=0; i<arr.length;i++){
			pairCount+=countpairforindex(arr,i);
		}				
		return pairCount;
	}
// method 1 just compact and less code imporoves 5% on time.
	public static int countpair2(int[] arr){
		int pairCount = 0, mid=0;
		int size= arr.length;
		for(int index=0; index<size;index++){
			mid = index+1;
			for(int i = index+1;i<size;i++){
				if(arr[mid]<=arr[i]){
					pairCount++;
					mid=i;
				}
				if(arr[i]>arr[index]) break;
			}
		}				
		return pairCount;
	}
// method 2 using stacks  
	static class Pair{
		int value;
		int freq;
		Pair(int v, int f){
			value = v;
			freq = f;
		}
	}
	public static int countpair3(int[] arr){
		// false in many conditions 
		// int[] arr = {2,1,2,2};  false at this

		int index = 0, count = 0, freq =0;
		Stack<Pair> st = new Stack<>();
		for(index = 0; index<arr.length; index++){
			// System.out.println("in"+index);
			// if(!st.isEmpty()) System.out.println(st.peek());
			freq = 1;
			while(index+1<arr.length&&arr[index]==arr[index+1]) {
					index++;
					freq++;
			}
			// System.out.println(index+" "+freq);
			count+= (freq*(freq-1))/2;

			if(!st.isEmpty()&&arr[index]<st.peek().value){
				count+=freq;
				// System.out.print("   lesser "+ count);
			}
			while(!st.isEmpty()&&arr[index]>=st.peek().value){
				count+=st.pop().freq;
				// System.out.print("   greater "+ count);
				if(!st.isEmpty()&&arr[index]<st.peek().value) {
					count+=freq;
					// System.out.print("   greater lesser "+ count);
				}
			}
			// System.out.println("     add  "+arr[index]+" "+freq);
			st.add(new Pair(arr[index],freq));
		}
		return count;
	}
	public static int countpair4(int[] arr){
		int index = 0, count = 0, freq =0;
		Stack<Pair> st = new Stack<>();
		for(index = 0; index<arr.length; index++){
			Pair p1 = new Pair(arr[index],1);

			while(!st.isEmpty()&&arr[index]>=st.peek().value){
				count+=st.peek().freq;
				// System.out.print("   greater "+ count);
				if(arr[index]==st.peek().value) {
					p1.freq+=st.peek().freq;
					// System.out.print("   greater lesser "+ count);
				}
				st.pop();
			}
			// System.out.println("     add  "+arr[index]+" "+freq);
			if(!st.isEmpty()){
				count++;
				// System.out.print("   lesser "+ count);
			}
			st.push(p1);
		}
		return count;
	}


	

	public static void main(String[] args) {
		// Scanner scan = new Scanner(System.in);
		// int n = scan.nextInt();
		// int[] arr = new int[n];
		// // creting arr from heights of the users.
		// for(int i=0;i<n;i++) arr[i] = scan.nextInt();
		// int[] arr = {1,2,3,4}; //incrising order
		// int[] arr = {4,3,2,1}; // decreasing order

		// int[] arr = {2,4,1,2,5,1};
		// int[] arr = {2,4,1,2,2,5,1};
		// int[] arr = {2,2,4,4,1,1,2,2,2,5,1};
		int[] arr = {2,1,2,2};
		// int[] arr = {4,3,2,1,2};
		System.out.println(countpair(arr,0));
		System.out.println(countpair1(arr));
		System.out.println(countpair2(arr));
		System.out.println(countpair3(arr));
		System.out.println(countpair4(arr));
	}
}


// ⢀⣠⠤⡶⣲⢺⣴⣶⢭⣉⢲⣀⠀⠀⠀⠀⠀⠀⠀⠀
// ⠀⠀⢀⡾⢵⣶⣿⣿⣿⣾⣷⣳⣿⣷⣵⣈⠷⢤⡀⠀⠀⠀⠀⠀
// ⠀⠀⠘⢾⣿⡿⠿⠿⠿⠿⠿⠿⢿⡿⣿⣿⣿⣾⣾⣦⠀⠀⠀⠀
// ⠀⠀⣠⡋⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠻⢿⢿⣧⠀⠀⠀

// ⠀⣰⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣳⢮⣧⠀⠀

// ⢠⣧⠇⡠⠄⣤⣤⣄⡀⠀⠀⣀⣤⣄⣤⣀⠀⠀⣿⣿⣿⣯⣇⠀

// ⠈⣿⠀⢀⣶⣾⣿⣿⠁⠀⢸⣿⣿⣿⣧⣌⣥⠀⠘⣿⣿⣿⣿⠀

// ⢀⣿⠀⠈⠁⠀⠀⠁⠀⠀⠀⠉⠉⠭⠽⠿⠻⠁⠀⣿⣿⣿⡏⠀

// ⡏⠆⠀⠀⠀⠀⠀⠀⡀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠸⠟⢋⣿⣆

// ⡎⠀⠀⢀⡴⠂⠈⠉⠻⠿⠿⠛⣀⢲⣤⣄⣀⠀⠀⠈⠘⣏⢹⡿

// ⠱⡄⠘⢻⣳⣤⡶⠖⠒⠶⠶⢶⣿⣷⣿⣿⣿⣟⠀⠀⠄⠠⣰⠃

// ⠀⢹⠀⠀⠀⠈⠓⠒⠒⠒⠒⠒⠛⠁⢨⣼⣿⣿⡀⣼⠖⠛⠁⠀

// ⠀⠘⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣿⣿⣿⣿⢁⠀⠀⠀⠀⠀

// ⠀⠀⢸⠀⠀⠀⢀⣀⣀⣀⣠⣤⣶⣿⣿⣿⡿⣁⡎⢸⠀⠀⠀⠀

// ⠀⠀⢸⠀⠀⠀⠘⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠁⠸⠀⠀⠀⠀

// ⠀⠀⢸⠀⠀⠀⠀⠀⢿⣿⣿⣿⣿ ⣿⡄⠀⡇⠀⠀⠀

// ⠀⢀⣼⠀⠀⠀⠀⠀⠈⢹⣿⣿⣿⡟⣿⣿⣿⣟⡁⠀⢿⣷⡄⠀

// ⠀⣸⣿⠀⠀⠀⠀⠀⠀⠸⣿⣿⣿⣿⣝⣿⣿⡍⠁⠀⢸⣿⣷⠀

// ⠀⣿⣿⡀⠀⠀⠀⠀⠀⢐⣿⣿⣿⣿⣿⣿⣯⠁⠀⠀⢸⣿⣿⠀

// ⠀⢿⢿⣿⣄⠀⠀⠀⠀⢼⣿⣿⣿⣿⣿⣿⡯⠀⢠⢒⣿⣿⡏