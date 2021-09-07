import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class factNotPosibleException extends Exception{

}

public class probabitity{
    public static int fact(int a)throws Exception{
            if(a<1){
                throw new factNotPosibleException();
            }
            if (a==1) return 1;
            return a*fact(a-1);   
    }
    public static int ncr(int n, int r) throws Exception{
        if (r==n) return   1;
        if(r>n || r<0){
            throw new factNotPosibleException();
        }
        double res = 0;
        res = ((double)fact(n))/(double)(fact(n-r)*fact(r));

        return (int)res;
    }
    public static int prob(int n, int x) throws Exception{
        double res = 0;
        res = ((double)(ncr(4,x)*ncr(4,n-x))*100.0)/(double)(ncr(8,n));
        return (int)res;
    }


    public static void main(String[] args) throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader s = new BufferedReader(isr);
        String[] str = s.readLine().strip().split(" ");
        System.out.println((str[0]+" "+str[1]));
        s.close();
        try {
           int res = prob(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
            System.out.println(res);
        } catch (Exception e) {
            System.out.println(e);
            //TODO: handle exception
        }

    }
}