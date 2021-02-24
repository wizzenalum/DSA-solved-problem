import java.util.Arrays;
import java.util.Scanner;
public class equilibriumIndex{
	public static int arrayEquilibriumIndex(int[] arr){ 
        if(arr.length==0) return -1;
		int sum1 =arr[0], sum2=0;
		for (int i=1; i<arr.length; i++) sum2+= arr[i];
		for(int i=0; i<arr.length; i++){
			if(sum1==sum2) return i;
			else if(i==arr.length-1) return-1;
			else{
				sum1+=arr[i];
				sum2-=arr[i+1];
			}
		}return -1;		
	}
	public static void main(String[] args){
		Scanner scan =  new Scanner(System.in);
		int t = scan.nextInt();
		for(int test=0; test<t; test++){
			int n = scan.nextInt();
			int[] arr = new int[n];
			for(int i=0; i<n;i++) arr[i]=scan.nextInt();
			System.out.print(arrayEquilibriumIndex(arr));
		}

	
	}

}