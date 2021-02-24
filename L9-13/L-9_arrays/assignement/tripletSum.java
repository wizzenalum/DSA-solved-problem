import java.util.Arrays;
import java.util.Scanner;
public class tripletSum{
	public static int findTriplet(int arr[], int x) {
		int l=0;
    	for(int i=0;i<arr.length-2;i++){
    		// System.out.println(i+ " i");
			for(int j=i+1;j<arr.length-1;j++){
				// System.out.print(j+" j ");
				for( int k=j+1;k<arr.length;k++){
				// System.out.print(k);
					if(arr[i]+arr[j]+arr[k]==x){
						l++;
						// System.out.println(l);
					}		
				}

			}
		}
		return l;

    }
	public static void main(String[] args){
		int arr1[] = {5, 5, 4, 4, 5, 4};
		System.out.print(findTriplet(arr1,15));
		}


}