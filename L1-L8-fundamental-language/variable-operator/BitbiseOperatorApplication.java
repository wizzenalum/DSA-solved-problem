public class BitbiseOperatorApplication {

    // Question 1  compute XOR for all numbers from 0 to n means 0^1^2^3^4^5^6^....^n
    public static int computeXOR(int n ) {
        // here you can see we found a pattern
        // 00000 -> 00001 -> 00010 -> 00011 -> 00100 -> 00101 -> 00110 -> 00111 ->  01000 -> 01001 -> 01010 -> 01011 -> 01100 -> 01101 -> 01110 -> 01111  
    //XORs 00000 -> 00001 -> 00011 -> 00000 -> 00100 -> 00001 -> 00111 -> 00000 ->  01000 -> 00001 -> 01011 -> 00000 -> 01100 -> 00001 -> 01111 -> 00000
    if (n % 4 == 0)
        return n;
    if (n % 4 == 1)
        return 1;
    if (n % 4 == 2)
        return n + 1;
    else
        return 0;
    }

    // Question 2  Find XOR of all subsets of a set. 
    //We can do it in O(1) time. The answer is always 0 if the given set has more than one element.
    // why it that you can find it man.
    public static void main(String[] args) {
        System.out.println(computeXOR(50));
    }
}
