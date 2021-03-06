public class LinkedList {

    /**
     * stores the head and the tail of the linked list so that nodes could be
     * added and removed in constant time.
     */
    private Node head;
    private Node tail;

    /**
     * stores the nodes that were already visited to avoid looping.
     */
    private boolean[] usedNodes; // works like hashset, keeps track of used nodes so no repetition occurs
    private char[] charSeq = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p'};

    public boolean hasOccurred(int nodeIndex) {
        return usedNodes[nodeIndex];
    }

    /**
     * makes a copy of the original linked list in the args.I realized
     * that setting a new linked list to an existing one merely references the
     * existing one so I created this method to create an actual copy.
     * @param otherLL
     * @param nodeCount
     */
    public LinkedList(LinkedList otherLL, int nodeCount) {
        usedNodes = new boolean[nodeCount];
        if (otherLL.getHead() != null) {
            Node temp = otherLL.getHead();
            while (temp != null) {
                Node next = new Node(temp.data());
                addNode(next);
                temp = temp.next();
            }
        }
    }

    public LinkedList(int nodeCount) {
        head = null;
        tail = null;
        usedNodes = new boolean[nodeCount];
    }

    public Node getTail() {
        return tail;
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
    }

    public Node dropNode() {
        if (head != null) {
            Node temp = tail;
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

    public void printList() {
        if (head != null) {
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
}