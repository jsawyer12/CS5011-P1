import java.util.ArrayList;

public class Part1 {

    private int[][] map;
    private int startInd;
    private int nodeCount;

    private LinkedList dFSPath;
    private int dFSCost;

    private LinkedList bFSPath;
    private int bFSCost;
    private int bFSStep;

    public Part1(int[][] map) {
        this.map = map;

        nodeCount = map[0].length;
        startInd = findStartInd();

        Node startPos = new Node(startInd);


        dFSPath = new LinkedList(nodeCount);
        dFSPath.addNode(startPos);
        dFSCost = 0;

        bFSPath = new LinkedList(nodeCount);
        bFSPath.addNode(startPos);
        bFSCost = 0;
        bFSStep = 0;
    }

    public int getdFSCost() {
        return dFSCost;
    }

    public int getbFSCost() {
        return bFSCost;
    }

    public boolean isPossible() {
        for (int i = 0; i < map[0].length; i++) {
            if (map[i][i] == 8) {
                for (int k = 0; k < map[i].length; k++) {
                    if (map[i][k] == 5)
                        return true;
                }
            }
        }
        return false;
    }

    private int findStartInd() {
        for (int i = 0; i < nodeCount; i++) {
            if (map[i][i] == 2)
                return i;
        }
        return 0;
    }

    public LinkedList startDFS() {
        return depthFirstSearch(dFSPath);
    }

    private LinkedList depthFirstSearch(LinkedList ll) {
        dFSCost++;
        System.out.print("Step " +dFSCost +": ");
        ll.printList();
        int current = ll.getTail().data();
        if (map[current][current] == 8)
            return ll;
        for (int i = 0; i < map[current].length; i++) {
            if (map[current][i] == 5) {
                if (!ll.hasOccurred(i)) {
                    Node newNode = new Node(i);
                    ll.addNode(newNode);
                    depthFirstSearch(ll);
                    current = ll.getTail().data();
                    if (map[current][current] == 8)
                        return ll;
                }
            }
        }
        if (map[current][current] != 8) {
            ll.dropNode();
        }
        return ll;
    }

    public LinkedList startBFS() {
        ArrayList<LinkedList> paths = new ArrayList<>();
        paths.add(bFSPath);
        return breadthFirstSearch(paths);
    }

    public LinkedList breadthFirstSearch(ArrayList<LinkedList> paths) {
        int currNumPaths = paths.size(); // so it doesn't keep adding while paths are added in one recursion
        bFSStep++;
        System.out.println("Step: " +bFSStep);
        for (int i = 0; i < currNumPaths; i++) { // iterates through current set of paths
            int current = paths.get(i).getTail().data();
//            boolean nextMove = false; // dictates whether to move a path option if there are no further moves in it
            boolean pathUsed = false; // dictates whether to copy path or use current one
            for (int j = 0; j < map[current].length; j++) { // for each next move option per path
                if (map[current][j] == 5) { // if node is next to current node
                    if (!paths.get(i).hasOccurred(j)) { // if this node in this path hasn't been hit yet
//                        nextMove = true;
                        bFSCost++;
                        Node nextStep = new Node(j); // create new node of index
                        if (pathUsed) {
                            LinkedList branchedPath = new LinkedList(paths.get(i), nodeCount);
                            branchedPath.dropNode(); // since one was added from below
                            branchedPath.addNode(nextStep);
                            paths.add(branchedPath);
                            branchedPath.printList();
                        }
                        else {
                            pathUsed = true;
                            paths.get(i).addNode(nextStep);
                            paths.get(i).printList();
                        }
                    }
                }
            }
//            if (!nextMove) { // remove path from options if no further moves in it
//                paths.remove(i);
//            }
            current = paths.get(i).getTail().data();
            if (map[current][current] == 8) {
                return paths.get(i);
            }
        }
        LinkedList ll = breadthFirstSearch(paths);
        return ll;
    }


}
