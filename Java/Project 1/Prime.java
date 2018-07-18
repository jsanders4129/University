public class Prime{
private static boolean primeCheck;

private static int mPrime = 2;
private static int iCount = 1;

  public static boolean isPrime(int input) {
    // Lowest possible even number:
    if(input == 2){
      primeCheck = true;
    }
    // Lowest possible odd number:
    else if (input == 3){
      primeCheck = true;
    }
    else{
      for(int i = 4; i <= Math.sqrt(input); i++) {//check for square root or even inputs
        if(input % i == 0){
          primeCheck = false;
          break;
        }
        else{
          primeCheck = true;
        }
      }
    }
    return primeCheck;
  }

  public static void main(String[] args){
    System.out.println(isPrime(4500007));
  }

  public static boolean isMersennePrime(int input) {
    if (isPrime(input) == true){
      while(inputCount<input) {
        mersennePrime*=2;
        inputCount+=1;
      }
      mersennePrime=mersennePrime-1;
      if(isPrime(mersennePrime)==true) {
        primeCheck = true;
      }
      else {
        primeCheck = false;
      }
    }
    else if (isPrime(input) == false){
      primeCheck = false;
    }
    return primeCheck;

  }
  public static int prime(int n){ //dont use isPrime
    if(n<1){
      return -1;
    }
    else{
      int i = 1;
      int count = 0;
      while(count<n){
        i++;
        if(isPrime(i)==true){
          count+=1;
        }

      }

      return i;
    }
  }

  public static int[] primeArray(int howMany) {//use this without isPrime
    int[] primeList;
    if(howMany < 1){
      return null;
    }
    else {
      primeList = new int[howMany];
      int i=0;
      while(i<howMany){
        primeList[i]=prime(i+1);
        i++;
      }

    }
    for(int k=0;k < primeList.length;k++) {
      System.out.println("primeList["+k+"]"+primeList[k]);
    }
    return primeList;
  }
  public static int[] primeArray2(int numFind)
{
    //determines the size of the array returned
    int primeTotal = 0;

    //loop to find total prime inputs
    for (int j = 1; j <= numFind; j ++)
    {
        if (isPrime(j))
        primeTotal +=1;
    }

    //declare array to be returned
    int[] numA = new int[primeTotal];

    //current index of prime input
    int iP = 0;

    //loop to add prime elements to array
    for (int x = 1; x <= numFind; x ++)
    {
        if (isPrime(x))
        {
            numA[iP]=x;
            iP++;    // <--- THIS IS CAUSING ME PROBLEMS
        }

    }
    for(int k=0;k < numA.length;k++) {
      System.out.println("primeLost["+k+"]"+numA[k]);
    }

    return numA;
}



  public static int[] primeFactors(int input) {
    int[] primes;
    int input2 = input;
    int input3 = input;
    int count=0;
    int count2=0;
    int i=0; //make i only prime inputs
    int j =0;
    int[] countArray=primeArray(5);//how can i make this array the correct length
    //System.out.println("factorization of "+input);
    //System.out.println(countArray.length);
    if(input<2){
      primes = new int[0];
      return primes;
    }
    else {
      while(i<countArray.length&&(isPrime(input)==false)) {
        if (input%countArray[i]==0) {
          input/=countArray[i];
          count+=1;
          i=0;
        }
        else {
          i++;
        }
      }

      if (isPrime(input)==true) {
        count+=1;
      }
      primes = new int[count];
      while(j<countArray.length) {

        if (input2%countArray[j]==0) {
          input2/=countArray[j];
          primes[count2]=countArray[j];
          count2 +=1;
          j=0;
        }
        else {
          j++;
        }
        if (isPrime(input2)==true) {
          primes[count2]=input2;
          j=5;
        }
      }

      for(int k=0;k < primes.length;k++) {
        if(k == 0) {
          System.out.print("["+primes[0]+",");
        }
        else if (k == primes.length-1) {
          System.out.print(primes[primes.length-1]+"]");
        }
        else {
          System.out.print(primes[k]+",");
        }
      }
      System.out.println(" are the primes of "+ input3);
      return primes;
    }
  }


}
