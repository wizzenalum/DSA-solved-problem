import java.util.Arrays;
import java.util.Scanner;
public class maxSum{
	public static long maximumSumPath(int[] input1, int[] input2) {
		long sum1=0,sum2=0,sum=0;
		int len1 = input1.length,len2 = input2.length;
		for(int i=0,j=0;i<len1||j<len2;){
			System.out.print(i+" "+j);
			if(i<len1&&j<len2&&input1[i]<input2[j]){
				sum1+=input1[i];
				System.out.println(" 1 "+ sum1);
				i++;
			}else if(i<len1&&j<len2&&input1[i]>input2[j]){
				sum2+=input2[j];
				System.out.println(" 2 "+ sum2);
				j++;
			}else if(i<len1&&j<len2&&input1[i]==input2[j]) {
				if(sum1>sum2) sum += sum1+input1[i];
				else sum+=sum2+input2[j];
				System.out.println(" 3  "+sum+" "+sum1+" "+sum2);
				sum1=0;
				sum2=0;
				i++;
				j++;
			}else if(i<len1){
				sum1 +=input1[i];
				System.out.println(" 4 "+ sum1);
				i++;
			}else if(j<len2){
				sum2 +=input2[j];
				System.out.println(" 5 "+ sum2);
				j++;
			}		
		}
		if(sum1>sum2) sum += sum1;
		else sum+=sum2;
		return sum;
	}
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int[] arr1 = new int[m];
		for(int i=0;i<m;i++) arr1[i]=scan.nextInt();
		int n = scan.nextInt();
		int[] arr2 = new int[n];
		for(int i=0;i<n;i++) arr2[i]=scan.nextInt();
		// int[] arr1 = {1,5,10,15,20,25};
		// int[] arr2 = {2,4,5,9,15};
		System.out.println(maximumSumPath(arr1,arr2));
	}
	// public static long maximumSumPath(int[] input1, int[] input2) {
	// 	long sum1=0,sum2=0,sum=0;
	// 	int len1 = input1.length,len2 = input2.length;
	// 	for(int i=0,j=0;i<len1&&j<len2;){
	// 		// System.out.print(i+" "+j);
	// 		if(input1[i]<input2[j]){
	// 			sum1+=input1[i];
	// 			// System.out.println(" 1 "+ sum1);
	// 			i++;
	// 		}else if(input1[i]>input2[j]){
	// 			sum2+=input2[j];
	// 			// System.out.println(" 2 "+ sum2);
	// 			j++;
	// 		}else if(input1[i]==input2[j]) {
	// 			if(sum1>sum2) sum += sum1+input1[i];
	// 			else sum+=sum2+input2[j];
	// 			// System.out.println(" 3  "+sum+" "+sum1+" "+sum2);
	// 			sum1=0;
	// 			sum2=0;
	// 			i++;
	// 			j++;
	// 	}
	// 	for()
	// 		}else if(i<len1){
	// 			sum1 +=input1[i];
	// 			// System.out.println(" 4 "+ sum1);
	// 			i++;
	// 		}else if(i<len2){
	// 			sum2 +=input2[j];
	// 			// System.out.println(" 5 "+ sum2);
	// 			j++;
	// 		}		
	// 	}
	// 	if(sum1>sum2) sum += sum1;
	// 	else sum+=sum2;
	// 	return sum;
	// }
	// public static void main(String[] args){
	// 	int[] arr1 = {1,5,10,15,20,25};
	// 	int[] arr2 = {2,4,5,9,15};
	// 	System.out.println(maximumSumPath(arr1,arr2));
	// }

}