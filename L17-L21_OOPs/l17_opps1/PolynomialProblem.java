class Polynomial{
	private int[] polyEquation = new int[50];

	public void setCoefficient(int degree, int coeff){
		this.polyEquation[degree] = coeff;
	}
	public void print(){
		for(int i=0;i<50;i++){
			if(polyEquation[i]!=0){
				System.out.print(polyEquation[i]+"x"+i+" ");
			}
		}
	}
	public void println(){
		for(int i=0;i<50;i++){
			if(polyEquation[i]!=0){
				System.out.print(polyEquation[i]+"x"+i+" ");
			}
		}System.out.println();
	}
	// Adds two polynomials and returns a new polynomial which has result
	public Polynomial add(Polynomial p){
		for(int i=0;i<50;i++){
			this.polyEquation[i] = this.polyEquation[i]+p.polyEquation[i];
		}	
		return this;
	}
	
	// Subtracts two polynomials and returns a new polynomial which has result
	public Polynomial subtract(Polynomial p){
		for(int i=0;i<50;i++){
			this.polyEquation[i] = this.polyEquation[i]-p.polyEquation[i];
		}	
		return this;
	}
	
	// Multiply two polynomials and returns a new polynomial which has result
	public Polynomial multiply(Polynomial p){
		Polynomial tobeSend =new Polynomial();

		for(int i=0;i<25;i++){
			for(int j =0; j<25;j++){
				tobeSend.polyEquation[i+j]+=this.polyEquation[i]*p.polyEquation[j];
			}
		} return tobeSend;
		
	}

}

public class PolynomialProblem{
	public static void main(String[] args){
		Polynomial p = new Polynomial();
		Polynomial q = new Polynomial();
		p.setCoefficient(1,3);
		p.setCoefficient(2,3);
		q.setCoefficient(0,2);
		q.setCoefficient(2,2);
		Polynomial x = p.multiply(q);
		p.println();
		q.println();
		x.println();
	}
}