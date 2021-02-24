import java.util.Arrays;
import java.util.Scanner;
public class Sort01{
  //   public static void sortZeroesAndOne(int[] arr){
  //    int lastZero = 0,firstElement =0;
  //    boolean flag = true;
  //    for (int i =1; i<arr.length; i++) {
  //        // System.out.println("for "+i);
  //        if(arr[i]==1) continue;
  //        else{
  //            // System.out.println(arr[i]+" "+arr[lastZero]);
  //            arr[i] = arr[lastZero]+arr[i];
  //            arr[lastZero] = arr[i]-arr[lastZero];
  //            arr[i] = arr[i]-arr[lastZero]; 
  //            lastZero++;
  //            if (flag){
  //                firstElement = i;
  //                flag = false;
  //            // System.out.println(lastZero+" hel "+firstElement);
  //            }
  //        }
  //    }
  //    // System.out.println(lastZero+" hel "+firstElement);
  //    // System.out.println(Arrays.toString(arr));
  //    if (arr[firstElement]!=0){
  //        int swap = arr[lastZero];
        //  arr[lastZero] = arr[firstElement];
        //  arr[firstElement] = swap;
  //    // System.out.println(Arrays.toString(arr));
        // }
        // for(int a: arr) System.out.print(a+" ");
  //   }
    
    public static void sortZeroesAndOne(int[] arr){
    	if(arr.length==0) return;
    	int firstone = 0,firstelement =0;
    	for (int i =1; i<arr.length; i++) {
    		if(arr[i]==1) continue;
    		else{
    			int swap = arr[firstone];
    			arr[firstone] = arr[i];
    			arr[i] = swap; 
    			if (firstone == firstelement) firstelement = i;
    			firstone++;
    			
    		}
    	}
		int swap = arr[firstone];
		arr[firstone] = arr[firstelement];
		arr[firstelement] = swap;
		
		for(int a: arr) System.out.print(a+" ");
    }
	public static void main(String[] args){
		int[] arr3 = {1,1,0,0,1,0,0,0,0,0,1 };
		sortZeroesAndOne(arr3);
	}
		
}