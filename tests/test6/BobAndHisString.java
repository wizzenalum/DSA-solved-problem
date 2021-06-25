import java.util.Scanner;

public class BobAndHisString{

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        // int n = 1;
        for(int i = 0;i<n;i++){
            String str = scan.next();
            // String str = "aba";
            int len = str.length();
            int[][] distance = new int[26][2]; 
            // System.out.print(str);
            for(int j = 0;j<len;j++){
                int index = str.charAt(j)-'a';
                // System.out.println(index);
                if(distance[index][0]==0) distance[index][0] = j+1;
                else distance[index][1] = j+1;
                
            }
            int maxDis = 0, temp = 0;
            for(int j = 0;j<26;j++){
                if(distance[j][0]!=0 && distance[j][1]!=0) temp = distance[j][1]-distance[j][0];
                if(temp>maxDis) maxDis = temp;
                
            }
            System.out.println(maxDis-1);
            
        // for(int[] arr:distance) System.out.print("("+arr[0]+","+arr[1]+")    ");
        
        }
    }
}
/*2
aba
babcddc*/