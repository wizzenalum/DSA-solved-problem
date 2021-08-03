import java.util.Scanner;

public class TeamSelection{

    public static void print(int[] arr, int index, int[] output, int len){
        if(len == 12) {
            for(int a: output) System.out.print(a+" ");
            System.out.println();
            return;
        }
        if(index>=arr.length){
            return;
        }
        if(len ==0){
            int[] output2 = new int[12];
            output2[len] = arr[index];
            print(arr, index+1,output2,len+1);
        }else{
            output[len] = arr[index];
            print(arr,index+1,output,len+1);
        }

        print(arr, index+1,output,len);
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // int n = scan.nextInt();
        // int[] arr = new int[n];
        // for(int i = 0;i<n;i++) arr[i] = scan.nextInt();
        int[] output = new int[12];
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13};  
        print(arr,0,output,0); 
    }
}
