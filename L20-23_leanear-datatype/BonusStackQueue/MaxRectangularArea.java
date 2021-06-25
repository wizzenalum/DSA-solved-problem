/*############################################################################
	You are given a binary matrix. You have to print the maximum area 
	possible for a sub-matrix with all 1's.

	Input Format:
		The first line of input contains two integers N (number of rows) and M 
		(number of columns) of the binary matrix.
		The second line of input contains N*M space-separated elements of the 
		binary matrix.

	Output Format:
		The only output line contains a single integer which will be the maximum 
		area possible of sub-matrix of all 1's.

	Explanation:
		The matrix for the above Sample Input is:
		0 1 0 0 0
		1 1 1 1 1
		1 1 1 1 1
		1 0 0 0 0
		The maximum size rectangle in this binary matrix is:
		1 1 1 1 1
		1 1 1 1 1
		So, the area of the rectangle is=5*2=10
		
	Sample Input:
		4 5
		0 1 0 0 0 1 1 1 1 1 1 1 1 1 1 1 0 0 0 0

	Sample Output:
		10
#############################################################################*/
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
public class MaxRectangularArea {

//**** method1 don't know the complexity. my method *********************************************************************

	public static int MaxAreaForwardHelper(int[][] mat, int row, int column, int currentColumn){
	// return max possible area for an array where i can move forward and below in matrix.
		if(mat.length<1) return 0;
		int prevColumn =currentColumn, max = currentColumn, tempMax = 0;
		for(int i = row+1;i<mat.length;i++){
			currentColumn = 0;
			for(int j = column;column==0?j<prevColumn:j<=prevColumn;j++){
				if(mat[i][j] ==0) break;
				currentColumn++;
			}
			tempMax = currentColumn*(i-row+1);
			prevColumn = currentColumn;
			if(max<tempMax) max = tempMax;
			if(currentColumn==0) break;
		} return max;
	}
	public static void maxArea(int[][] mat){
		// return the max posible area for the problem
		int max =0, tempMax = 0;
		for(int i =0; i<mat.length;i++){
			for(int j =0; j<mat[i].length;j++){
				int currentColumn = 0;
				for(int k=j; k<mat[i].length;k++){
					if(mat[i][k]==0) break;
					currentColumn++;
				}
				tempMax = MaxAreaForwardHelper(mat,i,j,currentColumn);
				if(tempMax>max) max = tempMax;

			}
		}
		System.out.println(max);
	}

// ***********   method 2 using histogram maximum area ***************************************
// step 1 create histogram for each row of the matirx.
	// step 2 now find the max area for that histogram.
	public static int histogramArea(int[] arr,int size) {
		Stack<Integer> st = new Stack<>();
		int index = 0, max_area=0,area=0;
		while(index<size){
			if(st.isEmpty()||arr[st.peek()]<=arr[index]){
				st.push(index);
				index++;
			}else{
				int tp = st.pop();
			if(st.isEmpty()) area = arr[tp]*(st.isEmpty()?index:(index-st.peek()-1));
			}if(area>max_area) max_area = area;
		}
		if(arr[st.peek()]>max_area) max_area = arr[st.peek()];
		while(!st.isEmpty()){
			int tp = st.pop();
			if(st.isEmpty()) area = arr[tp]*(st.isEmpty()?index:(index-st.peek()-1));
			if(area>max_area) max_area = area;
		}return max_area;
	}

	public static int histogramArea(int[] arr) {
		Stack<Integer> st = new Stack<>();
		int max_area = 0, top = 0,area = 0;
		for (int i = 0; i < arr.length; i++) {
			while(!st.isEmpty() && arr[st.peek()]>arr[i]){
				top = st.pop();
				area = arr[top]* (st.isEmpty()?i:(i-1-st.peek()));
				if(area>max_area) max_area = area;
			}
			st.push(i);
		}
		if(!st.isEmpty()){
			top = st.pop();
			area = top* (st.isEmpty()?top:(top-1-st.peek()));
			if(area>max_area) max_area = area;
		}

		return max_area;
	}
	
	public static void histogramMaxArea(int[][] mat){
		// step 1
		int[][] histogram = new int[mat.length][mat[0].length];
		for (int i = 0; i < histogram.length; i++) {
			for (int j = 0; j < histogram[0].length; j++) {
				if(mat[i][j] == 0) continue;
				if(i!=0) histogram[i][j]+=histogram[i-1][j]+1;
				else if(mat[i][j]==1) histogram[i][j] = 1;
			}
		}
		for (int i = 0; i < histogram.length; i++) {
			System.out.println(Arrays.toString(histogram[i]));
		}

		// step 2
		int matArea = 0, size = histogram[0].length;
		int[] arr = new int[size];

		for (int i = 0; i < histogram.length; i++) {
			arr = histogram[i];
			// int max_area = histogramArea(arr,size); // way one
			int max_area = histogramArea(arr);
			if(max_area>matArea) matArea = max_area;
			
		}
		System.out.println(matArea);
	}

	public static void main(String[] args) {
		// taking input for matrix 
		Scanner scan = new Scanner(System.in);
		// int[][] mat = {
		// 				{0, 1, 0, 0, 0},
		// 				{1, 1, 1, 1, 1},
		// 				{1, 1, 1, 1, 1},
		// 				{1, 0, 0, 0, 0}};
		int m = scan.nextInt();
		int n = scan.nextInt();
		int[][] mat = new int[m][n];
		for(int i = 0; i<m;i++) for(int j=0;j<n;j++) mat[i][j] = scan.nextInt();	
		scan.close();
		// maxArea(mat);
		histogramMaxArea(mat);
	}

}