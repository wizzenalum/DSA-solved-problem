import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.IOException;

public class HelpAroma{
    public static boolean isCombination(String str1, String str2){
        if(str1.length()!=str2.length()) return false;
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for(int i = 0;i<str1.length();i++){
            int index1 = str1.charAt(i)-'a';
            int index2 = str2.charAt(i)-'a';
            arr1[index1]++;
            arr2[index2]++;
        }
        for(int i = 0; i<26;i++){
            if(arr1[i]!=arr2[i]) return false;
        }
        return true;
    }

    // method2 function
    public static boolean isCombination(int w,int x,int y,int z, int[][] mat){
        if(Math.abs(w-x) != Math.abs(y-z)) return false;
        // here i making x greater and z greater
        int temp = w;
        if(w>x){
            temp = w;
            w = x;
            x = temp;
        }
        if(y>z){
            temp = y;
            y = z;
            z = temp;
        }

        // System.out.println(Arrays.toString(mat[w]));
        // System.out.println(Arrays.toString(mat[x]));
        // System.out.println(Arrays.toString(mat[y]));
        // System.out.println(Arrays.toString(mat[z]));
        
        for(int i = 0; i<26;i++){
            if((mat[x][i]-mat[w-1][i]) != (mat[z][i]-mat[y-1][i])) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Scanner scan = new Scanner(System.in);
        // String str = scan.next();
        String str = br.readLine();
        // int k = scan.nextInt();
        int k = Integer.parseInt(br.readLine().strip());
        // method 1 time limit exiiccding
        // for(int i = 0;i<k;i++){
        //     int w = scan.nextInt();
        //     int x = scan.nextInt();
        //     int y = scan.nextInt();
        //     int z = scan.nextInt();

        //     System.out.println(isCombination(str.substring(w-1,x),str.substring(y-1,z)));
        // }
        // method 2 by using dp
            int[][] mat = new int[str.length()+1][26];
            // here i create a storage 
            for (int i = 1; i < mat.length; i++) {
                int index = str.charAt(i-1)-'a';
                for (int j = 0; j < 26; j++) {
                    mat[i][j] = mat[i-1][j];
                }
                mat[i][index]++;
                // System.out.println(Arrays.toString(mat[i]));
            }
            for(int i = 0;i<k;i++){
                    // int w = scan.nextInt();
                    // int x = scan.nextInt();
                    // int y = scan.nextInt();
                    // int z = scan.nextInt();
                    String[] input = br.readLine().strip().split(" ");
                    int w = Integer.parseInt(input[0]);
                    int x = Integer.parseInt(input[1]);
                    int y = Integer.parseInt(input[2]);
                    int z = Integer.parseInt(input[3]);
                    
        
                    System.out.println(isCombination(w,x,y,z,mat));
                }

    }
}


// navdeepdvan
// 2
// 1 4 8 11
// 4 5 7 8