/*############################################################################
						Print subset of an array
	Given an integer array (of length n), find and print all the subsets of 
	input array.
	Subsets are of length varying from 0 to n, that contain elements of the array. 
	But the order of elements should remain same as in the input array.
	Note : The order of subsets are not important.
			array 
				15 20 12

			Sample Output:
				12 
				20 
				20 12 
				15 
				15 12 
				15 20 
				15 20 12 
				completed true
#############################################################################*/
import java.util.ArrayList;
public class PrintSubsetOfArray{
	public static void printSubsetsHelp(int input[],int index, ArrayList<Integer> outputSoFar) {
		if(input.length<=index){
			for(int i=0;i<outputSoFar.size();i++) System.out.print(outputSoFar.get(i)+" ");
			System.out.println();
			return;
		}
		ArrayList<Integer> outputWithoutElement, outputWithElement;
		outputWithoutElement = (ArrayList<Integer>)outputSoFar.clone();
		printSubsetsHelp(input,index+1, outputWithoutElement);
		outputWithElement = (ArrayList<Integer>)outputSoFar.clone();
		outputWithElement.add(input[index]);
		printSubsetsHelp(input,index+1,outputWithElement);		
	}

	public static void printSubsets(int input[]) {
		printSubsetsHelp(input,0,new ArrayList<Integer>());

	}
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		printSubsets(arr);
	}
}