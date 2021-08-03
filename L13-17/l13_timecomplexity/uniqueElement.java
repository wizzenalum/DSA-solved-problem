import java.util.Arrays;
import java.util.Scanner;
public class uniqueElement{
//****bruit force solution *********************************************************************
	// time complexity is O(n*n) because we are looking all the elements linearly.

	public static int findUnique(int arr[]) {
		int len = arr.length;
		if (len ==1) return arr[0];
		for(int i=0;i<len;i++){
			int j;
			for(j=i+1;j<len && arr[i]!=Integer.MIN_VALUE;j++){
				if(arr[i]==arr[j]){
				 arr[j] = Integer.MIN_VALUE;;
				 break;
			}	
			}
			if(j==len) return arr[i];
		}
		return -1;
	}
//****solution2 *********************************************************************
	//here i will sort array and then i will traverse once and find the unique.
	// so time complexity == O(nlogn)

	public static int findUnique1(int[] arr) {
		int len = arr.length;
		if(len==1) return arr[0];
		Arrays.sort(arr);
		System.out.print(Arrays.toString(arr));
		for(int i=1;i<len;i+=2){
			if(arr[i-1]!=arr[i]) return arr[i-1];
        }
        if(arr[len-1]!=arr[len-2]) return arr[len-1];
        return -1;
	}
//****solutiong 3 *********************************************************************
	//in this solution xor opration is used to find the unique
	// so time complexity == O(n).
	public static int findUnique2(int[] arr) {
		int xor = 0;
		for (int i = 0; i < arr.length; i++) {
			xor^=arr[i];
		}
		return xor;
		
	}
	public static void main(String[] args){
		Scanner scan =  new Scanner(System.in);
		int t = scan.nextInt();

		for(int test=0; test<t; test++){
			int n = scan.nextInt();
			int[] arr = new int[n];
			for(int i=0; i<n;i++) arr[i]=scan.nextInt();
			System.out.print(findUnique1(arr));
		}
	
	}

}