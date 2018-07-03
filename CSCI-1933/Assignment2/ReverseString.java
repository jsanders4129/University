public class ReverseString{
    private String rString = "";

    public String reverse(String input){
        if (input.length() == 0){
            return rString;
        }
        else{
            rString += input.charAt(input.length() - 1);
            input = input.substring(0, input.length() - 1);
            System.out.println(input);
            return reverse(input);
        }
    }

    public String reverseLoop(String input){

        for (int i = input.length() - 1; i >= 0; i--){
            rString += input.charAt(i);
        }
        return rString;
    }
    public static void main(String[] args){
        String string = "Hello World";
        ReverseString rString = new ReverseString();
        //System.out.println(rString.reverse(string));
        System.out.println(rString.reverseLoop(string));
    }
}
