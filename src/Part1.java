import java.util.ArrayList;
import java.util.Arrays;

public class Part1 {

    private int[][] map;
//    private int exitIndex; // index of exit node
//
//    private void getExitIndex() {
//        for (int i = 0; i < map[0].length; i++) {
//            for (int j = 0; j < map[0].length; i++) {
//                if (map[i][j] == 8) {
//                    this.exitIndex = map[i][j];
//                }
//            }
//        }
//    }


    public Part1(int[][] map) {
        this.map = map;
//        getExitIndex();
    }

    public LinkedList depthFirstSearch(LinkedList ll) {
        int current = ll.getTail().data();
        ll.printList();
        boolean good = false;
        if (map[current][current] == 8) {
            good = true;
        }
        else {
            for (int i = 0; i < map[current].length; i++) {
                if (map[current][i] == 5) {
                    if (!ll.hasOccured(i)) {
                        Node newNode = new Node(i);
                        ll.addNode(newNode);
                        depthFirstSearch(ll);
                    }
                }
            }
        }
        if (!good)
            ll.dropNode();
        return ll;
    }

    //    public LinkedList depthFirstSearch(LinkedList ll) {
//        int current = ll.getTail().data();
//        ll.printList();
//        if (map[current][current] == 8) {
//            return ll;
//        }
//        else {
//            for (int i = 0; i < map[current].length; i++) {
//                if (map[current][i] == 5) {
//                    if (!ll.hasOccured(i)) {
//                        Node newNode = new Node(i);
//                        ll.addNode(newNode);
//                        depthFirstSearch(ll);
//                    }
//                }
//            }
//        }
//        ll.dropNode();
//        return ll;
//    }
}
