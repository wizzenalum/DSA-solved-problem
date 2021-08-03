package graphics;
public class Point{
	//x shows x-coordinate and y is y coordinate.
	private int x;
	private int y;

	// constructor
	public Point(int... coordinate){
		if(coordinate.length ==0){
			this.x = 0;
			this.y = 0;
		}else if(coordinate.length ==1){
			this.x = coordinate[0];
		}else{
			this.x = coordinate[0];
			this.y = coordinate[1];
		}
	}
	// setter
	public void set(int... coordinate){
		if(coordinate.length ==0){
			this.x = 0;
			this.y = 0;
		}else if(coordinate.length ==1){
			this.x = coordinate[0];
		}else{
			this.x = coordinate[0];
			this.y = coordinate[1];
		}
	}
	// getter
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	public void show(){
		System.out.println("x = "+this.x+"  y = "+this.y);
	}


}