import java.util.Arrays;
import java.util.Scanner;
public class sumTwoArrays{
    //****sum or two arrays *********************************************************************
    public static void sumOfTwoArrays(int arr1[], int arr2[], int output[]) {
        int len1 =  arr1.length-1,len2 = arr2.length-1,len = output.length-1;
        int j=len1, k = len2;
        for(int i = len;i>=0;i--){
            if(j>-1 && k>-1){
                if(arr1[j]+arr2[k]+output[i]>9){
                    output[i] = (arr1[j]+arr2[k]+output[i])%10;
                    output[i-1] = 1;                    
                }else output[i] = arr1[j]+arr2[k]+output[i];
            }else if(j>-1){
                if(arr1[j]+output[i]>9){
                    output[i] = (arr1[j]+output[i])%10;
                    output[i-1] = 1;
                }else output[i] = arr1[j]+output[i];

            }else if(k>-1){
                if(arr1[k]+output[i]>9){
                    output[i] = (arr1[k]+output[i])%10;
                    output[i-1] = 1;
                }else output[i] = arr1[k]+output[i];

            }else break;
            j--;
            k--;
        }
    }
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,6,4,7,8,6};
        int[] arr2 = {2,3,7,4,3};
        int[] output = new int[arr1.length+1];
        sumOfTwoArrays(arr1,arr2,output);
        System.out.print(Arrays.toString(output));

    }
}