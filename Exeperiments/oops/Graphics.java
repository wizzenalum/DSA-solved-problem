import graphics.Point;
import graphics.Rectangle;
public class Graphics{
	public static void main(String[] args) {
		Point a = new Point(1,2);
		Point b = new Point(2);
		Point c = new Point();
		a.show();
		b.show();
		c.show();
		Rectangle square = new Rectangle(a,5,5);
		square.move(4,5);
		square.show();

	}
}