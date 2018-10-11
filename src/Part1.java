import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.Arrays;

public class Part1 {

    private int[][] map;

    public Part1(int[][] map) {
        this.map = map;
    }

    public LinkedList depthFirstSearch(LinkedList ll) {
        ll.printList();
        int current = ll.getTail().data();
        for (int i = 0; i < map[current].length; i++) {
            if (map[current][i] == 5) {
                if (!ll.hasOccured(i)) {
                    Node newNode = new Node(i);
                    ll.addNode(newNode);
                    ll = depthFirstSearch(ll);
                    current = ll.getTail().data();
                }
            }
        }
        if (map[current][current] != 8) {
            ll.dropNode();
        }
        return ll;
    }

    public LinkedList breadthFirstSearch(LinkedList ll) {
        ll.printList();
        return null; // CONTINUE HERE
    }
}
