public class MakeStringAnagram {
    public static int makeAnagram(String s1,String s2){
        int[] freqArr1 = new int[256];
        int[] freqArr2 = new int[256];
        for (int i = 0; i < s1.length(); i++) {
            freqArr1[s1.charAt(i)]++;
            freqArr2[s2.charAt(i)]++; 
        }
        int count = 0;
        for (int i = 0; i < 256; i++) {
            count+= Math.abs(freqArr1[i]-freqArr2[i]);
        }
        return count;
	}
    public static void main(String[] args) {
        String a ="cde"; 
        String b = "abc";
        System.out.println(makeAnagram(a, b));
    }
}
