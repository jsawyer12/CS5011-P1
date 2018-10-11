import java.util.Arrays;

public class LinkedList {

    private Node head;
    private Node tail;
    private boolean[] usedNodes; // works like hashset, keeps track of used nodes so no repetition occurs
    private char[] charSeq = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o'};



    public boolean hasOccured(int nodeIndex) {
        return usedNodes[nodeIndex];
    }

    public LinkedList(int nodeCount) {
        head = null;
        tail = null;
        usedNodes = new boolean[nodeCount];
    }

    public Node getTail() {
        return tail;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getHead() {
        return head;
    }

    public void addNode(Node node) {
        if (head != null) {
            Node temp = tail;
            tail.setNext(node);
            tail = node;
            tail.setPrev(temp);
        }
        else {
            head = node;
            tail = node;
        }
        usedNodes[node.data()] = true; // takes index of node, aka its data, aka its char, and sets that index to true
//        System.out.println(Arrays.toString(usedNodes));
    }

    public Node dropNode() {
        if (head != null) {
            Node temp = tail;
//            usedNodes[temp.data()] = false; // efficient without it, but may hurt other maps
            if (head == tail) {
                head = null;
                tail = null;
                return temp;
            }
            else {
                tail = tail.getPrev();
                tail.setNext(null);
                return temp;
            }
        }
        return null;
    }

    public boolean isEmpty() {
        if (head == null)
            return true;
        return false;
    }

    public void printList() {
        Node node = head;
        while (node != null) {
            System.out.print(charSeq[node.data()]);
            if (node.next() != null)
                System.out.print(" -> ");
            node = node.next();
        }
        System.out.println();
    }
}