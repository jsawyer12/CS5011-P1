public class Node {

    private Node next;
    private char data;

    public Node next() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setData(char data) {
        this.data = data;
    }

    public char data() {
        return data;
    }

    public Node(char data) {
        this.next = null;
        this.data = data;

    }
}