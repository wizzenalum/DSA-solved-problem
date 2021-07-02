package group2;

public class binaryplay {
    static public int binarySequence(int N, int X) {
        String a = "0";
        String b = "0";
        for (int j = 0; j < N-1; j++) {
            for (int i = 0; i < a.length(); i++) {
                if(a.charAt(i)=='0') b+='1';
                if(a.charAt(i)=='1') b+='0';
            }
            a= b;
            if(a.length()>=X) break;
            System.out.println(a);
        }
        return a.charAt(X-1)-'0';
    }
    public static void main(String[] args) {
        System.out.println(binarySequence(4, 5));
    }
}
