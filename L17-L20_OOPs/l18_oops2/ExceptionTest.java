class DivideByZeroExeption extends Exception{

}
class NegaticeNumberExecption extends Exception{

}

public class ExceptionTest{
	public static int divide (int  a, int b) throws DivideByZeroExeption{
		if(b==0){
			throw new DivideByZeroExeption();
		}
		return a/b;
	}

	public static void exep() h{
		throw new DivideByZeroExeption();
	}
	

	public static int fact(int n)throws NegaticeNumberExecption{
		if(n<0){
			throw new NegaticeNumberExecption();
		}
		if(n==0) return 1;
		return n*fact(n-1);
	}
	
	public static void main(String[] args){
		String s = null;
		// System.out.println(s.length());
		try{
			System.out.println("above try");
			divide(10,1);
			System.out.println("below try");
			System.out.println(fact(-1));

		} catch(DivideByZeroExeption e) {
			System.out.println("catch");
		}
		catch(NegaticeNumberExecption e){
			System.out.println("number is negative");
		}
	}
}