import java.util.HashSet;

public class LinkedList {

    private Node head;
    private Node last;

    public Node getLast() {
        return last;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getHead() {
        return head;
    }

    public void addNode(Node newNode) {
        if (head == null) {
            head = newNode;
        }
        else {
            Node end = head;
            while (end.next() != null) {
                end = end.next();
            }
            end.setNext(newNode);
        }
        last = newNode;
    }

    public void deleteNode(int value) {
        Node prev = head;
        boolean nodeDeleted = false;
        while (prev.next() != null && !nodeDeleted) {
            if (prev.data() == value) {
                if (prev == head) {
                    if (head.next() != null)
                        head = head.next();
                    else
                        head = null;
                }
                else {
                    prev.setNext(prev.next().next());
                    nodeDeleted = true;
                }
            }
            else
                prev = prev.next();
        }
    }

    public boolean isEmpty() {
        if (head == null)
            return true;
        return false;
    }

    public void printList() {
        Node node = head;
        int count = 0;
        while (node != null && count > 15) {
            System.out.print(node.data());
            if (node.next() != null)
                System.out.print(" -> ");
            node = node.next();
            count++;
        }
        System.out.println();
    }
}