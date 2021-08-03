package graphics;
public class Rectangle {
    private int width = 0;
    private int height = 0;
    private Point origin;

    // four constructors
    public Rectangle() {
        origin = new Point(0, 0);
    }
    public Rectangle(Point p) {
        origin = p;
    }
    public Rectangle(int w, int h) {
        origin = new Point();
        width = w;
        height = h;
    }
    public Rectangle(Point p, int w, int h) {
        origin = p;
        width = w;
        height = h;
    }

    // a method for moving the rectangle
    public void move(int x, int y) {
        origin.set(x,y);
    }

    // a method for computing the area of the rectangle
    public int getArea() {
        return width * height;
    }
    public void show(){
    	System.out.println("origin = ("+origin.getX()+","+origin.getY()+") width = "+width+"   height = "+height);
    }
}