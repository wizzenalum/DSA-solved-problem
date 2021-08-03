import java.util.Arrays;
import java.util.Scanner;
public class findUnique{
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
	public static void main(String[] args){
		int arr2[] = {2,2,3};
		System.out.print(findUnique(arr2));
	}	

}