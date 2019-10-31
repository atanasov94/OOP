package rectanglepoint;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains(Point toCheck) {
        if (toCheck.getX() >= this.bottomLeft.getX() && toCheck.getX() <= this.topRight.getX()) {
            return toCheck.getY() >= this.bottomLeft.getY() && toCheck.getY() <= this.topRight.getY() ;
        }
        return false;
    }
}
