public class Circle{
  public double pi = 3.14;
  private double radius;

  public void setRadius(double newRadius){
    radius = newRadius;
  }

  public double getRadius(){
    return radius;
  }

  public double perimeter(){
    double p = 2 * pi * radius;
    return p;
  }

  public double area(){
    double a = pi * (radius*radius);
    return a;
  }

}
