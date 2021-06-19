/*#####################################################################################
                               K largest Sums

    You are given a N-sized array and two integers m and k. You have to check if 
    the product of the k largest sums contiguous subarrays is greater than m.

    Input format:
        The first line of input contains the size of array(N). The second line of input 
        contains space separated elements of the array. The last line of input contains 
        the value of k and m separated by space.

    Output format:
        The only line of output contains "True" (if the product of the K largest sums of 
        contiguous subarrays is greater than M) otherwise "False"

    Sample Input:
        4
        8 -4 -2 7
        3 659

    Sample Output:
        False

    Explanation:
        The 3 largest sums contiguous subarrays are: {8}, {7} and {8, -4, -2, 7}. 
        Product of their sums is : 8*7*9=504 and it is less than 659.

                    completed: true;
#####################################################################################*/
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
public class KLargestSums {    
    public static void main(String[] args) throws IOException {
        FileReader is = new FileReader("/home/dipak/Bit_by_bit/DSA.learn/careercamp/priority-queue/priority-bonus/sampleTest.txt");
        // InputStreamReader is = new InputStreamReader(System.in);
        Scanner scan = new Scanner(is);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = scan.nextInt();
        int k = scan.nextInt();
        Long m = scan.nextLong();
        scan.close();
        is.close();
        long sum = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            sum  = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if(pq.size()<k){
                    pq.add(sum);
                }
                else{
                    if(pq.peek()<sum){
                        pq.poll();
                        pq.add(sum);
                    }
                }
            }
        }
        sum = 1;
        while(!pq.isEmpty()){
            // System.out.println(pq.peek());
            sum*=pq.poll();
        }
        // System.out.println(sum);
        if(sum>=m) System.out.println("True");
        else System.out.println("False");
    } 
}
    