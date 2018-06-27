import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;

public class ContactList{
    private int iContact = 0;
    private int ptr = -1;
    private Contact[] contactList;

    public ContactList(){
        String[] contactList = new String[20];
    }
    public contactList(int iLength){
        String[] contactList = new String[iLength];
    }

    public boolean add(Contact c){
        if (iContact < contactList.length()){
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
        boolean booleanCheck = false;
        int searchIndex = ptr + 1;
        int sortIndex = ptr + 1;
        while (i < length){
            sortIndex += 1;
            if (contactList[ptr + 1].getName().contains(name)){
                booleanCheck = true;
                ptr = searchIndex;
                return contactList[searchIndex]
            }
            else {
                if (sortIndex > length - 1){
                    sortIndex = 0;
                    contactList[searchIndex] = contactList[sortIndex];
                }
                contactList[searchIndex] = contactList[sortIndex];
                i++;
            }
        }
        if (booleanCheck == false){
            return null;
        }
    }

    public boolean write(String FileName){

    }
}
