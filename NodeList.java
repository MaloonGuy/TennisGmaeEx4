public class NodeList <T> {

    private Node<T> firstNode;

    public NodeList() {
        this.firstNode = null;
    }

    public NodeList(Node<T> firstNode) {
        this.firstNode = firstNode;
    }

    public Node<T> getHead() {
        return firstNode;
    }

    public void setFirstNode(Node<T> players) {
        this.firstNode = players;
    }

    @Override
    public String toString() {
        String result = "Node List:\n";
        Node temp = firstNode;
        while (temp != null) {
            result += "\t" + temp.getValue().toString() + "\n";
            temp = temp.getNext();
        }
        return result;
    }

    public boolean isEmpty() {
        return this.firstNode == null;
    }

    // insert item at front of List
    public void insertAtFront(Node<T> node) {
        // firstNode and lastNode refer to same object
        if (isEmpty()) firstNode = node;
            // firstNode refers to new node
        else {
            node.setNext(firstNode);
            setFirstNode(node);
        }
    }

    public void print(){
        System.out.println(toString());
    }
    public void removeFromBack(){
        if(isEmpty()) {
            System.out.println("The NodeList is empty.");
            return;
        }

        Node temp = firstNode;
        while (temp.getNext() != null)
            temp = temp.getNext();
        temp.setNext(null);

    }

}// end method insertAtFront
    


