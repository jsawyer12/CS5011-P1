public class Node {

    private Node next;
    private int data;

    public Node next() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int data() {
        return data;
    }

    public Node(int data) {
        this.next = null;
        this.data = data;

    }
}