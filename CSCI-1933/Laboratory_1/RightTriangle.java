import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public class RightTriangle{
  private double base;
  private double height;

  public void setBase(double newBase){
    base = newBase;
  }

  public double getBase(){
    return base;
  }

  public void setHeight(double newHeight){
    height = newHeight;
  }

  public double getHeight(){
    return height;
  }

  public double area(){
    return ((base*height)/2);
  }

  public double perimeter(){
    return (base + height + Math.sqrt((Math.pow(height, 2) + Math.pow(base, 2))));
  }



}
