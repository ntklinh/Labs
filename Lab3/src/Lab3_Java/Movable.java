package Lab3_Java;

public interface Movable {
   void moveUp ();
   void moveDown ();
   void moveLeft ();
   void moveRight ();
}

class MovablePoint implements Movable{
    protected int x;
    protected int y;
    protected int xSpeed;
    protected int ySpeed;

    public MovablePoint (int x, int y, int xSpeed, int ySpeed){
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public String toString(){
        return "Point (" + x + ", " + y + ")";
    }

    @Override
    public void moveUp() {++y;}

    @Override
    public void moveDown() {--y;}

    @Override
    public void moveRight() {++x;}

    @Override
    public void moveLeft() {--x;}
}

class MovableCircle implements Movable{
    protected int radius;
    protected MovablePoint center;
    public MovableCircle(int x, int y, int xSpeed,
                         int ySpeed, int radius){
        this.radius = radius;
        this.center = new MovablePoint(x, y, xSpeed, ySpeed);
    }

    public String toString() {return "Circle (" + center.x + ", "
            + center.y + ") with radius=" + radius;
    }

    public void moveUp() {center.moveUp();}

    public void moveDown() {center.moveDown();}

    public void moveRight() {center.moveRight();}

    public void moveLeft() {center.moveLeft();}
}

class TestMovable {
    public static void main(String[] args) {
        MovablePoint point = new MovablePoint(0, 0, 1, 1);
        System.out.println(point);
        point.moveUp();
        point.moveLeft();
        System.out.println(point);
        MovableCircle circle = new MovableCircle(0, 0, 1, 1, 2);
        System.out.println(circle);
        circle.moveDown();
        circle.moveRight();
        System.out.println(circle);
    }
}
