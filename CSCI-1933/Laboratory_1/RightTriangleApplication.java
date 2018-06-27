public class RightTriangleApplication{
  public static void main(String[] args){
    RightTriangle tri = new RightTriangle();
    tri.setBase(2.5);
    tri.setHeight(2.5);
    System.out.println("Base and height is set to: " + tri.getBase() + " " + tri.getHeight());
    double p = tri.perimeter();
    double a = tri.area();
    System.out.println("perimeter: " + p);
    System.out.println("area: " + a);
  }
}
