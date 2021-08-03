import java.util.Arrays;
import java.util.Scanner;
public class findLargest {
	public static int rowsum(int[][] arr,int n){
		int row = 0;
		for(int i=0;i<arr[n].length;i++) row +=arr[n][i];
		return row;
	}
	public static int columnsum(int[][] arr,int n){
		int column =0;
		for(int[] a:arr) column += a[n];
		return column;
	}
	public static int searchLargest(int[] arr){
		int larg = 0;
		for(int i = 0;i<arr.length;i++){
			if(arr[i]>arr[larg]) larg = i;
		}
		return larg;
	}
	public static void findLargest(int mat[][]){
		int n = mat.length, m =  mat[0].length;
		int[] sumArray = new int[m+n];
		for(int i=0; i<m+n;i++){
			if(i<n) sumArray[i] = rowsum(mat,i);
			else sumArray[i] = columnsum(mat,i-n);
		}
		int max = searchLargest(sumArray);
		int a =max-n;
		if(max<n) System.out.print("row "+ max +" "+sumArray[max]);
		else System.out.print("column "+ a + " "+sumArray[max]);
	}
	public static void main(String[] args){
		Scanner scan =  new Scanner(System.in);
		int t = scan.nextInt();
		for(int test = 0;test<t;test++){
			int n=scan.nextInt();
			int m = scan.nextInt();
			int[][] arr2d = new int[n][m];
			for(int i=0; i<n;i++) for(int j=0; j<m;j++) arr2d[i][j] = scan.nextInt();
			findLargest(arr2d,n,m);
			System.out.println();
		}
	}

}