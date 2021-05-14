import java.util.Scanner;

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
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        int k = scan.nextInt();
        for(int i = 0;i<k;i++){
            int w = scan.nextInt();
            int x = scan.nextInt();
            int y = scan.nextInt();
            int z = scan.nextInt();

            System.out.println(isCombination(str.substring(w-1,x),str.substring(y-1,z)));

        }
    }
}


// navdeepdvan
// 2
// 1 4 8 11
// 4 5 7 8