public class Node <T> {
    private Player value;
    private Node<T> next;

    public Node (Player value){this.value = value;}

    public Node(Player value, Node<T> next){ this.value = value;  this.next = next; }


    public Player getValue()                 {return value;}

    public Node<T> getNext()                 {return next;}

    public void setValue(Player value)       {this.value = value;}

    public void setNext(Node<T> next)        {this.next = next;}

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }


}
