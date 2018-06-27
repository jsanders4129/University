public class Contact{
    private String name;
    private long phone;
    private String address;
    private String comments;

    public void setName(String input){
        name = input;
    }
    public String getName(){
        return name;
    }

    public void setPhone(long input){
        phone = input;
    }
    pubilc long getPhone(){
        return phone;
    }

    public void setAddress(String input){
        address = input;
    }
    public String getAddress(){
        return address;
    }

    public void setComments(String input){
        comments = input;
    }
    public String getComments(){
        return comments;
    }

    public String toString(){
        return
        "Name: " + '\t' + '\t' + name + '\n'
        +
        "Phone: " + '\t' + '\t' + phone + '\n'
        +
        "Address: " + '\t' + address + '\n'
        +
        "Comments: " + '\t' + comments + '\n'
        ;
    }

    public static void main(String[] args){
        return 0;
    }
}
