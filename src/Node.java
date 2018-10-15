public class Node {

    /**
     * prev Node used to dropNode in Linked List class with constant time
     */
    private Node next;
    private Node prev;
    private int data;

    public Node next() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getPrev() {
        return prev;
    }

    public int data() {
        return data;
    }

    public Node(int data) {
        this.next = null;
        this.prev = null;
        this.data = data;
    }
}