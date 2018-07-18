//Austin Basala Basal006

public class Random {
    private int pOne;
    private int pTwo;
    private int maximum;
    private int rOld;
    private int rNew;
    public Random(int p1, int p2, int m) {
        pOne=p1;
        pTwo=p2;
        maximum=m;
        rOld = 0;
    }
    public void setSeed(int seed) {
    rOld = seed;
  }
  public int getMaximum() {
    return maximum;
  }
  public int random() {
    rNew = (((pOne*rOld)+pTwo)%maximum);
    this.setSeed(rNew);

    return rNew;
  }
  public int randomInteger(int lower, int upper) {
    if (lower > upper){
        int t = lower;
        lower = upper;
        upper = t;
    }
    int randRange = random() % (upper + lower);
    return randRange;
  }
  public boolean randomBoolean() {
    int randBool = random();
    //System.out.println("hi"+randBool);
    if(randBool%2==0) {
      return true;
    }
    else {
      return false;
    }

  }
  public double randomDouble(double lower, double upper) {
    double randDub = (random() / (upper + lower)) % (upper);
    return randDub;
  }
  public static void main(String []args) {
    Random randomVariable = new Random(7919,65537,102611);
    //System.out.println(randomVariable.random());
    int i = 0;
    while (i < 1000){
        System.out.println(randomVariable.randomInteger(1, 5));
        i++;
    }
    i = 0;

    while (i < 1000){
        System.out.println(randomVariable.randomDouble(1, 5));
        i++;
    }
    i = 0;

    while (i < 1000){
        System.out.println(randomVariable.randomBoolean());
        i++;
    }
    i = 0;


    //System.out.println(randomVariable2.random());

    //System.out.println(randomVariable.randomInteger(1,4));
    //System.out.println(randomVariable2.randomInteger(1,4));


  }
}
