/*****************************       Three Teams   *******************
    1. There are N players, linearly standing. Each player has a chest number. 
        The number also denotes the strength of that player. So, greater the number, 
        stronger the player.
    2. You have to form 3 teams from these N players. Each team has to be of k size.
    3. There are two restrictions in selections of players. First, a particular 
        player can only be selected for one team. So, two teams cannot have the 
        same player. Second, you can only select consecutively standing players 
        for a particular team
    4. Can you tell us the maximum possible cumulative sum of selected players chest 
        number, if the selection is done according to the above mentioned conditions.

    Input Format:
        The first line of input contains the value of N.
        The following line contains N space separated integers, that denotes the value 
        of players chest number. The following line contains the value of k. Input 
        would be provided in such a way that selection of 3 teams will always be possible.

    Constraints:
        Time Limit: 1 second
        The value of N lies in the range: [1, 10000]
        The value of N space separated integers lies in the range: [1, 65535]. 
        The values can be duplicate. As value denotes chest number and chest number 
        denotes strength and since, two players can have similar strength, hence, 
        there can be duplicate values in the array.
        The value of k lies in the range: [1, 1000].

    Output Format:
        The first and only line of output contains the maximum sum, as described in the task.

    Sample Input 1:
        8
        1 2 1 2 6 7 5 1
        2

    Sample Output 1:
        23

    Explanation:
        For selections, following 3 teams will have maximum sum: [1,2], [2, 6], [7, 5]
*/


package test9;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.io.BufferedReader;
import java.io.IOException;
public class ThreeTeams {
    // method 1 bruit force method correct time is O(n^3);
    public static void method1(String[] arr, int n,int k){

        int sum = 0, sum2 = 0, sum3 = 0;
        for (int i = 0; i <k; i++) {
            sum += Integer.parseInt(arr[i]);
        }
        int max = 0;
        for (int i = 0, j = k-1; j<n-2*k ; i++,j++) {
            if(i>0) sum = sum - Integer.parseInt(arr[i-1])+Integer.parseInt(arr[j]);;
            sum2 = 0;
            for (int p = j+1; p < j+1+k; p++) {
                sum2 += Integer.parseInt(arr[p]);
            }
            for (int i2 = j+1, j2 = i2+k-1; j2<n-k; i2++,j2++) {
                if(i2>j+1) sum2 = sum2 - Integer.parseInt(arr[i2-1])+Integer.parseInt(arr[j2]);;
                sum3 = 0;
                for (int p = j2+1; p < j2+1+k; p++) {
                    sum3 += Integer.parseInt(arr[p]);
                }
                for (int i3 = j2+1, j3 = i3+k-1 ; j3<n; i3++,j3++) {
                    if(i3>j2+1) sum3 = sum3 - Integer.parseInt(arr[i3-1])+Integer.parseInt(arr[j3]);;
                    // System.out.println(arr[i]+" "+arr[j]+" "+ sum+" "+arr[i2]+" "+arr[j2]+ " "+sum2+" "+arr[i3]+" "+arr[j3]+ " "+sum3);
                    if(max<(sum+sum2+sum3)) max = sum+sum2+sum3;
                }
            }
            
        }
        System.out.println(max);
    }

    // method2 kind of bruit force method correct time is tight bound O(n^3);
    public static boolean isIntersect(int[] arr1, int[] arr2) {
        boolean check = false;
        if(arr1[0]<=arr2[0] && arr2[0] <=arr1[1]) check= true;
        if(arr1[0]<=arr2[1] && arr2[1] <=arr1[1]) check = true; 
        // System.out.println(arr1[0]+ ","+arr1[1]+"  "+arr2[0]+","+arr2[1]+"   "+check);
        
        return check;
    }
    public static void method2(String[] arr, int n, int k){
        int[][] intrimArr = new int[n-k+1][3];
        int sum = 0;
        // creating intim arr
        for (int i = 0; i < k; i++) sum+=Integer.parseInt(arr[i]);
        for (int i = 0; i < intrimArr.length; i++) {
            intrimArr[i][0] = i;
            intrimArr[i][1] = i+k-1;
            if(i!=0) sum +=Integer.parseInt(arr[i+k-1]) - Integer.parseInt(arr[i-1]);
            intrimArr[i][2] = sum;
        }
        Arrays.sort(intrimArr,(a,b)->b[2]-a[2]);
        // for (int i = 0; i < intrimArr.length; i++) {
        //     System.out.println(Arrays.toString(intrimArr[i]));
        // }
        sum = 0;
        int max = 0;
        for (int i = 0; i < intrimArr.length-2; i++) {
            if(sum> intrimArr[i][2]+intrimArr[i+1][2]+intrimArr[i+2][2]) break;
            for (int j = i+1; j < intrimArr.length-1; j++) {
                if(isIntersect(intrimArr[i],intrimArr[j])) continue;

                for (int l = 0; l < intrimArr.length; l++) {
                    if(isIntersect(intrimArr[i], intrimArr[l]) || isIntersect(intrimArr[j], intrimArr[l]) ) continue;
                    System.out.println(intrimArr[i][0]+","+intrimArr[i][1]+" = "+intrimArr[i][2]+"     "+intrimArr[j][0]+","+intrimArr[j][1]+" = "+intrimArr[j][2]+"     "+intrimArr[l][0]+","+intrimArr[l][1]+" = "+intrimArr[l][2]);
                    sum = intrimArr[i][2]+intrimArr[j][2]+intrimArr[l][2];
                    if(max<sum) max=sum;
                }
            }
        }
        System.out.println(max);
    }

    // method 3 using a beutiful logic ; and true answer.
        public static void method3(String[] arr, int n, int k){
            // creating left arr sum
            // here we assumed 3*k<=n always 
            int sum = 0;
            int[] lsumArr = new int[n];
            for (int i = 0; i < k; i++) sum += Integer.parseInt(arr[i]);
            lsumArr[k-1] = sum;
            for (int i = k; i < lsumArr.length; i++) {
                sum += Integer.parseInt(arr[i])- Integer.parseInt(arr[i-k]);
                lsumArr[i] = Math.max(sum,lsumArr[i-1]);       
            }
            // creating right sum arr
            sum = 0;
            int[] rsumArr = new int[n];
            for (int i = n-1; i >n-1-k; i--) sum += Integer.parseInt(arr[i]);
            rsumArr[n-k] = sum;
            for (int i = n-k-1; i>=0; i--) {
                sum += Integer.parseInt(arr[i])- Integer.parseInt(arr[i+k]);
                rsumArr[i] = Math.max(sum,rsumArr[i+1]);  
            }
            // finding the max sum by traversing the middle arr

            int max = 0;
            sum = 0;
            for (int i = k-1; i < 2*k-1; i++) sum += Integer.parseInt(arr[i]);
            for (int j = 2*k-1; j < n-k; j++) {
                sum += Integer.parseInt(arr[j])- Integer.parseInt(arr[j-k]);
                if(max< lsumArr[j-k]+rsumArr[j+1]+sum){
                    max = lsumArr[j-k]+rsumArr[j+1]+sum;
                }
                
            }
            System.out.println(max);
            
            
        }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int k = Integer.parseInt(br.readLine());
        br.close();
        // method1(arr, n, k);
        // method2(arr, n, k);
        method3(arr, n, k);
    }
}
