public class BitwiseOperator {
    public static void main(String[] args){
        // shift operator work like multiplier of 2**n
        System.out.println("or   "+(0|0)+" "+(0|1)+" "+(1|0)+" "+(1|1));
        System.out.println("xor  "+(0^0)+" "+(0^1)+" "+(1^0)+" "+(1^1));
        System.out.println("and  "+(0&0)+" "+(0&1)+" "+(1&0)+" "+(1&1));
        // left and right shift
        System.out.println((1<<5)+"  "+ (5<<3));
       
        int binary = 0b1101101;
        // 1's and 2's complement
        System.out.println("not operator = "+Integer.toBinaryString(~binary));
        System.out.println("  2's complement  = "+Integer.toBinaryString(~binary+1));
        
        // to check number is odd or even do n&1 if true then odd, if false then true
        System.out.println("2341 is odd  "+(2341&1)+"  342 is odd  "+(342&1));

    // set or unset the specific bit of number. 
        System.out.println("numvber is  this   "+Integer.toBinaryString(binary));
        // set 4th(0 indexed) bit from right of 1101101--->1111101
        System.out.println("5th bit set        "+Integer.toBinaryString(binary | (0b1<<4)));
        // unset 3rd and 2nd  bit 1101101 -->1100001
        System.out.println("4th & 3rd bit unset   "+Integer.toBinaryString(binary&(~(0b11<<2))));
        // toggleing a bit from on posiotion
        System.out.println("toggle  "+Integer.toBinaryString(binary^(0b111<<2)));
        // check 5th bit is set or not
        System.out.println("is bit set or not    "+Integer.toBinaryString(binary&(1<<5))+"   "+((binary&(1<<5))>0));
        // clear all bits from LSB to 4th bit  and MSB to 3rd bit
        int mask = ~((1<<(4+1))-1);
        System.out.println("after clearing bits  "+Integer.toBinaryString(mask&binary)+" "+Integer.toBinaryString(~mask&binary));
        // character changing use xor for toggle.
        System.out.println(Integer.toBinaryString(' ')+ "   " +(char)('A'|' ')+"   "+(char)('x'&'_')+" "+Integer.toBinaryString('_'));
        // check number is power of 2 or not
        int x = 1054; // because all 2**n has only one in them. 
        boolean check1 = (x&(x-1))==0;// not consider the 0
        System.out.println((check1 && x!=0));
    }
    
}
