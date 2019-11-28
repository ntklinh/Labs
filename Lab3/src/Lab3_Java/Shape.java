package Lab3_Java;

public abstract class Shape{
    protected String color;
    protected boolean filled;

    public Shape(String color, boolean filled){
        setColor(color);
        setFilled(filled);
    }
    public Shape(){
        this("red", true);
    }
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }
    public boolean isFilled(){
        return filled;
    }
    public void setFilled (boolean filled){
        this.filled = filled;
    }
    abstract public double getArea();
    abstract public double getPerimeter();
    abstract public String toString();
}

class Circle extends Shape{
    protected double radius;
    public Circle(double radius, String color, boolean filled){
        super(color, filled);
        setRadius(radius);
    }
    public Circle(double radius){
        super();
        setRadius(radius);
    }
    public Circle(){
        this(1);
    }
    public double getRadius(){
        return radius;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public double getArea(){
        return Math.PI * Math.pow(radius, 2);
    }
    public double getPerimeter(){
        return 2 * Math.PI * radius;
    }
    public String toString(){
        return "Circle with radius=" + radius + ", Area=" +
                getArea() + ", Perimeter=" + getPerimeter();
    }
}

class Rectangle extends Shape{
    protected double width;
    protected double length;

    public Rectangle(double width, double length, String color,
                     boolean filled){
        super(color, filled);
        setWidth(width);
        setLength(length);
    }
    public Rectangle(double width, double length){
        super();
        setWidth(width);
        setLength(length);
    }
    public Rectangle(){
        this(1, 1);
    }
    public double getWidth(){
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getLength(){
        return length;
    }
    public void setLength(double length){
        this.length = length;
    }
    public double getArea(){
        return width * length;
    }
    public double getPerimeter(){
        return 2 * (width + length);
    }
    public String toString(){
        return "Rectangle with width=" + width + "," +
                "Length=" + length + ", Area=" + getArea() +
                ", Perimeter=" + getPerimeter();
    }
}

class Square extends Rectangle{
    public Square(double side, String color, boolean filled){
        super(side, side, color, filled);
    }
    public Square(double side){
        super(side, side);
    }
    public Square(){
        this(1);
    }
    public double getSide(){
        return width;
    }
    public void setSide(double side){
        width = side; length = side;
    }
    public void setWidth(double side){
        setSide(side);
    }
    public void setLength(double side){
        setSide(side);
    }
    public String toString(){
        return "Square with side=" + getSide() + ", Area="
                + getArea() + ", Perimeter=" + getPerimeter();
    }
}

class TestShape{
    public static void main(String[] args){
        Shape s1 = new Circle(5.5, "RED", false);
        System.out.println(s1);
        System.out.println(s1.getArea());
        System.out.println(s1.getPerimeter());
        System.out.println(s1.getColor());
        System.out.println(s1.isFilled());
        Circle c1 = (Circle)s1;
        System.out.println(c1);
        System.out.println(c1.getArea());
        System.out.println(c1.getPerimeter());
        System.out.println(c1.getColor());
        System.out.println(c1.isFilled());
        System.out.println(c1.getRadius());

        Shape s3 = new Rectangle(1.0, 2.0, "RED", false);
        System.out.println(s3);
        System.out.println(s3.getArea());
        System.out.println(s3.getPerimeter());
        System.out.println(s3.getColor());

        Rectangle r1 = (Rectangle)s3;
        System.out.println(r1);
        System.out.println(r1.getArea());
        System.out.println(r1.getColor());
        System.out.println(r1.getLength());

        Shape s4 = new Square(6.6);
        System.out.println(s4);
        System.out.println(s4.getArea());
        System.out.println(s4.getColor());

        Rectangle r2 = (Rectangle)s4;
        System.out.println(r2);
        System.out.println(r2.getArea());
        System.out.println(r2.getColor());
        System.out.println(r2.getLength());

        Square sq1 = (Square)r2;
        System.out.println(sq1);
        System.out.println(sq1.getArea());
        System.out.println(sq1.getColor());
        System.out.println(sq1.getSide());
        System.out.println(sq1.getLength());
    }
}