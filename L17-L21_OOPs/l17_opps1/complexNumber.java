class ComplexNumbers{
	private int real;
	private int img;
	public ComplexNumbers(int real, int img){
		this.real = real;
		this.img = img;
	}
	public void plus(ComplexNumbers s){
		int swap = this.real +s.real;
		this.img = this.img + s.img;
        this.real = swap;
	}
	public void multiply(ComplexNumbers s){
	// multiplcation of two imaginary numbers num1 = a+ib and num2=p+iq;
	// int num1*nmu2, real part = a*p-b*q  img part = a*q+b*p;
		int swap = this.real*s.real-this.img*s.img;
		this.img = this.real*s.img+this.img*s.real;
        this.real = swap;
	}
	public void print(){
		System.out.println(this.real+" + i"+this.img);
	}
	

}
public class complexNumber{
	 public static void main(String[] args) {
		ComplexNumbers a = new ComplexNumbers(5,4);
		ComplexNumbers b = new ComplexNumbers(5,14);
		ComplexNumbers c = new ComplexNumbers(15,4);
		a.multiply(b);
		a.print();

	}
}