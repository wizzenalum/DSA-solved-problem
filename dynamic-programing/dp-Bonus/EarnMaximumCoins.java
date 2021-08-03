/*############################################################################
 							    Earn maximum coins

    You are given N balloons indexed from 0 to N-1, with some number painted 
    on each of them represented by an array 'A'. By bursting a balloon i, 
    you will gain some coins. The number of coins gained is equal to 
    A[i-1]* A[i] * A[i+1]. After the burst, balloons i-1 and i+1 becomes 
    adjacent.
    
    Find the maximum coin you can gain by bursting all the balloons wisely.
    Note: At each boundary, i.e, A[-1] and A[N]=1

				completed false
 #############################################################################*/ 
 import java.util.Arrays;
 public class EarnMaximumCoins{
 	public static int maxCoins(int[] arr) {
        // bruit force method i just selecting each case and -1 reperesent the empty cell in the max coins.
        // time complexity is O(n^3);
        int tempMax=0, temp = 0, coins =0, fromNext = 0, j=0,k=0, current =0;
        for(int i = 0; i<arr.length;i++){
            if(arr[i]==-1) continue;
            j = i-1;
            while(j>=0&&arr[j]==-1) j--;
            k = i+1;
            while(k<arr.length&&arr[k]==-1) k++;
            if(j<0 && k>=arr.length) current = arr[i];
            else if(j<0) current = arr[i]*arr[k];  
            else if(k>=arr.length) current = arr[j]*arr[i];
            else current = arr[j]*arr[i]*arr[k];
            temp = arr[i];
            arr[i] = -1;
            fromNext = maxCoins(arr);
            tempMax = fromNext+current;
            arr[i] = temp;
            if(tempMax>coins) coins = tempMax;
        }
        return coins;
    }
    public static int maxCoins1(int[] arr) {
        // i oberserve one thing that always we pop balloon that have high coin weight and low coin attacehd to it lets check.
        // it will reduce the compelexity O(n^2);
        // failed man at {2, 1, 3, 4, 5} 
        // pop sequance according to this algo is 4,3,1,2,5 answerr pop is 1,4,3,2,5;
        // System.out.print(Arrays.toString(arr));
        int totalCoins=0;
        if(arr.length<=0) return 0;
        if(arr.length==1) return arr[0];
        if(arr.length==2){

            if(arr[0]>arr[1]) totalCoins = arr[0]*arr[1] + arr[0];
            else totalCoins = arr[0]*arr[1] + arr[1];
            // System.out.println(totalCoins);
            return totalCoins;
        }
        //calcualte the weights.
        int[] weight  = new int[arr.length];
        weight[0] = arr[0]*arr[1];
        weight[arr.length-1] = arr[arr.length-1]*arr[arr.length-2];
        for(int i = 1; i<arr.length-1;i++){
            weight[i]= arr[i-1]*arr[i]*arr[i+1];
        }
        int maxWeight = 0, weightIndex = 0;
        for(int i = 0; i<arr.length;i++){
            if(weight[i]==maxWeight&&arr[i]<arr[weightIndex]) weightIndex = i;
            if(weight[i]>maxWeight){
                weightIndex = i;
                maxWeight = weight[i];
            } 
        }
        // System.out.println("     "+Arrays.toString(weight)+"  "+weightIndex);
        int[] arr1 = new int[arr.length-1];
        for(int i = 0; i<arr1.length;i++){
            if(i>=weightIndex) arr1[i] = arr[i+1];
            if(i<weightIndex) arr1[i] = arr[i];
        }
        // System.out.println(" "+Arrays.toString(arr1));

        totalCoins = maxCoins1(arr1) +weight[weightIndex];
        // System.out.println(totalCoins);
        return totalCoins;
    }
    public static void main(String[] args) {
        // int[] arr = {1,2,3,4,5};
        int[] arr = {2, 1, 3, 4, 5};
        System.out.println(maxCoins(arr));
        System.out.println(maxCoins1(arr));
    }
 }