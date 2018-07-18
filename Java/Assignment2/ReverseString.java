public class ReverseString{
    private static String rString = "";
    private static String sString = "Hello World";

    // Question Four:
    public static String reverse(){
        if (sString.length() == 0){
            return rString;
        }
        else{
            rString += sString.charAt(sString.length() - 1);
            sString = sString.substring(0, sString.length() - 1);
            System.out.println(sString);
            return reverse();
        }
    }

    // Question Five:
    public static String reverseLoop(){

        for (int i = sString.length() - 1; i >= 0; i--){
            rString += sString.charAt(i);
        }
        return rString;
    }

    public static void main(String[] args){
        ReverseString rString = new ReverseString();
        System.out.println(rString.reverse());
        System.out.println(rString.reverseLoop());
    }
}
