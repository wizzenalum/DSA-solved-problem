
/*#####################################################################################
                        Merge Two sorted array
    You are given two sorted arrays with size M and N respectively, you have to merge 
    them into a sorted array.
    
    Note: Try to merge them with O(1) space complexity.

    Input format:
    Line 1 : Size of first array i.e. M
    Line 2 : M elements of first array separated by space
    Line 3 : Size of second array i.e. N
    Line 2 : N elements of second array separated by space

    Output format:
    The output contains the two merged sorted arrays in different lines.
    
    Constraints:
    1<=M,N<=100000
    
    Sample Input:
    6
    1 5 9 10 15 20
    4
    2 3 8 13
    
    Sample Output:
    1 2 3 5 8 9
    10 13 15 20
    
                        completed true;
#####################################################################################*/
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
public class MergeTwoSortedArray {
        
    private static void merge(int[] arr1, int[] arr2) {
        // time complexity O(n*m) space O(1);
        int m = arr1.length, n = arr2.length, i = 0, temp = 0;
        for (int j = n-1; j>=0; j--) {
            i = m-1;
            if(arr1[i]>arr2[j]){
                temp = arr2[j];
                arr2[j] = arr1[i];
                i--;
                while(i>=0 && arr1[i]>temp){
                    arr1[i+1] = arr1[i];
                    i--;
                }
                arr1[i+1] = temp;
            }
        }
        for (i = 0; i < m; i++) System.out.print(arr1[i]+" ");
        System.out.println();
		for (i = 0; i < n; i++) System.out.print(arr2[i]+" ");
    }
// method 2 using  it is wrong somewhere.
    private static void merge1(int[] arr1, int[] arr2) {
        // time complexity O(log(n)*m+n) space O(1);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int m = arr1.length, n = arr2.length, temp = 0;
        // creating priority queue;
        for (int j = 0; j < m; j++) {
            pq.add(arr1[j]);
        }

        for (int j = n-1; j>=0; j--) {
            if(pq.peek()>arr2[j]){
                temp = arr2[j];
                arr2[j] = pq.poll();
                pq.add(temp);
            }
        }
        for (int i = m-1; i >=0; i--) {
            arr1[i] = pq.poll();
        }
        for (int i = 0; i < m; i++) System.out.print(arr1[i]+" ");
        System.out.println();
		for (int i = 0; i < n; i++) System.out.print(arr2[i]+" ");
    }
// method 3 using min hip
    public static int compare(int a, int b){
        // return a-b; // for max hipify;
        return b-a; // for min hipify;
    }
    public static void swap(int[] arr, int index1, int index2){
        int swap = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = swap;
    }
    public static void downHipify(int[] arr, int element, int end){		
        if(end-element<1) return;
        int child = 0, child2 = 0;
        while(element<end){
        // System.out.println("insert" + element);
            child = element*2 +1;
            child2 = element*2 +2;
            if(child>=end || (child2>=end && compare(arr[element], arr[child])>=0)) return;
            if(child2>=end){
                swap(arr,child,element);
                return;
            }
            if((compare(arr[element],arr[child2])>=0 && compare(arr[element], arr[child])>=0)) return;
            if(compare(arr[element],arr[child2])<0 || compare(arr[element], arr[child])<0){
                if(compare(arr[child],arr[child2])>0){
                    swap(arr, child, element);
                    element = child;
                }
                else{
                    swap(arr,child2,element);
                    element = child2;
                }
            }
        }
    }
    public static void sortHippified(int[] arr){
		// now sort the array.
		for(int i = arr.length-1;i>0;i--){
			int swap = arr[0];
			arr[0] = arr[i];
			arr[i] = swap;
			downHipify(arr,0,i);
		}
	}
    private static void merge2(int[] arr1, int[] arr2) {
        // time complexity O(log(n)*m+n) space O(1);
        int m = arr1.length, n = arr2.length, temp = 0;

        for (int j = m-1; j>=0; j--) {
            // for (int i = 0; i < m; i++) System.out.print(arr1[i]+" ");
            // System.out.print(" || ");
            // for (int i = 0; i < n; i++) System.out.print(arr2[i]+" ");
            if(arr1[0]<=arr2[0]){
                swap(arr1,0,j);
                downHipify(arr1, 0, j);
                // System.out.print(" case 1 || ");
                // for (int i = 0; i < m; i++) System.out.print(arr1[i]+" ");
                // System.out.print(" || ");
                // for (int i = 0; i < n; i++) System.out.print(arr2[i]+" ");
            }else{
                temp = arr1[0];
                arr1[0] = arr2[0];
                arr2[0] = temp;

                swap(arr1,0,j);
                downHipify(arr1, 0, j);
                downHipify(arr2, 0, n-1);
                // System.out.print(" case 2 || ");
                // for (int i = 0; i < m; i++) System.out.print(arr1[i]+" ");
                // System.out.print(" || ");
                // for (int i = 0; i < n; i++) System.out.print(arr2[i]+" ");
            }
            System.out.println();
        }
        sortHippified(arr2);
        for (int i = m-1; i >=0; i--) System.out.print(arr1[i]+" ");
        System.out.println();
		for (int i = n-1; i >=0; i--) System.out.print(arr2[i]+" ");
        
    }
    public static void main(String[] args) throws IOException {
        FileReader is = new FileReader("/home/dipak/Bit_by_bit/DSA.learn/careercamp/priority-queue/priority-bonus/sampleTest.txt");
		// InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		int n = Integer.parseInt(br.readLine().trim());
		String[] str1 = br.readLine().trim().split(" ");
		int m = Integer.parseInt(br.readLine().trim());
		String[] str2 = br.readLine().trim().split(" ");
        br.close();
        is.close();
		int[] arr1 = new int[n];
		int[] arr2 = new int[m]; 
		for (int i = 0; i < n; i++) arr1[i] = Integer.parseInt(str1[i]);
		for (int i = 0; i < m; i++) arr2[i] = Integer.parseInt(str2[i]);
        // for (int i = 0; i < n; i++) System.out.print(arr1[i]+" ");
        // System.out.println();
		// for (int i = 0; i < m; i++) System.out.print(arr2[i]+" ");
        // System.out.println();
        // merge(arr1,arr2);
        // merge1(arr1,arr2);
        merge2(arr1,arr2);
        
    }

    
}
