import java.util.Scanner;
public class cafeteria {

    public static boolean func(int var){  
        System.out.printf("i = %s inconditional statement\n",var);              
        return var<=5?true:false;
    }
    public static void main(String[] args) {
    // arr diclaration by declaring, memory allocaion, initializing
        int[] arr;
        arr = new int[2];
        arr[0]=23;
        arr[1]=34;
        int[] arr1 = new int[2]; // dclare with memory alocation same time.
        arr1 = new int[3];
        arr1[0]=23;
        arr1[1]=35;
        int[] arr2 = {1,2};
        System.out.println(arr2[1]);
        // operators
        int a = 10, b = 5;
        System.out.println(++a+b++);
        System.out.println(a++*++b);
        System.out.println(a--+b++);
        System.out.println(a+++b);
        System.out.println(Integer.toString(-20,2));
    }
}