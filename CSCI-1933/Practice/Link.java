public class Link{
    public String bookName;
    public int numberSold;

    public Link next;

    public Link(String iBookName, int iNumberSold){
        bookName = iBookName;
        numberSold = iNumberSold;
    }

    public void display(){
        System.out.println(bookName + ": " + numberSold);
    }

    public String toString(){
        return bookName;
    }
}

class LinkList{
    public Link firstLink;

    LinkList(){
        firstLink = null;
    }

    public boolean isEmpty(){
        return(firstLink == null);
    }

    public void insertFirstLink(String bookName, int numberSold){
        Link newLink = new Link(bookName, numberSold);

        newLink.next = firstLink;

        firstLink = newLink;
    }

    public Link removeFirst(){
        Link linkRefernce = firstLink;

        if (!isEmpty()){
            firstLink = firstLink.next;
        }

        else {
            System.out.println("Empty Linked-List");
        }

        return linkRefernce;
    }

    public void displayList(){
        Link theLink = firstLink;

        while(theLink != null){
            theLink.display();
            System.out.println("Next Link: " + theLink.next);

            theLink = theLink.next;
            System.out.println();
        }
    }

    public Link find(String bookName){
        Link theLink = firstLink;

        if(!isEmpty()){
            while (theLink.bookName != bookName){

                if (theLink.next == null){
                    return null;
                }
                else {
                    theLink = theLink.next;
                }
            }
        }
        else {
            System.out.println("Empty Linked-List");
        }
        return theLink;
    }

    public Link removeLink(String bookName){
        Link currentLink = firstLink;
        Link previousLink = firstLink;

        while(CurrentLink.bookName != bookName){
            if (currentLink.next == null){
                return null;
            }
            else {
                previousLink = currentLink;
                currentLink = currentLink.next;
            }

            if (currentLink == firstLink){
                firstLink = firstLink.next;
            }

            else {
                previousLink.next = currentLink.next;
            }
        }
    }
}
