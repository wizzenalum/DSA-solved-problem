import java.util.Scanner;
import java.util.Arrays;

public class StrangeIsland{

    

    // public static void remove(char[][] island){
    //     for(int i = 0;i<island.length)
    // }
    
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int r = scan.nextInt();
        int c = scan.nextInt();
        char[][] island = new char[r+2][c+2];
        for(int i = 1;i<=r;i++){
            String str = scan.next();
            for(int j = 1;j<=c;j++){
                // System.out.println(i+" "+j);
                island[i][j] = str.charAt(j-1);
            } 
        }
        System.out.println();
        for(int i = 0;i<r+2;i++){
            island[i][0] = '.';
            island[i][c+1] = '.';
        }
        for(int i = 0;i<c+2;i++){
            island[0][i] = '.';
            island[r+1][i] = '.';
        }
        // for(char[] arr:island)System.out.println(Arrays.toString(arr));
        for(int i = 1;i<r+1;i++){
            for(int j = 1;j<c+1;j++){
                if(island[i][j]=='X'){
                    int count = 0;
                    if(island[i-1][j]=='.') count++;
                    if(island[i+1][j]=='.') count++;
                    if(island[i][j-1]=='.') count++;
                    if(island[i][j+1]=='.') count++;
                    if(count>2) island[i][j] = '1';
                }
            } 
        }
        for(int i = 1;i<r+1;i++){
            for(int j = 1;j<c+1;j++){
                if(island[i][j]=='1') island[i][j] = '.';
            } 
        }
        // for(char[] arr:island)System.out.println(Arrays.toString(arr));
        int rowStart = -1;
        int rowEnd = -1;
        int columnStart = -1;
        int columnEnd = -1;
        out:
        for(int i = 0;i<=r;i++){
            for(int j = 0;j<=c;j++){
                if(island[i][j]=='X'){
                  rowStart = i;
                  break out;  
                } 
            } 
        }
        out:
        for(int i = 0;i<=c;i++){
            for(int j = 0;j<=r;j++){
                if(island[j][i]=='X'){
                    columnStart = i;
                    break out;  
                    
                }
            } 
        }
        out:
        for(int i = r;i>0;i--){
            for(int j = c;j>0;j--){
                if(island[i][j]=='X'){
                    rowEnd = i;
                    break out;  
                    
                }
            } 
        }
        out:
        for(int i = c;i>0;i--){
            for(int j = r;j>0;j--){
                if(island[j][i]=='X'){
                    columnEnd = i;
                    break out;  
                    
                }
            } 
        }
        // System.out.println(rowStart+" "+columnStart+" "+rowEnd+" "+columnEnd);
        if(rowStart==-1 || columnStart==-1) System.out.println("X");
        else{
            for(int i = rowStart;i<=rowEnd;i++){
                // System.out.println("run");
                for(int j = columnStart;j<=columnEnd;j++){
                    System.out.print(island[i][j]);
                }
                System.out.println();
            }
        }
       
    }
}
