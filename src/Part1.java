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

    public LinkedList breadthFirstSearch(ArrayList<LinkedList> paths) {
        int currNumPaths = paths.size(); // so it doesn't keep adding while paths are added in one recursion
        for (int i = 0; i < currNumPaths; i++) { // iterates through current set of paths
//            System.out.print("Path " +i +": ");
//            paths.get(i).printList();
            int current = paths.get(i).getTail().data();
            if (map[current][current] == 8) {
                return paths.get(i);
            }
            boolean pathUsed = false; // dictates whether to copy path or use current one
//            System.out.println("Options: " + Arrays.toString(map[current]));
            for (int j = 0; j < map[current].length; j++) { // for each next move option per path
                if (map[current][j] == 5) { // if node is next to current node
                    if (!paths.get(i).hasOccured(j)) { // if this node in this path hasn't been hit yet
                        Node nextStep = new Node(j); // create new node of index
                        System.out.println("Adding index " +j);
                        if (pathUsed) {
                            ArrayList<LinkedList> pathsCopy = new ArrayList<>(paths);
                            LinkedList branchedPath = pathsCopy.get(i);
                            System.out.print("LL being copied: ");
                            branchedPath.printList();
                            branchedPath.dropNode(); // since one was added from below
                            System.out.print("LL after drop: ");
                            branchedPath.printList();
                            System.out.print("paths i after drop: ");
                            paths.get(i).printList();
                            branchedPath.addNode(nextStep);
                            System.out.print("LL being added: ");
                            branchedPath.printList();
                            paths.add(branchedPath);
                        }
                        else {
                            pathUsed = true;
                            paths.get(i).addNode(nextStep);
                        }
                        for (int k = 0; k < paths.size(); k++) {
                            System.out.print("Path " + k + ": ");
                            paths.get(k).printList();
                        }
                    }
                }
            }
//            System.out.println();
        }

        LinkedList ll = breadthFirstSearch(paths);
        return ll; // CONTINUE HERE
    }


}
