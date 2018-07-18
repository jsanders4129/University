public class RectangleApplication{
  public static void main(String[] args){
    Rectangle rect = new Rectangle();
    rect.setLength(2.5);
    rect.setWidth(2.5);
    System.out.println("Length and Width is set to: " + rect.getWidth() + " " + rect.getLength());
    double p = rect.perimeter();
    double a = rect.area();
    System.out.println("perimeter: " + p);
    System.out.println("area: " + a);
  }
}
