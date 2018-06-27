public class CircleApplication{
  public static void main(String[] args){
    Circle circle = new Circle();
    circle.setRadius(2.5);
    System.out.println("Radius is set to: " + circle.getRadius());
    double p = circle.perimeter();
    double a = circle.area();
    System.out.println("perimeter: " + p);
    System.out.println("area: " + a);
  }
}
