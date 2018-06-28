public class Contact{
    private String name;
    private long phone;
    private String address;
    private String comments;

    public Contact(){
        name = "N/A";
        phone = 0;
        address = "N/A";
        comments = "N/A";
    }

    public Contact(String iName, long iPhone, String iAddress, String iComments){
        name = iName;
        phone = iPhone;
        address = iAddress;
        comments = iComments;
    }

    public void setName(String input){
        name = input;
    }
    public String getName(){
        return name;
    }

    public void setPhone(long input){
        phone = input;
    }
    public long getPhone(){
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
        "Name: " + '\t' + '\t' + name + System.lineSeparator()
        +
        "Phone: " + '\t' + '\t' + phone + System.lineSeparator()
        +
        "Address: " + '\t' + address + System.lineSeparator()
        +
        "Comments: " + '\t' + comments + System.lineSeparator()
        +
        System.lineSeparator()
        ;
    }

    public static void main(String[] args){
        System.out.println("");
    }
}
