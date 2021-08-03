// outer class x is shadowed by Inner class x and Inner class x shadowed by method x.
class Outer {
	int x =0;

	class Inner{
		int x = 1;
		public int get(int x){
			return x;
		}
		public void print(int x){
			System.out.println(x);
			System.out.println(this.x);
			System.out.println(Outer.this.x);
		}
	}
}
public class NestedClass{
	public static void main(String[] args) {
		Outer out = new Outer();
		Outer.Inner in = out.new Inner();
		System.out.println(in.get(10));
		System.out.println(in.x);
		System.out.println(out.x);
		in.print(5);

		
	}
}