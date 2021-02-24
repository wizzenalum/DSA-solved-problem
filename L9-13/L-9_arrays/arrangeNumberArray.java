import java.util.Arrays;
import java.util.Scanner;
public class arrangeNumberArray{
	public static Void printArr(int arr[]){
		for(int i: arr) System.out.print(i+" ");
		return null;
	}
	public static int[] populateArr(int n){
		int arr[] = new int[n];
		int j=0;
		for(int i=1;i<=n;i+=2,j++) arr[j]=i;
		for(int i=(n/2)*2;i>=2;i-=2,j++) arr[j]=i;
		return arr;
	} 
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int i=1;i<=t;i++){
			int n = scan.nextInt();
			printArr(populateArr(n));
		}
	}

}