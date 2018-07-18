public class Node{
    public Node node;
    // Replace node with "next" for easier readiblity
    public String data;
    public Node(String input){
        data = input;
    }
}

public class LinkedList{
    public Node header;

    public void addNode(String input){
        if(header == null){
            header = new Node(input);
            link = header;
        }
        else{
            link = Node(input);
            link.node = header;

            header = link;
        }
    }

    public void remove(){
        if(header == null){
            System.out.println("List is empty");
        }

        else{
            header = header.node;
        }
    }
}
