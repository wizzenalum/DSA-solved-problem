/*#####################################################################################
                             Class Teacher

        A teacher is studying the confidence and the smartness of her students. The 
    confidence and the smartness are represented as an integer. The teacher 
    wants to know the Nth smallest sum of one confidence value and one smartness value
    for various values of N. The confidence and the smartness value may correspond to 
    different students.
    
    You are given two arrays, the first array denotes the confidence value and the 
    second array denotes the smartness value of the students. We can get a set of 
    sums(add one element from the first array and one from the second). For each query 
    ( denoted by an integer qi ( i = 1 to Q ) , Q denotes number of queries ) , find 
    the qi-th element in the set of sums ( in increasing order) .
    
    Input Format:
        The first line of input contains two space-separated integers K and Q denoting 
        the number of students and the number of queries .
        The second line of input contains K space-separated integers A1, A2, ..., AK denoting 
        the confidence value of the students.
        The third line of input contains K space-separated integers B1, B2, ..., BK denoting 
        the smartness of the students.
        The next Q lines contains a single integer qi ( for i = 1 to Q ) , find the qi th 
        element in the set of sums .

    Output Format:
        For each query of the input, output containing the answer to the query in different lines.

    Constraints:
                1 ≤ K ≤ 20000
                1 ≤ Q ≤ 500
                1 ≤ qi ( for i = 1 to Q ) ≤ 10000
                1 ≤ Ai ≤ 10^18 ( for i = 1 to K )
                1 ≤ Bi ≤ 10^18 ( for i = 1 to K )

    Sample Input:
                3 2
                1 2 3
                6 7 8
                3
                4

    Sample Output:
            8
            9

    Explanation:
            The 9 elements in the set sum are:
            1+6=7
            1+7=8
            2+6=8
            1+8=9
            2+7=9
            3+6=9
            2+8=10
            3+7=10
            3+8=11


                    completed: true;
#####################################################################################*/
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Comparator;
public class ClassTeacher {  
    public static long compare(long a, long b){
		return a-b; // for max hipify;
		// return b-a; // for min hipify;
	}
	public static void swap(long[] arr, int index1, int index2){
		long swap = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = swap;
	}
	public static void downHipify(long[] arr, int element, int end){		
		if(end-element<1) return;
		int child = 0, child2 = 0, swap=0;
		while(element<end){
			// swap++;
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
	

	public static void heapSort(long[] arr){
		// create heap first
			// downHipify(arr, 0, arr.length);
		for(int i = arr.length/2 - 1; i>=0;i--){
			downHipify(arr, i, arr.length);
		}

		// now sort the array.
		for(int i = arr.length-1;i>0;i--){
			long swap = arr[0];
			arr[0] = arr[i];
			arr[i] = swap;
			downHipify(arr,0,i);
		}
	}   
    public static void main(String[] args) throws IOException {
        FileReader is = new FileReader("/home/dipak/Bit_by_bit/DSA.learn/careercamp/priority-queue/priority-bonus/sampleTest.txt");
        // InputStreamReader is = new InputStreamReader(System.in);
        Scanner scan = new Scanner(is);
        int k = scan.nextInt();
        int q = scan.nextInt();
        long[] confidence = new long[k];
        for (int i = 0; i < k; i++) confidence[i] = scan.nextLong();
        long[] smartness = new long[k];
        for (int i = 0; i < k; i++) smartness[i] = scan.nextLong();
        int[] queries = new int[q];
        for (int i = 0; i < q; i++) queries[i] = scan.nextInt();
        scan.close();
        is.close();
    // // method 1 time complexity is very high and space goes beyond the heapspace.
    //     PriorityQueue<Long> pq = new PriorityQueue<>();
    //     int count =0; 
    //     for (int i = 0; i < k; i++) {
    //         for (int j = 0; j < k; j++) {
    //             long sum = confidence[i]+smartness[j];
    //             pq.add(sum);
    //         }
    //     }
    //     Long[] queryResult = new Long[pq.size()];
    //     for (int i = 0; i < queryResult.length; i++) {
    //         queryResult[i] = pq.poll();
    //     }
    //     System.out.println(Arrays.toString(queryResult));
    //     // time to print the result;
    //     for (int i = 0; i < queries.length; i++) {
    //         System.out.println(queryResult[queries[i]-1]);
    //     }
    // method 2 time complexity is very high but worked
        int count2 = 0; // in question given that query can't be more than 10000.
        for (int i = 0; i < queries.length; i++) {
            if(queries[count2]<queries[i]) count2 = i;
        }count2 = queries[count2];
        long[] pq = new long[count2];
        count2--; // now i will use this same variable for another usecase.
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                long sum = confidence[i]+smartness[j];
                if(count2>0){
                    pq[count2] = sum;
                    count2--;
                }else if(count2==0){
                    pq[0] = sum;
                    count2--;
                    for(int z = pq.length/2 - 1; z>=0;z--){
                        downHipify(pq, z, pq.length);
                    }
                }else{
                    if(pq[0]>sum){
                        pq[0] = sum;
                        downHipify(pq, 0, pq.length);
                    }
                }
            }
        }
        heapSort(pq);
        System.out.println(Arrays.toString(pq));
        // time to print the result;
        for (int i = 0; i < queries.length; i++) {
            System.out.println(pq[queries[i]-1]);
        }
    // // method 3 i did'nt know why this approach is there even i dont get this and giving wrong answer.
    //     Arrays.sort(confidence);
    //     Arrays.sort(smartness);
    //     System.out.println(Arrays.toString(confidence));
    //     System.out.println(Arrays.toString(smartness));
    //     int count1 = 0; // in question given that query can't be more than 10000.
    //     for (int i = 0; i < queries.length; i++) {
    //         if(queries[count1]<queries[i]) count1 = i;
    //     }count1 = queries[count1];
    //     long[] queryResult1 = new long[count1];
    //     System.out.println(count1);
    //     PriorityQueue<Long> pq1 = new PriorityQueue<>();
    //     long sum1=0, sum2 = 0;
    //     count1 = 0;
    //     out:
    //     for (int i = 0; i < k; i++) {
    //         for (int j = i; j < k; j++) {
    //             sum1 = confidence[i]+smartness[j];
    //             sum2 = confidence[j]+smartness[i];
    //             pq1.add(sum1);
    //             if(i!=j) pq1.add(sum2);
    //             if(count1>=queryResult1.length) break out;
    //             queryResult1[count1] = pq1.poll();
    //             count1++;
    //         }
    //     }
    //     System.out.println(Arrays.toString(queryResult1));
    //     // time to print the result;
    //     for (int i = 0; i < queries.length; i++) {
    //         System.out.println(queryResult1[queries[i]-1]);
    //     }
    } 
}
    