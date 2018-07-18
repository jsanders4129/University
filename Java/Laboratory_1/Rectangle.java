public class Rectangle{
  private double length;
  private double width;

  public void setLength(double newLength){
    length = newLength;
  }

  public double getLength(){
    return length;
  }

  public void setWidth(double newWidth){
    width = newWidth;
  }

  public double getWidth(){
    return width;
  }

  public double area(){
    return length * width;
  }

  public double perimeter(){
    return 2*(length + width);
  }



}
