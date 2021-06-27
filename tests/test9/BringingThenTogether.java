/* *****************************Bringing them together************************
    1. Rohit was organizing a party. He made his friends stand linearly in a 
    queue and gave a cap with number printed on its top to each of its friend.
    2. He wanted to bring all the people whose cap number is less than or equal 
    to 'X' together. But he wanted to achieve it in minimum transitions of his 
    friends.
    3. Given the initial position of friends with their cap numbers, can you 
    tell us minimum number of transitions required to bring all the people 
    whose cap number is less than or equal to 'X' together.
        Input Format:
            The first line contains the number of friends that came to the 
            party. Let it be denoted by n.
            The following line contains n space separated integers, that denotes 
            the cap of his standing friends. The following line contains the value of X.

        Constraints:
            Time Limit: 1 second
            The value of n lies in the range: [1, 1000000]
            The value of X lies in the range: [1, 1000]

        Output Format:
            The first and only line of output contains the value of minimum 
            number of transitions, as described in the task.  

        Sample Input 1:
            7
            12 17 19 15 18 17 14
            15

        Sample Output 1:
            2

        Explanation:
            There are three elements which are less than or equal to 'X'. Following are those three elements: 12, 14, 15.
            The minimum number of transitions will be two. One of the many subarrays, where the minimum transitions will be two is first subarray of size 3, i.e. [12, 17, 19]. We can bring all elements together by swapping (17 & 15) and (19 & 14).

 */


package test9;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
public class BringingThenTogether {
    // my methode wrong work approx 50% times
    public static void method1(String[] arr, int value,int n) {
        int i =0, j = n-1, transition = 0;
        String swap = "";
        while(i<n && Integer.parseInt(arr[i])>value) i++;
        int countmax = 0;
        for (int k = 0; k < arr.length;) {
            int count = 0;
            while(k<n && Integer.parseInt(arr[k++])<=value) count++;
            if(countmax<count) countmax = count;
        }
        int jod = 0, kod = i;
        while(kod<n && Integer.parseInt(arr[kod++])<=value) jod++;
        

        while(j>i){
            while(i<n && Integer.parseInt(arr[i])<=value) i++;
            while(j>= 0 && Integer.parseInt(arr[j])>value) j--;
            if(j<=i) break;
            if(i<n && j>=0){
                // System.out.println(arr[i]+" "+ arr[j]);
                swap = arr[i];
                arr[i] = arr[j];
                arr[j] = swap; 
                transition++;
            }
        }
        System.out.println(transition-jod+countmax);
    }

    public static void method2(String[] arr, int value, int n ) {
        int count = 0; // count of the elements those are lesser than the value
        for (int i = 0; i < arr.length; i++) if(Integer.parseInt(arr[i])<=value) count++;
        // count elements in count window first
        int inWinCount = 0; //count of elements those lesser to value and present in first window.
        for (int i = 0; i < count; i++) if(Integer.parseInt(arr[i])<=value) inWinCount++;
        int maxInWinCount = inWinCount;
        for (int i = count; i < n-count; i++) {
            if(Integer.parseInt(arr[i])<=value) inWinCount++;
            if(Integer.parseInt(arr[i-count])<=value) inWinCount--;
            
            if(inWinCount>maxInWinCount) maxInWinCount = inWinCount;
        }
        System.out.println(count-maxInWinCount);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int value = Integer.parseInt(br.readLine());
        br.close();
        // method1(arr, value, n);
        method2(arr, value, n);
    }
}
