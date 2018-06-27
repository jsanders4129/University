public class Random {
  private int P1;
  private int P2;
  private int M;
  private int rOld;
  private int rNew;
  public Random(int p1, int p2, int m) {
    P1=p1;
    P2=p2;
    M=m;
    rOld = 0;
  }
  public void setSeed(int seed) {
    rOld = seed;
  }
  public int getMaximum() {
    return M;
  }
  public int random() {
    rNew = ((P1*rOld)+P2)%M;
    rOld = rNew;
    return rNew;
  }
  public int randomInteger(int lower, int upper) {
    int randRange = random();
    randRange *= (upper-lower)/M;
    randRange += lower;
    return randRange;
  }
  public boolean randomBoolean() {
    int randBool = random();
    if(randBool%2==0) {
      return true;
    }
    else {
      return false;
    }

  }
  public double randomDouble(double lower, double upper) {
    double randDub = random();
    randDub *= (upper-lower)/M;
    randDub += lower;
    return randDub;
  }
  public static void main(String []args) {
    Random randomVariable = new Random(7919,65537,102611);
    Random randomVariable2 = new Random(12,4,6);

    System.out.println(randomVariable.random());
    System.out.println(randomVariable.random());
    System.out.println(randomVariable.random());

    System.out.println(randomVariable2.random());

    System.out.println(randomVariable.randomInteger(1,4));
    System.out.println(randomVariable2.randomInteger(1,4));


  }
}
