import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

public class ContactList{
    private int iContact = 0;
    private int ptr = -1;
    private Contact[] contactList;

    public ContactList(){
        contactList = new Contact[20];
        for (int i = 0; i < contactList.length; i++){
            contactList[i] = new Contact();
        }
    }
    public ContactList(int iLength){
        contactList = new Contact[iLength];
        for (int i = 0; i < contactList.length; i++){
            contactList[i] = new Contact();
        }
    }

    public Contact[] getContactList(){
        return contactList;
    }

    public boolean add(Contact c){
        if (iContact < contactList.length){
            contactList[iContact] = c;
            iContact += 1;
            ptr = iContact;
            return true;
        }
        else{
            return false;
        }
    }

    public Contact find(String name){
        int length = contactList.length;
        int i = 0;
        int searchIndex = ptr + 1;
        int sortIndex = ptr;
        Contact iContact = new Contact();
        while (i < length){
            sortIndex += 1;
            if (contactList[sortIndex].getName().contains(name)){
                System.out.println(ptr);
                ptr = sortIndex;
                System.out.println(ptr);
                iContact = contactList[sortIndex];
                break;
            }
            else {
                if (sortIndex > length){
                    sortIndex = 0;
                }
                contactList[searchIndex] = contactList[sortIndex];
                i++;
                System.out.println(i);
            }
        }
        return iContact;
    }

    public void remove(){
        contactList[ptr] = new Contact();
    }

    public static void main(String[] args){
        Contact Jacob = new Contact("Jacob", 2184129, "8600 39th Avenue North", "Student");
        Contact Ryan = new Contact("Ryan", 2184129, "8600 39th Avenue North", "Student");
        Contact Bill = new Contact("Bill", 2184129, "8600 39th Avenue North", "Student");

        ContactList contactMaster = new ContactList();

        Contact[] contactList = contactMaster.getContactList();

        System.out.println(contactList.length);

        contactList[3] = Jacob;
        contactList[5] = Ryan;
        contactList[13] = Bill;

        System.out.println(contactMaster.find("z").toString());
        //contactMaster.remove();

        try {
            PrintWriter writer = new PrintWriter("MyFile.txt");
            for (int i = 1; i < contactList.length + 1; i++){
                writer.print("\t" + i + System.lineSeparator() + contactList[i-1].toString());
            }
            writer.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
